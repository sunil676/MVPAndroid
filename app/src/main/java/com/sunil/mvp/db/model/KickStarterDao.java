package com.sunil.mvp.db.model;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "KICK_STARTER".
*/
public class KickStarterDao extends AbstractDao<KickStarter, Long> {

    public static final String TABLENAME = "KICK_STARTER";

    /**
     * Properties of entity KickStarter.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property S_no = new Property(1, String.class, "s_no", false, "S_NO");
        public final static Property Amt_pledged = new Property(2, String.class, "amt_pledged", false, "AMT_PLEDGED");
        public final static Property Blurb = new Property(3, String.class, "blurb", false, "BLURB");
        public final static Property By = new Property(4, String.class, "by", false, "BY");
        public final static Property Country = new Property(5, String.class, "country", false, "COUNTRY");
        public final static Property Currency = new Property(6, String.class, "currency", false, "CURRENCY");
        public final static Property End_time = new Property(7, String.class, "end_time", false, "END_TIME");
        public final static Property Location = new Property(8, String.class, "location", false, "LOCATION");
        public final static Property Percentage = new Property(9, String.class, "percentage", false, "PERCENTAGE");
        public final static Property Num_backers = new Property(10, String.class, "num_backers", false, "NUM_BACKERS");
        public final static Property State = new Property(11, String.class, "state", false, "STATE");
        public final static Property Title = new Property(12, String.class, "title", false, "TITLE");
        public final static Property Type = new Property(13, String.class, "type", false, "TYPE");
        public final static Property Url = new Property(14, String.class, "url", false, "URL");
    }


    public KickStarterDao(DaoConfig config) {
        super(config);
    }
    
    public KickStarterDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"KICK_STARTER\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"S_NO\" TEXT NOT NULL ," + // 1: s_no
                "\"AMT_PLEDGED\" TEXT," + // 2: amt_pledged
                "\"BLURB\" TEXT," + // 3: blurb
                "\"BY\" TEXT," + // 4: by
                "\"COUNTRY\" TEXT," + // 5: country
                "\"CURRENCY\" TEXT," + // 6: currency
                "\"END_TIME\" TEXT," + // 7: end_time
                "\"LOCATION\" TEXT," + // 8: location
                "\"PERCENTAGE\" TEXT," + // 9: percentage
                "\"NUM_BACKERS\" TEXT," + // 10: num_backers
                "\"STATE\" TEXT," + // 11: state
                "\"TITLE\" TEXT," + // 12: title
                "\"TYPE\" TEXT," + // 13: type
                "\"URL\" TEXT);"); // 14: url
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"KICK_STARTER\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, KickStarter entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getS_no());
 
        String amt_pledged = entity.getAmt_pledged();
        if (amt_pledged != null) {
            stmt.bindString(3, amt_pledged);
        }
 
        String blurb = entity.getBlurb();
        if (blurb != null) {
            stmt.bindString(4, blurb);
        }
 
        String by = entity.getBy();
        if (by != null) {
            stmt.bindString(5, by);
        }
 
        String country = entity.getCountry();
        if (country != null) {
            stmt.bindString(6, country);
        }
 
        String currency = entity.getCurrency();
        if (currency != null) {
            stmt.bindString(7, currency);
        }
 
        String end_time = entity.getEnd_time();
        if (end_time != null) {
            stmt.bindString(8, end_time);
        }
 
        String location = entity.getLocation();
        if (location != null) {
            stmt.bindString(9, location);
        }
 
        String percentage = entity.getPercentage();
        if (percentage != null) {
            stmt.bindString(10, percentage);
        }
 
        String num_backers = entity.getNum_backers();
        if (num_backers != null) {
            stmt.bindString(11, num_backers);
        }
 
        String state = entity.getState();
        if (state != null) {
            stmt.bindString(12, state);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(13, title);
        }
 
        String type = entity.getType();
        if (type != null) {
            stmt.bindString(14, type);
        }
 
        String url = entity.getUrl();
        if (url != null) {
            stmt.bindString(15, url);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, KickStarter entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getS_no());
 
        String amt_pledged = entity.getAmt_pledged();
        if (amt_pledged != null) {
            stmt.bindString(3, amt_pledged);
        }
 
        String blurb = entity.getBlurb();
        if (blurb != null) {
            stmt.bindString(4, blurb);
        }
 
        String by = entity.getBy();
        if (by != null) {
            stmt.bindString(5, by);
        }
 
        String country = entity.getCountry();
        if (country != null) {
            stmt.bindString(6, country);
        }
 
        String currency = entity.getCurrency();
        if (currency != null) {
            stmt.bindString(7, currency);
        }
 
        String end_time = entity.getEnd_time();
        if (end_time != null) {
            stmt.bindString(8, end_time);
        }
 
        String location = entity.getLocation();
        if (location != null) {
            stmt.bindString(9, location);
        }
 
        String percentage = entity.getPercentage();
        if (percentage != null) {
            stmt.bindString(10, percentage);
        }
 
        String num_backers = entity.getNum_backers();
        if (num_backers != null) {
            stmt.bindString(11, num_backers);
        }
 
        String state = entity.getState();
        if (state != null) {
            stmt.bindString(12, state);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(13, title);
        }
 
        String type = entity.getType();
        if (type != null) {
            stmt.bindString(14, type);
        }
 
        String url = entity.getUrl();
        if (url != null) {
            stmt.bindString(15, url);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public KickStarter readEntity(Cursor cursor, int offset) {
        KickStarter entity = new KickStarter( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getString(offset + 1), // s_no
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // amt_pledged
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // blurb
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // by
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // country
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // currency
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // end_time
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // location
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // percentage
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // num_backers
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // state
            cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), // title
            cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13), // type
            cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14) // url
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, KickStarter entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setS_no(cursor.getString(offset + 1));
        entity.setAmt_pledged(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setBlurb(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setBy(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setCountry(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setCurrency(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setEnd_time(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setLocation(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setPercentage(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setNum_backers(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setState(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setTitle(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setType(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
        entity.setUrl(cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(KickStarter entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(KickStarter entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(KickStarter entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
