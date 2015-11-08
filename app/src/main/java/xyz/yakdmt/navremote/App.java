package xyz.yakdmt.navremote;

import android.app.Application;
import android.content.Context;

/**
 * Created by yakdmt on 08/11/15.
 */
public class App extends Application {
    private static Context context;

    @Override public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext(){
        return context;
    }
}