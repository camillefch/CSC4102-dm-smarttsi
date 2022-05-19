// CHECKSTYLE:OFF
package eu.telecomsudparis.csc4102.smarttsi.unitaires;



import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import eu.telecomsudparis.csc4102.smarttsi.SourceIoT;


public class TestSourceIoT {

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	@Test(expected = IllegalArgumentException.class)
	public void constructeurSourceIoTTest1Jeu1() throws Exception {
		new SourceIoT(null, "description");
	}

	@Test(expected = IllegalArgumentException.class)
	public void constructeurSourceIoTTest1Jeu2() throws Exception {
		new SourceIoT("", "description");
	}

	@Test(expected = IllegalArgumentException.class)
	public void constructeurSourceIoTTest2Jeu1() throws Exception {
		new SourceIoT("identifiantl", null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void constructeurSourceIoTTest2Jeu2() throws Exception {
		new SourceIoT("identifiant", "");
	}


	public void constructeurSourceIoTTest4Jeu1() throws Exception {
		SourceIoT source = new SourceIoT("identifiant", "description");
		Assert.assertEquals("identifiant", source.getIdentifiant());
		Assert.assertEquals("nom", source.getDescription());
		Assert.assertEquals("idenvoi", source.getidenvoi());
	}
}