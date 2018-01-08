/*******************************************************
* Name: Christa Fox
* Course: CSIS 2420
* Assignment: A01
*******************************************************/

package infrastructure;

public class Tester {

	public Tester() {
		// testInt ();
		testString();
		testMenu();
	}

	public void testInt() {
		int age = IO.promptForInt("Enter your age ", 0, 150);
		System.out.println("your age is " + age);
	}

	public void testMenu() {
		int choice = -1;
		while (choice != 3) {  //(true) {
			final String MAIN_MENU = "Main Menu\n\n1. Select pet\n2. Display pet\n3. Exit\n";
			choice = IO.menu(MAIN_MENU, 1, 3);
			if (choice == 3) {
				System.out.println("bye bye");
			} else {
				System.out.println("your choice is " + choice);
				//testMenu();
				//System.out.println ("here");
			}
		}
	}

	public void testString() {
		 String name = IO.promptForString("Enter your name ");
		 System.out.println("your name is " + name);
	}

	public static void main(String[] args) {
		new Tester ();
	}

}
