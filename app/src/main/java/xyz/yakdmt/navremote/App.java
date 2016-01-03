package xyz.yakdmt.navremote;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
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
    public static SharedPreferences sharedPreferences;
    final String PREF_FILE = "pref_file";

    @Override public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        sharedPreferences = getSharedPreferences(PREF_FILE, MODE_PRIVATE);
    }

    public static Context getContext(){
        return context;
    }

    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager)  activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
    }



}