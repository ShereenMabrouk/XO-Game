//Nourhan Mohamed Ahmed Mohamed Ismail 7153
//Shereen Mostafa Hassan Mabrouk       6844

package assignment_1;

// This class is designed to print the array in Normal colors
public class BWDisp {
	// Getting objects p1 and p2 from class Game
	static Players p1 = Game.p1;
	static Players p2 = Game.p2;

	public static void display(String[][] arr) {

		int row, col;
		// printing the score
		System.out.println("             Score is " + p1.getName() + " " + "(" + p1.getSymbol() + ")" + " "
				+ p1.getScore() + " - " + p2.getName() + " " + "(" + p2.getSymbol() + ")" + " " + p2.getScore());
		// printing the grid in Normal console
		for (row = 0; row < arr.length; row++) {
			for (col = 0; col < arr[0].length; col++) {
				System.out.print("|");

				System.out.print("   " + arr[row][col]);
				// To make the table stable no shifts
				if (arr[row][col].length() < 2) {
					System.out.print(" ");

				}
				System.out.print("   |");
			}
			System.out.println(" ");
			System.out.println("-----------------------------------------------------------------------");

		}

		System.out.println("***********************************************************************");

	}

}
