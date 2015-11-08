package xyz.yakdmt.navremote.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import xyz.yakdmt.navremote.database.Work;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "WORK".
*/
public class WorkDao extends AbstractDao<Work, String> {

    public static final String TABLENAME = "WORK";

    /**
     * Properties of entity Work.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, String.class, "id", true, "ID");
        public final static Property Work_code = new Property(1, String.class, "work_code", false, "WORK_CODE");
        public final static Property Work_type = new Property(2, String.class, "work_type", false, "WORK_TYPE");
        public final static Property Measure_unit = new Property(3, String.class, "measure_unit", false, "MEASURE_UNIT");
        public final static Property Count = new Property(4, String.class, "count", false, "COUNT");
        public final static Property Responsible_worker = new Property(5, String.class, "responsible_worker", false, "RESPONSIBLE_WORKER");
        public final static Property Comment = new Property(6, String.class, "comment", false, "COMMENT");
        public final static Property Working_place = new Property(7, String.class, "working_place", false, "WORKING_PLACE");
        public final static Property Description = new Property(8, String.class, "description", false, "DESCRIPTION");
        public final static Property Delivery_id = new Property(9, String.class, "delivery_id", false, "DELIVERY_ID");
        public final static Property Cargo_id = new Property(10, String.class, "cargo_id", false, "CARGO_ID");
        public final static Property Actual_finish_date = new Property(11, String.class, "actual_finish_date", false, "ACTUAL_FINISH_DATE");
        public final static Property Actual_finish_time = new Property(12, String.class, "actual_finish_time", false, "ACTUAL_FINISH_TIME");
        public final static Property Creator = new Property(13, String.class, "creator", false, "CREATOR");
        public final static Property Responsible_department = new Property(14, String.class, "responsible_department", false, "RESPONSIBLE_DEPARTMENT");
    };


    public WorkDao(DaoConfig config) {
        super(config);
    }
    
    public WorkDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"WORK\" (" + //
                "\"ID\" TEXT PRIMARY KEY NOT NULL UNIQUE ," + // 0: id
                "\"WORK_CODE\" TEXT," + // 1: work_code
                "\"WORK_TYPE\" TEXT," + // 2: work_type
                "\"MEASURE_UNIT\" TEXT," + // 3: measure_unit
                "\"COUNT\" TEXT," + // 4: count
                "\"RESPONSIBLE_WORKER\" TEXT," + // 5: responsible_worker
                "\"COMMENT\" TEXT," + // 6: comment
                "\"WORKING_PLACE\" TEXT," + // 7: working_place
                "\"DESCRIPTION\" TEXT," + // 8: description
                "\"DELIVERY_ID\" TEXT," + // 9: delivery_id
                "\"CARGO_ID\" TEXT," + // 10: cargo_id
                "\"ACTUAL_FINISH_DATE\" TEXT," + // 11: actual_finish_date
                "\"ACTUAL_FINISH_TIME\" TEXT," + // 12: actual_finish_time
                "\"CREATOR\" TEXT," + // 13: creator
                "\"RESPONSIBLE_DEPARTMENT\" TEXT);"); // 14: responsible_department
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"WORK\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Work entity) {
        stmt.clearBindings();
 
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(1, id);
        }
 
        String work_code = entity.getWork_code();
        if (work_code != null) {
            stmt.bindString(2, work_code);
        }
 
        String work_type = entity.getWork_type();
        if (work_type != null) {
            stmt.bindString(3, work_type);
        }
 
        String measure_unit = entity.getMeasure_unit();
        if (measure_unit != null) {
            stmt.bindString(4, measure_unit);
        }
 
        String count = entity.getCount();
        if (count != null) {
            stmt.bindString(5, count);
        }
 
        String responsible_worker = entity.getResponsible_worker();
        if (responsible_worker != null) {
            stmt.bindString(6, responsible_worker);
        }
 
        String comment = entity.getComment();
        if (comment != null) {
            stmt.bindString(7, comment);
        }
 
        String working_place = entity.getWorking_place();
        if (working_place != null) {
            stmt.bindString(8, working_place);
        }
 
        String description = entity.getDescription();
        if (description != null) {
            stmt.bindString(9, description);
        }
 
        String delivery_id = entity.getDelivery_id();
        if (delivery_id != null) {
            stmt.bindString(10, delivery_id);
        }
 
        String cargo_id = entity.getCargo_id();
        if (cargo_id != null) {
            stmt.bindString(11, cargo_id);
        }
 
        String actual_finish_date = entity.getActual_finish_date();
        if (actual_finish_date != null) {
            stmt.bindString(12, actual_finish_date);
        }
 
        String actual_finish_time = entity.getActual_finish_time();
        if (actual_finish_time != null) {
            stmt.bindString(13, actual_finish_time);
        }
 
        String creator = entity.getCreator();
        if (creator != null) {
            stmt.bindString(14, creator);
        }
 
        String responsible_department = entity.getResponsible_department();
        if (responsible_department != null) {
            stmt.bindString(15, responsible_department);
        }
    }

    /** @inheritdoc */
    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Work readEntity(Cursor cursor, int offset) {
        Work entity = new Work( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // work_code
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // work_type
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // measure_unit
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // count
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // responsible_worker
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // comment
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // working_place
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // description
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // delivery_id
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // cargo_id
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // actual_finish_date
            cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), // actual_finish_time
            cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13), // creator
            cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14) // responsible_department
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Work entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setWork_code(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setWork_type(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setMeasure_unit(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setCount(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setResponsible_worker(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setComment(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setWorking_place(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setDescription(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setDelivery_id(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setCargo_id(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setActual_finish_date(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setActual_finish_time(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setCreator(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
        entity.setResponsible_department(cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14));
     }
    
    /** @inheritdoc */
    @Override
    protected String updateKeyAfterInsert(Work entity, long rowId) {
        return entity.getId();
    }
    
    /** @inheritdoc */
    @Override
    public String getKey(Work entity) {
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
