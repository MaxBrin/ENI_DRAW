package fr.eni.enidraw.dal;

import java.sql.Connection;
import java.sql.SQLException;

import fr.eni.enidraw.dal.jdbc.JdbcTools;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection con = JdbcTools.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
