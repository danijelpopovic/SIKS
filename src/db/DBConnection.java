package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class DBConnection {

	private static Connection conn;

	public static Connection getConnection() {
		if (conn == null)
			try {
				open();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		return conn;
	}

	public static void open() throws ClassNotFoundException, SQLException {
		if (conn != null)
			return;
		ResourceBundle bundle = PropertyResourceBundle
				.getBundle("DBConnection"); // ime fajla
		String driver = bundle.getString("driver"); // Ime parametara
		String url = bundle.getString("url");
		String username = bundle.getString("username");
		String password = bundle.getString("password");
		Class.forName(driver); // Registrovanje drajvera
		conn = DriverManager.getConnection(url, username, password);
		conn.setAutoCommit(false);

		System.out.println("DB connected...");
	}

	public static void close() {
		try {
			if (conn != null) {
				conn.close();
				conn = null;
				System.out.println("DB closed");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}

