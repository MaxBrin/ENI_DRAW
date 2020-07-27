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

			System.out.println(DAOFactory.getStagiaireDAO().selectAll());
			Groupe groupe1 = DAOFactory.getGroupeDAO().selectById(1);
			groupe1.setListStagiaire(DAOFactory.getStagiaireDAO().selectByIdGroupe(1));
			System.out.println();
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
