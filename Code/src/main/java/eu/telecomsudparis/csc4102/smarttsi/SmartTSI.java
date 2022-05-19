// CHECKSTYLE:OFF

package eu.telecomsudparis.csc4102.smarttsi;
import java.util.List;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import eu.telecomsudparis.csc4102.util.Datutil;
import eu.telecomsudparis.csc4102.util.OperationImpossible;

/**
 * Cette classe définit la façade du système.
 * @author Denis Conan
 */
public class SmartTSI {
	/**
	 * la collection des envois.
	 */
	private Map<String, Envoi> envois;
	/**
	 * la collection des clients.
	 */
	private Map<String, Client> clients;
	/**
	 * la collection des transporteurs.
	 */
	private Map<String, Transporteur> transporteurs;
	
	/**
	 * la collection des jalons.
	 */
	private Map<String, JalonAvancement> jalons;

	/**
	 * la collection des sources IoT.
	 */
	private Map<String, SourceIoT>sources;
	/**
	 * la collection des conditions
	 */
	private Map<String, Condition>conditions;
	
	/**
	 * construit une façade.
	 */
	public SmartTSI() {
		envois = new HashMap<>();
		clients = new HashMap<>();
		jalons = new HashMap<>();
		sources = new HashMap<>();
		conditions = new HashMap<>();
		transporteurs = new HashMap<>();
	}
	
	

	/**
	 * déposer un envoi. Cette opération est effectuée par un client.
	 * 
	 * NB: À compléter. Supprimer ce commentaire ensuite.
	 * 
	 * @param identifiantEnvoi l'identifiant de l'envoi.
	 * @param origine          l'origine de l'envoi.
	 * @param destination      la destination de l'envoi.
	 * @param identifiantClient	l'identifiant du client expediteur
	 * @throws OperationImpossible l'opération ne peut pas être effectuée.
	 */
	public void deposerUnEnvoi(final String identifiantEnvoi, final String origine, final String destination, final String identifiantClient)
			throws OperationImpossible {
		if (identifiantEnvoi == null || identifiantEnvoi.isBlank()) {
			throw new OperationImpossible("l'identifiant de l'envoi ne peut pas être null ou vide");
		}
		if (origine == null || origine.isBlank()) {
			throw new OperationImpossible("l'origine ne peut pas être null ou vide");
		}
		if (destination == null || destination.isBlank()) {
			throw new OperationImpossible("la destination ne peut pas être null ou vide");
		}
		if (identifiantClient == null || identifiantClient.isBlank()) {
			throw new OperationImpossible("l'identifiant du client expediteur ne peut pas être null ou vide");
		}
		if (!clients.containsKey(identifiantClient)) {
			throw new OperationImpossible("il n'existe aucun client associé à cet identifiant");
		}
		if (envois.containsKey(identifiantEnvoi)) {
			throw new OperationImpossible("il existe déjà un envoi avec le même identifiant");
		}
		Envoi envoi = new Envoi(identifiantEnvoi, origine, Datutil.maintenant(), destination);
		envois.put(identifiantEnvoi, envoi);
	}
	
	
	/**
	 * Ajouterune condition à un envoi. Peut etre effectuer par un client ou un transporteur
	 * 
	 * 
	 * @param identifiant  l'identifiant de la source.
	 * @param idenvoi         l'origine de l'envoi.
	 * @param attribut			nom de l'attribut.
	 * @param valeurhaute 		valeur haute de la condition.
	 * @param valeurbasse		valeur basse de la condition
	 * @throws OperationImpossible l'opération ne peut pas être effectuée.
	 */
	public void ajouterUneConditionaUnEnvoi(final String identifiant, final String idenvoi, final String attribut, final Double valeurhaute, final Double valeurbasse)
			throws OperationImpossible {
		
		if (identifiant == null || identifiant.isBlank()) {
			throw new OperationImpossible("l'identifiant de la source ne peut pas être null ou vide");
		}
		if (idenvoi == null || idenvoi.isBlank()) {
			throw new OperationImpossible("l'identifiant de l'envoi ne peut pas être null ou vide");
		}
		if (attribut == null || attribut.isBlank()) {
			throw new OperationImpossible("le nom de l'attribut ne peut pas être null ou vide");
		}
		if (!envois.containsKey(idenvoi)) {
			throw new OperationImpossible("il n'existe aucun envoi associé à cet identifiant");
		}
		if (sources.containsKey(identifiant)) {
			throw new OperationImpossible("il existe déjà une conditon avec cet identifiant");
		}
		Condition condition = new Condition(identifiant, idenvoi, attribut, valeurbasse, valeurhaute);
		conditions.put(identifiant, condition);

	}
	/**
	 * Adjoindre une source IoT à un envoi. Peut etre effectuer par un client ou un transporteur
	 * 
	 * 
	 * @param idsource  l'identifiant de la source.
	 * @param idenvoi         l'origine de l'envoi.
	 * @throws OperationImpossible l'opération ne peut pas être effectuée.
	 */
	public void adjoindreUneSourceIoTaUnEnvoi(final String idsource, final String idenvoi)
			throws OperationImpossible {
		if (idenvoi == null || idenvoi.isBlank()) {
			throw new OperationImpossible("l'identifiant de l'envoi ne peut pas être null ou vide");
		}
		if (idsource == null || idsource.isBlank()) {
			throw new OperationImpossible("l'identifiant de la source ne peut pas être null ou vide");
		}
		if (!envois.containsKey(idenvoi)) {
			throw new OperationImpossible("il n'existe aucun envoi associé à cet identifiant");
		}
		if (!sources.containsKey(idsource)) {
			throw new OperationImpossible("il n'existe une source IoT avec cet identifiant");
		}
		SourceIoT s = sources.get(idsource);
		if (s.idenvoi != null) {
			throw new OperationImpossible("la source est déjà actuellement adjointe à un envoi");
		}else {
			s.adjoindreAUnEnvoi(idenvoi);
		}

	}


	/**
	 * ajouter un client. 
	 * 
	 * @param identifiant	identifiant du client.
	 * @param nom		le nom du client.
	 * @param prenom	le prenom du client.
	 * @throws OperationImpossible l'opération ne peut pas être effectuée.
	 */

	
	public void ajouterUnClient(final String identifiant, final String nom, final String prenom)
			throws OperationImpossible {
		if (identifiant == null || identifiant.isBlank()) {
			throw new OperationImpossible("l'identifiant ne peut pas être null ou vide");
		}
		if (nom == null || nom.isBlank()) {
			throw new OperationImpossible("le nom ne peut pas être null ou vide");
		}
		if (prenom == null || prenom.isBlank()) {
			throw new OperationImpossible("le prenom ne peut pas être null ou vide");
		}
		if (clients.containsKey(identifiant)) {
			throw new OperationImpossible("il existe déjà un client avec le même identifiant");
		}
		Client client = new Client(identifiant, nom, prenom);
		clients.put(identifiant, client);
	}
	
	/**
	 * ajouter un envoi. 
	 * 
	 * @param identifiant	identifiant de la source.
	 * @param description  	la description de la source.
	 * @throws OperationImpossible l'opération ne peut pas être effectuée.
	 */

	
	public void ajouterUneSourceIot(final String identifiant, final String description)
			throws OperationImpossible {
		if (identifiant == null || identifiant.isBlank()) {
			throw new OperationImpossible("l'identifiant ne peut pas être null ou vide");
		}
		if (description == null || description.isBlank()) {
			throw new OperationImpossible("le nom ne peut pas être null ou vide");
		}
		if (clients.containsKey(identifiant)) {
			throw new OperationImpossible("il existe déjà une source avec le même identifiant");
		}
		SourceIoT source = new SourceIoT(identifiant, description);
		sources.put(identifiant, source);
	}
	
	/**
	 * ajouter un transporteur. 
	 * 
	 * @param  identifiant	identifiant du transporteur.
	 * @param nom		le nom du transporteur.
	 */
	
	
	public void ajouterUnTransporteur(final String identifiant, final String nom)
			throws OperationImpossible {
		if (identifiant == null || identifiant.isBlank()) {
			throw new OperationImpossible("l'identifiant ne peut pas être null ou vide");
		}
		if (nom == null || nom.isBlank()) {
			throw new OperationImpossible("le nom ne peut pas être null ou vide");
		}
		
		if (transporteurs.containsKey(identifiant)) {
			throw new OperationImpossible("il existe déjà un transporteur avec le même identifiant");
		}
		Transporteur transporteur = new Transporteur(identifiant, nom);
		transporteurs.put(identifiant, transporteur);
	}
	

	/**
	 * prendre en charge un envoi. 
	 * 
	 * @param idtransporteur l'identifiant du transporteur.
	 * @param codeenvoi code de l'envoi.
	 * @throws OperationImpossible l'opération ne peut pas être effectuée.
	 */


	public void prendreEnChargeUnEnvoi(final String idtransporteur, final String codeenvoi)
			throws OperationImpossible {
		if (idtransporteur == null || idtransporteur.isBlank()) {
			throw new OperationImpossible("l'identfiant du transporteur  ne peut pas être null ou vide");
		}
		if (codeenvoi == null || codeenvoi.isBlank()) {
			throw new OperationImpossible("le code de l'envoi ne peut pas être null ou vide");
		}
		if (!transporteurs.containsKey(idtransporteur)) {
			throw new OperationImpossible("le transporteur n'existe pas");
		}
		
		if  (!envois.containsKey(codeenvoi)) {
			throw new OperationImpossible("l'envoi n'existe pas");
		} else {
			Envoi e = envois.get(codeenvoi);
			e.prisencharge();
		}
	}


	/**
	 * Accepter un envoi. 
	 * 
	 * @param idenvoi identifiant de l'envoi.
	 * @param idjalon identifiant jalon.
	 * @throws OperationImpossible l'opération ne peut pas être effectuée.
	 */


	public void accepterUnEnvoi(final String idenvoi, final String idjalon)
			throws OperationImpossible {
		if (idenvoi == null || idenvoi.isBlank()) {
			throw new OperationImpossible("l'id de l'envoi  ne peut pas être null ou vide");
		}
		if (idjalon == null || idjalon.isBlank()) {
			throw new OperationImpossible("l id du jalon  ne peut pas être null ou vide");
		}
		if (!transporteurs.containsKey(idenvoi)) {
			throw new OperationImpossible("l'envoi n'existe pas");
		}
		
		if  (!envois.containsKey(idjalon)) {
			throw new OperationImpossible("le jalon n'existe pas");
		} else {
			Envoi e = envois.get(idenvoi);
			JalonAvancement j = jalons.get(idjalon);
			if (e.getDestination().equals(j.getEmplacement())) {
				throw new OperationImpossible("pas encore à destination");	
			} else  {
				e.livre();
				Instant maintenant = Datutil.maintenant();
				e.ajoutDateLivraison(maintenant);
			}
		}
	}



	




	
	/**
	 * liste les clients.
	 * @return les identifiants des clients existants.
	 **/
	
	
	public List<String> listeLesClients() {
		return new ArrayList<>(this.clients.keySet());
	}
	
	/**
	 * liste les envois.
	 * @return les identifiants des envois existants.
	 **/
	public List<String> listeLesEnvois() {
		return new ArrayList<>(this.envois.keySet());
	}
	
	/**
	 * liste les transporteurs.
	 * 
	 * @return les identifiants des transporteurs existants.
	 **/
	public List<String> listeLesTransporteurs() {
		return new ArrayList<>(this.transporteurs.keySet());	
	}
	/**
	 * liste les jalons
	 * 
	 * @return les identifiants des jalons existants.
	 **/
	public List<String> listeLesJalons() {
		return new ArrayList<>(this.jalons.keySet());	
	}
	/**
	 * liste les sources IoT
	 * 
	 * @return les identifiants des sources existantes.
	 **/
	public List<String> listeLesSourcesIoT() {
		return new ArrayList<>(this.sources.keySet());	
	}
	/**
	 * liste les conditions.
	 * 
	 * @return les identifiants des conditions existantes.
	 **/
	public List<String> listeLesConditions() {
		return new ArrayList<>(this.conditions.keySet());	
	}
	

	

}

