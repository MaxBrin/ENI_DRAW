package fr.eni.enidraw.dal;

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

			System.out.println(DAOFactory.getStagiaireDAO().selectAll());

			System.out.println(DAOFactory.getGroupeDAO().selectAll());
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
