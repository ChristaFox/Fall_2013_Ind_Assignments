/*******************************************************
* Name: Christa Fox
* Course: CSIS 2420
* Assignment: A01
*******************************************************/

package animalList;


public class OviparousReptile extends Reptile implements Oviparous {

	public OviparousReptile(String animalType, String animalName) {
		super(animalType, animalName);
		
	}

	@Override
	protected String howBorn() {
		return layEggs();

	}

	@Override
	public String layEggs() {
		return " comes from an egg";
		
	}
	
	@Override
	public String toString() {
		return(String.format("You selected a(n) %s and named it %s.%nA(n) %s%s.%nA(n) %s%s.%nA(n) %s%s%n",
				getAnimalType(), getAnimalName(), getAnimalType(), howBorn(), 
				getAnimalType(), howControlsTemp(), getAnimalType(), move()));

	}

}
