/**
 * 
 */
package fr.eni.enidraw.dal;

import fr.eni.enidraw.dal.jdbc.GroupeDAOJDBCImpl;
import fr.eni.enidraw.dal.jdbc.StagiaireDAOJDBCImpl;

/**
 * @author Maxime Brin
 * @version
 * @dateDeCréation 27 juil. 2020
 */
public class DAOFactory {
	/**
	 * methode pour recuperer une instance de StagiaireDAOJDBCImpl
	 * 
	 * @return
	 */
	public static StagiaireDAO getStagiaireDAO() {
		return new StagiaireDAOJDBCImpl();
	}

	/**
	 * methode pour recuperer une instance de GroupeDAOJDBCImpl
	 * 
	 * @return
	 */
	public static GroupeDAO getGroupeDAO() {
		return new GroupeDAOJDBCImpl();
	}
}
