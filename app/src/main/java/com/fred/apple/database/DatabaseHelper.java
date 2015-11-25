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
    //3001 used

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

            //insert 山东 cities.
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

            //insert 北京 cities.
            db.execSQL("INSERT INTO city(city_id, city_name, province_id) VALUES(1, '北京市', 1);");
            //insert 上海 cities.
            db.execSQL("INSERT INTO city (city_id, city_name, province_id) VALUES (73, '上海市', 9);");


            //insert 济南市 areas.
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1223, '历下区', 135);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1224, '市中区', 135);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1225, '槐荫区', 135);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1226, '天桥区', 135);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1227, '历城区', 135);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1228, '长清区', 135);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1229, '平阴县', 135);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1230, '济阳县', 135);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1231, '商河县', 135);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1232, '章丘市', 135);");

            //insert 青岛市 areas.
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1233, '市南区', 136);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1234, '市北区', 136);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1235, '四方区', 136);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1236, '黄岛区', 136);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1237, '崂山区', 136);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1238, '李沧区', 136);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1239, '城阳区', 136);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1240, '胶州市', 136);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1241, '即墨市', 136);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1242, '平度市', 136);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1243, '胶南市', 136);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1244, '莱西市', 136);");

            //insert 淄博市 areas.
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1245, '淄川区', 137);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES(1246, '张店区', 137); ");
            db.execSQL("INSERT INTO area(area_id, area_name, city_id) VALUES (1247, '博山区', 137);");
            db.execSQL("INSERT INTO area(area_id, area_name, city_id) VALUES(1248, '临淄区', 137) ");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1249, '周村区', 137)");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1250, '桓台县', 137);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1251, '高青县', 137);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1252, '沂源县', 137);");

            //insert 枣庄市 areas.
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1253, '市中区', 138);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1254, '薛城区', 138);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1255, '峄城区', 138);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1256, '台儿庄区', 138)");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1257, '山亭区', 138);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1258, '滕州市', 138);");

            //insert 东营市 areas.
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1259, '东营区', 139);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1260, '河口区', 139);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1261, '垦利县', 139);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1262, '利津县', 139);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1263, '广饶县', 139);");

            //insert 烟台 areas.
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1264, '芝罘区', 140);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1265, '福山区', 140);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1266, '牟平区', 140);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1267, '莱山区', 140);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (3000, '开发区', 140);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (3001, '高新区', 140);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1268, '长岛县', 140);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1269, '龙口市', 140);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1270, '莱阳市', 140);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1271, '莱州市', 140);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1272, '蓬莱市', 140);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1273, '招远市', 140);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1274, '栖霞市', 140);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1275, '海阳市', 140);");

            //insert 潍坊市 areas.
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1276, '潍城区', 141);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1277, '寒亭区', 141);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1278, '坊子区', 141);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1279, '奎文区', 141);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1280, '临朐县', 141);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1281, '昌乐县', 141);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1282, '青州市', 141);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1283, '诸城市', 141);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1284, '寿光市', 141);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1285, '安丘市', 141);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1286, '高密市', 141);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1287, '昌邑市', 141);");

            //insert 济宁市 areas.
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1288, '市中区', 142);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1289, '任城区', 142);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1290, '微山县', 142);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1291, '鱼台县', 142);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1292, '金乡县', 142);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1293, '嘉祥县', 142);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1294, '汶上县', 142);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1295, '泗水县', 142);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1296, '梁山县', 142);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1297, '曲阜市', 142);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1298, '兖州市', 142);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1299, '邹城市', 142);");

            //insert 泰安市 areas.
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1300, '泰山区', 143);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1301, '岱岳区', 143);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1302, '宁阳县', 143);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1303, '东平县', 143);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1304, '新泰市', 143);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1305, '肥城市', 143);");

            //insert 威海市 areas.
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1306, '环翠区', 144);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1307, '文登市', 144);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1308, '荣成市', 144);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1309, '乳山市', 144);");

            //insert 日照市 areas.
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1310, '东港区', 145);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1311, '岚山区', 145);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1312, '五莲县', 145);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1313, '莒县', 145);");

            //insert 莱芜市 areas.
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1314, '莱城区', 146);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1315, '钢城区', 146);");

            //insert 临沂市 areas.
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1316, '兰山区', 147);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1317, '罗庄区', 147);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1318, '河东区', 147);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1319, '沂南县', 147);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1320, '郯城县', 147);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1321, '沂水县', 147);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1322, '苍山县', 147);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1323, '费县', 147);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1324, '平邑县', 147);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1325, '莒南县', 147);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1326, '蒙阴县', 147);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1327, '临沭县', 147);");

            //insert 德州市 areas.
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1328, '德城区', 148);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1329, '陵县', 148);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1330, '宁津县', 148);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1331, '庆云县', 148);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1332, '临邑县', 148);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1333, '齐河县', 148);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1334, '平原县', 148);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1335, '夏津县', 148);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1336, '武城县', 148);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1337, '乐陵市', 148);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1338, '禹城市', 148);");

            //insert 聊城市 areas.
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1339, '东昌府区', 149)");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1340, '阳谷县', 149);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1341, '莘县', 149);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1342, '茌平县', 149);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1343, '东阿县', 149);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1344, '冠县', 149);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1345, '高唐县', 149);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1346, '临清市', 149);");

            //insert 滨州市 areas.
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1347, '滨城区', 150);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1348, '惠民县', 150);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1349, '阳信县', 150);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1350, '无棣县', 150);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1351, '沾化县', 150);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1352, '博兴县', 150);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1353, '邹平县', 150);");

            //insert 菏泽市 areas.
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1354, '牡丹区', 151);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1355, '曹县', 151);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1356, '单县', 151);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1357, '成武县', 151);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1358, '巨野县', 151);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1359, '郓城县', 151);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1360, '鄄城县', 151);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1361, '定陶县', 151);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1362, '东明县', 151);");

            //insert 上海 areas.
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (719, '黄浦区', 73)");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (720, '卢湾区', 73);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (721, '徐汇区', 73);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (722, '长宁区', 73);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (723, '静安区', 73);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (724, '普陀区', 73);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (725, '闸北区', 73);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (726, '虹口区', 73);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (727, '杨浦区', 73);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (728, '闵行区', 73);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (729, '宝山区', 73);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (730, '嘉定区', 73);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (731, '浦东新区', 73);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (732, '金山区', 73);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (733, '松江区', 73);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (734, '青浦区', 73);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (735, '南汇区', 73);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (736, '奉贤区', 73);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (737, '崇明县', 73);");

            //insert 北京 areas.
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (1, '东城区', 1);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (2, '西城区', 1);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (3, '崇文区', 1);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (4, '宣武区', 1);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (5, '朝阳区', 1);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (6, '丰台区', 1);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (7, '石景山区', 1);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (8, '海淀区', 1);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (9, '门头沟区', 1);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (10, '房山区', 1);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (11, '通州区', 1);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (12, '顺义区', 1);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (13, '昌平区', 1);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (14, '大兴区', 1);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (15, '怀柔区', 1);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (16, '平谷区', 1);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (17, '密云县', 1);");
            db.execSQL("INSERT INTO area (area_id, area_name, city_id) VALUES (18, '延庆县', 1);");


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
