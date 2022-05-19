package eu.telecomsudparis.csc4102.smarttsi;

import java.time.Instant;


import eu.telecomsudparis.csc4102.util.Datutil;
import eu.telecomsudparis.csc4102.util.Objects;
import eu.telecomsudparis.csc4102.util.OperationImpossible;

/**
 * Cette classe définit le concept d'envoi.
 * 
 *
 */
public class Envoi {
	/**
	 * l'identifiant de l'envoi.
	 */
	private String identifiant;
	/**
	 * le lieu d'origine.
	 */
	private String origine;
	/**
	 * l'instant du dépôt.
	 */
	private Instant instantDepot;
	/**
	 * le lieu de destination.
	 */
	private String destination;
	/**
	 * l'instant de la livraison.
	 */
	private Instant instantLivraison;
	/**
	 * L'état de l'envoi.
	 */
	private EtatEnvoi etat;

	/**
	 * construit un nouvel envoi. La source de données IoT jointe à l'envoi est mise
	 * utilisée.
	 * 
	 * 
	 * @param identifiant  l'identifiant de l'envoi.
	 * @param origine      le lieu d'origine de l'envoi.
	 * @param instantDepot l'instant du dépôt.
	 * @param destination  le lieu de destination de l'envoi.
	 * @throws OperationImpossible l'opération ne peut pas être effectuée.
	 */
	public Envoi(final String identifiant, final String origine, final Instant instantDepot, final String destination)
			throws OperationImpossible {
		if (identifiant == null || identifiant.isBlank()) {
			throw new IllegalArgumentException("identifiant ne peut pas être null ou vide");
		}
		if (origine == null || origine.isBlank()) {
			throw new IllegalArgumentException("origine ne peut pas être null ou vide");
		}
		Objects.requireNonNull(instantDepot, "instantDepot ne peut pas être null");
		if (!Datutil.instantEstAvant(instantDepot, Datutil.maintenant())) {
			throw new IllegalArgumentException("l'instant de dépôt ne peut pas être dans le futur");
		}
		if (destination == null || destination.isBlank()) {
			throw new IllegalArgumentException("destination ne peut pas être null ou vide");
		}

		this.identifiant = identifiant;
		this.origine = origine;
		this.instantDepot = instantDepot;
		this.destination = destination;
		this.etat = EtatEnvoi.CHEZ_LE_CLIENT_EXPEDITEUR;
		assert invariant();
	}

	/**
	 * vérifie l'invariant de la classe.
	 * 
	 * NB: À compléter. Supprimer ce commentaire ensuite.
	 * 
	 * @return vrai si l'invariant est vérifié.
	 */
	public boolean invariant() {
		return identifiant != null && !identifiant.isBlank() && origine != null && !origine.isBlank()
				&& instantDepot != null && destination != null && !destination.isBlank() && etat != null;
	}

	/**
	 * obtient l'identifiant.
	 * 
	 * @return l'identifiant.
	 */
	public String getIdentifiant() {
		return identifiant;
	}

	/**
	 * obtient l'origine.
	 * 
	 * @return l'origine.
	 */
	public String getOrigine() {
		return origine;
	}

	/**
	 * obtient l'instant de dépôt.
	 * 
	 * @return l'instant de dépôt.
	 */
	public Instant getInstantDepot() {
		return instantDepot;
	}

	/**
	 * obtient la destination.
	 * 
	 * @return la destination.
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * obtient l'instant de livraison.
	 * 
	 * @return l'instant de livraison.
	 */
	public Instant getInstantLivraison() {
		return instantLivraison;
	}

	/**
	 * obtient l'état de l'envoi.
	 * 
	 * @return l'état de l'envoi.
	 */
	public EtatEnvoi getEtatEnvoi() {
		return etat;
	}
	
	/**
	 * change l'etat de l'envoi sur "en cours de livraison".
	 */
	public void prisencharge() {
		this.etat = EtatEnvoi.EN_COURS_DE_LIVRAISON;
		}
	/**
	 * change l'etat de l'envoi sur "livre".
	 */
	public void livre() {
		this.etat = EtatEnvoi.LIVRE;
		}
	/**
	 * @param date 	Date de la livraison.
	 * ajoute la date de livraison.
	 */
	public void ajoutDateLivraison(final Instant date) {
		this.instantLivraison = date;
		}
	
	
	@Override
	public int hashCode() {
		return java.util.Objects.hash(identifiant);
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Envoi)) {
			return false;
		}
		Envoi other = (Envoi) obj;
		return java.util.Objects.equals(identifiant, other.identifiant);
	}
	
	
	@Override
	public String toString() {
		return "Envoi [identifiant=" + identifiant + ", origine=" + origine + ", instantDepot=" + instantDepot
				+ ", destination=" + destination + ", instantLivraison=" + instantLivraison + ", état=" + etat + "]";
	}
}
