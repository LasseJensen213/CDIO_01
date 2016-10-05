package dice;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;




public class JUnitTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}



	@Test
	public void testsetfaceValue() {
		Dice d1 = new Dice();
		int expected = 5;
		d1.setFaceValue(5);
		int actual = d1.getFaceValue();
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void testgetfaceValue() {
		Dice d1 = new Dice();
		int expected = 5;
		d1.setFaceValue(5);
		int actual = d1.getFaceValue();
		assertEquals(expected,actual);
	}
	
	@Test
	public void testroll() {
		
		Dice d1 = new Dice();
		d1.roll();
		int ex[] = {1,2,3,4,5,6};
		int expected = ex[d1.getFaceValue()-1];
		int actual = d1.getFaceValue();
		assertEquals(expected,actual);
	}
	
	@Test
	public void testD1EqualsD2() {
		Dice d1 = new Dice();
		Dice d2 = new Dice();
		d1.setFaceValue(3);
		d2.setFaceValue(3);
		boolean expected = d1.isEqual(d2);
		assertTrue(expected);
	}
	@Test
	public void testRollChance() {
		Dice dice = new Dice();
		
		//Instanser
		int one = 0;		//Til at starte med er 1 forekommet 0 gange
		int two = 0;		//Til at starte med er 2 forekommet 0 gange
		int three = 0;		//Til at starte med er 3 forekommet 0 gange
		int four = 0;		//Til at starte med er 4 forekommet 0 gange
		int five = 0;		//Til at starte med er 5 forekommet 0 gange
		int six = 0;		//Til at starte med er 6 forekommet 0 gange		
		
		//Expected values
		
		
		for(int i=0, n=60000; i<n; i++) {
			dice.roll();
			
			switch(dice.getFaceValue()) {
			case 1 : 
				one++;
				break;
			case 2 : 
				two++;
				break;
			case 3 :
				three++;
				break;
			case 4 :
				four++;
				break;
			case 5 :
				five++;
				break;
			case 6 :
				six++;
				break;
				
			}
		}
		assertEquals(10000, one, 400);
		assertEquals(10000, two, 400);		
		assertEquals(10000, three,400);		
		assertEquals(10000, four, 400);		
		assertEquals(10000, five, 400);		
		assertEquals(10000, six, 400);		
	
	
		
		}
	@Test
	public void testAddPoint() {
		Player[] players = new Player[2];
		players[0] = new Player(0);
		players[0].setpoints(5);
		players[0].addpoints(17);
		
		int expected = 22;
		int actual = players[0].getpoints();
		
		assertEquals(expected,actual);
	}
	


}
