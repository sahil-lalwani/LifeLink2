package in.lifelink.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static Connection conn;
	
	public static void openConnection(String url,String username,String pass){
		try {
			Class.forName("org.postgresql.Driver");
			conn=DriverManager.getConnection(url,username,pass);
			System.out.println("Connection open successfully");
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws SQLException{
		if(conn!=null) {
			return conn;
		}
		throw new SQLException("Connection is null");
	}
	
	public static void closeConnection() {
		if(conn!=null) {
			try {
				conn.close();
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

}
