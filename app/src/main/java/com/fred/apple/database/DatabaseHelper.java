package com.fred.apple.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.fred.apple.bean.Province;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * @author Fred Liu (liuxiaokun0410@gmail.com)
 * @version 5.0
 * @since 2015/11/20 17:27
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "apple.db3";
    private static final int DATABASE_VERSION = 1;
    private Dao<Province, Integer> provinceDao = null;


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Province.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource,
                          int oldVersion, int newVersion) {

    }

    public Dao<Province, Integer> getProvinceDao() {

        if (provinceDao == null) {
            try {
                provinceDao = getDao(Province.class);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return provinceDao;
    }

    @Override
    public void close() {
        super.close();
        provinceDao = null;
    }

}
