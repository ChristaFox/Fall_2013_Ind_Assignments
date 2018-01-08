/*******************************************************
* Name: Christa Fox
* Course: CSIS 2420
* Assignment: A01
*******************************************************/

package animalList;


public class NonWingedArthropod extends Arthropod {

	public NonWingedArthropod(String animalType, String animalName) {
		super(animalType, animalName);
		
	}

	@Override
	protected String move() {
		return" moves across ground.";

	}
	
	public String toString() {
		return(String.format("You selected a(n) %s and named it %s.%nA(n) %s%s.%nA(n) %s%s.%nA(n) %s%s%n",
				getAnimalType(), getAnimalName(), getAnimalType(), howBorn(), 
				getAnimalType(), howControlsTemp(), getAnimalType(), move()));

	}

}
