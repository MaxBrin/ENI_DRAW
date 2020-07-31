/**
 * 
 */
package fr.eni.enidraw.bll;

import java.util.List;

import fr.eni.enidraw.bo.Groupe;
import fr.eni.enidraw.bo.Stagiaire;
import fr.eni.enidraw.dal.DALException;
import fr.eni.enidraw.dal.DAOFactory;
import fr.eni.enidraw.dal.GroupeDAO;
import fr.eni.enidraw.dal.StagiaireDAO;

/**
 * @author Maxime Brin
 * @version
 * @dateDeCréation 30 juil. 2020
 */
public class TirageManager {
	private static TirageManager instance;
	private static GroupeDAO groupeDAO;
	private static StagiaireDAO stagiaireDAO;

	// Constructeur
	private TirageManager() {
		groupeDAO = DAOFactory.getGroupeDAO();
		stagiaireDAO = DAOFactory.getStagiaireDAO();
	}

	// Méthode pour avoir mon instance
	public static TirageManager getInstance() {
		if (instance == null) {
			instance = new TirageManager();
		}
		return instance;
	}

	/**
	 * Méthode pour vérifier les données d'un(e) stagiaire
	 * 
	 * @param stagiaire
	 * @throws BLLException
	 */
	public void verifStagiaire(Stagiaire stagiaire) throws BLLException {
		boolean valide = true;
		StringBuffer sb = new StringBuffer();

		if (stagiaire == null)
			throw new BLLException("Stagiaire null");
		if (stagiaire.getNom() == null || stagiaire.getNom().isEmpty()) {
			sb.append("Le nom du stagiaire est obligatoire.\n");
			valide = false;
		}
		if (stagiaire.getPrenom() == null || stagiaire.getPrenom().isEmpty()) {
			sb.append("Le prénom du stagiaire est obligatoire.\n");
			valide = false;
		}
		if (stagiaire.getSexe() != 'F' && stagiaire.getSexe() != 'M' || (stagiaire.getSexe() + "").trim().isEmpty()) {
			sb.append("Le genre du stagiaire est obligatoire.\n");
			valide = false;
		}
		if (!valide) {
			throw new BLLException(sb.toString());
		}
	}

	/**
	 * Méthode pour vérifier si un groupe est déjà présent dans la BD
	 * 
	 * @param groupe
	 * @throws BLLException
	 */
	public void verifGroupe(Groupe groupeAVerifier) throws BLLException {
		boolean valide = true;
		StringBuffer sb = new StringBuffer();
		// Verification si le groupe est déjà présent dans la BD
		try {
			// Récupération de la liste des groupes présents
			List<Groupe> groupes = groupeDAO.selectAll();
			// Si la liste n'est pas vide on verifie
			if (!groupes.isEmpty()) {
				// Pour chaque groupe présent dans la liste
				for (Groupe groupe : groupes) {
					// Vérification si idGroupe du groupe présent est egale à idGroupe du groupe à
					// vérifier
					if (groupe.getIdGroupe() == groupeAVerifier.getIdGroupe()) {
						sb.append("Le groupe est déjà présent dans la BD\n");
						valide = false;
					}
				}
			}
		} catch (DALException e) {
			e.printStackTrace();
		}
		if (!valide) {
			throw new BLLException(sb.toString());
		}
	}

	/**
	 * Methode pour ajouter un(e) stagiaire à la BD
	 * 
	 * @param stagiaire
	 * @throws BLLException
	 */
	public void addStagiaire(Stagiaire stagiaire) throws BLLException {
		try {
			verifStagiaire(stagiaire);
			if (stagiaire.getIdStagiaire() != null) {
				throw new BLLException("Ajout d'un stagiaire déjà présent impossible");
			}
			stagiaireDAO.insert(stagiaire);
		} catch (DALException e) {
			throw new BLLException("Echec d'ajout Stagiaire", e);
		}
	}

	/**
	 * Méthode pour mettre à jour les données d'un(e) stagiaire
	 * 
	 * @param stagiaire
	 * @throws BLLException
	 */
	public void updateStagiaire(Stagiaire stagiaire) throws BLLException {
		try {
			verifStagiaire(stagiaire);
			boolean verif = false;
			List<Groupe> groupes = groupeDAO.selectAll();
			for (Groupe groupe : groupes) {
				if (groupe.getIdGroupe() == stagiaire.getGroupe().getIdGroupe()) {
					verif = true;
				}
			}
			if (!verif) {
				groupeDAO.insert(stagiaire.getGroupe());
			}
			stagiaireDAO.update(stagiaire);
		} catch (DALException e) {
			throw new BLLException("Echec de updateStagiaire");
		} catch (NullPointerException e) {
			throw new BLLException("Stagiaire non présent dans la BD");
		}
	}

	/**
	 * Méthode pour effacer un(e) stagiaire de la BD
	 * 
	 * @param stagiaire
	 * @throws BLLException
	 */
	public void deleteStagiaire(Stagiaire stagiaire) throws BLLException {
		try {
			verifStagiaire(stagiaire);
			stagiaireDAO.delete(stagiaire.getIdStagiaire());
		} catch (DALException e) {
			throw new BLLException("Echec de effacerStagiaire");
		} catch (NullPointerException e) {
			throw new BLLException("Stagiaire non présent dans la BD");
		}
	}

	/**
	 * Méthode pour récupérer un(e) stagiaire de la BD grâce à son idStagiaire
	 * 
	 * @param idStagiaire
	 * @return
	 * @throws BLLException
	 */
	public Stagiaire getStagiaire(int idStagiaire) throws BLLException {
		Stagiaire stagiaire = null;
		try {
			stagiaire = stagiaireDAO.selectByIdStagiaire(idStagiaire);
		} catch (DALException e) {
			throw new BLLException("Echec de getStagiaire");
		}
		if (stagiaire == null) {
			throw new BLLException("Cet id de stagiaire n'existe pas");
		}
		return stagiaire;
	}

	/**
	 * Méthode pour récupérer la liste de tous(tes) les stagiaires
	 * 
	 * @return
	 * @throws BLLException
	 */
	public List<Stagiaire> getListStagiaires() throws BLLException {
		List<Stagiaire> stagiaires = null;
		try {
			stagiaires = stagiaireDAO.selectAll();
		} catch (DALException e) {
			throw new BLLException("Echec de getListStagiaires");
		}
		return stagiaires;
	}

	/**
	 * Méthode pour récupérer une liste de stagiaires en fonction du groupe à qui
	 * ils(elles) appartiennent
	 * 
	 * @param idGroupe
	 * @return
	 */
	public List<Stagiaire> getListStagiairesByGroupe(int idGroupe) throws BLLException {
		List<Stagiaire> stagiaires = null;
		try {
			stagiaires = stagiaireDAO.selectByIdGroupe(idGroupe);
		} catch (DALException e) {
			throw new BLLException("Echec de getListStagiaires");
		}
		return stagiaires;
	}

	/**
	 * Méthode pour ajouter un groupe à la BD
	 * 
	 * @param groupe
	 * @throws BLLException
	 */
	public void addGroupe(Groupe groupe) throws BLLException {
		try {
			verifGroupe(groupe);
			groupeDAO.insert(groupe);

		} catch (DALException e) {
			throw new BLLException("Impossible d'ajouter un groupe déja présent");
		}
	}

	/**
	 * Méthode pour mettre à jour les données d'un groupe
	 * 
	 * @param groupe
	 * @throws BLLException
	 */
	public void updateGroupe(Groupe groupe) throws BLLException {
		// TODO
	}

	/**
	 * Méthode pour effacer un groupe de la BD
	 * 
	 * @param groupe
	 * @throws BLLException
	 */
	public void effacerGroupe(Groupe groupe) throws BLLException {
		// TODO
	}

	/**
	 * Méthode pour récupérer un groupe de la BD grâce à son idGroupe
	 * 
	 * @param idGroupe
	 * @return
	 * @throws BLLException
	 */
	public Groupe getGroupe(int idGroupe) throws BLLException {
		Groupe groupe = null;
		try {
			groupe = groupeDAO.selectById(idGroupe);
		} catch (DALException e) {
			throw new BLLException("Echec de getStagiaire");
		}
		if (groupe == null) {
			throw new BLLException("Cet id de stagiaire n'existe pas");
		}
		return groupe;

	}

	/**
	 * Méthode pour récupérer la liste de tous les groupes
	 * 
	 * @return
	 * @throws BLLException
	 */
	public List<Groupe> getListGroupe() throws BLLException {
		List<Groupe> groupes = null;
		try {
			groupes = groupeDAO.selectAll();
		} catch (DALException e) {
			throw new BLLException("Echec de getListStagiaires");
		}
		return groupes;

	}
}
