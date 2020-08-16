/**
 * 
 */
package fr.eni.enidraw.dal.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * @author Maxime Brin
 * @version
 * @dateDeCréation 23 juil. 2020
 */
public class JdbcTools {
	private static DataSource dataSource;

	static {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Impossible d'accéder à la base de donn�es");
		}

	}

	public static Connection getConnection() throws SQLException {

		return dataSource.getConnection();
	}
}
