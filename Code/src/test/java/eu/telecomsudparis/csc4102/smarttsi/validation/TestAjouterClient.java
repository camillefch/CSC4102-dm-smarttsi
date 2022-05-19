// CHECKSTYLE:OFF
package eu.telecomsudparis.csc4102.smarttsi.validation;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import eu.telecomsudparis.csc4102.smarttsi.SmartTSI;
import eu.telecomsudparis.csc4102.util.OperationImpossible;
import eu.telecomsudparis.csc4102.smarttsi.Client;

public class TestAjouterClient {
	private SmartTSI smartTSI;
	private String identifiant;
	private String nom;
	private String prenom;
	private Client client;
	
	@Before
	public void setUp() throws OperationImpossible {
		smartTSI = new SmartTSI();
		identifiant = "identifiant";
		nom = "nom";
		prenom = "prenom";
		client = new Client("identifiant", "nom", "prenom" );
	}

	@After
	public void tearDown() {
		smartTSI = null;
		identifiant = null;
		nom = null;
		prenom = null;
		client = null;
	}

	@Test(expected = OperationImpossible.class)
	public void ajouterUnClientTest1Jeu1() throws Exception {
		smartTSI.ajouterUnClient(null, nom , prenom);
	}

	@Test(expected = OperationImpossible.class)
	public void ajouterUnClientTest1Jeu2() throws Exception {
		smartTSI.ajouterUnClient("", nom, prenom);
	}

	@Test(expected = OperationImpossible.class)
	public void ajouterUnClientTest2Jeu1() throws Exception {
		smartTSI.ajouterUnClient(identifiant, null, prenom);
	}

	@Test(expected = OperationImpossible.class)
	public void ajouterUnClientTest2Jeu2() throws Exception {
		smartTSI.ajouterUnClient(identifiant, "", prenom);
	}

	@Test(expected = OperationImpossible.class)
	public void ajouterUnClientTest3Jeu1() throws Exception {
		smartTSI.ajouterUnClient(identifiant, nom, null);
	}

	@Test(expected = OperationImpossible.class)
	public void ajouterUnClientTest3Jeu2() throws Exception {
		smartTSI.ajouterUnClient(identifiant, nom, "");
	}

	@Test
	public void ajouterUnClientTest5Puis4() throws Exception {
		Assert.assertTrue(smartTSI.listeLesClients().isEmpty());
		smartTSI.ajouterUnClient(identifiant, nom, prenom);
		Assert.assertEquals(1, smartTSI.listeLesClients().size());
		Assert.assertEquals(client.getIdentifiant(), smartTSI.listeLesClients().get(0));
		Assert.assertThrows(OperationImpossible.class,
				() -> smartTSI.ajouterUnClient(client.getIdentifiant(), nom, prenom));
	}
}

