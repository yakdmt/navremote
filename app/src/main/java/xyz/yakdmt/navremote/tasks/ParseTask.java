package xyz.yakdmt.navremote.tasks;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import de.greenrobot.event.EventBus;
import xyz.yakdmt.navremote.App;
import xyz.yakdmt.navremote.utils.Column;
import xyz.yakdmt.navremote.utils.Constants;
import xyz.yakdmt.navremote.utils.Events;

/**
 * Created by yakdmt on 26/11/15.
 */
public class ParseTask extends AsyncTask<String, Void, Boolean> {

    private final static String LOG_TAG = "ParseTask";
    private Context mContext;
    private ProgressDialog mProgress;

    public ParseTask(Context pContext, @NonNull ProgressDialog pProgress) {
        mContext = pContext;
        mProgress = pProgress;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mProgress.setMessage("Обработка...");
        mProgress.show();
    }

    @Override
    protected Boolean doInBackground(String... params) {
        int count = 0;
        for (int i = 0; i<Constants.FILENAME_ARRAY.length; i++) {
            String filename = Constants.FILENAME_ARRAY[i];
            File inputWorkbook = new File(App.getContext().getFilesDir()+"/"+filename+Constants.FILE_EXTENSION);
            if (!inputWorkbook.exists()) {
                Log.i(LOG_TAG, "file " + inputWorkbook.getName() + " не найден");
                continue;
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
                    Class clazz = Constants.CLASSES_ARRAY[i];
                    Object object = clazz.newInstance();
                    for (int column = 0; column < sheet.getRow(0).getPhysicalNumberOfCells(); column++) {
                        Field[] fields = clazz.getDeclaredFields();
                        boolean isFound = false;
                        for (Field field : fields) {
                            Column columnName = field.getAnnotation(Column.class);
                            if (columnName != null) {
                                String name = columnName.name();
                                Cell nameCell = sheet.getRow(0).getCell(column);
                                String xlsName = nameCell.getStringCellValue();
                                if (name.equals(xlsName)) {
                                    isFound = true;
                                    Row sheetRow = sheet.getRow(row);
                                    if (sheetRow==null) {
                                        continue;
                                    }
                                    Cell cell = sheetRow.getCell(column);
                                    if (cell == null) {
                                        continue;
                                    }
                                    String methodName = "set" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
                                    Method method = clazz.getMethod(methodName, String.class);
                                    if (method != null) {
                                        String value = "";
                                        if (cell.getCellType() == 0 || cell.getCellType() == 2) {
                                            value = String.valueOf(cell.getNumericCellValue());
                                        } else {
                                            try {
                                                value = cell.getStringCellValue();
                                            } catch (Exception e) {
                                                Log.i(LOG_TAG, "cell.getType=="+cell.getCellType()+", cell.getname"+xlsName+"i="+i);
                                                e.printStackTrace();
                                            }
                                        }
                                        if (xlsName.toLowerCase().contains("дата")) {
                                            Date date = cell.getDateCellValue();
                                            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                                            value = dateFormat.format(date);
                                        }
                                        if (xlsName.toLowerCase().contains("время")) {
                                            Date date = cell.getDateCellValue();
                                            DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
                                            value = dateFormat.format(date);
                                        }
                                        
                                        if (value==null) {
                                            value = "";
                                        }
                                        method.invoke(object, value);
                                    }
                                }
                            }
                        }
                        if (!isFound) {
                            Cell nameCell = sheet.getRow(0).getCell(column);
                            String xlsName = nameCell.getStringCellValue();
                            Log.i(LOG_TAG, "Column not found, name = " + xlsName);
                        }
                    }
                    Method method = clazz.getMethod("save");
                    if (method != null) {
                        try {method.invoke(object);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                }
                Log.i(LOG_TAG, "saved " + (sheet.getPhysicalNumberOfRows()-1) + " objects of " + Constants.CLASSES_ARRAY[i].getName());
            }  catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    @Override
    protected void onPostExecute(Boolean result) {
        super.onPostExecute(result);
        mProgress.hide();
        EventBus.getDefault().post(new Events.OnDataUpdated());
    }

}
