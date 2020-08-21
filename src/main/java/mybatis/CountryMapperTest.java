package mybatis;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CountryMapperTest extends BaseMapperTest{
    @Test
    public void testSelectAll() throws InterruptedException {
        SqlSession sqlSession = getSqlSession();
        try{
//            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//              ArticleMapper articleMapper = sqlSession.getMapper(ArticleMapper.class);
//            List<SysUser> sysUsers = userMapper.selectAll();
//            printList(sysUsers);

//            List<Long> strings = new ArrayList<Long>();
//            strings.add(1L);
//            strings.add(2L);
//            List<SysUser> sysUsers = userMapper.selectByIdList(strings);
//            printList(sysUsers);

//            SysUser sysUser = userMapper.selectById(1L);
//            System.out.println(sysUser.getId()+"---"+sysUser.getUserName()+"---"+sysUser.getUserPassword());

//            List<SysUser> sysUser = userMapper.selectUserAndRoleById3(1L);
//            printList(sysUser);

//            SysUser user = new SysUser();
//            user.setUserName("admin");
//            user.setUserEmail("asdasd@qq.com");
//            SysUser sysUser = userMapper.selectbyUserName(user);
//            System.out.println(sysUser.getId()+"---"+sysUser.getUserName()+"---"+sysUser.getUserPassword());

//                SysUser user = new SysUser();
//                user.setId(2L);
//                user.setUserName("adasd");
//                user.setUserPassword("21313123");
//                user.setUserEmail("wxawdaw@qq.com");
//                user.setUserInfo("asdasdasdasdasdasd");
//                user.setBeadImg("asdasd".getBytes());
//                user.setCreateTime(new Date());
//                int result = userMapper.insertUser(user);
//                sqlSession.commit();
//                System.out.println(result);

//                    SysUser sysUser = new SysUser();
//                    sysUser.setId(2L);
//                    sysUser.setUserEmail("asdadssa@qq.com");
//                    sysUser.setUserPassword("aabbcc");
//                    int result = userMapper.updateById(sysUser);
//                    sqlSession.commit();

//                SysUser user = new SysUser();
//                user.setUserName("wxq");
//                user.setUserPassword("2312312");
//                user.setUserEmail("wxawdaw12@122.com");
//                user.setUserInfo("sadsadasdad12121");
//                user.setBeadImg("12213123223123".getBytes());
//                user.setCreateTime(new Date());
//                SysUser user1 = new SysUser();
//                user1.setUserName("wxq1");
//                user1.setUserPassword("3534534543");
//                user1.setUserEmail("wxawdaw@sina.com");
//                user1.setUserInfo("324452324234dsfsdfsf");
//                user1.setBeadImg("asd234232434asd".getBytes());
//                user1.setCreateTime(new Date());
//                List<SysUser> sysUsers = new ArrayList<SysUser>();
//                sysUsers.add(user);
//                sysUsers.add(user1);
//                int result = userMapper.insertUserList(sysUsers);
//                sqlSession.commit();
//                System.out.println(result);


//            UserDemoMapper um = sqlSession.getMapper(UserDemoMapper.class);
//            // 调用selectUserById方法
//            User user = um.selectUserById(1);
//            // 查看查询到的user对象信息
//            System.out.println(user.getId() + " " + user.getUsername());
//            // 查看user对象关联的订单信息
//            List<Order> orders = user.getOrders();
//            for (Order order : orders)
//            {
//                System.out.println(order.toString());
//            }

            SensorRecordMapper sensorRecordMapper = sqlSession.getMapper(SensorRecordMapper.class);
            String tableName = "freeze_sensor_record_892b62b47fd8835d1c7ded3d7396e3a7";
////            System.out.println(sensorRecordMapper.existTable(tableName));
            Map<String,Object> map = new HashMap<String, Object>();
            for (int i =0;i<=400;i++){
                map.put(generate(),0);
            }
            for (int n =0;n<2000;n++){
                Map<String,Object> paramsmap = new HashMap<String, Object>();
                for (String key:map.keySet()){
                    map.put(key,(int)(Math.random()*100+1));
                }
                paramsmap.put("tableName",tableName);
                paramsmap.put("dataTime",dateFormat(new Date()));
                paramsmap.put("reportTime",dateFormat(new Date()));
                paramsmap.put("sensorValue",JSON.toJSONString(map));
                paramsmap.put("state",0);
                sensorRecordMapper.insert(paramsmap);
                sqlSession.commit();
                Thread.sleep(Long.valueOf("500"));
//                int beginid =  10;
//                int endid =  206;
//                List<Integer> integers = new ArrayList<Integer>();
//                for (int i = beginid;i<=endid;i = i+2){
//                    integers.add(i);
//                }
//                Map<String, Object> params = new HashMap<String,Object>();
//                params.put("tableName",tableName);
//                params.put("beforedate","2020-04-07 20:21:35" );
//                params.put("nowdate","2020-04-09 20:21:35");
//                params.put("ids",integers);
//                List<SensorRecord> sensorRecords = sensorRecordMapper.selectById(tableName,integers);
////                sqlSession.commit();
//                System.out.println(sensorRecords.size());
            }
        }finally {
            sqlSession.close();
        }
    }

//    private void printList(List<SysUser> sysUsers) {
//        for (SysUser sysUser: sysUsers){
//            System.out.println(sysUser.getId()+"---"+sysUser.getUserName()+"---"+sysUser.getUserPassword());
//        }
//    }

    public static String generate() {
        char[] letters = { 'a', 'b', 'c', 'd', 'e', 'f',
                'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
        boolean[] flag = new boolean[letters.length];//初始化都为false
        char[] results = new char[5];
        for (int i = 0; i < 5; i++) {
            int index = 0;
            do {
                index = (int) (Math.random() * 26);//第一个肯定是不重复的
            } while (flag[index]);
            results[i] = letters[index];
            flag[index] = true;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char c:results){
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    public static String dateFormat(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }
}
