package db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	
			static String driver = "org.h2.Driver";
			/*static String url = "jdbc:jtds:sqlserver://localhost/Magacin";
			static String username = "user";
			static String password = "user";*/

	public static void open() throws ClassNotFoundException, SQLException {
		if (conn != null)
			return;
		//ResourceBundle bundle = PropertyResourceBundle
		//		.getBundle("DBConnection"); // ime fajla
		//String driver = bundle.getString("driver"); // Ime parametara
		//String url = bundle.getString("url");
		//String username = bundle.getString("username");
		//String password = bundle.getString("password");
		Class.forName(driver); // Registrovanje drajvera
		conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
		conn.setAutoCommit(false);
		DatabaseMetaData metaData = DBConnection.getConnection().getMetaData();
		ResultSet set = metaData.getTableTypes();
		while (set.next()) {
			System.out.println(set.getString("TABLE_TYPE"));
		}
		setLockTimeOut(); 
	}

	public static void close() {
		try {
			if (conn != null)
				conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private static final String LOCK_TIMEOUT_INTERVAL = "5000";

	private static void setLockTimeOut() throws SQLException {
		Statement stmt = conn.createStatement();
		String cmd = "SET LOCK_TIMEOUT " + LOCK_TIMEOUT_INTERVAL;
		stmt.execute(cmd);
	}
}

