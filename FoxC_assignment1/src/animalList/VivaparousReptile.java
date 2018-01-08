/*******************************************************
* Name: Christa Fox
* Course: CSIS 2420
* Assignment: A01
*******************************************************/

package animalList;


public class VivaparousReptile extends Reptile implements Vivaparous {

	public VivaparousReptile(String animalType, String animalName) {
		super(animalType, animalName);
		
	}

	@Override
	protected String howBorn() {
		return giveBirth();

	}

	@Override
	public String giveBirth() {
		return "is a live bearer";
		
	}
	
	@Override
	public String toString() {
		return(String.format("You selected a(n) %s and named it %s.%nA(n) %s%s.%nA(n) %s%s.%nA(n) %s%s.%n",
				getAnimalType(), getAnimalName(), getAnimalType(), howBorn(), 
				getAnimalType(), howControlsTemp(), getAnimalType(), move()));

	}

}
