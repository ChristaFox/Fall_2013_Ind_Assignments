/*******************************************************
* Name: Christa Fox
* Course: CSIS 2420
* Assignment: A01
*******************************************************/

package animalList;


public class Mammal extends Animal implements WarmBlooded, Vivaparous{

	public Mammal(String animalType, String animalName) {
		super(animalType, animalName);

	}

	@Override
	protected String move() {
		return " moves across land.";

	}

	@Override
	protected String howBorn() {
		return giveBirth();

	}

	@Override
	protected String howControlsTemp() {
		return maintainWarm();

	}

	@Override
	public String maintainWarm() {
		return " is warm blooded";
	}

	@Override
	public String giveBirth() {
		return "is a live bearer";
		
	}
	
	public String toString() {
		return(String.format("You selected a(n) %s and named it %s.%nA(n) %s%s.%nA(n) %s%s.%nA(n) %s%s.%n",
				getAnimalType(), getAnimalName(), getAnimalType(), howBorn(), 
				getAnimalType(), howControlsTemp(), getAnimalType(), move()));

	}

}
