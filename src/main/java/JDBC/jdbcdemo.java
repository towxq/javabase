package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class jdbcdemo {
	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");//加载驱动
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.1.16:3306/appdemo","root","wxqwxqwxq");
		Statement stmt = conn.createStatement();
		String sql = "select * from project;";
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()){
			for (int i = rs.getRow();i>0;i--){
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				System.out.println(rs.getString(5));
				System.out.println(rs.getString(5));
				System.out.println(rs.getString(6));
				System.out.println(rs.getString(7));
			}
		}
	}
}

//3个基本动作
//1，建立数据库连接
//2，执行SQL语句
//3，获取SQL语句的执行结果