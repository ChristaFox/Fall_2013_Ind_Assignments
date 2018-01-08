/*******************************************************
* Name: Christa Fox
* Course: CSIS 2420
* Assignment: A01
*******************************************************/

package animalList;


public abstract class Arthropod extends Animal implements ColdBlooded, Oviparous{

	public Arthropod(String animalType, String animalName) {
		super(animalType, animalName);
		
	}

	@Override
	protected abstract String move(); 

	@Override
	protected String howBorn() {
		return layEggs();

	}
	
	@Override
	public String layEggs() {
		return " comes from an egg";
		
	}

	@Override
	protected String howControlsTemp() {
		return maintainCold();

	}
	
	@Override
	public String maintainCold() {
		return" is cold blooded";
		
	}

}
