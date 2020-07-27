/**
 * 
 */
package fr.eni.enidraw.bo;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 * @author Maxime Brin
 * @version
 * @dateDeCréation 24 juil. 2020
 */
@Data
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
		listStagiaire = new ArrayList<Stagiaire>();
	}

	/**
	 * @param reference
	 * @param stagiaire
	 */
	public Groupe(String reference) {
		super();
		this.reference = reference;
		listStagiaire = new ArrayList<Stagiaire>();
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

}
