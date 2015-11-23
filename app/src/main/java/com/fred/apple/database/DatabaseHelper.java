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

            db.execSQL("INSERT INTO province (province_id, province_name) VALUES (1, '北京市');");
            db.execSQL("INSERT INTO province (province_id, province_name) VALUES (2, '天津市');");
            db.execSQL("INSERT INTO province (province_id, province_name) VALUES (3, '河北省');");
            db.execSQL("INSERT INTO province (province_id, province_name) VALUES (4, '山西省');");
            db.execSQL("INSERT INTO province (province_id, province_name) VALUES (5, '内蒙古自治区');");
            db.execSQL("INSERT INTO province (province_id, province_name) VALUES (6, '辽宁省');");
            db.execSQL("INSERT INTO province (province_id, province_name) VALUES (7, '吉林省');");
            db.execSQL("INSERT INTO province (province_id, province_name) VALUES (8, '黑龙江省');");
            db.execSQL("INSERT INTO province (province_id, province_name) VALUES (9, '上海市');");
            db.execSQL("INSERT INTO province (province_id, province_name) VALUES (10, '江苏省');");
            db.execSQL("INSERT INTO province (province_id, province_name) VALUES (11, '浙江省');");
            db.execSQL("INSERT INTO province (province_id, province_name) VALUES (12, '安徽省');");
            db.execSQL("INSERT INTO province (province_id, province_name) VALUES (13, '福建省');");
            db.execSQL("INSERT INTO province (province_id, province_name) VALUES (14, '江西省');");
            db.execSQL("INSERT INTO province (province_id, province_name) VALUES (15, '山东省');");
            db.execSQL("INSERT INTO province (province_id, province_name) VALUES (16, '河南省');");
            db.execSQL("INSERT INTO province (province_id, province_name) VALUES (17, '湖北省');");
            db.execSQL("INSERT INTO province (province_id, province_name) VALUES (18, '湖南省');");
            db.execSQL("INSERT INTO province (province_id, province_name) VALUES (19, '广东省');");
            db.execSQL("INSERT INTO province (province_id, province_name) VALUES (20, '广西壮族自治区');");
            db.execSQL("INSERT INTO province (province_id, province_name) VALUES (21, '海南省');");
            db.execSQL("INSERT INTO province (province_id, province_name) VALUES (22, '重庆市');");
            db.execSQL("INSERT INTO province (province_id, province_name) VALUES (23, '四川省');");
            db.execSQL("INSERT INTO province (province_id, province_name) VALUES (24, '贵州省');");
            db.execSQL("INSERT INTO province (province_id, province_name) VALUES (25, '云南省');");
            db.execSQL("INSERT INTO province (province_id, province_name) VALUES (26, '西藏自治区');");
            db.execSQL("INSERT INTO province (province_id, province_name) VALUES (27, '陕西省');");
            db.execSQL("INSERT INTO province (province_id, province_name) VALUES (28, '甘肃省');");
            db.execSQL("INSERT INTO province (province_id, province_name) VALUES (29, '青海省');");
            db.execSQL("INSERT INTO province (province_id, province_name) VALUES (30, '宁夏回族自治区');");
            db.execSQL("INSERT INTO province (province_id, province_name) VALUES (31, '新疆维吾尔自治区');");
            db.execSQL("INSERT INTO province (province_id, province_name) VALUES (32, '香港特别行政区');");
            db.execSQL("INSERT INTO province (province_id, province_name) VALUES (33, '澳门特别行政区');");
            db.execSQL("INSERT INTO province (province_id, province_name) VALUES (34, '台湾省');");

            //insert city information.
            db.execSQL("INSERT INTO city (city_id, city_name, province_id) VALUES (135,'济南市', 15 );");
            db.execSQL("INSERT INTO city (city_id, city_name, province_id) VALUES (136,'青岛市', 15 );");
            db.execSQL("INSERT INTO city (city_id, city_name, province_id) VALUES (137,'淄博市', 15 );");
            db.execSQL("INSERT INTO city (city_id, city_name, province_id) VALUES (138,'枣庄市', 15 );");
            db.execSQL("INSERT INTO city (city_id, city_name, province_id) VALUES (139,'东营市', 15 );");
            db.execSQL("INSERT INTO city (city_id, city_name, province_id) VALUES (140,'烟台市', 15 );");
            db.execSQL("INSERT INTO city (city_id, city_name, province_id) VALUES (141,'潍坊市', 15 );");
            db.execSQL("INSERT INTO city (city_id, city_name, province_id) VALUES (142,'济宁市', 15 );");
            db.execSQL("INSERT INTO city (city_id, city_name, province_id) VALUES (143,'泰安市', 15 );");
            db.execSQL("INSERT INTO city (city_id, city_name, province_id) VALUES (144,'威海市', 15 );");
            db.execSQL("INSERT INTO city (city_id, city_name, province_id) VALUES (145,'日照市', 15 );");
            db.execSQL("INSERT INTO city (city_id, city_name, province_id) VALUES (146,'莱芜市', 15 );");
            db.execSQL("INSERT INTO city (city_id, city_name, province_id) VALUES (147,'临沂市', 15 );");
            db.execSQL("INSERT INTO city (city_id, city_name, province_id) VALUES (148,'德州市', 15 );");
            db.execSQL("INSERT INTO city (city_id, city_name, province_id) VALUES (149,'聊城市', 15 );");
            db.execSQL("INSERT INTO city (city_id, city_name, province_id) VALUES (150,'滨州市', 15 );");
            db.execSQL("INSERT INTO city (city_id, city_name, province_id) VALUES (151,'荷泽市', 15 );");

            //insert city information.

            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1264, '芝罘区', 140);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1265, '福山区', 140);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1266, '牟平区', 140);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1267, '莱山区', 140);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1268, '长岛县', 140);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1269, '龙口市', 140);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1270, '莱阳市', 140);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1271, '莱州市', 140);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1272, '蓬莱市', 140);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1273, '招远市', 140);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1274, '栖霞市', 140);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1275, '海阳市', 140);");

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
