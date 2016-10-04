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
		while (start = true) 
		{
			/*Noter
			 * Skal have et loop, der repræsenterer starten af spillet
			 */
			System.out.println("Velkommen til spillet");
			//Spillere
			int numOfPlayers = 2;
			Player[] players = initPlayers(numOfPlayers);

			//Terninger
			Dice d1 = new Dice();
			Dice d2 = new Dice();

			//Instanser
			int turn = 0;							//Vælger hvilken spillers tur det er.


			//Udskriver antallet af point spillerne har


			//Start tekst
			System.out.println("Spiller 1 starter.");
			boolean sidsteTur = false;


			String gameCommand = "";

			while (!sidsteTur) {

				int ekstratur = 1;						// Tæller hvor mange ture spilleren har

				//Loop for en spillers runde
				while(ekstratur != 0 || !sidsteTur) 
				{
					System.out.println("             "+players[turn].getowner()+"'s tur\r");
					System.out.println(players[0].getowner() + " har " + players[0].getpoints() + " points");
					System.out.println(players[1].getowner() + " har " + players[1].getpoints() + " points\r");
					System.out.println("Tryk enter for at rafle");
					gameCommand = keyb.nextLine();
					d1.roll();
					d2.roll();

					System.out.println(players[turn].getowner()+" slog: "+d1.getFaceValue()+" og "+d2.getFaceValue());
					
					int resultat = d1.getFaceValue()+d2.getFaceValue();
					//Spørger om spilleren har mere end 40 point
					if (players[turn].getpoints() >= 40) 
					{

						//Spørger om terningernes øjne er ens
						if (d1.isEqual(d2)) 
						{
							
							//Spørger om terningernes øjne er 1'ere
							if (d1.getFaceValue() == 1) 
							{
								players[turn].setpoints(0);
								players[turn].setLastThrow(d1.getFaceValue(), d2.getFaceValue());
								ekstratur++;
							}	

							//Spørger om terningernes øjne er andet end 1'ere
							else if (d1.getFaceValue() != 1) 
							{

								// NOTE, SYSTEMET MANGLER AT UDSKRIVE POINT TIL DETTE STEP
								System.out.println(players[turn].getowner() + " har vundet");
								start = false;
								sidsteTur = true;
							}			// Slut else if sætning 
						}				// slut d1.isEqual(d2) if sætning
						else 
						{
							players[turn].addpoints(resultat);
							players[turn].setLastThrow(d1.getFaceValue(), d2.getFaceValue());
						}				
					}					// slut players points >=40
					else 
					{
						players[turn].addpoints(resultat);
						//Spørger om terningernes øjne er ens
						if (d1.isEqual(d2)) 
						{


							//Spørger om terningernes øjne er 1'ere
							if (d1.getFaceValue() == 1) 
							{
								players[turn].setpoints(0);
								players[turn].setLastThrow(d1.getFaceValue(), d2.getFaceValue());
								ekstratur++;
								//syso? "Du har mistet alle dine points"
							}	

							//Spørger om terningernes øjne er andet end 1'ere
							else if (d1.getFaceValue() == 6) 
							{
								if(players[turn].lastThrowEqual(d1.getFaceValue(), d2.getFaceValue()))
								{
									System.out.println("Du har vundet");
									sidsteTur = true;
									///VINNER TEXT og fyværkeri
								}
								else
								{
									ekstratur++;
									players[turn].setLastThrow(d1.getFaceValue(), d2.getFaceValue());
								}
							}
							else
							{
								ekstratur++;
							}
						}
						ekstratur--;
						System.out.println("____________________________________________________\r");
						
					}	
					if (ekstratur==0)
					{
						turn++;
					}
					if (turn == numOfPlayers) {
						turn = 0;
					}//Slutning af tur.
					//Turen skiftes
					
				}

				// Runder						






			}}								//Selve spillets while loop.

	}
	private static Player[] initPlayers(int numOfPlayers)
	{
		/// opretter spillere med selvvalgte navne, returnere en spiller array.
		/// er static så man ikke behøver at instantiere et objekt for at bruge metoden
		Player players[] = new Player[numOfPlayers];
		Scanner keyb = new Scanner(System.in);
		String name = "";
		for(int i = 0 ; i<numOfPlayers; i++)
		{
			System.out.println("Indtast navn på spiller_"+(i+1));
			name = keyb.nextLine();
			players[i] = new Player(name);			
		}
		return players;
	}
}

