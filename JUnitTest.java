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
	public void testgetOwner() {
		Player player = new Player("Navn");
		String expected = "Navn";
		String actual = player.getowner();
		assertEquals(expected,actual);
	}
	@Test 
	public void testsetOwner() {
		Player player = new Player("Navn");
		player.setowner("Ændret navn");
		String expected = "Ændret navn";
		String actual = player.getowner();
		assertEquals(expected,actual);
	}

	@Test 
	public void testsetvundet() {
		Player player = new Player("");
		boolean expected = true;
		player.setvundet(true);
		boolean actual = player.getvundet();
		
		assertEquals(expected,actual);
	}
	@Test
	public void testgetvundet() {
		Player player = new Player("");
		player.setvundet(true);
		boolean actual = player.getvundet();
		assertTrue(actual);
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
		players[0] = new Player("");
		players[0].setpoints(5);
		players[0].addpoints(17);
		
		int expected = 22;
		int actual = players[0].getpoints();
		
		assertEquals(expected,actual);
	}

	@Test 
	public void testgetTimesRolled() {
		Player player = new Player("");
		player.incTimesRolled();
		player.incTimesRolled();
		int expected = 2;
		int actual = player.getTimesRolled();
		assertEquals(expected,actual);
	}
	
	@Test
	public void testsetTimesRolled() {
		Player player = new Player("");
		player.setTimesRolled(23);
		int expected = 23;
		int actual = player.getTimesRolled();
		assertEquals(expected,actual);
	}
	@Test 
	public void testincTimesRolled() {
		Player player = new Player("");
		player.incTimesRolled();
		int expected = 1;
		int actual = player.getTimesRolled();
		assertEquals(expected,actual);
	}
	
	@Test
	public void testsetPoints() {
		Player player = new Player("");
		player.setpoints(1337);
		int expected = 1337;
		int actual = player.getpoints();
		assertEquals(expected,actual);
	}
	
	@Test
	public void testgetPoints() {
		Player player = new Player("");
		player.addpoints(5);
		player.setpoints(666);
		int expected = 666;
		int actual = player.getpoints();
		assertEquals(expected,actual);
	}
	
	
	@Test
	public void testgetPlayerNum() {
		Player player = new Player("Navn");
		player.setPlayerNum(2);
		int expected = 2;
		int actual = player.getPlayerNum();
		assertEquals(expected,actual);
	}
	
	@Test
	public void testsetPlayerNum() {
		Player player = new Player("");
		player.setPlayerNum(123);
		int expected = 123;
		int actual = player.getPlayerNum();
		assertEquals(expected,actual);
	}
	
	 @Test
	 public void testsetLastThrow() {
		 Player player = new Player("");
		 player.setLastThrow(1, 2);
		 boolean expected = true;
		 boolean actual = player.lastThrowEqual(1, 2);
		 assertEquals(expected,actual);
	 }
	 
	public void testlastThrowEqual() {
		Player player = new Player("");
		 player.setLastThrow(3, 15);
		 boolean expected = true;
		 boolean actual = player.lastThrowEqual(3, 15);
		 assertEquals(expected,actual);
	}
	
	
	
}