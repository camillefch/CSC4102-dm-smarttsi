// CHECKSTYLE:OFF
package eu.telecomsudparis.csc4102.smarttsi.validation;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import eu.telecomsudparis.csc4102.smarttsi.SmartTSI;
import eu.telecomsudparis.csc4102.util.OperationImpossible;
import eu.telecomsudparis.csc4102.smarttsi.SourceIoT;

public class TestAjouterSourceIoT {
	private SmartTSI smartTSI;
	private String identifiant;
	private String description;
	private SourceIoT source;

	
	@Before
	public void setUp() throws OperationImpossible {
		smartTSI = new SmartTSI();
		identifiant = "identifiant";
		description = "description";
		source = new SourceIoT("identifiant", "description");
	}

	@After
	public void tearDown() {
		smartTSI = null;
		identifiant = null;
		description = null;
		source = null;
	}

	@Test(expected = OperationImpossible.class)
	public void ajouterUneSourceIotTest1Jeu1() throws Exception {
		smartTSI.ajouterUneSourceIot(null, description);
	}

	@Test(expected = OperationImpossible.class)
	public void ajouterUneSourceIotTest1Jeu2() throws Exception {
		smartTSI.ajouterUneSourceIot("", description);
	}

	@Test(expected = OperationImpossible.class)
	public void ajouterUneSourceIotTest2Jeu1() throws Exception {
		smartTSI.ajouterUneSourceIot(identifiant, null);
	}

	@Test(expected = OperationImpossible.class)
	public void ajouterUneSourceIotTest2Jeu2() throws Exception {
		smartTSI.ajouterUneSourceIot(identifiant, "");
	}

	

	@Test
	public void ajouterUneSourceIotTest4Puis3() throws Exception {
		Assert.assertTrue(smartTSI.listeLesClients().isEmpty());
		smartTSI.ajouterUneSourceIot(identifiant, description);
		Assert.assertEquals(1, smartTSI.listeLesSourcesIoT().size());
		Assert.assertEquals(source.getIdentifiant(), smartTSI.listeLesSourcesIoT().get(0));
		Assert.assertThrows(OperationImpossible.class,
				() -> smartTSI.ajouterUneSourceIot(identifiant, description));
	}
}

