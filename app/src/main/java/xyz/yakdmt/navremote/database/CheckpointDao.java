package xyz.yakdmt.navremote.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import xyz.yakdmt.navremote.database.Checkpoint;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "CHECKPOINT".
*/
public class CheckpointDao extends AbstractDao<Checkpoint, String> {

    public static final String TABLENAME = "CHECKPOINT";

    /**
     * Properties of entity Checkpoint.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, String.class, "id", true, "ID");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property Country_code = new Property(2, String.class, "country_code", false, "COUNTRY_CODE");
        public final static Property Info = new Property(3, String.class, "info", false, "INFO");
        public final static Property Type = new Property(4, String.class, "type", false, "TYPE");
    };


    public CheckpointDao(DaoConfig config) {
        super(config);
    }
    
    public CheckpointDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"CHECKPOINT\" (" + //
                "\"ID\" TEXT PRIMARY KEY NOT NULL ," + // 0: id
                "\"NAME\" TEXT," + // 1: name
                "\"COUNTRY_CODE\" TEXT," + // 2: country_code
                "\"INFO\" TEXT," + // 3: info
                "\"TYPE\" TEXT);"); // 4: type
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"CHECKPOINT\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Checkpoint entity) {
        stmt.clearBindings();
 
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(1, id);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        String country_code = entity.getCountry_code();
        if (country_code != null) {
            stmt.bindString(3, country_code);
        }
 
        String info = entity.getInfo();
        if (info != null) {
            stmt.bindString(4, info);
        }
 
        String type = entity.getType();
        if (type != null) {
            stmt.bindString(5, type);
        }
    }

    /** @inheritdoc */
    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Checkpoint readEntity(Cursor cursor, int offset) {
        Checkpoint entity = new Checkpoint( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // name
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // country_code
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // info
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4) // type
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Checkpoint entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setCountry_code(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setInfo(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setType(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
     }
    
    /** @inheritdoc */
    @Override
    protected String updateKeyAfterInsert(Checkpoint entity, long rowId) {
        return entity.getId();
    }
    
    /** @inheritdoc */
    @Override
    public String getKey(Checkpoint entity) {
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
