 // CHECKSTYLE:OFF
package eu.telecomsudparis.csc4102.smarttsi;


import java.util.Objects;

import eu.telecomsudparis.csc4102.util.OperationImpossible;

/**
 * Cette classe définit le concept de Transporteur.
 */
public class Transporteur {

	/**
	 * l'identifiant du transporteur
	 */
	private String identifiant;
	/**
	 * le nom du client.
	 */
	private String nom ;
	
		/**
	 * construit un nouveau transporteur. La source de données IoT jointe à l'envoi est mise
	 * utilisée.
	 * 
	 * 
	
	 * @param identifiant transporteur
	 * @param nom compagnie du transporteur
	 * .
	 *
	 */

	public Transporteur (final String identifiant, final String nom)
			throws OperationImpossible {
	
		if (identifiant == null || identifiant.isBlank()) {
			throw new IllegalArgumentException("identifiant ne peut pas être null ou vide");
		}
		if (nom == null || nom.isBlank()) {
			throw new IllegalArgumentException("nom ne peut pas être null ou vide");
		}
		
		
		this.identifiant = identifiant;
		this.nom = nom;
		assert invariant();
	}


	public boolean invariant() {
		return nom != null && !nom.isBlank() && identifiant != null && !identifiant.isBlank() ;
	}




	public String getIdentifiant() {
		return identifiant;
	}
	public String getNom() {
		return nom;
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
		if (!(obj instanceof Transporteur)) {
			return false;
		}
		Transporteur other = (Transporteur) obj;
		return Objects.equals(identifiant, other.identifiant);
	}


	public String toString() {
		return "Transporteur[identifiant" +identifiant + ", nom=" + nom +"]";
	}
}
