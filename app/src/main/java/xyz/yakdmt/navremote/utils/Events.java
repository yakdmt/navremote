package xyz.yakdmt.navremote.utils;

import xyz.yakdmt.navremote.database.Cargo;
import xyz.yakdmt.navremote.database.Delivery;
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

    public static class OnCargoClick {

        private Cargo mCargo;

        public OnCargoClick(Cargo pCargo) {
            mCargo = pCargo;
        }

        public Cargo getCargo(){
            return mCargo;
        }

    }

    public static class OnDeliveryClick {

        private Delivery mDelivery;

        public OnDeliveryClick(Delivery pDelivery) {
            mDelivery = pDelivery;
        }

        public Delivery getDelivery(){
            return mDelivery;
        }

    }

    public static class OnDataUpdated {

    }

    public static class OnAuthCompleted {

        private boolean isOk;

        public OnAuthCompleted(boolean ok) {
            isOk = ok;
        }

        public boolean getIsOk(){
            return isOk;
        }
    }
}
