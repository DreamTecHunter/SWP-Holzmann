package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Datenbank modell erzeugen in workbench
// connector in lib hinzufügen
public class DBManager {
	private static DBManager instance = null;

	private DBManager() {
	}

	public static DBManager getInstance() {
		if (instance == null) {
			instance = new DBManager();
		}
		return instance;
	}

	// java sql conneciton

	public Connection getConnection() throws ClassNotFoundException,
			SQLException { // TODO
		Connection con = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager
				.getConnection(
						"jdbc:mysql://localhost:3306/swp_holzmann?useUnicode=true&characterEncoding=utf8&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC",
						"swp-holzmann", "swp-holzmann");
		return con;

	}

	public void relesaeConnection(Connection con) throws SQLException {
		con.close();
	}

	public boolean canLogin(Connection con, String user, String password)
			throws Exception {
		String sql = "select count(*) from users where user = ? and password = ?;";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, user);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				return rs.getInt(1) == 1;
			}
		} catch (Exception ex) {
			throw new Exception(ex.getMessage());
		}
		return false;
	}
}
