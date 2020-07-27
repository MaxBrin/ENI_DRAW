/**
 * 
 */
package fr.eni.enidraw.bo;

import lombok.Data;

/**
 * @author Maxime Brin
 * @version
 * @dateDeCréation 24 juil. 2020
 */
@Data
public class Stagiaire {
	private int idStagiaire;
	private String nom;
	private String prenom;
	private char sexe;
	private boolean cda;
	private boolean presence;
	private Groupe groupe;

	/**
	 * @param idStagiaire
	 * @param nom
	 * @param prenom
	 * @param sexe
	 * @param cda
	 * @param presence
	 * @param groupe
	 */
	public Stagiaire(int idStagiaire, String nom, String prenom, char sexe, boolean cda, boolean presence,
			Groupe groupe) {
		super();
		this.idStagiaire = idStagiaire;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.cda = cda;
		this.presence = presence;
		this.groupe = groupe;
	}

	/**
	 * @param nom
	 * @param prenom
	 * @param sexe
	 * @param cda
	 * @param presence
	 */
	public Stagiaire(String nom, String prenom, char sexe, boolean cda, boolean presence) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.cda = cda;
		this.presence = presence;
		this.groupe = groupe;
	}

	/**
	 * @param idStagiaire
	 * @param nom
	 * @param prenom
	 * @param sexe
	 * @param cda
	 * @param presence
	 */
	public Stagiaire(int idStagiaire, String nom, String prenom, char sexe, boolean cda, boolean presence) {
		super();
		this.idStagiaire = idStagiaire;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.cda = cda;
		this.presence = presence;
	}

}
