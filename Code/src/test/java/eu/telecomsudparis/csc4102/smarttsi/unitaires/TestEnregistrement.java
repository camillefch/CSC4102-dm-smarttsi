// CHECKSTYLE:OFF
package eu.telecomsudparis.csc4102.smarttsi.unitaires;



import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import eu.telecomsudparis.csc4102.smarttsi.Enregistrement;
import eu.telecomsudparis.csc4102.util.Datutil;


public class TestEnregistrement {

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	@Test(expected = IllegalArgumentException.class)
	public void constructeurEnregistrementTest1Jeu1() throws Exception {
		new Enregistrement(null, "idsource", "idenvoi","nom_attribut", 5.0 , Datutil.maintenant());
	}

	@Test(expected = IllegalArgumentException.class)
	public void constructeurEnregistrementTest1Jeu2() throws Exception {
		new Enregistrement("", "idsource", "idenvoi","nom_attribut", 5.0 , Datutil.maintenant());
	}

	@Test(expected = IllegalArgumentException.class)
	public void constructeurEnregistrementTest2Jeu1() throws Exception {
		new Enregistrement("identifiant", null, "idenvoi","nom_attribut", 5.0 , Datutil.maintenant());
	}

	@Test(expected = IllegalArgumentException.class)
	public void constructeurEnregistrementTest2Jeu2() throws Exception {
		new Enregistrement("identifiant", "", "idenvoi","nom_attribut", 5.0 , Datutil.maintenant());
	}

	public void constructeurEnregistrementTest3Jeu1() throws Exception {
		new Enregistrement("identifiant", "idsource", null,"nom_attribut", 5.0 , Datutil.maintenant());
	}
	
	public void constructeurEnregistrementTest3Jeu2() throws Exception {
		new Enregistrement("identifiant", "idsource", "","nom_attribut", 5.0 , Datutil.maintenant());
	}
	
	public void constructeurEnregistrementTest4Jeu1() throws Exception {
		new Enregistrement("identifiant", "idsource", "idenvoi",null, 5.0 , Datutil.maintenant());
	}
	
	public void constructeurEnregistrementTest4Jeu2() throws Exception {
		new Enregistrement("identifiant", "idsource", "idenvoi","", 5.0 , Datutil.maintenant());
	}
	
	public void constructeurEnregistrementTest5Jeu1() throws Exception {
		new Enregistrement("identifiant", "idsource", "idenvoi","nom_attribut", null , Datutil.maintenant());
	}
	public void constructeurEnregistrementTest6Jeu1() throws Exception {
		new Enregistrement("identifiant", "idsource", "idenvoi","nom_attribut", 5.0 , null);
	}
	public void constructeurEnregistrementTest6Jeu2() throws Exception {
		new Enregistrement("identifiant", "idsource", "idenvoi","nom_attribut", 5.0 , Datutil.ajouterJoursAInstant(Datutil.maintenant(),1));
	}
	
	public void constructeurEnregistrementTest7jeu1() throws Exception {
		Enregistrement enregistrement = new Enregistrement("identifiant", "description", "idenvoi", "nom_attribut",5.0, Datutil.maintenant());
		Assert.assertEquals("identifiant", enregistrement.getIdentifiant());
		Assert.assertEquals("idesource", enregistrement.getIdSource());
		Assert.assertEquals("idenvoi", enregistrement.getIdEnvoi());
		Assert.assertEquals("nom_attribut", enregistrement.getAttribut());
		Assert.assertEquals(Datutil.maintenant(), enregistrement.getDate());
		Assert.assertEquals("5.0", enregistrement.getValeur().toString());	
	}
}