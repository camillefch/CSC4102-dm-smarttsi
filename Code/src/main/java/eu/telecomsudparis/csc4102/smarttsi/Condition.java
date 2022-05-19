 // CHECKSTYLE:OFF
package eu.telecomsudparis.csc4102.smarttsi;


import java.util.Objects;

import eu.telecomsudparis.csc4102.util.OperationImpossible;

/**
 * Cette classe définit le concept de Client.
 */
public class Condition {

	/**
	 * l'identifiant du client. 
	 */
	private String identifiant;
	
	private String idenvoi; 
	
	private String attribut;

	private Double valeurhaute;
	
	private Double valeurbasse;

		/**
	 * construit un nouveau client.
	 * 
	
	 * @param identifiant identifiant de la condition
	 * @param idenvoi identifiant de lenvoi associé à cette condition
	 * @param attribut nom de l'attribut concerné.
	 * @param valeurhaute  	borne superieure de la condition
	 * @param valeurbasse de la condition
	 *
	 */

	public Condition(final String identifiant, final String idenvoi, final String attribut, final Double valeurbasse, final Double valeurhaute)
			throws OperationImpossible {
		if (identifiant == null || identifiant.isBlank()) {
			throw new IllegalArgumentException("identifiant ne peut pas être null ou vide");
		}
		if (idenvoi == null || idenvoi.isBlank()) {
			throw new IllegalArgumentException("identifiant de l'envoi ne peut pas être null ou vide");
		}
		if (attribut == null || attribut.isBlank()) {
			throw new IllegalArgumentException("l'attribut ne peut pas être null ou vide");
		}
		if (valeurhaute == null && valeurbasse == null) {
			throw new IllegalArgumentException("Une des deux valeurs doit etre non null");
		}

		
		this.identifiant = identifiant;
		this.idenvoi = idenvoi;
		this.attribut = attribut;
		this.valeurbasse = valeurbasse;
		this.valeurhaute = valeurhaute;
		assert invariant();
	}


	public boolean invariant() {
		return idenvoi != null && !idenvoi.isBlank() && identifiant != null && !identifiant.isBlank() && attribut != null && !attribut.isBlank() ;
	}




	public String getIdentifiant() {
		return identifiant;
	}
	public String getIdenvoi() {
		return idenvoi;
	}
	
	public String getAttribut() {
		return attribut;
	}
	
	public Double getValeurhaute() {
		return valeurhaute;
	}
	
	public Double getValeurbasse() {
		return valeurbasse;
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
		if (!(obj instanceof Condition)) {
			return false;
		}
		Condition other = (Condition) obj;
		return Objects.equals(identifiant, other.identifiant);
	}


	@Override
	public String toString() {
		return "Condition [identifiant=" + identifiant + ", idenvoi=" + idenvoi + ", attribut=" + attribut
				+ ", valeurhaute=" + valeurhaute + ", valeurbasse=" + valeurbasse + "]";
	}
}
