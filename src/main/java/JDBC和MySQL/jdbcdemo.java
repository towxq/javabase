package JDBC和MySQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class  jdbcdemo {
	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");//加载驱动
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.11.130:3306/test","root","wxq123456");
		Statement stmt = conn.createStatement();
		String sql = "select * from shop;";
		ResultSet rs = stmt.executeQuery(sql);
		ResultSetMetaData rsmd = rs.getMetaData();
		int i = rsmd.getColumnCount();
		while(rs.next()){
			for (int n = 0;n<i;n++){
				System.out.print(rsmd.getColumnName(i+1)+" ");
				System.out.println();
			}
		}
	}

	public static List<Map<String,Object>> queryForList(){
		Connection connection = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		List<Map<String,Object>> resultList = new ArrayList<Map<String,Object>>();

		try {
 			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://192.168.1.16:3306/appdemo";

			String user = "root";
			String password = "wxqwxqwxq";

			// 获取数据库连接
			connection = DriverManager.getConnection(url,user,password);

			String sql = "select * from userinfo where user_id = ? ";
			// 创建Statement对象（每一个Statement为一次数据库执行请求）
			stmt = connection.prepareStatement(sql);

			// 设置传入参数
			stmt.setString(1, "zhangsan");

			// 执行SQL语句
			rs = stmt.executeQuery();

			// 处理查询结果（将查询结果转换成List<Map>格式）
			ResultSetMetaData rsmd = rs.getMetaData();
			int num = rsmd.getColumnCount();

			while(rs.next()){
				Map map = new HashMap();
				for(int i = 0;i < num;i++){
					String columnName = rsmd.getColumnName(i+1);
					map.put(columnName,rs.getString(columnName));
				}
				resultList.add(map);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 关闭结果集
				if (rs != null) {
					rs.close();
					rs = null;
				}
				// 关闭执行
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (connection != null) {
					connection.close();
					connection = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultList;
	}
}


//JDBC和MySQL API
//1,DriverManager 用来管理，加载驱动程序
//2，Connection 表示驱动程序提供和数据库连接的对话
//3，Statement 向数据库发送SQL和取得一组结果
//4，ResultSet 定义访问执行statement产生的数据表的方法

