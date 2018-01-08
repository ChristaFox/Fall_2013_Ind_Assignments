/*******************************************************
* Name: Christa Fox
* Course: CSIS 2420
* Assignment: A01
*******************************************************/


package animalList;


public class Bird extends Animal implements Flyable, WarmBlooded, Oviparous {

	public Bird(String animalType, String animalName) {
		super(animalType, animalName);
	
	}

	@Override
	protected String move() {
		return fly();

	}

	@Override
	protected String howBorn() {
		return layEggs();

	}

	@Override
	protected String howControlsTemp() {
		return maintainWarm();

	}

	@Override
	public String maintainWarm() {
		return" is warm blooded";
	}

	@Override
	public String layEggs() {
		return " comes from an egg";
	}

	public String fly() {
		return " moves through the sky";
		
	}

	public String toString() {
		return(String.format("You selected a(n) %s and named it %s.%nA(n) %s%s.%nA(n) %s%s.%nA(n) %s%s.%n",
				getAnimalType(), getAnimalName(), getAnimalType(), howBorn(), 
				getAnimalType(), howControlsTemp(), getAnimalType(), move()));

	}

}
