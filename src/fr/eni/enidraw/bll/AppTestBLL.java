/**
 * 
 */
package fr.eni.enidraw.bll;

import fr.eni.enidraw.bo.Groupe;
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

		// TEST TirageManager
		System.out.println("Test pour voir si on vérifie bien les données des stagiaires");
		try {
			tm.verifStagiaire(new Stagiaire(null, null, ' ', true, false));
		} catch (BLLException e) {
			System.err.println("Verif Stagiaire marche");
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("Test ajoutStagiaire déjà présent");

		Stagiaire max = new Stagiaire(1, "Max", "Brin", 'M', false, true, new Groupe(1, ""));
		Stagiaire john = new Stagiaire("Edouard", "John", 'M', true, false);
		Stagiaire elio = new Stagiaire("Cartier", "Elio", 'M', true, false);
		Stagiaire charlotte = new Stagiaire("Penot", "Charlotte", 'F', true, true);
		try {
			// Affichage du stagaire présent dans la BD et test de getStagiaire
			System.out.println(tm.getStagiaire(max.getIdStagiaire()));
			// Essaie d'ajoutstagiaire
			tm.addStagiaire(max);

		} catch (BLLException e) {
			e.printStackTrace();
		}
		max.setIdStagiaire(null);
		try {
			tm.addStagiaire(max);
		} catch (BLLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println();
		System.out.println("Test ajoutStagiaire non présents");

		try {
			// Ajout d'un stagiaire
			tm.addStagiaire(john);
			// Affichage de ce stagiaire présent dans la BD
			System.out.println(tm.getStagiaire(john.getIdStagiaire()));
		} catch (BLLException e) {
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("Test de updateStagiaire");
		// Changement du nom du stagiaire pour tester
		try {
			max.setNom("Dupond");
			tm.updateStagiaire(max);
			max.setNom("Brin");
			max.setPrenom("Maxime");
			tm.updateStagiaire(max);
			// Affichage de l'update du stagiaire dans la BD
			System.out.println(tm.getStagiaire(max.getIdStagiaire()));
		} catch (BLLException e) {
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("Test de updateStagiaire avec un groupe non présent dans la BD");
		// Changer l'idGroupe pour tester
		max.setGroupe(new Groupe(3, "Seconde Team"));
		try {
			tm.updateStagiaire(max);
			System.out.println(tm.getStagiaire(max.getIdStagiaire()));
		} catch (BLLException e) {
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("Test de effacerStagiaire");
		try {
			tm.deleteStagiaire(john);
		} catch (BLLException e) {
			e.printStackTrace();
		}
		System.out.println("Test de getListStagiaires");
		try {
			System.out.println(tm.getListStagiaires());
		} catch (BLLException e) {
			e.printStackTrace();
		}
		System.out.println("Test de bygroupe");
		try {
			System.out.println(tm.getListStagiairesByGroupe(3));
		} catch (BLLException e) {
			e.printStackTrace();
		}
		System.out.println("Test de selectallgroupe");
		try {
			System.out.println(tm.getListGroupe());
		} catch (BLLException e) {
			e.printStackTrace();
		}
		System.out.println("Test de selectallgroupe");
		try {
			System.out.println(tm.getGroupe(3));
		} catch (BLLException e) {
			e.printStackTrace();
		}
	}

}
