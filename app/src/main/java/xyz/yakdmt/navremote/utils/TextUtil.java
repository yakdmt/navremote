package xyz.yakdmt.navremote.utils;

/**
 * Created by yakdmt on 21/11/15.
 */
public class TextUtil {

    public static String removeNulls(String text){
        if (text.contains("null")) {
            text.replaceAll("null\\s?", "");
        }
        return text;
    }
}
