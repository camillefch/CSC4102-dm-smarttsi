 // CHECKSTYLE:OFF
package eu.telecomsudparis.csc4102.smarttsi;


import eu.telecomsudparis.csc4102.util.OperationImpossible;
/**
 * Cette classe définit le concept de Client.
 */
public class SourceIoT {

	/**
	 * l'identifiant de la source iot. 
	 */
	private String identifiant;
	/**
	 * la description de la source iot
	 */
	private String description;
	/**
	 * l'identifiant de l'envoi auquel la source iot est associée
	 */
	public String idenvoi;

		/**
	 * construit une nouvelle source iot 
	 * 
	
	 * @param identifiant identifiant de la source iot
	 * @param description description de la source iot
	 */

	public SourceIoT(final String identifiant, final String description)
			throws OperationImpossible {
		if (identifiant == null || identifiant.isBlank()) {
			throw new IllegalArgumentException("identifiant ne peut pas être null ou vide");
		}
		if (description == null || description.isBlank()) {
			throw new IllegalArgumentException("description ne peut pas être null ou vide");
		}

		
		this.identifiant = identifiant;
		this.description = description;
		this.idenvoi = null;
		assert invariant();
	}


	


	public boolean invariant() {
		return identifiant != null && !identifiant.isBlank() && description != null && !description.isBlank() ;
	}




	public String getIdentifiant() {
		return identifiant;
	}
	
	public String getDescription() {
		return description;
	}

	
	public String getidenvoi() {
		return idenvoi;
	}
	
	public void adjoindreAUnEnvoi(String identifiant) {
		this.idenvoi = identifiant;
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
		if (!(obj instanceof SourceIoT)) {
			return false;
		}
		SourceIoT other = (SourceIoT) obj;
		return java.util.Objects.equals(identifiant, other.identifiant);
	}



@Override
public String toString() {
	return "SourceIoT [identifiant=" + identifiant + ", description=" + description + ", idenvoi=" + idenvoi
			+ "]";
}
}
