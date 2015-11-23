package xyz.yakdmt.navremote.database;

import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import xyz.yakdmt.navremote.App;

/**
 * Created by yakdmt on 08/11/15.
 */
public class DaoTask {

    public static final String PRELIMINARY_PREFIX = "PRE";
    public static final String PRELIMINARY_FIRST = "PRE000001";

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

    public String getNewOrderId(){
        ArrayList<Order> preliminaryOrders = (ArrayList<Order>) getInstance().getSession().getOrderDao().queryBuilder().where(OrderDao.Properties.Id.between("PRE000000", "PRE999999")).list();
        if (preliminaryOrders == null || preliminaryOrders.size()==0) {
            return PRELIMINARY_FIRST;
        }
        Collections.sort(preliminaryOrders, new Comparator<Order>() {
            @Override
            public int compare(Order lhs, Order rhs) {
                return -(lhs.getId().compareTo(rhs.getId()));
            }
        });
        Order order = preliminaryOrders.get(0);
        String id = order.getId();
        id = id.replaceAll(PRELIMINARY_PREFIX, "");
        int num = Integer.parseInt(id);
        num++;
        String newId = String.valueOf(num);
        String mask = "000000";
        return PRELIMINARY_PREFIX+mask.substring(0, mask.length()-newId.length())+newId;
    }
}
