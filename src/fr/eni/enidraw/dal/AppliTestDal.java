package fr.eni.enidraw.dal;

import fr.eni.enidraw.bo.Groupe;
import fr.eni.enidraw.bo.Stagiaire;

public class AppliTestDal {

	public static void main(String[] args) {
		try {
			// Création de 5 stagiaire test
			Stagiaire max = new Stagiaire("Brin", "Max", 'M', false, false);
			Stagiaire john = new Stagiaire("Edouard", "John", 'M', true, false);
			Stagiaire charlotte = new Stagiaire("Penot", "Charlotte", 'F', false, true);
			Stagiaire elio = new Stagiaire("Cartier", "Elio", 'M', true, true);
			Stagiaire tanguy = new Stagiaire("Jouvin", "Tanguy", 'M', true, false);
			// Acces à l'implémentation de StagiaireDAO
			StagiaireDAO sDAO = DAOFactory.getStagiaireDAO();
			// Insertion des stagiaires dans la BD
			sDAO.insert(max);
			sDAO.insert(john);
			sDAO.insert(charlotte);
			sDAO.insert(elio);
			sDAO.insert(tanguy);

			// Affichage d'un test de selectByIdStagiaire
			System.out.println("Affichage d'un stagiaire en fonction de son id");
			System.out.println(DAOFactory.getStagiaireDAO().selectByIdStagiaire(5));
			// Test de selectById pour un groupe
			System.out.println("------------------------");
			System.out.println("Affichage d'un groupe en fonction de son id");
			System.out.println(DAOFactory.getGroupeDAO().selectById(1));
			// Création d'un deuxième groupe test
			Groupe groupe2 = new Groupe(2, "Seconde Team");
			// Insertion du groupe test
			DAOFactory.getGroupeDAO().insert(groupe2);
			// Mettre un stagiaire dans groupe2
			max.setGroupe(groupe2);
			// Test Update pour un stagiaire avec changement de groupe et affichage du
			// groupe
			DAOFactory.getStagiaireDAO().update(max);
			System.out.println("-----------------");
			System.out.println(DAOFactory.getStagiaireDAO().selectByIdGroupe(2));
			// Test Delete pour un stagiaire
			DAOFactory.getStagiaireDAO().delete(john.getIdStagiaire());
			System.out.println(DAOFactory.getGroupeDAO().selectById(1));
			// Récuperation de groupe2 dans la BD
			groupe2 = DAOFactory.getGroupeDAO().selectById(2);
			System.out.println(groupe2);
			// Affichage des groupes avant modif
			System.out.println("----------------------");
			System.out.println("Affichage avant modif");
			for (Groupe groupe : DAOFactory.getGroupeDAO().selectAll()) {
				System.out.println("Groupe " + groupe.getIdGroupe() + " : ");
				System.out.println();
				for (Stagiaire stagiaire : groupe.getListStagiaire()) {
					System.out.println("Stagiaire " + stagiaire.getIdStagiaire() + " : ");
					System.out.println(stagiaire);

				}
			}

			// Test de Delete pour les groupes
			DAOFactory.getGroupeDAO().delete(2);
			// Affichage des groupes après modif
			System.out.println("----------------------");
			System.out.println("Affichage après modif");
			for (Groupe groupe : DAOFactory.getGroupeDAO().selectAll()) {
				System.out.println("Groupe " + groupe.getIdGroupe() + " : ");
				for (Stagiaire stagiaire : groupe.getListStagiaire()) {
					System.out.println("Stagiaire " + stagiaire.getIdStagiaire() + " : ");
					System.out.println(stagiaire);
				}
			}
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
