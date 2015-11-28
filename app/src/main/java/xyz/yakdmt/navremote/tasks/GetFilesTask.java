package xyz.yakdmt.navremote.tasks;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import it.sauronsoftware.ftp4j.FTPAbortedException;
import it.sauronsoftware.ftp4j.FTPClient;
import it.sauronsoftware.ftp4j.FTPDataTransferException;
import it.sauronsoftware.ftp4j.FTPException;
import it.sauronsoftware.ftp4j.FTPIllegalReplyException;
import xyz.yakdmt.navremote.App;
import xyz.yakdmt.navremote.utils.Constants;

/**
 * Created by yakdmt on 26/11/15.
 */
public class GetFilesTask extends AsyncTask<String, Void, Boolean> {

    private final static String LOG_TAG = "GetFilesTask";
    private Context mContext;
    private  ProgressDialog mProgress;

    public GetFilesTask(Context pContext, @NonNull ProgressDialog pProgress) {
        mContext = pContext;
        mProgress = pProgress;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mProgress.show();
    }

    @Override
    protected Boolean doInBackground(String... params) {
        int count = 0;
        for (String filename : Constants.FILENAME_ARRAY) {

            try {
                File output = new File(App.getContext().getFilesDir()+"/"+filename+Constants.FILE_EXTENSION);
                boolean isOk = downloadAndSaveFile(Constants.SERVER_NAME,
                        Constants.PORT,
                        Constants.USER_NAME,
                        Constants.PASS,
                        Constants.SERVER_PATH + filename + Constants.FILE_EXTENSION,
                        output);
                if (isOk) {
                    count++;
                }
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
        }
        Log.i(LOG_TAG, "Получено " + count + " из " + Constants.FILENAME_ARRAY.length + " файлов");
        //Toast.makeText(mContext, "Получено "+count+" из "+Constants.FILENAME_ARRAY.length+" файлов", Toast.LENGTH_LONG).show();
        return (count == Constants.FILENAME_ARRAY.length);
    }

    @Override
    protected void onPostExecute(Boolean result) {
        super.onPostExecute(result);
        mProgress.hide();
        new ParseTask(mContext, mProgress).execute();
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
}
