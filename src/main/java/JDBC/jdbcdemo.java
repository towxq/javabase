package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class jdbcdemo {
	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");//加载驱动
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.1.160:3306/byt_oc","byt_oc","123456");
		Statement stmt = conn.createStatement();
		String sql = "show tables;";
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()){
			System.out.println(rs.getString(1));
		}
	}
}
