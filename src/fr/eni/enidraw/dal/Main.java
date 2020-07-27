package fr.eni.enidraw.dal;

import fr.eni.enidraw.bo.Stagiaire;

public class Main {

	public static void main(String[] args) {
		try {
			Stagiaire max = new Stagiaire("Brin", "Max", 'M', false, false);
			StagiaireDAO sDAO = DAOFactory.getStagiaireDAO();
			sDAO.insert(max);
			System.out.println(max);
			System.out.println(DAOFactory.getStagiaireDAO().selectAll());
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
