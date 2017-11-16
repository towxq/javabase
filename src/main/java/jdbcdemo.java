import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by MSI on 2016/6/15.
 */
public class jdbcdemo {

    public static void main(String[] args) {
        Connection conn= getConn();
        long begin = System.currentTimeMillis();
        for (int i =0;i<=1000000;i++){
        try {
            util u = new util();
            String sql = "insert into bytpaycard VALUES ('"+u.getUUID()+"','"+u.getUUID()+"','1'"+",'100001'"+",'asdadasd'"+",'sdsadad'"+",'11'"+",'"+u.getdate()+"','"+u.getOverduetime()+"','"+u.addgetdate()+"','1'"+")";//SQL语句
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.executeUpdate(sql);
            System.out.println("第" + i + "条执行ok");
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }
        long end = System.currentTimeMillis();
        System.out.println("总耗时："+(double)(end-begin)/1000);
    }

    private static Connection getConn() {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://192.168.65.128:3306/appdemo";
        String username = "root";
        String password = "wxqwxq";
        Connection conn = null;
        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
