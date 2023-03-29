package homework.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	
	public static void main(String[] args) {
		System.out.println(DbConnection.getDB());
	}
	public static Connection getDB() {
		String url="jdbc:mysql://localhost:3306/seek";
		String username="root";
		String password="0000";
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(url,username,password);
			System.out.println("成功!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("失敗1");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("失敗2");
		}
		return conn;
	}
}
