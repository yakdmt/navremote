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

import xyz.yakdmt.navremote.database.Document;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "DOCUMENT".
*/
public class DocumentDao extends AbstractDao<Document, Long> {

    public static final String TABLENAME = "DOCUMENT";

    /**
     * Properties of entity Document.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property OrderId = new Property(0, String.class, "orderId", false, "ORDER_ID");
        public final static Property Id = new Property(1, Long.class, "id", true, "_id");
        public final static Property Document_name = new Property(2, String.class, "document_name", false, "DOCUMENT_NAME");
        public final static Property Document_path = new Property(3, String.class, "document_path", false, "DOCUMENT_PATH");
        public final static Property Creator = new Property(4, String.class, "creator", false, "CREATOR");
    };

    private DaoSession daoSession;


    public DocumentDao(DaoConfig config) {
        super(config);
    }
    
    public DocumentDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"DOCUMENT\" (" + //
                "\"ORDER_ID\" TEXT UNIQUE ," + // 0: orderId
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 1: id
                "\"DOCUMENT_NAME\" TEXT," + // 2: document_name
                "\"DOCUMENT_PATH\" TEXT," + // 3: document_path
                "\"CREATOR\" TEXT);"); // 4: creator
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"DOCUMENT\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Document entity) {
        stmt.clearBindings();
 
        String orderId = entity.getOrderId();
        if (orderId != null) {
            stmt.bindString(1, orderId);
        }
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(2, id);
        }
 
        String document_name = entity.getDocument_name();
        if (document_name != null) {
            stmt.bindString(3, document_name);
        }
 
        String document_path = entity.getDocument_path();
        if (document_path != null) {
            stmt.bindString(4, document_path);
        }
 
        String creator = entity.getCreator();
        if (creator != null) {
            stmt.bindString(5, creator);
        }
    }

    @Override
    protected void attachEntity(Document entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1);
    }    

    /** @inheritdoc */
    @Override
    public Document readEntity(Cursor cursor, int offset) {
        Document entity = new Document( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // orderId
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // id
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // document_name
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // document_path
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4) // creator
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Document entity, int offset) {
        entity.setOrderId(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setId(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setDocument_name(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setDocument_path(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setCreator(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Document entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Document entity) {
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
            SqlUtils.appendColumns(builder, "T0", daoSession.getOrderDao().getAllColumns());
            builder.append(" FROM DOCUMENT T");
            builder.append(" LEFT JOIN ORDER T0 ON T.\"ORDER_ID\"=T0.\"ID\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected Document loadCurrentDeep(Cursor cursor, boolean lock) {
        Document entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Order order = loadCurrentOther(daoSession.getOrderDao(), cursor, offset);
        entity.setOrder(order);

        return entity;    
    }

    public Document loadDeep(Long key) {
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
    public List<Document> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<Document> list = new ArrayList<Document>(count);
        
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
    
    protected List<Document> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<Document> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
