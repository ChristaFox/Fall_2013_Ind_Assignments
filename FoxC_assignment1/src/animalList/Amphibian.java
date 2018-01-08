/*******************************************************
* Name: Christa Fox
* Course: CSIS 2420
* Assignment: A01
*******************************************************/

package animalList;

public class Amphibian extends Animal implements ColdBlooded, Oviparous{

	public Amphibian(String animalType, String animalName) {
		super(animalType, animalName);
		
	}

	@Override
	public String move() {
		return " moves in the water and across land";
	}

	@Override
	protected String howBorn() {
		return layEggs();

	}

	@Override
	protected String howControlsTemp() {
		return maintainCold();
	}

	@Override
	public String layEggs() {
		return " comes from an egg";
	}

	@Override
	public String maintainCold() {
		return " is cold blooded";
		
	}
	
	public String toString() {
		return(String.format("You selected a(n) %s and named it %s.%nA(n) %s%s.%nA(n) %s%s.%nA(n) %s%s.%n",
				getAnimalType(), getAnimalName(), getAnimalType(), howBorn(), 
				getAnimalType(), howControlsTemp(), getAnimalType(), move()));

	}

}
