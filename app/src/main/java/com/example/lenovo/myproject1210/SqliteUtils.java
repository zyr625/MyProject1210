package com.example.lenovo.myproject1210;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.lenovo.myproject1210.greendao.CacheDao;
import com.example.lenovo.myproject1210.greendao.DaoMaster;

import java.util.List;

public class SqliteUtils {
    private CacheDao cacheDao;
    private SqliteUtils() {
    }

    private static SqliteUtils mSqliteUtils;

    public static SqliteUtils getSqliteUtils() {
        if (mSqliteUtils == null) {
            mSqliteUtils = new SqliteUtils();
        }
        return mSqliteUtils;
    }
    public void init(Context context) {
        DaoMaster.DevOpenHelper car = new DaoMaster.DevOpenHelper(context, "car");
        SQLiteDatabase db = car.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        cacheDao = daoMaster.newSession().getCacheDao();
    }
    public void insert(Cache cache) {
        cacheDao.insert(cache);
    }

    public void deleteAll() {
        cacheDao.deleteAll();
    }

    public List<Cache> queryAll() {
        return cacheDao.loadAll();
    }

    public Cache query(String key) {
        return cacheDao.load(Long.parseLong(key));
    }

    public void update(Cache cache ) {
        cacheDao.update(cache);
    }
}
