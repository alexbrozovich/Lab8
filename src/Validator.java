
import java.util.Scanner;

//you can add your own validation methods if needed
public class Validator {
	public static String getString(Scanner sc, String prompt) {
		System.out.print(prompt);
		String s = sc.next(); // read user entry
		sc.nextLine(); // discard any other data entered on the line
		return s;
	}
	
	public static boolean yesOrNo(Scanner sc, String prompt) {
		boolean isValid = false;
		boolean keepGoing = false;
		while (isValid == false) {
			String s = Validator.getString(sc, prompt);
			if (s.length() == 1) {
				if(s.charAt(0) == 'y' || s.charAt(0) == 'Y') {
					keepGoing = true;
					isValid = true;
				}
				else if (s.charAt(0) == 'n' || s.charAt(0) == 'N') {
					keepGoing = false;
					isValid = true;
				}
				else {
					System.out.println("That is not a valid input. Please enter 'y' or 'n'");
				}
			}
			else {
				System.out.println("That is not a valid input. Please enter 'y' or 'n'");
			}
		}
		return keepGoing;
	}
	public static int intIsPos(Scanner sc, String prompt) {
		int i = 0;
		boolean isValid = false;
		while (isValid == false) {
			System.out.println(prompt);
			if (sc.hasNextInt()) {
				i = sc.nextInt();
				if ( i > 0) {
				isValid = true;
				}
				else {
					System.out.println("Error! Input must be positive. Please try again.");
				}
			}
			else {
				System.out.println("Error! Input must be an integer. Please try again.");
			}
			sc.nextLine();
		}
		return i;
	}
	public static int getInt(Scanner sc, String prompt) {
		int i = 0;
		boolean isValid = false;
		while (isValid == false) {
			System.out.print(prompt);
			if (sc.hasNextInt()) {
				i = sc.nextInt();
				isValid = true;
			} else {
				System.out.println("Error! Invalid integer value. Try again.");
			}
			sc.nextLine(); // discard any other data entered on the line
		}
		return i;
	}

	public static int getInt(Scanner sc, String prompt, int min, int max) {
		int i = 0;
		boolean isValid = false;
		while (isValid == false) {
			i = getInt(sc, prompt);
			if (i < min)
				System.out.println("Error! Number must be " + min + " or greater.");
			else if (i > max)
				System.out.println("Error! Number must be " + max + " or less.");
			else
				isValid = true;
		}
		return i;
	}

	public static double getDouble(Scanner sc, String prompt) {
		double d = 0;
		boolean isValid = false;
		while (isValid == false) {
			System.out.print(prompt);
			if (sc.hasNextDouble()) {
				d = sc.nextDouble();
				isValid = true;
			} else {
				System.out.println("Error! Invalid decimal value. Try again.");
			}
			sc.nextLine(); // discard any other data entered on the line
		}
		return d;
	}

	public static double getDouble(Scanner sc, String prompt, double min, double max) {
		double d = 0;
		boolean isValid = false;
		while (isValid == false) {
			d = getDouble(sc, prompt);
			if (d < min)
				System.out.println("Error! Number must be " + min + " or greater.");
			else if (d > max)
				System.out.println("Error! Number must be " + max + " or less.");
			else
				isValid = true;
		}
		return d;
	}
}
