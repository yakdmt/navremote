package xyz.yakdmt.navremote.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import xyz.yakdmt.navremote.database.Delivery;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "DELIVERY".
*/
public class DeliveryDao extends AbstractDao<Delivery, String> {

    public static final String TABLENAME = "DELIVERY";

    /**
     * Properties of entity Delivery.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, String.class, "id", true, "ID");
        public final static Property Transportation_method = new Property(1, String.class, "transportation_method", false, "TRANSPORTATION_METHOD");
        public final static Property Status = new Property(2, String.class, "status", false, "STATUS");
        public final static Property Auto_train_number = new Property(3, String.class, "auto_train_number", false, "AUTO_TRAIN_NUMBER");
        public final static Property Auto_carrier = new Property(4, String.class, "auto_carrier", false, "AUTO_CARRIER");
        public final static Property Description = new Property(5, String.class, "description", false, "DESCRIPTION");
        public final static Property Client_name = new Property(6, String.class, "client_name", false, "CLIENT_NAME");
        public final static Property Cargo_description = new Property(7, String.class, "cargo_description", false, "CARGO_DESCRIPTION");
        public final static Property Expected_start_date = new Property(8, String.class, "expected_start_date", false, "EXPECTED_START_DATE");
        public final static Property Actual_start_date = new Property(9, String.class, "actual_start_date", false, "ACTUAL_START_DATE");
        public final static Property Start_checkpoint_name = new Property(10, String.class, "start_checkpoint_name", false, "START_CHECKPOINT_NAME");
        public final static Property Finish_checkpoint_name = new Property(11, String.class, "finish_checkpoint_name", false, "FINISH_CHECKPOINT_NAME");
        public final static Property Start_country = new Property(12, String.class, "start_country", false, "START_COUNTRY");
        public final static Property Expected_arrival_terminal_date = new Property(13, String.class, "expected_arrival_terminal_date", false, "EXPECTED_ARRIVAL_TERMINAL_DATE");
        public final static Property Actual_arrival_terminal_date = new Property(14, String.class, "actual_arrival_terminal_date", false, "ACTUAL_ARRIVAL_TERMINAL_DATE");
        public final static Property Terminal_name = new Property(15, String.class, "terminal_name", false, "TERMINAL_NAME");
        public final static Property Receiver_name = new Property(16, String.class, "receiver_name", false, "RECEIVER_NAME");
        public final static Property Actual_release_terminal_date = new Property(17, String.class, "actual_release_terminal_date", false, "ACTUAL_RELEASE_TERMINAL_DATE");
        public final static Property Actual_finish_date = new Property(18, String.class, "actual_finish_date", false, "ACTUAL_FINISH_DATE");
        public final static Property Performer_name = new Property(19, String.class, "performer_name", false, "PERFORMER_NAME");
        public final static Property Gtd_release_date = new Property(20, String.class, "gtd_release_date", false, "GTD_RELEASE_DATE");
        public final static Property Gtd_number = new Property(21, String.class, "gtd_number", false, "GTD_NUMBER");
        public final static Property Container_number = new Property(22, String.class, "container_number", false, "CONTAINER_NUMBER");
        public final static Property Wagon_number = new Property(23, String.class, "wagon_number", false, "WAGON_NUMBER");
        public final static Property Tl_number = new Property(24, String.class, "tl_number", false, "TL_NUMBER");
        public final static Property Tl_transport_type = new Property(25, String.class, "tl_transport_type", false, "TL_TRANSPORT_TYPE");
        public final static Property Tl_transport_number = new Property(26, String.class, "tl_transport_number", false, "TL_TRANSPORT_NUMBER");
        public final static Property Cargo_id = new Property(27, String.class, "cargo_id", false, "CARGO_ID");
    };


    public DeliveryDao(DaoConfig config) {
        super(config);
    }
    
    public DeliveryDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"DELIVERY\" (" + //
                "\"ID\" TEXT PRIMARY KEY NOT NULL UNIQUE ," + // 0: id
                "\"TRANSPORTATION_METHOD\" TEXT," + // 1: transportation_method
                "\"STATUS\" TEXT," + // 2: status
                "\"AUTO_TRAIN_NUMBER\" TEXT," + // 3: auto_train_number
                "\"AUTO_CARRIER\" TEXT," + // 4: auto_carrier
                "\"DESCRIPTION\" TEXT," + // 5: description
                "\"CLIENT_NAME\" TEXT," + // 6: client_name
                "\"CARGO_DESCRIPTION\" TEXT," + // 7: cargo_description
                "\"EXPECTED_START_DATE\" TEXT," + // 8: expected_start_date
                "\"ACTUAL_START_DATE\" TEXT," + // 9: actual_start_date
                "\"START_CHECKPOINT_NAME\" TEXT," + // 10: start_checkpoint_name
                "\"FINISH_CHECKPOINT_NAME\" TEXT," + // 11: finish_checkpoint_name
                "\"START_COUNTRY\" TEXT," + // 12: start_country
                "\"EXPECTED_ARRIVAL_TERMINAL_DATE\" TEXT," + // 13: expected_arrival_terminal_date
                "\"ACTUAL_ARRIVAL_TERMINAL_DATE\" TEXT," + // 14: actual_arrival_terminal_date
                "\"TERMINAL_NAME\" TEXT," + // 15: terminal_name
                "\"RECEIVER_NAME\" TEXT," + // 16: receiver_name
                "\"ACTUAL_RELEASE_TERMINAL_DATE\" TEXT," + // 17: actual_release_terminal_date
                "\"ACTUAL_FINISH_DATE\" TEXT," + // 18: actual_finish_date
                "\"PERFORMER_NAME\" TEXT," + // 19: performer_name
                "\"GTD_RELEASE_DATE\" TEXT," + // 20: gtd_release_date
                "\"GTD_NUMBER\" TEXT," + // 21: gtd_number
                "\"CONTAINER_NUMBER\" TEXT," + // 22: container_number
                "\"WAGON_NUMBER\" TEXT," + // 23: wagon_number
                "\"TL_NUMBER\" TEXT," + // 24: tl_number
                "\"TL_TRANSPORT_TYPE\" TEXT," + // 25: tl_transport_type
                "\"TL_TRANSPORT_NUMBER\" TEXT," + // 26: tl_transport_number
                "\"CARGO_ID\" TEXT);"); // 27: cargo_id
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"DELIVERY\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Delivery entity) {
        stmt.clearBindings();
 
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(1, id);
        }
 
        String transportation_method = entity.getTransportation_method();
        if (transportation_method != null) {
            stmt.bindString(2, transportation_method);
        }
 
        String status = entity.getStatus();
        if (status != null) {
            stmt.bindString(3, status);
        }
 
        String auto_train_number = entity.getAuto_train_number();
        if (auto_train_number != null) {
            stmt.bindString(4, auto_train_number);
        }
 
        String auto_carrier = entity.getAuto_carrier();
        if (auto_carrier != null) {
            stmt.bindString(5, auto_carrier);
        }
 
        String description = entity.getDescription();
        if (description != null) {
            stmt.bindString(6, description);
        }
 
        String client_name = entity.getClient_name();
        if (client_name != null) {
            stmt.bindString(7, client_name);
        }
 
        String cargo_description = entity.getCargo_description();
        if (cargo_description != null) {
            stmt.bindString(8, cargo_description);
        }
 
        String expected_start_date = entity.getExpected_start_date();
        if (expected_start_date != null) {
            stmt.bindString(9, expected_start_date);
        }
 
        String actual_start_date = entity.getActual_start_date();
        if (actual_start_date != null) {
            stmt.bindString(10, actual_start_date);
        }
 
        String start_checkpoint_name = entity.getStart_checkpoint_name();
        if (start_checkpoint_name != null) {
            stmt.bindString(11, start_checkpoint_name);
        }
 
        String finish_checkpoint_name = entity.getFinish_checkpoint_name();
        if (finish_checkpoint_name != null) {
            stmt.bindString(12, finish_checkpoint_name);
        }
 
        String start_country = entity.getStart_country();
        if (start_country != null) {
            stmt.bindString(13, start_country);
        }
 
        String expected_arrival_terminal_date = entity.getExpected_arrival_terminal_date();
        if (expected_arrival_terminal_date != null) {
            stmt.bindString(14, expected_arrival_terminal_date);
        }
 
        String actual_arrival_terminal_date = entity.getActual_arrival_terminal_date();
        if (actual_arrival_terminal_date != null) {
            stmt.bindString(15, actual_arrival_terminal_date);
        }
 
        String terminal_name = entity.getTerminal_name();
        if (terminal_name != null) {
            stmt.bindString(16, terminal_name);
        }
 
        String receiver_name = entity.getReceiver_name();
        if (receiver_name != null) {
            stmt.bindString(17, receiver_name);
        }
 
        String actual_release_terminal_date = entity.getActual_release_terminal_date();
        if (actual_release_terminal_date != null) {
            stmt.bindString(18, actual_release_terminal_date);
        }
 
        String actual_finish_date = entity.getActual_finish_date();
        if (actual_finish_date != null) {
            stmt.bindString(19, actual_finish_date);
        }
 
        String performer_name = entity.getPerformer_name();
        if (performer_name != null) {
            stmt.bindString(20, performer_name);
        }
 
        String gtd_release_date = entity.getGtd_release_date();
        if (gtd_release_date != null) {
            stmt.bindString(21, gtd_release_date);
        }
 
        String gtd_number = entity.getGtd_number();
        if (gtd_number != null) {
            stmt.bindString(22, gtd_number);
        }
 
        String container_number = entity.getContainer_number();
        if (container_number != null) {
            stmt.bindString(23, container_number);
        }
 
        String wagon_number = entity.getWagon_number();
        if (wagon_number != null) {
            stmt.bindString(24, wagon_number);
        }
 
        String tl_number = entity.getTl_number();
        if (tl_number != null) {
            stmt.bindString(25, tl_number);
        }
 
        String tl_transport_type = entity.getTl_transport_type();
        if (tl_transport_type != null) {
            stmt.bindString(26, tl_transport_type);
        }
 
        String tl_transport_number = entity.getTl_transport_number();
        if (tl_transport_number != null) {
            stmt.bindString(27, tl_transport_number);
        }
 
        String cargo_id = entity.getCargo_id();
        if (cargo_id != null) {
            stmt.bindString(28, cargo_id);
        }
    }

    /** @inheritdoc */
    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Delivery readEntity(Cursor cursor, int offset) {
        Delivery entity = new Delivery( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // transportation_method
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // status
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // auto_train_number
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // auto_carrier
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // description
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // client_name
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // cargo_description
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // expected_start_date
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // actual_start_date
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // start_checkpoint_name
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // finish_checkpoint_name
            cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), // start_country
            cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13), // expected_arrival_terminal_date
            cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14), // actual_arrival_terminal_date
            cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15), // terminal_name
            cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16), // receiver_name
            cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17), // actual_release_terminal_date
            cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18), // actual_finish_date
            cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19), // performer_name
            cursor.isNull(offset + 20) ? null : cursor.getString(offset + 20), // gtd_release_date
            cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21), // gtd_number
            cursor.isNull(offset + 22) ? null : cursor.getString(offset + 22), // container_number
            cursor.isNull(offset + 23) ? null : cursor.getString(offset + 23), // wagon_number
            cursor.isNull(offset + 24) ? null : cursor.getString(offset + 24), // tl_number
            cursor.isNull(offset + 25) ? null : cursor.getString(offset + 25), // tl_transport_type
            cursor.isNull(offset + 26) ? null : cursor.getString(offset + 26), // tl_transport_number
            cursor.isNull(offset + 27) ? null : cursor.getString(offset + 27) // cargo_id
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Delivery entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setTransportation_method(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setStatus(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setAuto_train_number(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setAuto_carrier(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setDescription(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setClient_name(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setCargo_description(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setExpected_start_date(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setActual_start_date(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setStart_checkpoint_name(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setFinish_checkpoint_name(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setStart_country(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setExpected_arrival_terminal_date(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
        entity.setActual_arrival_terminal_date(cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14));
        entity.setTerminal_name(cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15));
        entity.setReceiver_name(cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16));
        entity.setActual_release_terminal_date(cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17));
        entity.setActual_finish_date(cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18));
        entity.setPerformer_name(cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19));
        entity.setGtd_release_date(cursor.isNull(offset + 20) ? null : cursor.getString(offset + 20));
        entity.setGtd_number(cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21));
        entity.setContainer_number(cursor.isNull(offset + 22) ? null : cursor.getString(offset + 22));
        entity.setWagon_number(cursor.isNull(offset + 23) ? null : cursor.getString(offset + 23));
        entity.setTl_number(cursor.isNull(offset + 24) ? null : cursor.getString(offset + 24));
        entity.setTl_transport_type(cursor.isNull(offset + 25) ? null : cursor.getString(offset + 25));
        entity.setTl_transport_number(cursor.isNull(offset + 26) ? null : cursor.getString(offset + 26));
        entity.setCargo_id(cursor.isNull(offset + 27) ? null : cursor.getString(offset + 27));
     }
    
    /** @inheritdoc */
    @Override
    protected String updateKeyAfterInsert(Delivery entity, long rowId) {
        return entity.getId();
    }
    
    /** @inheritdoc */
    @Override
    public String getKey(Delivery entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
