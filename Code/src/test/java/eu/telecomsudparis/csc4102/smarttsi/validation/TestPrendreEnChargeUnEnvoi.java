// CHECKSTYLE:OFF
package eu.telecomsudparis.csc4102.smarttsi.validation;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.time.Instant;

import eu.telecomsudparis.csc4102.smarttsi.SmartTSI;
import eu.telecomsudparis.csc4102.smarttsi.Client;
import eu.telecomsudparis.csc4102.smarttsi.Envoi;
import eu.telecomsudparis.csc4102.smarttsi.Transporteur;
import eu.telecomsudparis.csc4102.util.Datutil;
import eu.telecomsudparis.csc4102.util.OperationImpossible;

public class TestPrendreEnChargeUnEnvoi {
	private SmartTSI smartTSI;
	private String idtransporteur;
	private String idenvoi;
	private Instant instant ;
	private Envoi envoi ;
	private Transporteur transporteur ;
	private Client client; 

	@Before
	public void setUp() throws OperationImpossible {
		smartTSI = new SmartTSI();
		idtransporteur = "idtransporteur";
		idenvoi = "idenvoi";
		instant = Datutil.maintenant();
		client = new Client("idclient", "nom", "prenom" );
		transporteur = new Transporteur("idtransporteur", "nom");

	
	}

	@After
	public void tearDown() {
		smartTSI = null;
		idtransporteur= null;
		idenvoi= null;
		instant = null;
		envoi = null;
		transporteur = null;
		client = null;
	}

	@Test(expected = OperationImpossible.class)
	public void prendreEnChargeUnEnvoiTest1Jeu1() throws Exception {
		smartTSI.prendreEnChargeUnEnvoi(null, idenvoi);
	}

	@Test(expected = OperationImpossible.class)
	public void prendreEnChargeUnEnvoiTest1Jeu2() throws Exception {
		smartTSI.prendreEnChargeUnEnvoi("", idenvoi);
	}

	@Test(expected = OperationImpossible.class)
	public void prendreEnChargeUnEnvoiTest3Jeu1() throws Exception {
		smartTSI.prendreEnChargeUnEnvoi(idtransporteur, null);
	}

	@Test(expected = OperationImpossible.class)
	public void prendreEnChargeUnEnvoiTest3Jeu2() throws Exception {
		smartTSI.prendreEnChargeUnEnvoi(idtransporteur, "");
	}


	@Test
	public void prendreEnChargeUnEnvoiTest5Puis2Puis2() throws Exception {
		Assert.assertTrue(smartTSI.listeLesEnvois().isEmpty());
		smartTSI.ajouterUnClient("idclient", "nom", "prenom");
		smartTSI.ajouterUnTransporteur("idtransporteur", "nom");
		smartTSI.deposerUnEnvoi(idenvoi,"origine", "destination", "idclient");
		Assert.assertEquals(1, smartTSI.listeLesEnvois().size());
		Assert.assertEquals(idenvoi, smartTSI.listeLesEnvois().get(0));
		Assert.assertEquals(idtransporteur, smartTSI.listeLesTransporteurs().get(0));
		Assert.assertThrows(OperationImpossible.class,
				() -> smartTSI.prendreEnChargeUnEnvoi(idtransporteur, idenvoi));
	}
}
