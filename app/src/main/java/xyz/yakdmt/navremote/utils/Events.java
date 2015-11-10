package xyz.yakdmt.navremote.utils;

import xyz.yakdmt.navremote.database.Order;

/**
 * Created by yakdmt on 10/11/15.
 */
public class Events {

    public static class OnOrderClick {

        private Order mOrder;

        public OnOrderClick(Order pOrder) {
            mOrder = pOrder;
        }

        public Order getOrder(){
            return mOrder;
        }

    }
}
