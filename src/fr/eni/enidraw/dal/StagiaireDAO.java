/**
 * 
 */
package fr.eni.enidraw.dal;

import java.util.List;

import fr.eni.enidraw.bo.Stagiaire;

/**
 * @author Maxime Brin
 * @version
 * @dateDeCréation 24 juil. 2020
 */
public interface StagiaireDAO {
	/**
	 * Méthode pour insérer un stagiaire dans la BD
	 * 
	 * @param stagiaire
	 * @throws DALException
	 */
	public void insert(Stagiaire stagiaire) throws DALException;

	/**
	 * Méthode pour recupérer toute la liste des stagiaires
	 * 
	 * @return
	 * @throws DALException
	 */
	public List<Stagiaire> selectAll() throws DALException;

	/**
	 * Méthode pour récuperer un stagiaire en fonction de son id
	 * 
	 * @param id
	 * @return
	 * @throws DALException
	 */
	public Stagiaire selectById(int id) throws DALException;

	/**
	 * Methode pour mettre a jour les données d'un stagiaire
	 * 
	 * @param stagiaire
	 * @throws DALException
	 */
	public void update(Stagiaire stagiaire) throws DALException;

	/**
	 * Methode pour effacer un stagiaire de la BD
	 * 
	 * @param Stagiaire
	 * @throws DALException
	 */
	public void delete(int idStagiaire) throws DALException;
}
