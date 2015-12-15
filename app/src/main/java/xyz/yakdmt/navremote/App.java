package xyz.yakdmt.navremote;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by yakdmt on 08/11/15.
 */
public class App extends Application {
    private static Context context;
    public static boolean bindViews = true;
    public static String currentClientId = "";
    public static String currentContactId = "";
    public static boolean skipLogin = false;

    @Override public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext(){
        return context;
    }

    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager)  activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
    }

}