package xyz.yakdmt.navremote.database;

import android.database.sqlite.SQLiteDatabase;

import xyz.yakdmt.navremote.App;

/**
 * Created by yakdmt on 08/11/15.
 */
public class DaoTask {

    private static class InstanceHolder {
        public static final DaoTask instance = new DaoTask();
    }

    DaoMaster.DevOpenHelper helper;
    SQLiteDatabase db;
    DaoMaster daoMaster;
    DaoSession daoSession;
    OrderDao orderDao;

    public DaoTask(){
        helper = new DaoMaster.DevOpenHelper(App.getContext(), "notes-db", null);
        db = helper.getWritableDatabase();
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
        orderDao = daoSession.getOrderDao();
    }

    public static DaoTask getInstance(){
        return InstanceHolder.instance;
    }

    public DaoSession getSession(){
        return daoSession;
    }
}
