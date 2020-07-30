/**
 * 
 */
package fr.eni.enidraw.bo;

/**
 * @author Maxime Brin
 * @version
 * @dateDeCréation 24 juil. 2020
 */

public class Stagiaire {
	private Integer idStagiaire;
	private String nom;
	private String prenom;
	private Character sexe;
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
	public Stagiaire(Integer idStagiaire, String nom, String prenom, Character sexe, boolean cda, boolean presence,
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
	public Stagiaire(String nom, String prenom, Character sexe, boolean cda, boolean presence) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.cda = cda;
		this.presence = presence;
	}

	/**
	 * @param idStagiaire
	 * @param nom
	 * @param prenom
	 * @param sexe
	 * @param cda
	 * @param presence
	 */
	public Stagiaire(Integer idStagiaire, String nom, String prenom, Character sexe, boolean cda, boolean presence) {
		super();
		this.idStagiaire = idStagiaire;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.cda = cda;
		this.presence = presence;
	}

	/**
	 * @return the idStagiaire
	 */
	public int getIdStagiaire() {
		return idStagiaire;
	}

	/**
	 * @param idStagiaire the idStagiaire to set
	 */
	public void setIdStagiaire(Integer idStagiaire) {
		this.idStagiaire = idStagiaire;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the sexe
	 */
	public char getSexe() {
		return sexe;
	}

	/**
	 * @param sexe the sexe to set
	 */
	public void setSexe(Character sexe) {
		this.sexe = sexe;
	}

	/**
	 * @return the cda
	 */
	public boolean isCda() {
		return cda;
	}

	/**
	 * @param cda the cda to set
	 */
	public void setCda(boolean cda) {
		this.cda = cda;
	}

	/**
	 * @return the presence
	 */
	public boolean isPresence() {
		return presence;
	}

	/**
	 * @param presence the presence to set
	 */
	public void setPresence(boolean presence) {
		this.presence = presence;
	}

	/**
	 * @return the groupe
	 */
	public Groupe getGroupe() {
		return groupe;
	}

	/**
	 * @param groupe the groupe to set
	 */
	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}

	@Override
	public String toString() {
		return "Stagiaire [idStagiaire=" + idStagiaire + ", nom=" + nom + ", prenom=" + prenom + ", sexe=" + sexe
				+ ", cda=" + cda + ", presence=" + presence + ", groupe=" + groupe.getIdGroupe() + "]";
	}

}
