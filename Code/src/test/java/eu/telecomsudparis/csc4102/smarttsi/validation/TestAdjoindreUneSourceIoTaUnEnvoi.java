// CHECKSTYLE:OFF
package eu.telecomsudparis.csc4102.smarttsi.validation;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import eu.telecomsudparis.csc4102.smarttsi.SmartTSI;
import eu.telecomsudparis.csc4102.smarttsi.Envoi;
import eu.telecomsudparis.csc4102.smarttsi.SourceIoT;
import eu.telecomsudparis.csc4102.util.Datutil;
import eu.telecomsudparis.csc4102.util.OperationImpossible;

public class TestAdjoindreUneSourceIoTaUnEnvoi {
	private SmartTSI smartTSI;
	private String idsource;
	private String idenvoi;
	private SourceIoT source;
	private Envoi envoi;


	@Before
	public void setUp() throws OperationImpossible {
		smartTSI = new SmartTSI();
		idsource = "idsource";
		idenvoi = "idenvoi";
		source = new SourceIoT(idsource, "description");
		envoi = new Envoi(idenvoi, "origine", Datutil.maintenant(), "destination");

	}

	@After
	public void tearDown() {
		smartTSI = null;
		idsource= null;
		idenvoi= null;
		envoi = null;
		source = null;
	
	}

	@Test(expected = OperationImpossible.class)
	public void adjoindreUneSourceIoTaUnEnvoiTest1Jeu1() throws Exception {
		smartTSI.adjoindreUneSourceIoTaUnEnvoi(null, idsource);
	}

	@Test(expected = OperationImpossible.class)
	public void adjoindreUneSourceIoTaUnEnvoiTest1Jeu2() throws Exception {
		smartTSI.adjoindreUneSourceIoTaUnEnvoi("", idenvoi);
	}

	@Test(expected = OperationImpossible.class)
	public void adjoindreUneSourceIoTaUnEnvoiTest3Jeu1() throws Exception {
		smartTSI.adjoindreUneSourceIoTaUnEnvoi(idsource, null);
	}

	@Test(expected = OperationImpossible.class)
	public void adjoindreUneSourceIoTaUnEnvoiTest3Jeu2() throws Exception {
		smartTSI.adjoindreUneSourceIoTaUnEnvoi(idsource, "");
	}


	@Test
	public void adjoindreUneSourceIoTaUnEnvoiTest5Puis2Puis2() throws Exception {
		Assert.assertTrue(smartTSI.listeLesEnvois().isEmpty());
		Assert.assertTrue(smartTSI.listeLesSourcesIoT().isEmpty());
		smartTSI.ajouterUnClient("identifiantClient", "nom", "prenom");
		smartTSI.deposerUnEnvoi(idenvoi, "origine", "destination", "identifiantClient");
		smartTSI.ajouterUneSourceIot("idsource", "description");
		Assert.assertEquals(1, smartTSI.listeLesEnvois().size());
		Assert.assertEquals(1, smartTSI.listeLesSourcesIoT().size());
		Assert.assertEquals(idenvoi, smartTSI.listeLesEnvois().get(0));
		Assert.assertEquals(idsource, smartTSI.listeLesSourcesIoT().get(0));
		Assert.assertTrue(source.getidenvoi() == null);
		Assert.assertThrows(OperationImpossible.class,
				() -> smartTSI.adjoindreUneSourceIoTaUnEnvoi(source.getIdentifiant(), envoi.getIdentifiant()));
	}
}
