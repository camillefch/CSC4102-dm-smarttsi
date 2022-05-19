// CHECKSTYLE:OFF


package eu.telecomsudparis.csc4102.smarttsi;

/**
 * Cette énumération modélise l'état d'un envoi.
 * 
 * NB: À compléter. Supprimer ce commentaire ensuite.
 * 
 * @author Denis Conan
 */
public enum EtatEnvoi {
	/**
	 * l'envoi est encore chez le client.
	 */
	CHEZ_LE_CLIENT_EXPEDITEUR("chez le client expéditeur"), EN_COURS_DE_LIVRAISON("en cours de livraison"), LIVRE("livre");


/**
 * le nom de l'état.
 */
private String nom;

/**
 * construit un énumérateur.
 * 
 * @param nom le nom de l'énumérateur.
 */
EtatEnvoi(final String nom) {
	this.nom = nom;
}


public final String getNom() {
	return nom;
}
@Override
public String toString() {
	return this.nom;
}
}