package xyz.yakdmt.navremote.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import xyz.yakdmt.navremote.database.Contact;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "CONTACT".
*/
public class ContactDao extends AbstractDao<Contact, String> {

    public static final String TABLENAME = "CONTACT";

    /**
     * Properties of entity Contact.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, String.class, "id", true, "ID");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property Client_id = new Property(2, String.class, "client_id", false, "CLIENT_ID");
        public final static Property Client_name = new Property(3, String.class, "client_name", false, "CLIENT_NAME");
        public final static Property Postal_index = new Property(4, String.class, "postal_index", false, "POSTAL_INDEX");
        public final static Property Region_code = new Property(5, String.class, "region_code", false, "REGION_CODE");
        public final static Property Phone = new Property(6, String.class, "phone", false, "PHONE");
        public final static Property Mobile_phone = new Property(7, String.class, "mobile_phone", false, "MOBILE_PHONE");
        public final static Property Fax = new Property(8, String.class, "fax", false, "FAX");
        public final static Property Manager_code = new Property(9, String.class, "manager_code", false, "MANAGER_CODE");
    };


    public ContactDao(DaoConfig config) {
        super(config);
    }
    
    public ContactDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"CONTACT\" (" + //
                "\"ID\" TEXT PRIMARY KEY NOT NULL UNIQUE ," + // 0: id
                "\"NAME\" TEXT," + // 1: name
                "\"CLIENT_ID\" TEXT," + // 2: client_id
                "\"CLIENT_NAME\" TEXT," + // 3: client_name
                "\"POSTAL_INDEX\" TEXT," + // 4: postal_index
                "\"REGION_CODE\" TEXT," + // 5: region_code
                "\"PHONE\" TEXT," + // 6: phone
                "\"MOBILE_PHONE\" TEXT," + // 7: mobile_phone
                "\"FAX\" TEXT," + // 8: fax
                "\"MANAGER_CODE\" TEXT);"); // 9: manager_code
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"CONTACT\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Contact entity) {
        stmt.clearBindings();
 
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(1, id);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        String client_id = entity.getClient_id();
        if (client_id != null) {
            stmt.bindString(3, client_id);
        }
 
        String client_name = entity.getClient_name();
        if (client_name != null) {
            stmt.bindString(4, client_name);
        }
 
        String postal_index = entity.getPostal_index();
        if (postal_index != null) {
            stmt.bindString(5, postal_index);
        }
 
        String region_code = entity.getRegion_code();
        if (region_code != null) {
            stmt.bindString(6, region_code);
        }
 
        String phone = entity.getPhone();
        if (phone != null) {
            stmt.bindString(7, phone);
        }
 
        String mobile_phone = entity.getMobile_phone();
        if (mobile_phone != null) {
            stmt.bindString(8, mobile_phone);
        }
 
        String fax = entity.getFax();
        if (fax != null) {
            stmt.bindString(9, fax);
        }
 
        String manager_code = entity.getManager_code();
        if (manager_code != null) {
            stmt.bindString(10, manager_code);
        }
    }

    /** @inheritdoc */
    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Contact readEntity(Cursor cursor, int offset) {
        Contact entity = new Contact( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // name
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // client_id
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // client_name
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // postal_index
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // region_code
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // phone
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // mobile_phone
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // fax
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9) // manager_code
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Contact entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setClient_id(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setClient_name(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setPostal_index(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setRegion_code(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setPhone(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setMobile_phone(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setFax(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setManager_code(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
     }
    
    /** @inheritdoc */
    @Override
    protected String updateKeyAfterInsert(Contact entity, long rowId) {
        return entity.getId();
    }
    
    /** @inheritdoc */
    @Override
    public String getKey(Contact entity) {
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
