/**
 * 
 */
package fr.eni.enidraw.bll;

import java.util.List;

import fr.eni.enidraw.bo.Groupe;
import fr.eni.enidraw.bo.Stagiaire;

/**
 * @author Maxime Brin
 * @version
 * @dateDeCréation 30 juil. 2020
 */
public class TirageManager {
	private TirageManager instance;

	// Constructeur
	private TirageManager() {

	}

	// Méthode pour avoir mon instance
	public TirageManager getInstance() {
		if (this.instance == null) {
			this.instance = new TirageManager();
		}
		return this.instance;
	}

	/**
	 * Méthode pour vérifier les données d'un(e) stagiaire
	 * 
	 * @param stagiaire
	 * @throws BLLException
	 */
	public void verifStagiaire(Stagiaire stagiaire) throws BLLException {
		// TODO
	}

	/**
	 * Méthode pour vérifier les données d'un groupe et vérifier si il est déjà
	 * présent dans la BD
	 * 
	 * @param groupe
	 * @throws BLLException
	 */
	public void verifGroupe(Groupe groupe) throws BLLException {
		// TODO
	}

	/**
	 * Methode pour ajouter un(e) stagiaire à la BD
	 * 
	 * @param stagiaire
	 * @throws BLLException
	 */
	public void ajoutStagiaire(Stagiaire stagiaire) throws BLLException {
		// TODO
	}

	/**
	 * Méthode pour mettre à jour les données d'un(e) stagiaire
	 * 
	 * @param stagiaire
	 * @throws BLLException
	 */
	public void updateStagiaire(Stagiaire stagiaire) throws BLLException {
		// TODO
	}

	/**
	 * Méthode pour effacer un(e) stagiaire de la BD
	 * 
	 * @param stagiaire
	 * @throws BLLException
	 */
	public void effacerStagiaire(Stagiaire stagiaire) throws BLLException {
		// TODO
	}

	/**
	 * Méthode pour récupérer un(e) stagiaire de la BD grâce à son idStagiaire
	 * 
	 * @param idStagiaire
	 * @return
	 * @throws BLLException
	 */
	public Stagiaire getStagiaire(int idStagiaire) throws BLLException {
		// TODO
		return null;
	}

	/**
	 * Méthode pour récupérer la liste de tous(tes) les stagiaires
	 * 
	 * @return
	 * @throws BLLException
	 */
	public List<Stagiaire> getListStagiaires() throws BLLException {
		// TODO
		return null;
	}

	/**
	 * Méthode pour récupérer une liste de stagiaires en fonction du groupe à qui
	 * ils(elles) appartiennent
	 * 
	 * @param idGroupe
	 * @return
	 */
	public List<Stagiaire> getListStagiairesByGroupe(int idGroupe) {
		// TODO
		return null;
	}

	/**
	 * Méthode pour ajouter un groupe à la BD
	 * 
	 * @param groupe
	 * @throws BLLException
	 */
	public void ajoutGroupe(Groupe groupe) throws BLLException {
		// TODO
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
		// TODO
		return null;
	}

	/**
	 * Méthode pour récupérer la liste de tous les groupes
	 * 
	 * @return
	 * @throws BLLException
	 */
	public List<Groupe> getListGroupe() throws BLLException {
		// TODO
		return null;
	}
}
