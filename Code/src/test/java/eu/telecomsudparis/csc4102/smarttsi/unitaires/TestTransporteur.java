// CHECKSTYLE:OFF
package eu.telecomsudparis.csc4102.smarttsi.unitaires;



import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import eu.telecomsudparis.csc4102.smarttsi.Transporteur;


public class TestTransporteur {

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	@Test(expected = IllegalArgumentException.class)
	public void constructeurTransporteurTest1Jeu1() throws Exception {
		new Transporteur(null, "nom");
	}

	@Test(expected = IllegalArgumentException.class)
	public void constructeurTransporteurTest1Jeu2() throws Exception {
		new Transporteur("", "nom");
	}

	@Test(expected = IllegalArgumentException.class)
	public void constructeurTransporteurTest2Jeu1() throws Exception {
		new Transporteur("identifiantl", null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void constructeurTransporteurTest2Jeu2() throws Exception {
		new Transporteur("identifiant", "");
	}

	public void constructeurTransporteurTest3Jeu1() throws Exception {
		Transporteur transporteur = new Transporteur("identifiant", "nom");
		Assert.assertEquals("identifiant", transporteur.getIdentifiant());
		Assert.assertEquals("nom", transporteur.getNom());
	}
}