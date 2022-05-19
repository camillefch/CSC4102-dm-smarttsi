 // CHECKSTYLE:OFF
package eu.telecomsudparis.csc4102.smarttsi;



import java.time.Instant;


import eu.telecomsudparis.csc4102.util.Datutil;
import eu.telecomsudparis.csc4102.util.Objects;
import eu.telecomsudparis.csc4102.util.OperationImpossible;

/**
 * Cette classe définit le concept d'enregistrement
 */
public class Enregistrement {

	/**
	 * l'identifiant de l'enregistrement.
	 */
	private String identifiant;
	/**
	 * l'identifiant de l'envoi associé à cet enregistrement.
	 */
	private String idenvoi;
	/**
	 * l'identifiant de la source qui fait cet enregistrement.
	 */
	private String idsource;
	/**
	 * le nom de l'attribut relevé.
	 */
	private String nom_attribut ;
	/**
	 * le valeur relevée.
	 */
	private Double valeur ;
	/**
	 * date de l'enregistrement
	 */
	private Instant date ; 
	

	/**
	 * construit un nouvel enregistrement
	 * 
	
	 * @param identifiant identifiant de l'enregistrement
	 * @param idsource 	  id de la source qui a fait cet enregistrement.
	 * @param idenvoi 	  id de l'envoi associé à cet enregistrement.
	 * @param nom_attribut attribut relevé.
	 * @param valeur      valeur relevée.
	 * @param date 		 date de l'enregistrement.
	 *
	 */

	public Enregistrement(final String identifiant,final String idsource, final String idenvoi, final String nom_attribut, final Double valeur, final Instant date)
			throws OperationImpossible {
		if (identifiant == null || identifiant.isBlank()) {
			throw new IllegalArgumentException("identifiant ne peut pas être null ou vide");
		}
		if (idsource == null || idsource.isBlank()) {
			throw new IllegalArgumentException("l'identifiant de la source ne peut pas être null ou vide");
		}
		if (idenvoi == null || idenvoi.isBlank()) {
			throw new IllegalArgumentException("l'identifiant de l'envoi ne peut pas être null ou vide");
		}
		if (nom_attribut == null || nom_attribut.isBlank()) {
			throw new IllegalArgumentException("nom de l'attribut ne peut pas être null ou vide");
		}
		if (valeur == null) {
			throw new IllegalArgumentException("valeur ne peut pas être null");
		}
		Objects.requireNonNull(date, "date enregistrement ne peut pas être null");
		if (!Datutil.instantEstAvant(date, Datutil.maintenant())) {
			throw new IllegalArgumentException("l'instant de dépôt ne peut pas être dans le futur");
		}
		
		
		
		this.identifiant = identifiant;
		this.idsource = idsource;
		this.idenvoi = idenvoi;
		this.nom_attribut = nom_attribut;
		this.valeur = valeur;
		this.date = date;
		assert invariant();
	}


	public boolean invariant() {
		return identifiant != null && !identifiant.isBlank() 
				&& idsource != null && !idsource.isBlank() 
				&& idenvoi != null && !idenvoi.isBlank() 
				&& nom_attribut != null && !nom_attribut.isBlank() 
				&& valeur != null ;
	}




	public String getIdentifiant() {
		return identifiant;
	}

	public String getIdSource() {
		return idsource;
	}

	
	public String getIdEnvoi() {
		return idenvoi;
	}

	public String getAttribut() {
		return nom_attribut;
	}
	public Instant getDate() {
		return date;
	}
	
	public Double getValeur() {
		return valeur;
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(identifiant);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Enregistrement)) {
			return false;
		}
		Enregistrement other = (Enregistrement) obj;
		return java.util.Objects.equals(identifiant, other.identifiant);
	}
	



}
