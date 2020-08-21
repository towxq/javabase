package JDBC和MySQL;

import java.sql.*;

public class  jdbcdemo {
	public static void main(String[] args){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		String sql = "select * from shop;";

		try {
			connection = DriverManager.getConnection("jdbc:mysql://192.168.11.130:3306/test","root","root");
			statement = connection.createStatement();
			rs = statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int counts = 0;
		try {
			ResultSetMetaData resultSetMetaData = rs.getMetaData();
			counts = resultSetMetaData.getColumnCount();
			while(rs.next()){
				for (int n = 0;n<counts;n++){
					System.out.print(resultSetMetaData.getColumnName(n+1)+":");
					System.out.print(rs.getString(resultSetMetaData.getColumnName(n+1))+" ");
				}
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (statement!=null){
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (connection!=null){
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}


	}
}


//JDBC和MySQL API
//1,DriverManager 用来管理，加载驱动程序
//2，Connection 表示驱动程序提供和数据库连接的对话
//3，Statement 向数据库发送SQL和取得一组结果
//4，ResultSet 定义访问执行statement产生的数据表的方法

