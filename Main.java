package dice;
import java.util.Scanner;
import dice.Player;
public class Main {

	public static void main(String[] args) {

		Scanner keyb = new Scanner(System.in);		
		//Velkomst information
		String info = ("Hej. Velkommen til spillet.");
		String info2 = ("Tast \"Hjælp\" for at læse spillet regler eller  \"Start\" for at starte spillet ");

		//Introduktion
		System.out.println(info);
		System.out.println(info2);

		//Instanser der bestemmer om spillet skal spilles
		boolean start = false;
		boolean slut = false;

		//Start valg.
		do {
			String Input = keyb.nextLine();
			Input.toLowerCase();

			switch (Input) {
			case "hjælp":
				System.out.println("Regler");
				break;
			case "start":
				System.out.println("Du har trykket start.");
				slut = true;
				break;

			case "slut" :
				System.out.println("Tak fordi du brugte spillet - Farvel");
				slut = true;
				break;
			default :
				System.out.println("Ugyldig Indtastning");
			}
		}
		while (start || slut == false);



		//Selve spillet
		while (start = true) {
			/*Noter
			 * Skal have et loop, der repræsenterer starten af spillet
			 */
			System.out.println("Velkommen til spillet");
			//Spillere
			Player[] players = new Player[2];
			players[0] = new Player(0);
			players[1] = new Player(0);

			//Terninger
			Dice d1 = new Dice();
			Dice d2 = new Dice();

			//Instanser
			int turn = 0;							//Vælger hvilken spillers tur det er.
			int ekstratur = 1;						// Tæller hvor mange ture spilleren har

			//Udskriver antallet af point spillerne har
			System.out.println(players[0].getowner() + "har " + players[0].getpoints() + "points");
			System.out.println(players[1].getowner() + "har " + players[1].getpoints() + "points");

			//Start tekst
			System.out.println("Spiller 1 starter.");
			System.out.println("Tryk enter for at rafle");


			String Input = keyb.nextLine();
			while (Input != null) {		

				//Loop for en spillers runde
				while(ekstratur != 0) {
					d1.roll();
					d2.roll();

					//Spørger om spilleren har mere end 40 point
					if (players[turn].getpoints() >= 40) {

						//Spørger om terningernes øjne er ens
						if (d1.isEqual(d2)); {
							ekstratur++;
							//Spørger om terningernes øjne er 1'ere
							if (d1.getFaceValue() == 1) {
								players[turn].setpoints(0);
							}

							//Spørger om terningernes øjne er andet end 1'ere
							else if (d1.getFaceValue() != 1) {

								// NOTE, SYSTEMET MANGLER AT UDSKRIVE POINT TIL DETTE STEP
								System.out.println(players[turn].getowner() + " har vundet");
								start = false;
								break;
							}			// Slut else if sætning 


						} 				// slut d1.isEqual(d2) if sætning


					}					// slut players points >=40

				}						//Slutning af tur.
				//Turen skiftes	
				turn++;
				if (turn == 2) {
					turn = 0;
				}


			} 							






		}								//Selve spillets while loop.

	}
}

