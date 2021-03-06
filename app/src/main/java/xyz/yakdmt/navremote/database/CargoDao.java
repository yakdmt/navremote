package xyz.yakdmt.navremote.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import xyz.yakdmt.navremote.database.Cargo;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "CARGO".
*/
public class CargoDao extends AbstractDao<Cargo, String> {

    public static final String TABLENAME = "CARGO";

    /**
     * Properties of entity Cargo.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, String.class, "id", true, "ID");
        public final static Property Transport = new Property(1, String.class, "transport", false, "TRANSPORT");
        public final static Property Master_document = new Property(2, String.class, "master_document", false, "MASTER_DOCUMENT");
        public final static Property Sender_code = new Property(3, String.class, "sender_code", false, "SENDER_CODE");
        public final static Property Sender_name = new Property(4, String.class, "sender_name", false, "SENDER_NAME");
        public final static Property Appearance_date = new Property(5, String.class, "appearance_date", false, "APPEARANCE_DATE");
        public final static Property Destination_checkpoint_code = new Property(6, String.class, "destination_checkpoint_code", false, "DESTINATION_CHECKPOINT_CODE");
        public final static Property Transport_line_code = new Property(7, String.class, "transport_line_code", false, "TRANSPORT_LINE_CODE");
        public final static Property Transport_line_name = new Property(8, String.class, "transport_line_name", false, "TRANSPORT_LINE_NAME");
        public final static Property Client_id = new Property(9, String.class, "client_id", false, "CLIENT_ID");
        public final static Property Client_name = new Property(10, String.class, "client_name", false, "CLIENT_NAME");
        public final static Property Standard_description = new Property(11, String.class, "standard_description", false, "STANDARD_DESCRIPTION");
        public final static Property Description = new Property(12, String.class, "description", false, "DESCRIPTION");
        public final static Property Insurance = new Property(13, String.class, "insurance", false, "INSURANCE");
        public final static Property Insurance_amount = new Property(14, String.class, "insurance_amount", false, "INSURANCE_AMOUNT");
        public final static Property Count = new Property(15, String.class, "count", false, "COUNT");
        public final static Property Weight = new Property(16, String.class, "weight", false, "WEIGHT");
        public final static Property Volume = new Property(17, String.class, "volume", false, "VOLUME");
        public final static Property Occurence_checkpoint_type = new Property(18, String.class, "occurence_checkpoint_type", false, "OCCURENCE_CHECKPOINT_TYPE");
        public final static Property Occurence_checkpoint_code = new Property(19, String.class, "occurence_checkpoint_code", false, "OCCURENCE_CHECKPOINT_CODE");
        public final static Property Destination_checkpoint_type = new Property(20, String.class, "destination_checkpoint_type", false, "DESTINATION_CHECKPOINT_TYPE");
        public final static Property Currency_code = new Property(21, String.class, "currency_code", false, "CURRENCY_CODE");
        public final static Property Cost = new Property(22, String.class, "cost", false, "COST");
        public final static Property Customs_clearance = new Property(23, String.class, "customs_clearance", false, "CUSTOMS_CLEARANCE");
        public final static Property Broker_code = new Property(24, String.class, "broker_code", false, "BROKER_CODE");
        public final static Property Broker_name = new Property(25, String.class, "broker_name", false, "BROKER_NAME");
        public final static Property Consignee_code = new Property(26, String.class, "consignee_code", false, "CONSIGNEE_CODE");
        public final static Property Consignee_name = new Property(27, String.class, "consignee_name", false, "CONSIGNEE_NAME");
        public final static Property Delivery_conditions = new Property(28, String.class, "delivery_conditions", false, "DELIVERY_CONDITIONS");
        public final static Property Terminal = new Property(29, String.class, "terminal", false, "TERMINAL");
        public final static Property Order_id = new Property(30, String.class, "order_id", false, "ORDER_ID");
        public final static Property Container_number = new Property(31, String.class, "container_number", false, "CONTAINER_NUMBER");
        public final static Property Dt_number = new Property(32, String.class, "dt_number", false, "DT_NUMBER");
        public final static Property Department_name = new Property(33, String.class, "department_name", false, "DEPARTMENT_NAME");
        public final static Property Wagon_number = new Property(34, String.class, "wagon_number", false, "WAGON_NUMBER");
        public final static Property Release_date = new Property(35, String.class, "release_date", false, "RELEASE_DATE");
        public final static Property Product_count = new Property(36, String.class, "product_count", false, "PRODUCT_COUNT");
        public final static Property Dt_registration_date = new Property(37, String.class, "dt_registration_date", false, "DT_REGISTRATION_DATE");
    };


    public CargoDao(DaoConfig config) {
        super(config);
    }
    
    public CargoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"CARGO\" (" + //
                "\"ID\" TEXT PRIMARY KEY NOT NULL UNIQUE ," + // 0: id
                "\"TRANSPORT\" TEXT," + // 1: transport
                "\"MASTER_DOCUMENT\" TEXT," + // 2: master_document
                "\"SENDER_CODE\" TEXT," + // 3: sender_code
                "\"SENDER_NAME\" TEXT," + // 4: sender_name
                "\"APPEARANCE_DATE\" TEXT," + // 5: appearance_date
                "\"DESTINATION_CHECKPOINT_CODE\" TEXT," + // 6: destination_checkpoint_code
                "\"TRANSPORT_LINE_CODE\" TEXT," + // 7: transport_line_code
                "\"TRANSPORT_LINE_NAME\" TEXT," + // 8: transport_line_name
                "\"CLIENT_ID\" TEXT," + // 9: client_id
                "\"CLIENT_NAME\" TEXT," + // 10: client_name
                "\"STANDARD_DESCRIPTION\" TEXT," + // 11: standard_description
                "\"DESCRIPTION\" TEXT," + // 12: description
                "\"INSURANCE\" TEXT," + // 13: insurance
                "\"INSURANCE_AMOUNT\" TEXT," + // 14: insurance_amount
                "\"COUNT\" TEXT," + // 15: count
                "\"WEIGHT\" TEXT," + // 16: weight
                "\"VOLUME\" TEXT," + // 17: volume
                "\"OCCURENCE_CHECKPOINT_TYPE\" TEXT," + // 18: occurence_checkpoint_type
                "\"OCCURENCE_CHECKPOINT_CODE\" TEXT," + // 19: occurence_checkpoint_code
                "\"DESTINATION_CHECKPOINT_TYPE\" TEXT," + // 20: destination_checkpoint_type
                "\"CURRENCY_CODE\" TEXT," + // 21: currency_code
                "\"COST\" TEXT," + // 22: cost
                "\"CUSTOMS_CLEARANCE\" TEXT," + // 23: customs_clearance
                "\"BROKER_CODE\" TEXT," + // 24: broker_code
                "\"BROKER_NAME\" TEXT," + // 25: broker_name
                "\"CONSIGNEE_CODE\" TEXT," + // 26: consignee_code
                "\"CONSIGNEE_NAME\" TEXT," + // 27: consignee_name
                "\"DELIVERY_CONDITIONS\" TEXT," + // 28: delivery_conditions
                "\"TERMINAL\" TEXT," + // 29: terminal
                "\"ORDER_ID\" TEXT," + // 30: order_id
                "\"CONTAINER_NUMBER\" TEXT," + // 31: container_number
                "\"DT_NUMBER\" TEXT," + // 32: dt_number
                "\"DEPARTMENT_NAME\" TEXT," + // 33: department_name
                "\"WAGON_NUMBER\" TEXT," + // 34: wagon_number
                "\"RELEASE_DATE\" TEXT," + // 35: release_date
                "\"PRODUCT_COUNT\" TEXT," + // 36: product_count
                "\"DT_REGISTRATION_DATE\" TEXT);"); // 37: dt_registration_date
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"CARGO\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Cargo entity) {
        stmt.clearBindings();
 
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(1, id);
        }
 
        String transport = entity.getTransport();
        if (transport != null) {
            stmt.bindString(2, transport);
        }
 
        String master_document = entity.getMaster_document();
        if (master_document != null) {
            stmt.bindString(3, master_document);
        }
 
        String sender_code = entity.getSender_code();
        if (sender_code != null) {
            stmt.bindString(4, sender_code);
        }
 
        String sender_name = entity.getSender_name();
        if (sender_name != null) {
            stmt.bindString(5, sender_name);
        }
 
        String appearance_date = entity.getAppearance_date();
        if (appearance_date != null) {
            stmt.bindString(6, appearance_date);
        }
 
        String destination_checkpoint_code = entity.getDestination_checkpoint_code();
        if (destination_checkpoint_code != null) {
            stmt.bindString(7, destination_checkpoint_code);
        }
 
        String transport_line_code = entity.getTransport_line_code();
        if (transport_line_code != null) {
            stmt.bindString(8, transport_line_code);
        }
 
        String transport_line_name = entity.getTransport_line_name();
        if (transport_line_name != null) {
            stmt.bindString(9, transport_line_name);
        }
 
        String client_id = entity.getClient_id();
        if (client_id != null) {
            stmt.bindString(10, client_id);
        }
 
        String client_name = entity.getClient_name();
        if (client_name != null) {
            stmt.bindString(11, client_name);
        }
 
        String standard_description = entity.getStandard_description();
        if (standard_description != null) {
            stmt.bindString(12, standard_description);
        }
 
        String description = entity.getDescription();
        if (description != null) {
            stmt.bindString(13, description);
        }
 
        String insurance = entity.getInsurance();
        if (insurance != null) {
            stmt.bindString(14, insurance);
        }
 
        String insurance_amount = entity.getInsurance_amount();
        if (insurance_amount != null) {
            stmt.bindString(15, insurance_amount);
        }
 
        String count = entity.getCount();
        if (count != null) {
            stmt.bindString(16, count);
        }
 
        String weight = entity.getWeight();
        if (weight != null) {
            stmt.bindString(17, weight);
        }
 
        String volume = entity.getVolume();
        if (volume != null) {
            stmt.bindString(18, volume);
        }
 
        String occurence_checkpoint_type = entity.getOccurence_checkpoint_type();
        if (occurence_checkpoint_type != null) {
            stmt.bindString(19, occurence_checkpoint_type);
        }
 
        String occurence_checkpoint_code = entity.getOccurence_checkpoint_code();
        if (occurence_checkpoint_code != null) {
            stmt.bindString(20, occurence_checkpoint_code);
        }
 
        String destination_checkpoint_type = entity.getDestination_checkpoint_type();
        if (destination_checkpoint_type != null) {
            stmt.bindString(21, destination_checkpoint_type);
        }
 
        String currency_code = entity.getCurrency_code();
        if (currency_code != null) {
            stmt.bindString(22, currency_code);
        }
 
        String cost = entity.getCost();
        if (cost != null) {
            stmt.bindString(23, cost);
        }
 
        String customs_clearance = entity.getCustoms_clearance();
        if (customs_clearance != null) {
            stmt.bindString(24, customs_clearance);
        }
 
        String broker_code = entity.getBroker_code();
        if (broker_code != null) {
            stmt.bindString(25, broker_code);
        }
 
        String broker_name = entity.getBroker_name();
        if (broker_name != null) {
            stmt.bindString(26, broker_name);
        }
 
        String consignee_code = entity.getConsignee_code();
        if (consignee_code != null) {
            stmt.bindString(27, consignee_code);
        }
 
        String consignee_name = entity.getConsignee_name();
        if (consignee_name != null) {
            stmt.bindString(28, consignee_name);
        }
 
        String delivery_conditions = entity.getDelivery_conditions();
        if (delivery_conditions != null) {
            stmt.bindString(29, delivery_conditions);
        }
 
        String terminal = entity.getTerminal();
        if (terminal != null) {
            stmt.bindString(30, terminal);
        }
 
        String order_id = entity.getOrder_id();
        if (order_id != null) {
            stmt.bindString(31, order_id);
        }
 
        String container_number = entity.getContainer_number();
        if (container_number != null) {
            stmt.bindString(32, container_number);
        }
 
        String dt_number = entity.getDt_number();
        if (dt_number != null) {
            stmt.bindString(33, dt_number);
        }
 
        String department_name = entity.getDepartment_name();
        if (department_name != null) {
            stmt.bindString(34, department_name);
        }
 
        String wagon_number = entity.getWagon_number();
        if (wagon_number != null) {
            stmt.bindString(35, wagon_number);
        }
 
        String release_date = entity.getRelease_date();
        if (release_date != null) {
            stmt.bindString(36, release_date);
        }
 
        String product_count = entity.getProduct_count();
        if (product_count != null) {
            stmt.bindString(37, product_count);
        }
 
        String dt_registration_date = entity.getDt_registration_date();
        if (dt_registration_date != null) {
            stmt.bindString(38, dt_registration_date);
        }
    }

    /** @inheritdoc */
    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Cargo readEntity(Cursor cursor, int offset) {
        Cargo entity = new Cargo( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // transport
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // master_document
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // sender_code
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // sender_name
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // appearance_date
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // destination_checkpoint_code
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // transport_line_code
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // transport_line_name
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // client_id
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // client_name
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // standard_description
            cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), // description
            cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13), // insurance
            cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14), // insurance_amount
            cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15), // count
            cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16), // weight
            cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17), // volume
            cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18), // occurence_checkpoint_type
            cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19), // occurence_checkpoint_code
            cursor.isNull(offset + 20) ? null : cursor.getString(offset + 20), // destination_checkpoint_type
            cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21), // currency_code
            cursor.isNull(offset + 22) ? null : cursor.getString(offset + 22), // cost
            cursor.isNull(offset + 23) ? null : cursor.getString(offset + 23), // customs_clearance
            cursor.isNull(offset + 24) ? null : cursor.getString(offset + 24), // broker_code
            cursor.isNull(offset + 25) ? null : cursor.getString(offset + 25), // broker_name
            cursor.isNull(offset + 26) ? null : cursor.getString(offset + 26), // consignee_code
            cursor.isNull(offset + 27) ? null : cursor.getString(offset + 27), // consignee_name
            cursor.isNull(offset + 28) ? null : cursor.getString(offset + 28), // delivery_conditions
            cursor.isNull(offset + 29) ? null : cursor.getString(offset + 29), // terminal
            cursor.isNull(offset + 30) ? null : cursor.getString(offset + 30), // order_id
            cursor.isNull(offset + 31) ? null : cursor.getString(offset + 31), // container_number
            cursor.isNull(offset + 32) ? null : cursor.getString(offset + 32), // dt_number
            cursor.isNull(offset + 33) ? null : cursor.getString(offset + 33), // department_name
            cursor.isNull(offset + 34) ? null : cursor.getString(offset + 34), // wagon_number
            cursor.isNull(offset + 35) ? null : cursor.getString(offset + 35), // release_date
            cursor.isNull(offset + 36) ? null : cursor.getString(offset + 36), // product_count
            cursor.isNull(offset + 37) ? null : cursor.getString(offset + 37) // dt_registration_date
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Cargo entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setTransport(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setMaster_document(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setSender_code(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setSender_name(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setAppearance_date(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setDestination_checkpoint_code(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setTransport_line_code(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setTransport_line_name(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setClient_id(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setClient_name(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setStandard_description(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setDescription(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setInsurance(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
        entity.setInsurance_amount(cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14));
        entity.setCount(cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15));
        entity.setWeight(cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16));
        entity.setVolume(cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17));
        entity.setOccurence_checkpoint_type(cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18));
        entity.setOccurence_checkpoint_code(cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19));
        entity.setDestination_checkpoint_type(cursor.isNull(offset + 20) ? null : cursor.getString(offset + 20));
        entity.setCurrency_code(cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21));
        entity.setCost(cursor.isNull(offset + 22) ? null : cursor.getString(offset + 22));
        entity.setCustoms_clearance(cursor.isNull(offset + 23) ? null : cursor.getString(offset + 23));
        entity.setBroker_code(cursor.isNull(offset + 24) ? null : cursor.getString(offset + 24));
        entity.setBroker_name(cursor.isNull(offset + 25) ? null : cursor.getString(offset + 25));
        entity.setConsignee_code(cursor.isNull(offset + 26) ? null : cursor.getString(offset + 26));
        entity.setConsignee_name(cursor.isNull(offset + 27) ? null : cursor.getString(offset + 27));
        entity.setDelivery_conditions(cursor.isNull(offset + 28) ? null : cursor.getString(offset + 28));
        entity.setTerminal(cursor.isNull(offset + 29) ? null : cursor.getString(offset + 29));
        entity.setOrder_id(cursor.isNull(offset + 30) ? null : cursor.getString(offset + 30));
        entity.setContainer_number(cursor.isNull(offset + 31) ? null : cursor.getString(offset + 31));
        entity.setDt_number(cursor.isNull(offset + 32) ? null : cursor.getString(offset + 32));
        entity.setDepartment_name(cursor.isNull(offset + 33) ? null : cursor.getString(offset + 33));
        entity.setWagon_number(cursor.isNull(offset + 34) ? null : cursor.getString(offset + 34));
        entity.setRelease_date(cursor.isNull(offset + 35) ? null : cursor.getString(offset + 35));
        entity.setProduct_count(cursor.isNull(offset + 36) ? null : cursor.getString(offset + 36));
        entity.setDt_registration_date(cursor.isNull(offset + 37) ? null : cursor.getString(offset + 37));
     }
    
    /** @inheritdoc */
    @Override
    protected String updateKeyAfterInsert(Cargo entity, long rowId) {
        return entity.getId();
    }
    
    /** @inheritdoc */
    @Override
    public String getKey(Cargo entity) {
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
