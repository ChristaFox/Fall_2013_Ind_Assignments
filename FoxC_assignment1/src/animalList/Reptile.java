/*******************************************************
* Name: Christa Fox
* Course: CSIS 2420
* Assignment: A01
*******************************************************/

package animalList;


public abstract class Reptile extends Animal implements ColdBlooded {

	public Reptile(String animalType, String animalName) {
		super(animalType, animalName);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String move() {
		return " moves across the ground";

	}

	@Override
	protected abstract String howBorn();

	@Override
	protected String howControlsTemp() {
		return maintainCold();

	}

	@Override
	public String maintainCold() {
		return(" is cold blooded");
		
	}

}
