package xyz.yakdmt.navremote.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yakdmt on 21/11/15.
 */
public class TextUtil {

    public static String removeNulls(String text){
        if (text==null) {
            return "     ";
        }
        if (text.contains("null")) {
            String result = text.replaceAll("null", "     ");
            if (result.contains(" , ")) {
                return "    ";
            }
            return result;
        }
        return text;
    }

    public static String removeNulls(StringBuilder builder){
        String text = builder.toString();
        return removeNulls(text);
    }

    public static String getCurrentDate(){
        return new SimpleDateFormat("dd/MM/yy").format(new Date());
    }

    public static String getCurrentTime(){
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }
}
