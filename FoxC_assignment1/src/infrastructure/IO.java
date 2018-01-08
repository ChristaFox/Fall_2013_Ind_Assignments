/*******************************************************
* Name: Christa Fox
* Course: CSIS 2420
* Assignment: A01
*******************************************************/

package infrastructure;

import java.util.*;

public class IO {
	static int choice;
	static int userChoice;
	static String string;
	
	public static int menu(String prompt, int min, int max) {
		return promptForInt("\n" + prompt, min, max);
	}

	private static int fetchIntInput(String prompt, int min, int max) {
		Scanner input = null;
		choice = min - 1;
		try {
			System.out.println(prompt);
			System.out.print("Make your choice, but it should be between " + min
					+ " and " + max + ".\n");
			input = new Scanner(System.in);
			choice = input.nextInt();
			//input.close();
		} catch (IllegalStateException e) {
		} catch (InputMismatchException e) {
		}
		return choice;
	}

	public static int promptForInt(String prompt, int min, int max) {
		int userChoice = min - 1;
		while (userChoice < min || userChoice > max) {
			userChoice = IO.fetchIntInput(prompt, min, max);
			if (userChoice < min || userChoice > max) {
				System.out.println("You did not follow instructions.");
			}
		}
		return userChoice;
	}

	public static String promptForString(String prompt) {
		Scanner in = new Scanner(System.in);
		int size = 0;
		do {
			System.out.print(prompt + " ");
			string = in.nextLine();
			size = string.length();
			if (size <= 0) {
				System.out.println("You must enter at least one character");
			}
		} while (size <= 0);
		//in.close();
		return string;
	}
	
	
}
