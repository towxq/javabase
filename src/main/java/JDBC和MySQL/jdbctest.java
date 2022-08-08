package JDBC和MySQL;

import org.junit.Test;

import java.sql.*;

/**
 * @author wxq
 * @ClassName jdbctest
 * @Description TODO
 * @date 2021/8/12  14:58
 */
public class jdbctest {
//JDBC
//1, DriverManager 用来管理，加载驱动程序
//2，Connection 表示驱动程序提供和数据库连接的对话
//3，Statement 向数据库发送SQL和取得一组结果
//4，ResultSet 定义访问执行statement产生的数据表的方法
//5，close关闭连接

    @Test
    public void test() throws ClassNotFoundException, SQLException {
        String sql = "select * from freeze_user";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://121.4.31.212:3306/test", "root", "123456");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        int counts = resultSetMetaData.getColumnCount();//列数
        while (resultSet.next()) {//遍历行
            for (int n = 0; n < counts; n++) {
                System.out.print(resultSetMetaData.getColumnName(n + 1) + ":");
                System.out.print(resultSet.getString(resultSetMetaData.getColumnName(n + 1)) + " ");
            }
            System.out.println();
        }
        statement.close();
        connection.close();
    }
}
