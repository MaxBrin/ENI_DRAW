/**
 * 
 */
package fr.eni.enidraw.bo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maxime Brin
 * @version
 * @dateDeCréation 24 juil. 2020
 */

public class Groupe {
	private int idGroupe;
	private String reference;
	private List<Stagiaire> listStagiaire;

	/**
	 * @param idEquipe
	 * @param reference
	 * @param stagiaire
	 */
	public Groupe(int idGroupe, String reference) {
		super();
		this.idGroupe = idGroupe;
		this.reference = reference;
		this.listStagiaire = new ArrayList<Stagiaire>();
	}

	/**
	 * @param reference
	 * @param stagiaire
	 */
	public Groupe(String reference) {
		super();
		this.reference = reference;
		this.listStagiaire = new ArrayList<Stagiaire>();
	}

	public Groupe() {
		this.listStagiaire = new ArrayList<Stagiaire>();
	}

	/**
	 * Rajoute un stagiaire à la liste de l'équipe
	 * 
	 * @param stagiaire
	 */
	public void addStagiaire(Stagiaire stagiaire) {
		listStagiaire.add(stagiaire);
	}

	/**
	 * Recupère un stagiaire en fonction de son index dans la liste
	 * 
	 * @param index
	 * @return
	 */
	public Stagiaire getStagiaire(int index) {
		return listStagiaire.get(index);
	}

	/**
	 * @return the idGroupe
	 */
	public int getIdGroupe() {
		return idGroupe;
	}

	/**
	 * @param idGroupe the idGroupe to set
	 */
	public void setIdGroupe(int idGroupe) {
		this.idGroupe = idGroupe;
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
	 * @return the listStagiaire
	 */
	public List<Stagiaire> getListStagiaire() {
		return listStagiaire;
	}

	/**
	 * @param listStagiaire the listStagiaire to set
	 */
	public void setListStagiaire(List<Stagiaire> listStagiaire) {
		this.listStagiaire = listStagiaire;
	}

	@Override
	public String toString() {
		return "Groupe [idGroupe=" + idGroupe + ", reference=" + reference + ", listStagiaire=" + listStagiaire + "]";
	}

}
