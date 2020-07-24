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
	private int idStagiaire;
	private String nom;
	private String prenom;
	private char sexe;
	private boolean cda;
	private boolean presence;
	private Equipe equipe;

	/**
	 * @param idStagiaire
	 * @param nom
	 * @param prenom
	 * @param sexe
	 * @param cda
	 * @param presence
	 * @param equipe
	 */
	public Stagiaire(int idStagiaire, String nom, String prenom, char sexe, boolean cda, boolean presence,
			Equipe equipe) {
		super();
		this.idStagiaire = idStagiaire;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.cda = cda;
		this.presence = presence;
		this.equipe = equipe;
	}

	/**
	 * @param nom
	 * @param prenom
	 * @param sexe
	 * @param cda
	 * @param presence
	 * @param equipe
	 */
	public Stagiaire(String nom, String prenom, char sexe, boolean cda, boolean presence, Equipe equipe) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.cda = cda;
		this.presence = presence;
		this.equipe = equipe;
	}

	/**
	 * @param idStagiaire the idStagiaire to set
	 */
	public void setIdStagiaire(int idStagiaire) {
		this.idStagiaire = idStagiaire;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @param sexe the sexe to set
	 */
	public void setSexe(char sexe) {
		this.sexe = sexe;
	}

	/**
	 * @param cda the cda to set
	 */
	public void setCda(boolean cda) {
		this.cda = cda;
	}

	/**
	 * @param presence the presence to set
	 */
	public void setPresence(boolean presence) {
		this.presence = presence;
	}

	/**
	 * @param equipe the equipe to set
	 */
	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	/**
	 * @return the idStagiaire
	 */
	public int getIdStagiaire() {
		return idStagiaire;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @return the sexe
	 */
	public char getSexe() {
		return sexe;
	}

	/**
	 * @return the cda
	 */
	public boolean isCda() {
		return cda;
	}

	/**
	 * @return the presence
	 */
	public boolean isPresence() {
		return presence;
	}

	/**
	 * @return the equipe
	 */
	public Equipe getEquipe() {
		return equipe;
	}

}
