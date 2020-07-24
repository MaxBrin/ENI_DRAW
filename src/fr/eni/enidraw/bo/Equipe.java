/**
 * 
 */
package fr.eni.enidraw.bo;

import java.util.List;

/**
 * @author Maxime Brin
 * @version
 * @dateDeCréation 24 juil. 2020
 */
public class Equipe {
	private int idEquipe;
	private String reference;
	private List<Stagiaire> listStagiaire;

	/**
	 * @param idEquipe
	 * @param reference
	 * @param stagiaire
	 */
	public Equipe(int idEquipe, String reference, List<Stagiaire> listStagiaire) {
		super();
		this.idEquipe = idEquipe;
		this.reference = reference;
		listStagiaire = listStagiaire;
	}

	/**
	 * @param reference
	 * @param stagiaire
	 */
	public Equipe(String reference, List<Stagiaire> listStagiaire) {
		super();
		this.reference = reference;
		listStagiaire = listStagiaire;
	}

	/**
	 * @return the idEquipe
	 */
	public int getIdEquipe() {
		return idEquipe;
	}

	/**
	 * @param idEquipe the idEquipe to set
	 */
	public void setIdEquipe(int idEquipe) {
		this.idEquipe = idEquipe;
	}

	/**
	 * @return the reference
	 */
	public String getReference() {
		return reference;
	}

	/**
	 * @param reference the reference to set
	 */
	public void setReference(String reference) {
		this.reference = reference;
	}

	/**
	 * @return the stagiaire
	 */
	public List<Stagiaire> getListStagiaire() {
		return listStagiaire;
	}

	/**
	 * @param stagiaire the stagiaire to set
	 */
	public void setStagiaire(List<Stagiaire> listStagiaire) {
		listStagiaire = listStagiaire;
	}

	public Stagiaire getStagiaire(int index) {
		return listStagiaire.get(index);
	}

}
