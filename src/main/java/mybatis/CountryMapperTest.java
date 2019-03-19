package mybatis;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class CountryMapperTest extends BaseMapperTest{
    @Test
    public void testSelectAll(){
        SqlSession sqlSession = getSqlSession();
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//            List<SysUser> sysUsers = userMapper.selectAll();
//            printList(sysUsers);

//            SysUser sysUser = userMapper.selectById(1L);
//            System.out.println(sysUser.getId()+"---"+sysUser.getUserName()+"---"+sysUser.getUserPassword());

            SysUser user = new SysUser();
            user.setUserName("admin");
            SysUser sysUser = userMapper.selectbyUserName(user);
            System.out.println(sysUser.getId()+"---"+sysUser.getUserName()+"---"+sysUser.getUserPassword());

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
