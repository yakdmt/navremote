package xyz.yakdmt.navremote.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import xyz.yakdmt.navremote.database.Product;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "PRODUCT".
*/
public class ProductDao extends AbstractDao<Product, Long> {

    public static final String TABLENAME = "PRODUCT";

    /**
     * Properties of entity Product.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Order_id = new Property(1, String.class, "order_id", false, "ORDER_ID");
        public final static Property String_number = new Property(2, String.class, "string_number", false, "STRING_NUMBER");
        public final static Property StringNo = new Property(3, String.class, "stringNo", false, "STRING_NO");
        public final static Property Brutto_weight = new Property(4, String.class, "brutto_weight", false, "BRUTTO_WEIGHT");
        public final static Property Count = new Property(5, String.class, "count", false, "COUNT");
        public final static Property Description = new Property(6, String.class, "description", false, "DESCRIPTION");
    };


    public ProductDao(DaoConfig config) {
        super(config);
    }
    
    public ProductDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"PRODUCT\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"ORDER_ID\" TEXT," + // 1: order_id
                "\"STRING_NUMBER\" TEXT," + // 2: string_number
                "\"STRING_NO\" TEXT," + // 3: stringNo
                "\"BRUTTO_WEIGHT\" TEXT," + // 4: brutto_weight
                "\"COUNT\" TEXT," + // 5: count
                "\"DESCRIPTION\" TEXT);"); // 6: description
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"PRODUCT\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Product entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String order_id = entity.getOrder_id();
        if (order_id != null) {
            stmt.bindString(2, order_id);
        }
 
        String string_number = entity.getString_number();
        if (string_number != null) {
            stmt.bindString(3, string_number);
        }
 
        String stringNo = entity.getStringNo();
        if (stringNo != null) {
            stmt.bindString(4, stringNo);
        }
 
        String brutto_weight = entity.getBrutto_weight();
        if (brutto_weight != null) {
            stmt.bindString(5, brutto_weight);
        }
 
        String count = entity.getCount();
        if (count != null) {
            stmt.bindString(6, count);
        }
 
        String description = entity.getDescription();
        if (description != null) {
            stmt.bindString(7, description);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Product readEntity(Cursor cursor, int offset) {
        Product entity = new Product( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // order_id
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // string_number
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // stringNo
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // brutto_weight
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // count
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6) // description
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Product entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setOrder_id(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setString_number(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setStringNo(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setBrutto_weight(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setCount(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setDescription(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Product entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Product entity) {
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
