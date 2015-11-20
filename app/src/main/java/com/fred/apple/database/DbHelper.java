package com.fred.apple.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author Fred Liu (liuxiaokun041@gmail.com)
 * @version 1.0.0
 * @since 2015/11/16 12:55
 */
public class DbHelper extends SQLiteOpenHelper {

    private static final String CREATE_PROVINCE = "CREATE TABLE province(province_id int NOT NULL PRIMARY KEY, province_name VARCHAR NOT NULL, enable int NOT NULL DEFAULT 1);";
    private static final String CREATE_CITY = "CREATE TABLE city(city_id int NOT NULL PRIMARY KEY, city_name varchar NOT NULL, province_id int NOT NULL);";
    private static final String CREATE_AREA = "CREATE TABLE area(area_id int NOT NULL PRIMARY KEY, area_name varchar NOT NULL, city_id int NOT NULL);";

    public DbHelper(Context context, String name, int version) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_PROVINCE);
        //insert province data.
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
        db.execSQL("INSERT INTO province (province_id, province_name) VALUES (21, '海南省',?, ?);");
        db.execSQL("INSERT INTO province (province_id, province_name) VALUES (22, '重庆市',?, ?);");
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

        //insert city data.
        db.execSQL(CREATE_CITY);
        db.execSQL("INSERT INTO city (city_id, city_name, zip_code, province_id) VALUES (135,'济南市', '250000', 15 );");
        db.execSQL("INSERT INTO city (city_id, city_name, zip_code, province_id) VALUES (136,'青岛市', '266000', 15 );");
        db.execSQL("INSERT INTO city (city_id, city_name, zip_code, province_id) VALUES (137,'淄博市', '255000', 15 );");
        db.execSQL("INSERT INTO city (city_id, city_name, zip_code, province_id) VALUES (138,'枣庄市', '277100', 15 );");
        db.execSQL("INSERT INTO city (city_id, city_name, zip_code, province_id) VALUES (139,'东营市', '257000', 15 );");
        db.execSQL("INSERT INTO city (city_id, city_name, zip_code, province_id) VALUES (140,'烟台市', '264000', 15 );");
        db.execSQL("INSERT INTO city (city_id, city_name, zip_code, province_id) VALUES (141,'潍坊市', '261000', 15 );");
        db.execSQL("INSERT INTO city (city_id, city_name, zip_code, province_id) VALUES (142,'济宁市', '272100', 15 );");
        db.execSQL("INSERT INTO city (city_id, city_name, zip_code, province_id) VALUES (143,'泰安市', '271000', 15 );");
        db.execSQL("INSERT INTO city (city_id, city_name, zip_code, province_id) VALUES (144,'威海市', '265700', 15 );");
        db.execSQL("INSERT INTO city (city_id, city_name, zip_code, province_id) VALUES (145,'日照市', '276800', 15 );");
        db.execSQL("INSERT INTO city (city_id, city_name, zip_code, province_id) VALUES (146,'莱芜市', '271100', 15 );");
        db.execSQL("INSERT INTO city (city_id, city_name, zip_code, province_id) VALUES (147,'临沂市', '276000', 15 );");
        db.execSQL("INSERT INTO city (city_id, city_name, zip_code, province_id) VALUES (148,'德州市', '253000', 15 );");
        db.execSQL("INSERT INTO city (city_id, city_name, zip_code, province_id) VALUES (149,'聊城市', '252000', 15 );");
        db.execSQL("INSERT INTO city (city_id, city_name, zip_code, province_id) VALUES (150,'滨州市', '256600', 15 );");
        db.execSQL("INSERT INTO city (city_id, city_name, zip_code, province_id) VALUES (151,'荷泽市', '255000', 15 );");

        db.execSQL(CREATE_AREA);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /*


















     */
}
