package mybatis;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CountryMapperTest extends BaseMapperTest{
    @Test
    public void testSelectAll(){
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


            UserDemoMapper um = sqlSession.getMapper(UserDemoMapper.class);
            // 调用selectUserById方法
            User user = um.selectUserById(1);
            // 查看查询到的user对象信息
            System.out.println(user.getId() + " " + user.getUsername());
            // 查看user对象关联的订单信息
            List<Order> orders = user.getOrders();
            for (Order order : orders)
            {
                System.out.println(order.toString());
            }
        }finally {
            sqlSession.close();
        }
    }

    private void printList(List<SysUser> sysUsers) {
        for (SysUser sysUser: sysUsers){
            System.out.println(sysUser.getId()+"---"+sysUser.getUserName()+"---"+sysUser.getUserPassword());
        }
    }
}
