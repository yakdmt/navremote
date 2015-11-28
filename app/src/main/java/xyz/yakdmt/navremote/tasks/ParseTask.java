package xyz.yakdmt.navremote.tasks;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import xyz.yakdmt.navremote.App;
import xyz.yakdmt.navremote.utils.Column;
import xyz.yakdmt.navremote.utils.Constants;

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
        mProgress.setTitle("Обработка...");
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
                        for (Field field : fields) {
                            Column columnName = field.getAnnotation(Column.class);
                            if (columnName != null) {
                                String name = columnName.name();
                                Cell nameCell = sheet.getRow(0).getCell(column);
                                String xlsName = nameCell.getStringCellValue();
                                if (name.equals(xlsName)) {
                                    Cell cell = sheet.getRow(i).getCell(column);
                                    String methodName = "set" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
                                    Method method = clazz.getMethod(methodName, String.class);
                                    if (method != null) {
                                        method.invoke(object, cell.getStringCellValue());
                                    }
                                }
                            }
                        }
                    }
                    Method method = clazz.getMethod("save");
                    if (method != null) {
                        method.invoke(object);
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
    }

}
