/**
 * 
 */
package fr.eni.enidraw.dal;

import java.util.List;

import fr.eni.enidraw.bo.Groupe;

/**
 * @author Maxime Brin
 * @version
 * @dateDeCréation 27 juil. 2020
 */
public interface GroupeDAO {
	/**
	 * Méthode pour insérer un Groupe dans la BD
	 * 
	 * @param groupe
	 * @throws DALException
	 */
	public void insert(Groupe groupe) throws DALException;

	/**
	 * Méthode pour recupérer toute la liste des groupes
	 * 
	 * @return
	 * @throws DALException
	 */
	public List<Groupe> selectAll() throws DALException;

	/**
	 * Méthode pour récuperer un groupe en fonction de son id
	 * 
	 * @param id
	 * @return
	 * @throws DALException
	 */
	public Groupe selectById(int id) throws DALException;

	/**
	 * Methode pour mettre a jour les données d'un groupe
	 * 
	 * @param groupe
	 * @throws DALException
	 */
	public void update(Groupe groupe) throws DALException;

	/**
	 * Methode pour effacer un groupe de la BD
	 * 
	 * @param groupe
	 * @throws DALException
	 */
	public void delete(int idGroupe) throws DALException;
}
