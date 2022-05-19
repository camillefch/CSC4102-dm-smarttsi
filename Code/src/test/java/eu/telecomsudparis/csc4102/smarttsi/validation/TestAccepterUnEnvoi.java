// CHECKSTYLE:OFF
package eu.telecomsudparis.csc4102.smarttsi.validation;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.time.Instant;

import eu.telecomsudparis.csc4102.smarttsi.SmartTSI;
import eu.telecomsudparis.csc4102.smarttsi.Envoi;
import eu.telecomsudparis.csc4102.smarttsi.Transporteur;
import eu.telecomsudparis.csc4102.util.OperationImpossible;
import eu.telecomsudparis.csc4102.util.Datutil;

public class TestAccepterUnEnvoi {
	private SmartTSI smartTSI;
	private String idjalon;
	private String idenvoi;
	private Envoi envoi ;
	private Instant instant;
	private Transporteur transporteur;

	@Before
	public void setUp() throws OperationImpossible {
		smartTSI = new SmartTSI();
		idjalon = "idjalon" ;
		idenvoi = "idenvoi";
		instant = Datutil.maintenant();
		envoi = new Envoi("identifiant", "origine", instant, "destination"  );
		transporteur = new Transporteur("identifiant", "nom");
		
	}

	@After
	public void tearDown() {
		smartTSI = null;
		idjalon= null;
		idenvoi= null;
		instant = null;
		envoi = null;
		transporteur = null;
		

	}

	@Test(expected = OperationImpossible.class)
	public void accepterUnEnvoiTest1Jeu1() throws Exception {
		smartTSI.accepterUnEnvoi(null, idjalon);
	}

	@Test(expected = OperationImpossible.class)
	public void accepterUnEnvoiTest1Jeu2() throws Exception {
		smartTSI.accepterUnEnvoi("", idjalon);
	}

	@Test(expected = OperationImpossible.class)
	public void accepterUnEnvoiTest2Jeu1() throws Exception {
		smartTSI.accepterUnEnvoi(idenvoi, null);
	}

	@Test(expected = OperationImpossible.class)
	public void accepterUnEnvoiTest2Jeu2() throws Exception {
		smartTSI.accepterUnEnvoi(idenvoi, "");
	}


	@Test
	public void accepterUnEnvoiTest5Puis2Puis2() throws Exception {
		Assert.assertTrue(smartTSI.listeLesEnvois().isEmpty());
		Assert.assertTrue(smartTSI.listeLesTransporteurs().isEmpty());
		Assert.assertEquals(1, smartTSI.listeLesEnvois().size());
		Assert.assertEquals(idenvoi, smartTSI.listeLesEnvois().get(0));
		Assert.assertThrows(OperationImpossible.class,
				() -> smartTSI.accepterUnEnvoi(transporteur.getIdentifiant(), envoi.getIdentifiant()));
	}
}
