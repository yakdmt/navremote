package xyz.yakdmt.navremote.database;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.SqlUtils;
import de.greenrobot.dao.internal.DaoConfig;

import xyz.yakdmt.navremote.database.RouteRow;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "ROUTE_ROW".
*/
public class RouteRowDao extends AbstractDao<RouteRow, Long> {

    public static final String TABLENAME = "ROUTE_ROW";

    /**
     * Properties of entity RouteRow.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Delivery_id = new Property(0, String.class, "delivery_id", false, "DELIVERY_ID");
        public final static Property String_number = new Property(1, String.class, "string_number", false, "STRING_NUMBER");
        public final static Property Position = new Property(2, String.class, "position", false, "POSITION");
        public final static Property Id = new Property(3, Long.class, "id", true, "_id");
        public final static Property Checkpoint_description = new Property(4, String.class, "checkpoint_description", false, "CHECKPOINT_DESCRIPTION");
        public final static Property Procedure_type = new Property(5, String.class, "procedure_type", false, "PROCEDURE_TYPE");
        public final static Property Expected_arrival_date = new Property(6, String.class, "expected_arrival_date", false, "EXPECTED_ARRIVAL_DATE");
        public final static Property Actual_arrival_date = new Property(7, String.class, "actual_arrival_date", false, "ACTUAL_ARRIVAL_DATE");
        public final static Property Actual_arrival_time = new Property(8, String.class, "actual_arrival_time", false, "ACTUAL_ARRIVAL_TIME");
        public final static Property Actual_departure_date = new Property(9, String.class, "actual_departure_date", false, "ACTUAL_DEPARTURE_DATE");
        public final static Property Actual_departure_time = new Property(10, String.class, "actual_departure_time", false, "ACTUAL_DEPARTURE_TIME");
        public final static Property Expected_departure_date = new Property(11, String.class, "expected_departure_date", false, "EXPECTED_DEPARTURE_DATE");
        public final static Property Expected_departure_time = new Property(12, String.class, "expected_departure_time", false, "EXPECTED_DEPARTURE_TIME");
        public final static Property Country_code = new Property(13, String.class, "country_code", false, "COUNTRY_CODE");
        public final static Property Country_name = new Property(14, String.class, "country_name", false, "COUNTRY_NAME");
        public final static Property Address = new Property(15, String.class, "address", false, "ADDRESS");
        public final static Property Checkpoint_id = new Property(16, String.class, "checkpoint_id", false, "CHECKPOINT_ID");
    };

    private DaoSession daoSession;


    public RouteRowDao(DaoConfig config) {
        super(config);
    }
    
    public RouteRowDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ROUTE_ROW\" (" + //
                "\"DELIVERY_ID\" TEXT," + // 0: delivery_id
                "\"STRING_NUMBER\" TEXT," + // 1: string_number
                "\"POSITION\" TEXT," + // 2: position
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 3: id
                "\"CHECKPOINT_DESCRIPTION\" TEXT," + // 4: checkpoint_description
                "\"PROCEDURE_TYPE\" TEXT," + // 5: procedure_type
                "\"EXPECTED_ARRIVAL_DATE\" TEXT," + // 6: expected_arrival_date
                "\"ACTUAL_ARRIVAL_DATE\" TEXT," + // 7: actual_arrival_date
                "\"ACTUAL_ARRIVAL_TIME\" TEXT," + // 8: actual_arrival_time
                "\"ACTUAL_DEPARTURE_DATE\" TEXT," + // 9: actual_departure_date
                "\"ACTUAL_DEPARTURE_TIME\" TEXT," + // 10: actual_departure_time
                "\"EXPECTED_DEPARTURE_DATE\" TEXT," + // 11: expected_departure_date
                "\"EXPECTED_DEPARTURE_TIME\" TEXT," + // 12: expected_departure_time
                "\"COUNTRY_CODE\" TEXT," + // 13: country_code
                "\"COUNTRY_NAME\" TEXT," + // 14: country_name
                "\"ADDRESS\" TEXT," + // 15: address
                "\"CHECKPOINT_ID\" TEXT);"); // 16: checkpoint_id
        // Add Indexes
        db.execSQL("CREATE UNIQUE INDEX " + constraint + "IDX_ROUTE_ROW_DELIVERY_ID_STRING_NUMBER ON ROUTE_ROW" +
                " (\"DELIVERY_ID\",\"STRING_NUMBER\");");
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ROUTE_ROW\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, RouteRow entity) {
        stmt.clearBindings();
 
        String delivery_id = entity.getDelivery_id();
        if (delivery_id != null) {
            stmt.bindString(1, delivery_id);
        }
 
        String string_number = entity.getString_number();
        if (string_number != null) {
            stmt.bindString(2, string_number);
        }
 
        String position = entity.getPosition();
        if (position != null) {
            stmt.bindString(3, position);
        }
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(4, id);
        }
 
        String checkpoint_description = entity.getCheckpoint_description();
        if (checkpoint_description != null) {
            stmt.bindString(5, checkpoint_description);
        }
 
        String procedure_type = entity.getProcedure_type();
        if (procedure_type != null) {
            stmt.bindString(6, procedure_type);
        }
 
        String expected_arrival_date = entity.getExpected_arrival_date();
        if (expected_arrival_date != null) {
            stmt.bindString(7, expected_arrival_date);
        }
 
        String actual_arrival_date = entity.getActual_arrival_date();
        if (actual_arrival_date != null) {
            stmt.bindString(8, actual_arrival_date);
        }
 
        String actual_arrival_time = entity.getActual_arrival_time();
        if (actual_arrival_time != null) {
            stmt.bindString(9, actual_arrival_time);
        }
 
        String actual_departure_date = entity.getActual_departure_date();
        if (actual_departure_date != null) {
            stmt.bindString(10, actual_departure_date);
        }
 
        String actual_departure_time = entity.getActual_departure_time();
        if (actual_departure_time != null) {
            stmt.bindString(11, actual_departure_time);
        }
 
        String expected_departure_date = entity.getExpected_departure_date();
        if (expected_departure_date != null) {
            stmt.bindString(12, expected_departure_date);
        }
 
        String expected_departure_time = entity.getExpected_departure_time();
        if (expected_departure_time != null) {
            stmt.bindString(13, expected_departure_time);
        }
 
        String country_code = entity.getCountry_code();
        if (country_code != null) {
            stmt.bindString(14, country_code);
        }
 
        String country_name = entity.getCountry_name();
        if (country_name != null) {
            stmt.bindString(15, country_name);
        }
 
        String address = entity.getAddress();
        if (address != null) {
            stmt.bindString(16, address);
        }
 
        String checkpoint_id = entity.getCheckpoint_id();
        if (checkpoint_id != null) {
            stmt.bindString(17, checkpoint_id);
        }
    }

    @Override
    protected void attachEntity(RouteRow entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3);
    }    

    /** @inheritdoc */
    @Override
    public RouteRow readEntity(Cursor cursor, int offset) {
        RouteRow entity = new RouteRow( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // delivery_id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // string_number
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // position
            cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3), // id
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // checkpoint_description
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // procedure_type
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // expected_arrival_date
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // actual_arrival_date
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // actual_arrival_time
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // actual_departure_date
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // actual_departure_time
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // expected_departure_date
            cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), // expected_departure_time
            cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13), // country_code
            cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14), // country_name
            cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15), // address
            cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16) // checkpoint_id
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, RouteRow entity, int offset) {
        entity.setDelivery_id(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setString_number(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setPosition(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setId(cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3));
        entity.setCheckpoint_description(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setProcedure_type(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setExpected_arrival_date(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setActual_arrival_date(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setActual_arrival_time(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setActual_departure_date(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setActual_departure_time(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setExpected_departure_date(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setExpected_departure_time(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setCountry_code(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
        entity.setCountry_name(cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14));
        entity.setAddress(cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15));
        entity.setCheckpoint_id(cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(RouteRow entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(RouteRow entity) {
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
    
    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getCheckpointDao().getAllColumns());
            builder.append(" FROM ROUTE_ROW T");
            builder.append(" LEFT JOIN CHECKPOINT T0 ON T.\"CHECKPOINT_ID\"=T0.\"ID\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected RouteRow loadCurrentDeep(Cursor cursor, boolean lock) {
        RouteRow entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Checkpoint checkpoint = loadCurrentOther(daoSession.getCheckpointDao(), cursor, offset);
        entity.setCheckpoint(checkpoint);

        return entity;    
    }

    public RouteRow loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<RouteRow> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<RouteRow> list = new ArrayList<RouteRow>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<RouteRow> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<RouteRow> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
