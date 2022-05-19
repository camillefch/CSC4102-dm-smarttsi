// CHECKSTYLE:OFF
package eu.telecomsudparis.csc4102.smarttsi.validation;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import eu.telecomsudparis.csc4102.smarttsi.SmartTSI;
import eu.telecomsudparis.csc4102.util.Datutil;
import eu.telecomsudparis.csc4102.util.OperationImpossible;

import eu.telecomsudparis.csc4102.smarttsi.Envoi;
import eu.telecomsudparis.csc4102.smarttsi.Client;
import eu.telecomsudparis.csc4102.smarttsi.Condition;

public class TestAjouterUneConditionaUnEnvoi {
	private SmartTSI smartTSI;
	private String identifiant;
	private String idenvoi;
	private String attribut;
	private Double valeurbasse;
	private Double valeurhaute;
	private Condition condition;
	private Envoi envoi;
	private Client client;


	@Before
	public void setUp() throws OperationImpossible {
		smartTSI = new SmartTSI();
		identifiant = "identifiant";
		idenvoi = "idenvoi";
		attribut = "attribut";
		valeurbasse = 3.0;
		valeurhaute = 5.0;
		condition = new Condition("identifiantcondition", "idenvoi", "attribut", 3.0, 5.0);
		client = new Client("idclient", "nom", "prenom");
		envoi = new Envoi("idenvoi2", "origine" , Datutil.maintenant(), "destination");
				


	}

	@After
	public void tearDown() {
		smartTSI = null;
		identifiant= null;
		idenvoi= null;
		attribut = null;
		valeurhaute = null;
		valeurbasse = null;
		condition = null;
	
	}

	@Test(expected = OperationImpossible.class)
	public void ajouterUneConditionaUnEnvoiTest1Jeu1() throws Exception {
		smartTSI.ajouterUneConditionaUnEnvoi(null, idenvoi, attribut, valeurbasse, valeurhaute);
	}

	@Test(expected = OperationImpossible.class)
	public void ajouterUneConditionaUnEnvoiTest1Jeu2() throws Exception {
		smartTSI.ajouterUneConditionaUnEnvoi("", idenvoi, attribut, valeurbasse, valeurhaute);
	}

	@Test(expected = OperationImpossible.class)
	public void ajouterUneConditionaUnEnvoiTest5Jeu1() throws Exception {
		smartTSI.ajouterUneConditionaUnEnvoi(identifiant, null, attribut, valeurbasse, valeurhaute);
	}

	@Test(expected = OperationImpossible.class)
	public void ajouterUneConditionaUnEnvoiTest5Jeu2() throws Exception {
		smartTSI.ajouterUneConditionaUnEnvoi(identifiant, "", attribut, valeurbasse, valeurhaute);
	}

	@Test(expected = OperationImpossible.class)
	public void ajouterUneConditionaUnEnvoiTest6() throws Exception {
		smartTSI.ajouterUneConditionaUnEnvoi(identifiant, "", attribut, valeurbasse, valeurhaute);
	}

	@Test(expected = OperationImpossible.class)
	public void ajouterUneConditionaUnEnvoiTest3Jeu1() throws Exception {
		smartTSI.ajouterUneConditionaUnEnvoi(identifiant, idenvoi, null, valeurbasse, valeurhaute);
	}
	@Test(expected = OperationImpossible.class)
	public void ajouterUneConditionaUnEnvoiTest3Jeu2() throws Exception {
		smartTSI.ajouterUneConditionaUnEnvoi(identifiant, idenvoi, "", valeurbasse, valeurhaute);
	}
	
	@Test(expected = OperationImpossible.class)
	public void ajouterUneConditionaUnEnvoiTest4() throws Exception {
		smartTSI.ajouterUneConditionaUnEnvoi(identifiant, idenvoi, "", null, null);
	}


	@Test
	public void ajouterUneConditionaUnEnvoiTest7Puis6Puis2() throws Exception {
		Assert.assertTrue(smartTSI.listeLesConditions().isEmpty());
		Assert.assertTrue(smartTSI.listeLesEnvois().isEmpty());
		smartTSI.ajouterUnClient("idclient", "nom", "prenom");
		smartTSI.deposerUnEnvoi("idenvoi", "origine", "destination", "idclient");
		smartTSI.ajouterUneConditionaUnEnvoi("identifiantcondition", "idenvoi", "attribut", 3.0, 5.0);
		Assert.assertEquals(1, smartTSI.listeLesEnvois().size());
		Assert.assertEquals(1, smartTSI.listeLesConditions().size());
		Assert.assertEquals(condition.getIdentifiant(), smartTSI.listeLesConditions().get(0));
		Assert.assertNotEquals(envoi.getIdentifiant(), smartTSI.listeLesEnvois().get(0));
		Assert.assertThrows(OperationImpossible.class,
				() -> smartTSI.ajouterUneConditionaUnEnvoi(identifiant, idenvoi, attribut, 3.0, 5.0));}
}
