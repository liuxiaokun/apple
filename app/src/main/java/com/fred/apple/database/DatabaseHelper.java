package com.fred.apple.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.fred.apple.bean.Area;
import com.fred.apple.bean.City;
import com.fred.apple.bean.Option;
import com.fred.apple.bean.OptionValue;
import com.fred.apple.bean.Order;
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

    private Dao<Province, Integer> provinceDao;
    private Dao<City, Integer> cityDao;
    private Dao<Area, Integer> areaDao;
    private Dao<Order, Integer> orderDao;
    private Dao<Option, Integer> optionDao;
    private Dao<OptionValue, Integer> optionValueDao;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
        try {
            TableUtils.createTableIfNotExists(connectionSource, Province.class);
            TableUtils.createTableIfNotExists(connectionSource, City.class);
            TableUtils.createTableIfNotExists(connectionSource, Area.class);
            TableUtils.createTableIfNotExists(connectionSource, Order.class);
            TableUtils.createTableIfNotExists(connectionSource, Option.class);
            TableUtils.createTableIfNotExists(connectionSource, OptionValue.class);

            db.execSQL("INSERT INTO option (option_id, option_name) VALUES(1, '规格')");
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

    public Dao<City, Integer> getCityDao() {

        if (cityDao == null) {
            try {
                cityDao = getDao(City.class);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return cityDao;
    }

    public Dao<Area, Integer> getAreaDao() {

        if (areaDao == null) {
            try {
                areaDao = getDao(Area.class);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return areaDao;
    }

    public Dao<Order, Integer> getOrderDao() {

        if (orderDao == null) {
            try {
                orderDao = getDao(Order.class);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return orderDao;
    }

    public Dao<Option, Integer> getOptionDao() {

        if (optionDao == null) {
            try {
                optionDao = getDao(Option.class);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return optionDao;
    }

    public Dao<OptionValue, Integer> getOptionValueDao() {

        if (optionValueDao == null) {
            try {
                optionValueDao = getDao(OptionValue.class);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return optionValueDao;
    }

    @Override
    public void close() {
        super.close();
        provinceDao = null;
        cityDao = null;
        areaDao = null;
        orderDao = null;
        optionDao = null;
        optionValueDao = null;
    }

}
