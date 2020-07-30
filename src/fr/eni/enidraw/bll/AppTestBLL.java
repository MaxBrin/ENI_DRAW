/**
 * 
 */
package fr.eni.enidraw.bll;

import fr.eni.enidraw.bo.Stagiaire;

/**
 * @author Maxime Brin
 * @version
 * @dateDeCréation 30 juil. 2020
 */
public class AppTestBLL {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Récupération d'une instance de TirageManager
		TirageManager tm = TirageManager.getInstance();
		// Test pour voir si on vérifie bien les données des stagiaires
		try {
			tm.verifStagiaire(new Stagiaire(null, null, ' ', true, false));
		} catch (BLLException e) {
			e.printStackTrace();
		}
	}

}
