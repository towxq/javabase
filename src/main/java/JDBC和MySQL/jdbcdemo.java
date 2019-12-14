package JDBC和MySQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class  jdbcdemo {
	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.11.130:3306/test","root","wxq123456");
		Statement stmt = conn.createStatement();
		String sql = "select * from shop;";
		ResultSet rs = stmt.executeQuery(sql);
		ResultSetMetaData resultSetMetaData = rs.getMetaData();
		int counts = resultSetMetaData.getColumnCount();
//		rs.last();
//		int cs = rs.getRow();
		System.out.println(counts+" ");
		while(rs.next()){
			for (int n = 0;n<counts;n++){
				System.out.print(resultSetMetaData.getColumnName(n+1)+":");
				System.out.print(rs.getString(resultSetMetaData.getColumnName(n+1))+" ");
			}
			System.out.println();
		}
	}
}


//JDBC和MySQL API
//1,DriverManager 用来管理，加载驱动程序
//2，Connection 表示驱动程序提供和数据库连接的对话
//3，Statement 向数据库发送SQL和取得一组结果
//4，ResultSet 定义访问执行statement产生的数据表的方法

