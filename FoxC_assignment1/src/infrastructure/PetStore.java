/*******************************************************
* Name: Christa Fox
* Course: CSIS 2420
* Assignment: A01
*******************************************************/

package infrastructure;

import animalList.Amphibian;
import animalList.Animal;
import animalList.Bird;
import animalList.Mammal;
import animalList.NonWingedArthropod;
import animalList.OviparousReptile;
import animalList.VivaparousReptile;
import animalList.WingedArthropod;

//application
public class PetStore{
	
	private static String type;
	private static Animal lastAnimal;


	public static void main(String[] args){
		mainMenu();
}


	private static void mainMenu() {
		IO.menu("Main Menu\n\n1. Select a pet.\n2. Display last selected pet.\n3. Exit\n",
				1, 3);
		int selection = IO.choice;
			switch(selection) {
				case 1: animalMenu();
						break;
				case 2:	displayAnimal(lastAnimal);
						break;
				case 3: System.exit(0);
				
			}
		
	}


	private static void displayAnimal(Animal a) {
		if(lastAnimal != null)
			System.out.print(lastAnimal.toString());
		else
			System.out.println("Please select another animal.");
		
	
}

	private static void animalMenu() {
		IO.menu("Animal Menu\n\n1. Reptile\n2. Arthropod\n3. Bird\n4. Amphibian\n5. Mammal\n6. Return to Main Menu.",
				1, 6);
		switch(IO.choice) {
			case 1: reptileMenu();
					break;
			case 2:	arthropodMenu();
					break;
			case 3: birdMenu();
					break;
			case 4: amphibianMenu();
					break;
			case 5: mammalMenu();
					break;
			case 6: animalMenu();
					break;
	
	}
}


	private static void mammalMenu() {
		IO.menu("Mammal Menu\n\n1. Lemur\n2. Aardvark\n3.  Return to Animal Menu.",
				1, 4);
		if (IO.choice < 4){
			IO.promptForString("Please choose a name for your pet.");
			if(IO.choice == 1)
				type = "lemur";
			else
				type = "aardvark";
			lastAnimal = new Mammal(type, IO.string);
			mainMenu();
		}
		else
			animalMenu();
		
	}


	private static void amphibianMenu() {
		IO.menu("Amphibian Menu\n\n1. Salamander\n2. Bullfrog\n3. Newts\n4.  Return to Animal Menu.",
				1, 4);
		if (IO.choice < 4){
			IO.promptForString("Please choose a name for your pet.");
			if(IO.choice == 1)
				type = "salamander";
			if(IO.choice == 2)
				type = "bullfrog";
			else
				type = "newt";
			lastAnimal = new Amphibian(type, IO.string);
			mainMenu();
		}
		else
			animalMenu();
		
	}


	private static void birdMenu() {
		IO.menu("Amphibian Menu\n\n1. Parrot\n2. Pink Flamingo\n3. Love Bird\n4.  Return to Animal Menu.",
				1, 4);
		if (IO.choice < 4){
			if(IO.choice == 1)
				type = "parrot";
			if(IO.choice == 2)
				type = "pink flamingo";
			else
				type = "love bird";
			IO.promptForString("Please choose a name for your pet.");

			lastAnimal = new Bird(type, IO.string);
			mainMenu();
		}
		else if (IO.choice == 4)
			animalMenu();
		
	}


	private static void reptileMenu() {
		IO.menu("1. Reptile that lays eggs.\n2. Reptle that is a live bearer.\n3. Return to Animal Menu.",
				1, 3);
		if(IO.choice == 1){
			oviparousReptileMenu();
		}
		else if(IO.choice == 2){
			vivaparousReptileMenu();
		}
		else
			animalMenu();
		}


	private static void vivaparousReptileMenu() {
		IO.menu("Vivaparous Menu\n\n1. Viper\n2. Skink\n3. Return to Animal Menu.", 1, 3);
		if(IO.choice < 3)
			IO.promptForString("Please choose a name for your pet.");
			if(IO.choice == 1)
				type = "viper";
			else
				type = "skink";
		lastAnimal = new VivaparousReptile(type, IO.string);
		mainMenu();
	}


	private static void oviparousReptileMenu() {
		IO.menu("Oviparous Menu\n\n1. Leopard Gecko\n2. Blue Banded Iguana\n3. Return to Animal Menu.", 1, 3);
		if(IO.choice < 3)
			IO.promptForString("Please choose a name for your pet.");
			if(IO.choice == 1)
				type = "leopard gecko";
			else
				type = "blue banded iguana";
		lastAnimal = new OviparousReptile(type, IO.string);
		mainMenu();
	}


	private static void arthropodMenu() {
		IO.menu("1. Arthropod with wings.\n2. Arthropod without wings.\n3. Return to Animal Menu.",
				1, 3);
		if(IO.choice == 1){
			wingedArthropodMenu();
		}
		else if(IO.choice == 2){
			nonWingedArthropodMenu();
		}
		else
			animalMenu();
		}


	private static void nonWingedArthropodMenu() {
		IO.menu("Non-winged Arthropod Menu\n\n1. Lobster\n2. Centipede\n3. Return to Animal Menu.", 1, 3);
		if(IO.choice < 3)
			IO.promptForString("Please choose a name for your pet.");
			if(IO.choice == 1)
				type = "lobster";
			else
				type = "centipede";
			
		lastAnimal = new NonWingedArthropod(type, IO.string);
		mainMenu();
		
	}


	private static void wingedArthropodMenu() {
		IO.menu("Vivaparous Menu\n\n1. Praying Mantis\n2. Beetle\n3. Return to Animal Menu.", 1, 3);
		if(IO.choice < 3)
			IO.promptForString("Please choose a name for your pet.");
			if(IO.choice == 1)
				type = "praying mantis";
			else
				type = "beetle";
		lastAnimal = new WingedArthropod(type, IO.string);
		mainMenu();
		
	}
		
	}
