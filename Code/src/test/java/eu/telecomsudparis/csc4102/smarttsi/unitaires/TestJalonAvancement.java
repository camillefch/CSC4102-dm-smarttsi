// CHECKSTYLE:OFF
package eu.telecomsudparis.csc4102.smarttsi.unitaires;



import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import eu.telecomsudparis.csc4102.smarttsi.JalonAvancement;


public class TestJalonAvancement {

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	@Test(expected = IllegalArgumentException.class)
	public void constructeurJalonAvancementTest1Jeu1() throws Exception {
		new JalonAvancement(null, "emplacement");
	}

	@Test(expected = IllegalArgumentException.class)
	public void constructeurJalonAvancementTest1Jeu2() throws Exception {
		new JalonAvancement("", "emplacement");
	}

	@Test(expected = IllegalArgumentException.class)
	public void constructeurJalonAvancementTest2Jeu1() throws Exception {
		new JalonAvancement("identifiant", null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void constructeurJalonAvancementTest2Jeu2() throws Exception {
		new JalonAvancement("identifiant", "");
	}

	public void constructeurJalonAvancementTest3Jeu1() throws Exception {
		JalonAvancement transporteur = new JalonAvancement("identifiant", "emplacement");
		Assert.assertEquals("identifiant", transporteur.getIdentifiant());
		Assert.assertEquals("emplacement", transporteur.getEmplacement());
	}
}