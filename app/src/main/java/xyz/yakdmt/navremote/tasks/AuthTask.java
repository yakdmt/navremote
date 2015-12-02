package xyz.yakdmt.navremote.tasks;

import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import de.greenrobot.event.EventBus;
import it.sauronsoftware.ftp4j.FTPAbortedException;
import it.sauronsoftware.ftp4j.FTPClient;
import it.sauronsoftware.ftp4j.FTPDataTransferException;
import it.sauronsoftware.ftp4j.FTPException;
import it.sauronsoftware.ftp4j.FTPIllegalReplyException;
import xyz.yakdmt.navremote.App;
import xyz.yakdmt.navremote.utils.Constants;
import xyz.yakdmt.navremote.utils.Events;

/**
 * Created by yakdmt on 26/11/15.
 */
public class AuthTask extends AsyncTask<String, Void, Boolean> {

    private final static String LOG_TAG = "AuthTask";
    private Context mContext;
    private View mProgress;

    public AuthTask(Context pContext, @NonNull View pProgress ) {
        mContext = pContext;
        mProgress = pProgress;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mProgress.setVisibility(View.VISIBLE);
    }

    @Override
    protected Boolean doInBackground(String... params) {
        boolean isOk = false;
        try {
            File output = new File(App.getContext().getFilesDir()+"/"+Constants.AUTH_FILE+Constants.FILE_EXTENSION);
            isOk = downloadAndSaveFile(Constants.SERVER_NAME,
                    Constants.PORT,
                    Constants.USER_NAME,
                    Constants.PASS,
                    Constants.SERVER_PATH + Constants.AUTH_FILE + Constants.FILE_EXTENSION,
                    output);
            if (isOk) {
                isOk = checkForCredentials(params[0], params[1]);
                if (isOk) {
                    EventBus.getDefault().post(new Events.OnAuthCompleted(true));
                }
            }
            output.delete();
        } catch (IOException e) {
            //Toast.makeText(mContext, "Ошибка ввода/вывода во время копирования файла "+filename, Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        } catch (FTPIllegalReplyException e) {
            //Toast.makeText(mContext, "Неверный ответ ftp соединения во время копирования файла "+filename, Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        } catch (FTPException e) {
            //Toast.makeText(mContext, "Ошибка ftp соединения во время копирования файла "+filename, Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
        //Toast.makeText(mContext, "Получено "+count+" из "+Constants.FILENAME_ARRAY.length+" файлов", Toast.LENGTH_LONG).show();
        return isOk;
    }

    @Override
    protected void onPostExecute(Boolean result) {
        super.onPostExecute(result);
        mProgress.setVisibility(View.GONE);

    }


    public Boolean downloadAndSaveFile(String server, int portNumber,
                                        String user, String password, String filename, File output)
            throws IOException, FTPIllegalReplyException, FTPException {
        FTPClient ftp = null;
        boolean isOk = true;
        try {
            ftp = new FTPClient();
            String[] responseArray = ftp.connect(server, portNumber);
            Log.d(LOG_TAG, "Connected. Reply: ");
            ftp.login(user, password);
            Log.d(LOG_TAG, "Logged in");
            //ftp.setFileType(FTPClient.TYPE_TEXTUAL);
            Log.d(LOG_TAG, "Downloading");
            // ftp.enterLocalPassiveMode();

            OutputStream outputStream = null;
            try {
                outputStream = new BufferedOutputStream(new FileOutputStream(
                        output));
                ftp.download(filename, output);
            } catch (FTPAbortedException e) {
                isOk = false;
                e.printStackTrace();
            } catch (FTPDataTransferException e) {
                isOk = false;
                e.printStackTrace();
            } finally {
                if (outputStream != null) {
                    outputStream.close();
                }
            }
        } catch (FTPException e) {
            isOk = false;
            e.printStackTrace();
        } catch (FTPIllegalReplyException e) {
            isOk = false;
            e.printStackTrace();
        } catch (Exception e ) {
            isOk = false;
            e.printStackTrace();
        } finally {
            if (ftp != null) {
                //ftp.logout();
                ftp.disconnect(true);
            }
        }
        return isOk;
    }

    private boolean checkForCredentials(String login, String password) {
        File inputWorkbook = new File(App.getContext().getFilesDir()+"/"+Constants.AUTH_FILE+Constants.FILE_EXTENSION);
        if (!inputWorkbook.exists()) {
            Log.i(LOG_TAG, "file " + inputWorkbook.getName() + " не найден");
            return false;
        }
        OPCPackage pkg = null;
        XSSFWorkbook w = null;
        try {
            pkg = OPCPackage.open(inputWorkbook);
            w = new XSSFWorkbook(pkg);
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            // Get the first sheet
            assert w != null;
            Sheet sheet = w.getSheetAt(0);
            // Loop over column and lines
            for (int row = 1; row < sheet.getPhysicalNumberOfRows(); row++) {
                Cell loginCell = sheet.getRow(row).getCell(0);
                String serverLogin = loginCell.getStringCellValue();
                if (login.equals(serverLogin)) {
                    Cell passCell = sheet.getRow(row).getCell(1);
                    String pass = passCell.getStringCellValue();
                    if (pass.equals(password)) {
                        Cell contactIdCell = sheet.getRow(row).getCell(2);
                        App.currentContactId = contactIdCell.getStringCellValue();
                        Cell clientIdCell = sheet.getRow(row).getCell(3);
                        int clientId = (int) clientIdCell.getNumericCellValue();
                        App.currentClientId = String.valueOf(clientId);
                        return true;
                    }
                }

            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
