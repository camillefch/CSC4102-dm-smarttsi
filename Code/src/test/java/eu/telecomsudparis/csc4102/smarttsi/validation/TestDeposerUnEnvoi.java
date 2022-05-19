// CHECKSTYLE:OFF
package eu.telecomsudparis.csc4102.smarttsi.validation;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import eu.telecomsudparis.csc4102.smarttsi.Client;
import eu.telecomsudparis.csc4102.smarttsi.Envoi;
import eu.telecomsudparis.csc4102.smarttsi.SmartTSI;
import eu.telecomsudparis.csc4102.util.Datutil;
import eu.telecomsudparis.csc4102.util.OperationImpossible;

public class TestDeposerUnEnvoi {
	private SmartTSI smartTSI;
	private String identifiantEnvoi;
	private String origine;
	private String destination;
	private String identifiantClient;
	private Client client;
	private Envoi envoi;

	@Before
	public void setUp() throws OperationImpossible {
		smartTSI = new SmartTSI();
		identifiantEnvoi = "identifiantEnvoi";
		origine = "origine";
		destination = "destination";
		identifiantClient = "identifiantClient";
		client = new Client("identifiantClient", "nom", "prenom" );
		envoi = new Envoi ( "identifiantEnvoi", "origine" , Datutil.maintenant(), "destination");
	}

	@After
	public void tearDown() {
		smartTSI = null;
		identifiantEnvoi = null;
		origine = null;
		destination = null;
		identifiantClient = null;
		client = null;
		envoi = null;
	}

	@Test(expected = OperationImpossible.class)
	public void deposerUnEnvoiTest1Jeu1() throws Exception {
		smartTSI.deposerUnEnvoi(null, origine, destination, identifiantClient);
	}

	@Test(expected = OperationImpossible.class)
	public void deposerUnEnvoiTest1Jeu2() throws Exception {
		smartTSI.deposerUnEnvoi("", origine, destination, identifiantClient);
	}

	@Test(expected = OperationImpossible.class)
	public void deposerUnEnvoiTest2Jeu1() throws Exception {
		smartTSI.deposerUnEnvoi(identifiantEnvoi, null, destination, identifiantClient);
	}

	@Test(expected = OperationImpossible.class)
	public void deposerUnEnvoiTest2Jeu2() throws Exception {
		smartTSI.deposerUnEnvoi(identifiantEnvoi, "", destination, identifiantClient);
	}

	@Test(expected = OperationImpossible.class)
	public void deposerUnEnvoiTest3Jeu1() throws Exception {
		smartTSI.deposerUnEnvoi(identifiantEnvoi, origine, null,identifiantClient);
	}

	@Test(expected = OperationImpossible.class)
	public void deposerUnEnvoiTest3Jeu2() throws Exception {
		smartTSI.deposerUnEnvoi(identifiantEnvoi, origine, "", identifiantClient);
	}
	
	@Test(expected = OperationImpossible.class)
	public void deposerUnEnvoiTest5Jeu1() throws Exception {
		smartTSI.deposerUnEnvoi(identifiantEnvoi, origine, destination, null);
	}
	
	@Test(expected = OperationImpossible.class)
	public void deposerUnEnvoiTest7Jeu4() throws Exception {
		Assert.assertTrue(smartTSI.listeLesEnvois().isEmpty());
		smartTSI.deposerUnEnvoi(identifiantEnvoi, origine, destination, client.getIdentifiant());
		Assert.assertEquals(1, smartTSI.listeLesEnvois().size());
		Assert.assertEquals(envoi.getIdentifiant(), smartTSI.listeLesEnvois().get(0));
		Assert.assertThrows(OperationImpossible.class,
				() -> smartTSI.deposerUnEnvoi(envoi.getIdentifiant(), origine, destination, client.getIdentifiant()));
	}

	
	
	
	@Test
	public void deposerUnEnvoiTest7Puis6() throws Exception {
		Assert.assertTrue(smartTSI.listeLesEnvois().isEmpty());
		smartTSI.ajouterUnClient("identifiantClient", "nom", "prenom");
		smartTSI.deposerUnEnvoi(identifiantEnvoi, origine, destination, client.getIdentifiant());
		Assert.assertEquals(1, smartTSI.listeLesClients().size());
		Assert.assertEquals(1, smartTSI.listeLesEnvois().size());
		Assert.assertEquals(identifiantClient, smartTSI.listeLesClients().get(0));
		Assert.assertThrows(OperationImpossible.class,
				() -> smartTSI.deposerUnEnvoi(envoi.getIdentifiant(), origine, destination, client.getIdentifiant()));
	}
}
