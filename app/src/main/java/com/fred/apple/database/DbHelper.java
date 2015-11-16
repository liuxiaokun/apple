package com.fred.apple.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.fred.apple.util.DateUtil;

/**
 * @author Fred Liu (liuxiaokun041@gmail.com)
 * @version 1.0.0
 * @since 2015/11/16 12:55
 */
public class DbHelper extends SQLiteOpenHelper {

    private static final String CREATE_PROVINCE = "CREATE TABLE province( province_id int NOT NULL PRIMARY KEY , province_name VARCHAR(50) NOT NULL, created VARCHAR(25) NOT NULL, updated VARCHAR(25) NOT NULL);";
    private static final String CREATE_CITY = "CREATE TABLE city( city_id int NOT NULL PRIMARY KEY , city_name varchar(50) , province_id int NOT NULL , created varchar(25) NOT NULL , updated varchar(25) NOT NULL);";

    public DbHelper(Context context, String name, int version) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_PROVINCE);
        db.execSQL(CREATE_CITY);

        String defaultCurrentDateTime = DateUtil.getDefaultCurrentDateTime();
        String[] args = {defaultCurrentDateTime, defaultCurrentDateTime};

        //insert province data.
        db.execSQL("INSERT INTO province (province_id, province_name, created, updated) VALUES (1, '北京市', ?,?);",
                args);

        db.execSQL("INSERT INTO province (province_id, province_name, created, updated) VALUES (2, '天津市', ?,?);",
                args);

        db.execSQL("INSERT INTO province (province_id, province_name, created, updated) VALUES (3, '河北省', ?,?);",
                args);

        db.execSQL("INSERT INTO province (province_id, province_name, created, updated) VALUES (4, '山西省', ?,?);",
                args);

        db.execSQL("INSERT INTO province (province_id, province_name, created, updated) VALUES (5, '内蒙古自治区',?,?);",
                args);

        db.execSQL("INSERT INTO province (province_id, province_name, created, updated) VALUES (6, '辽宁省',?,?);",
                args);

        db.execSQL("INSERT INTO province (province_id, province_name, created, updated) VALUES (7, '吉林省',?,?);",
                args);

        db.execSQL("INSERT INTO province (province_id, province_name, created, updated) VALUES (8, '黑龙江省',?,?);",
                args);

        db.execSQL("INSERT INTO province (province_id, province_name, created, updated) VALUES (9, '上海市', ?,?);",
                args);

        db.execSQL("INSERT INTO province (province_id, province_name, created, updated) VALUES (10, '江苏省',?,?);",
                args);

        db.execSQL("INSERT INTO province (province_id, province_name, created, updated) VALUES (11, '浙江省',?,?);",
                args);

        db.execSQL("INSERT INTO province (province_id, province_name, created, updated) VALUES (12, '安徽省',?,?);",
                args);

        db.execSQL("INSERT INTO province (province_id, province_name, created, updated) VALUES (13, '福建省',?,?);",
                args);

        db.execSQL("INSERT INTO province (province_id, province_name, created, updated) VALUES (14, '江西省',?,?);",
                args);

        db.execSQL("INSERT INTO province (province_id, province_name, created, updated) VALUES (15, '山东省',?,?);",
                args);

        db.execSQL("INSERT INTO province (province_id, province_name, created, updated) VALUES (16, '河南省',?,?);",
                args);

        db.execSQL("INSERT INTO province (province_id, province_name, created, updated) VALUES (17, '湖北省',?,?);",
                args);

        db.execSQL("INSERT INTO province (province_id, province_name, created, updated) VALUES (18, '湖南省',?,?);",
                args);

        db.execSQL("INSERT INTO province (province_id, province_name, created, updated) VALUES (19, '广东省',?,?);",
                args);

        db.execSQL("INSERT INTO province (province_id, province_name, created, updated) VALUES (20, '广西壮族自治区',?,?);",
                args);

        db.execSQL("INSERT INTO province (province_id, province_name, created, updated) VALUES (21, '海南省',?, ?);",
                args);

        db.execSQL("INSERT INTO province (province_id, province_name, created, updated) VALUES (22, '重庆市',?, ?);",
                args);

        db.execSQL("INSERT INTO province (province_id, province_name, created, updated) VALUES (23, '四川省',?,?);",
                args);

        db.execSQL("INSERT INTO province (province_id, province_name, created, updated) VALUES (24, '贵州省',?,?);",
                args);

        db.execSQL("INSERT INTO province (province_id, province_name, created, updated) VALUES (25, '云南省', ?,?);",
                args);

        db.execSQL("INSERT INTO province (province_id, province_name, created, updated) VALUES (26, '西藏自治区',?,?);",
                args);

        db.execSQL("INSERT INTO province (province_id, province_name, created, updated) VALUES (27, '陕西省',?,?);",
                args);

        db.execSQL("INSERT INTO province (province_id, province_name, created, updated) VALUES (28, '甘肃省',?,?);",
                args);

        db.execSQL("INSERT INTO province (province_id, province_name, created, updated) VALUES (29, '青海省',?,?);",
                args);

        db.execSQL("INSERT INTO province (province_id, province_name, created, updated) VALUES (30, '宁夏回族自治区',?,?);",
                args);

        db.execSQL("INSERT INTO province (province_id, province_name, created, updated) VALUES (31, '新疆维吾尔自治区',?,?);",
                args);

        db.execSQL("INSERT INTO province (province_id, province_name, created, updated) VALUES (32, '香港特别行政区',?,?);",
                args);

        db.execSQL("INSERT INTO province (province_id, province_name, created, updated) VALUES (33, '澳门特别行政区',?,?);",
                args);

        db.execSQL("INSERT INTO province (province_id, province_name, created, updated) VALUES (34, '台湾省',?,?);",
                args);

        /*

        insert city data.
         */

        db.execSQL("INSERT INTO city (city_id, city_name, zip_code, province_id, created, updated) VALUES (135, '济南市', '250000', 15, ?,?);",
                args);
        db.execSQL("INSERT INTO city (city_id, city_name, zip_code, province_id, created, updated) VALUES (136,'青岛市', '266000', 15, ?,?);",
                args);
        db.execSQL("INSERT INTO city (city_id, city_name, zip_code, province_id, created, updated) VALUES (137,'淄博市', '255000', 15, ?,?);",
                args);
        db.execSQL("INSERT INTO city (city_id, city_name, zip_code, province_id, created, updated) VALUES (138,'枣庄市', '277100', 15, ?,?);",
                args);
        db.execSQL("INSERT INTO city (city_id, city_name, zip_code, province_id, created, updated) VALUES (139,'东营市', '257000', 15, ?,?);",
                args);
        db.execSQL("INSERT INTO city (city_id, city_name, zip_code, province_id, created, updated) VALUES (140,'烟台市', '264000', 15, ?,?);",
                args);
        db.execSQL("INSERT INTO city (city_id, city_name, zip_code, province_id, created, updated) VALUES (141,'潍坊市', '261000', 15, ?,?);",
                args);
        db.execSQL("INSERT INTO city (city_id, city_name, zip_code, province_id, created, updated) VALUES (142,'济宁市', '272100', 15, ?,?);",
                args);
        db.execSQL("INSERT INTO city (city_id, city_name, zip_code, province_id, created, updated) VALUES (143,'泰安市', '271000', 15, ?,?);",
                args);
        db.execSQL("INSERT INTO city (city_id, city_name, zip_code, province_id, created, updated) VALUES (144,'威海市', '265700', 15, ?,?);",
                args);
        db.execSQL("INSERT INTO city (city_id, city_name, zip_code, province_id, created, updated) VALUES (145,'日照市', '276800', 15, ?,?);",
                args);
        db.execSQL("INSERT INTO city (city_id, city_name, zip_code, province_id, created, updated) VALUES (146,'莱芜市', '271100', 15, ?,?);",
                args);
        db.execSQL("INSERT INTO city (city_id, city_name, zip_code, province_id, created, updated) VALUES (147,'临沂市', '276000', 15, ?,?);",
                args);
        db.execSQL("INSERT INTO city (city_id, city_name, zip_code, province_id, created, updated) VALUES (148,'德州市', '253000', 15, ?,?);",
                args);
        db.execSQL("INSERT INTO city (city_id, city_name, zip_code, province_id, created, updated) VALUES (149,'聊城市', '252000', 15, ?,?);",
                args);
        db.execSQL("INSERT INTO city (city_id, city_name, zip_code, province_id, created, updated) VALUES (150,'滨州市', '256600', 15, ?,?);",
                args);
        db.execSQL("INSERT INTO city (city_id, city_name, zip_code, province_id, created, updated) VALUES (151,'荷泽市', '255000', 15, ?,?);",
                args);




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /*


















     */
}
