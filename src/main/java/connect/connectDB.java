package connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class connectDB {
	public static Connection getConnection() {
		Connection connect = null;
		try {
			String url = "jdbc:mysql://localhost:3306/mywweb";
			String user = "root";
			String password = "12345";
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connect;
	}

	public static void closeConnection(Connection con) {
		try {
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		if (connectDB.getConnection() != null) {
			System.out.println("Success");
		} else {
			System.out.println("Error");
		}
	}
}
