package fr.eni.enidraw.dal;

import fr.eni.enidraw.bo.Groupe;
import fr.eni.enidraw.bo.Stagiaire;

public class Main {

	public static void main(String[] args) {
		try {
			Stagiaire max = new Stagiaire("Brin", "Max", 'M', false, false);
			Stagiaire john = new Stagiaire("Edouard", "John", 'M', true, false);
			Stagiaire charlotte = new Stagiaire("Penot", "Charlotte", 'F', false, true);
			Stagiaire elio = new Stagiaire("Cartier", "Elio", 'M', true, true);
			Stagiaire tanguy = new Stagiaire("Jouvin", "Tanguy", 'M', true, false);

			StagiaireDAO sDAO = DAOFactory.getStagiaireDAO();
			sDAO.insert(max);
			sDAO.insert(john);
			sDAO.insert(charlotte);
			sDAO.insert(elio);
			sDAO.insert(tanguy);

			System.out.println(DAOFactory.getStagiaireDAO().selectByIdStagiaire(5));
			Groupe groupe = DAOFactory.getGroupeDAO().selectById(1);
			Groupe groupe2 = new Groupe(2, "Seconde Team");
//			DAOFactory.getGroupeDAO().insert(groupe2);
			max.setGroupe(groupe2);
			System.out.println(max);
			DAOFactory.getStagiaireDAO().update(max);
			groupe2 = DAOFactory.getGroupeDAO().selectById(2);
			System.out.println(groupe2);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
