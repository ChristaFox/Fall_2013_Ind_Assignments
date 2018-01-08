/*******************************************************
* Name: Christa Fox
* Course: CSIS 2420
* Assignment: A01
*******************************************************/

package animalList;

public abstract class Animal {
	
	//feilds
	protected String animalType;
	protected String animalName;
	
	//ctors
	public Animal(String animalType, String animalName){
		this.animalType = animalType;
		this.animalName = animalName;
		
	}
	
	//methods
	protected abstract String move();
	protected abstract String howBorn();
	protected abstract String howControlsTemp();
	public abstract String toString();

	public String getAnimalName() {
		return animalName;
	}

	protected String setAnimalName(String animalName) {
		return this.animalName = animalName;
	}

	protected String getAnimalType() {
		return animalType;
	}

	protected String setAnimalType(String animalType) {
		return this.animalType = animalType;
	}


	
	

}
