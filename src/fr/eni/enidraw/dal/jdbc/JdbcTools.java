/**
 * 
 */
package fr.eni.enidraw.dal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import fr.eni.enidraw.dal.Settings;

/**
 * @author Maxime Brin
 * @version
 * @dateDeCréation 23 juil. 2020
 */
public class JdbcTools {
	private static String monUrl;
	private static String monUser;
	private static String monPassword;

	static {
		monUrl = Settings.getProperty("urldb").trim();
		monUser = Settings.getProperty("userdb").trim();
		monPassword = Settings.getProperty("passworddb").trim();
		try {
			DriverManager.registerDriver(new SQLServerDriver());
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(monUrl, monUser, monPassword);
		return conn;
	}
}
