// CHECKSTYLE:OFF
package eu.telecomsudparis.csc4102.smarttsi.unitaires;



import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import eu.telecomsudparis.csc4102.smarttsi.Client;


public class TestClient {

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	@Test(expected = IllegalArgumentException.class)
	public void constructeurClientTest1Jeu1() throws Exception {
		new Client(null, "nom", "prenom");
	}

	@Test(expected = IllegalArgumentException.class)
	public void constructeurClientTest1Jeu2() throws Exception {
		new Client("", "nom", "prenom");
	}
	@Test(expected = IllegalArgumentException.class)
	public void constructeurClientTest2Jeu1() throws Exception {
		new Client("identifiant", null, "prenom");
	}

	@Test(expected = IllegalArgumentException.class)
	public void constructeurClientTest2Jeu2() throws Exception {
		new Client("identifiant", "", "prenom");
	}

	@Test(expected = IllegalArgumentException.class)
	public void constructeurClientTest3Jeu1() throws Exception {
		new Client("identifiant", "nom", null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void constructeurClientTest3Jeu2() throws Exception {
		new Client("identifiant", "nom", "");
	}
	

	public void constructeurClientTest4jeu1() throws Exception {
		Client client = new Client("identifiant", "nom", "prenom");
		Assert.assertEquals("identifiant", client.getIdentifiant());
		Assert.assertEquals("nom", client.getNom());
		Assert.assertEquals("prenom", client.getPrenom());
	}
}