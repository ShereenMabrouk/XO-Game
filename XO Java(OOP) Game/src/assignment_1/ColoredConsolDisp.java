//Nourhan Mohamed Ahmed Mohamed Ismail 7153
//Shereen Mostafa Hassan Mabrouk       6844

package assignment_1;

// this class is designed to display the colored Grid 
public class ColoredConsolDisp {
	public static final String BLACK_BOLD = "\033[1;30m";
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m";
	public static final String RED_BOLD_BRIGHT = "\033[1;91m";
	public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";
	public static final String YELLOW_BOLD = "\033[1;33m";
	// objects of class Players imported from class Game
	static Players p1 = Game.p1;
	static Players p2 = Game.p2;

	public static void display(String[][] arr) {

		int row, col;
		// printing the score
		System.out.println(ANSI_RESET + YELLOW_BOLD + "             Score is " + RED_BOLD_BRIGHT + p1.getName() + " "
				+ "(" + p1.getSymbol() + ")" + " " + p1.getScore() + YELLOW_BOLD + " - " + PURPLE_BOLD_BRIGHT
				+ p2.getName() + " " + "(" + p2.getSymbol() + ")" + " " + p2.getScore() + CYAN_BACKGROUND_BRIGHT
				+ BLACK_BOLD);
		// printing the Grid
		for (row = 0; row < arr.length; row++) {
			for (col = 0; col < arr[0].length; col++) {
				System.out.print("|");
				if (arr[row][col].equals("X"))

					System.out.print(ANSI_RESET + CYAN_BACKGROUND_BRIGHT + RED_BOLD_BRIGHT);
				else if (arr[row][col].equals("Y"))
					System.out.print(PURPLE_BOLD_BRIGHT);
				System.out.print("   " + arr[row][col] + BLACK_BOLD);
				if (arr[row][col].length() < 2) {
					System.out.print(" ");

				}
				System.out.print("   |");
			}
			System.out.println(" ");
			System.out.println("-----------------------------------------------------------------------");

		}

		System.out.println("***********************************************************************" + ANSI_RESET);

	}

}
