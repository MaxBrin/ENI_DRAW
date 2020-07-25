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

	public void insert(Stagiaire stagiaire);

	public List<Stagiaire> selectAll();

	public Stagiaire selectById(int id);

	public void update(Stagiaire stagiaire);

	public void delete(Stagiaire Stagiaire);
}
