

//CHECKSTYLE:OFF
package eu.telecomsudparis.csc4102.smarttsi.unitaires;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import eu.telecomsudparis.csc4102.smarttsi.Condition;


public class TestCondition {

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	@Test(expected = IllegalArgumentException.class)
	public void constructeurConditionTest1Jeu1() throws Exception {
		new Condition(null, "idenvoi", "attribut", 3.0, 5.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void constructeurConditionTest1Jeu2() throws Exception {
		new Condition("", "idenvoi", "attribut", 3.0, 5.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void constructeurConditionTest2Jeu1() throws Exception {
		new Condition("identifiant", null, "attribut", 3.0, 5.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void constructeurConditionTest2Jeu2() throws Exception {
		new Condition("identifiant", "", "attribut", 3.0, 5.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void constructeurConditionTest3Jeu1() throws Exception {
		new Condition("identifiant", "idenvoi", null, 3.0, 5.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void constructeurConditionTest3Jeu2() throws Exception {
		new Condition("identifiant", "idenvoi", "", 3.0, 5.0);
	}
	@Test(expected = IllegalArgumentException.class)
	public void constructeurConditionTest4() throws Exception {
		new Condition("identifiant", "idenvoi", "attribut", null, null);
	}

	public void constructeurConditionTest6() throws Exception {
		Condition condition = new Condition("identifiant", "idenvoi", "attribut", 3.0,5.0);
		Assert.assertEquals("identifiant", condition.getIdentifiant());
		Assert.assertEquals("idenvoi", condition.getIdenvoi());
		Assert.assertEquals("attribut", condition.getAttribut());
		Assert.assertEquals("5.0", condition.getValeurhaute().toString());
		Assert.assertEquals("3.0", condition.getValeurbasse().toString());
	
	}
}


