 // CHECKSTYLE:OFF
package eu.telecomsudparis.csc4102.smarttsi;


import java.util.Objects;

import eu.telecomsudparis.csc4102.util.OperationImpossible;

/**
 * Cette classe définit le concept de Client.
 */
public class JalonAvancement {

	/**
	 * l'identifiant du jalon d'avancement. 
	 */
	private String identifiant;
	/**
	 * le emplacement du jalon d'avancement.
	 */
	private String emplacement;
	
		/**
	 * construit un nouveau jalon d'avancement.
	 * 
	
	 * @param identifiant identifiant du jalon d'avancement
	 * @param emplacement  emplacement du jalon d'avancement.

	 *
	 */

	public JalonAvancement(final String identifiant, final String emplacement)
			throws OperationImpossible {
		if (identifiant == null || identifiant.isBlank()) {
			throw new IllegalArgumentException("identifiant ne peut pas être null ou vide");
		}
		if (emplacement == null || emplacement.isBlank()) {
			throw new IllegalArgumentException("emplacement ne peut pas être null ou vide");
		}
		
		
		this.identifiant = identifiant;
		this.emplacement = emplacement;
		assert invariant();
	}


	public boolean invariant() {
		return emplacement != null && !emplacement.isBlank() && identifiant != null && !identifiant.isBlank() ;
	}




	public String getIdentifiant() {
		return identifiant;
	}
	public String getEmplacement() {
		return emplacement;
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
		if (!(obj instanceof JalonAvancement)) {
			return false;
		}
		JalonAvancement other = (JalonAvancement) obj;
		return Objects.equals(identifiant, other.identifiant);
	}


	public String toString() {
		return "Client [identifiant" + identifiant + ", emplacement=" + emplacement + "]";
	}
}
