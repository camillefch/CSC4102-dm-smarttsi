 // CHECKSTYLE:OFF
package eu.telecomsudparis.csc4102.smarttsi;


import java.util.Objects;

import eu.telecomsudparis.csc4102.util.OperationImpossible;

/**
 * Cette classe définit le concept de Client.
 */
public class Client {

	/**
	 * l'identifiant du client. 
	 */
	private String identifiant;
	/**
	 * le nom du client.
	 */
	private String nom;
	/**
	 * le prenom du client.
	 */
	private String prenom;

		/**
	 * construit un nouveau client.
	 * 
	
	 * @param identifiant identifiant du client (= identifiant)
	 * @param nom  nom du client.
	 * @param prenom  prenom du client.
	 *
	 */

	public Client(final String identifiant, final String nom, final String prenom)
			throws OperationImpossible {
		if (identifiant == null || identifiant.isBlank()) {
			throw new IllegalArgumentException("identifiant ne peut pas être null ou vide");
		}
		if (nom == null || nom.isBlank()) {
			throw new IllegalArgumentException("nom ne peut pas être null ou vide");
		}
		if (prenom == null || prenom.isBlank()) {
			throw new IllegalArgumentException("prenom ne peut pas être null ou vide");
		}
		
		
		this.identifiant = identifiant;
		this.nom = nom;
		this.prenom = prenom;
		assert invariant();
	}


	public boolean invariant() {
		return nom != null && !nom.isBlank() && identifiant != null && !identifiant.isBlank() && prenom != null && !prenom.isBlank() ;
	}




	public String getIdentifiant() {
		return identifiant;
	}
	public String getNom() {
		return nom;
	}
	
	public String getPrenom() {
		return prenom;
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(identifiant);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Client)) {
			return false;
		}
		Client other = (Client) obj;
		return Objects.equals(identifiant, other.identifiant);
	}


	public String toString() {
		return "Client [iidentifiant" + identifiant + ", nom=" + nom + ", prenom=" + prenom	 +"]";
	}
}
