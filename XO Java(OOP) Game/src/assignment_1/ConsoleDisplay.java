//Nourhan Mohamed Ahmed Mohamed Ismail 7153
//Shereen Mostafa Hassan Mabrouk       6844

package assignment_1;

import javax.swing.JOptionPane;

public class ConsoleDisplay {
	// This class is designed to be a layer between the console and the logic of the
	// game
	// So if I wanted to convert the game to GUI I can without creating a new logic
	// Game

	// G1 is an object of class Game
	static Game g1 = new Game();
	// ROWS and COLUMNS are imported from Game so as to change the size of the grid
	// only 1 time in the Game class

	static int rows = Game.ROWS;
	static int columns = Game.COLUMNS;
	// objects of Player are imported from the class Game to set the values
	static Players p1 = Game.p1;
	static Players p2 = Game.p2;

	// This method to ask the user if he wants the console to be coloured or not on
	// condition that the user
	// open the game from Eclipse IDE and installed Ansi Console from the market
	public static int ChoiceConsole() {
		boolean wrong = false;
		// wrong boolean variable means that the user entered something wrong as (didn't
		// enter anything
		// and choice is empty , clicked cancel or esc , entered number other than 1 and
		// 2 ,or entered a string)
		while (!wrong) {
			// Dialogbox is created to take the value from the user
			String choice = JOptionPane.showInputDialog(
					"Please choice if you want colored console press 1 if you want normal console press 2 not Note that Colored console needs Ansi Console from eclipse market");
			// if the user clicked Esc or cancel the program will view the msg GoodBye and
			// exit
			if (choice == null) {
				JOptionPane.showMessageDialog(null, "GoodBye");
				System.exit(0);
			}
			// if the user entered empty string (click ok and didn't type anything the
			// message will prompt again
			// asking for the number
			else if (choice.isEmpty()) {
				wrong = false;
			}
			// calling method tryParse to know if the string is a number or not if is
			// returned a null
			// then it is not a number and a prompt message will ask again for the number
			else if (tryParse(choice) == null) {
				wrong = false;

			}
			// if the user entered a number not 1 or 2 it will ask for the number again
			else if (Integer.parseInt(choice) != 1 && Integer.parseInt(choice) != 2) {
				wrong = false;
				System.out.println(Integer.parseInt(choice));
			} else
				return Integer.parseInt(choice);

		}
		return 0;

	}

	// play method is created to be the starting of the program taking the names of
	// the players
	public void play() {
		String[][] arr = new String[rows][columns];
		players(arr);
		start(arr);
	}

	// start method is created to run the program in the sequence we want
	public static void start(String[][] arr) {
		// 1) the user choose coloured grid or Black and white grid
		int console = ChoiceConsole();
		// 2)grid is created and array is initialized
		grid(arr);
		// this for is used to center the grid in the middle of the console and to be in
		// a fixed
		// place everytime (Used as a clear console)
		for (int i = 0; i < 30; ++i) {
			System.out.println();
		}
		// 3)Displaying the grid the user wants either colored or black and white
		if (console == 1)
			ColoredConsolDisp.display(arr);

		else
			BWDisp.display(arr);
		// fixing the grid in the same place
		for (int i = 0; i < 7; ++i)
			System.out.println();

		int turn = 0;
		int winner = 0;
		// running the game until all squares are filled or until someone wins
		while (turn < rows * columns && winner == 0) {
			// player 1 plays even turns
			if (turn % 2 == 0) {
				// 4)Getting the place of the symbol X from player 1
				getInput(arr, p1.getSymbol(), p1.getName());

			}
			// 4')Getting the place of the symbol Y from player 2
			else
				getInput(arr, p2.getSymbol(), p2.getName());
			// to fix the console Display
			for (int i = 0; i < 30; ++i)
				System.out.println();
			// displaying the grid
			if (console == 1)
				ColoredConsolDisp.display(arr);

			else
				BWDisp.display(arr);
			for (int i = 0; i < 7; ++i)
				System.out.println();
			// 5)calling the method playerTurn form class Game to check for the logic and
			// return if
			// anyone wins
			winner = Game.playerTurn(arr, turn);
			turn++;
		}
		// 6) calling the method win to print for the user the message who wins
		messageWins(arr, winner);

	}

	// method Grid to initialize the Grid array with numbers from 1 to numbers of
	// squares
	public static void grid(String[][] arr) {
		int row, col, counter = 1;

		for (row = 0; row < arr.length; row++) {
			for (col = 0; col < arr[0].length; col++) {
				arr[row][col] = String.valueOf(counter);
				counter++;
			}
		}

	}

	// method to get the names of the players and welcome them
	public static void players(String[][] arr) {
		JOptionPane.showMessageDialog(null, " Welcome to our game, Have a nice game ");
		boolean cancel = false;
		String name1 = "";
		String name2 = "";

		while (!cancel) {
			name1 = JOptionPane.showInputDialog("Please Enter the name of first player(X): ");
			// if the user clicked ESC or cancel will get out of the program
			if (name1 == null) {
				JOptionPane.showMessageDialog(null, "GoodBye");

				System.exit(0);
			}
			// if the user entered an empty string he will be asked again for the name
			else if (!(name1.isEmpty()))
				cancel = true;

		}
		cancel = false;
		while (!cancel) {
			name2 = JOptionPane.showInputDialog("Please Enter the name of Second player(Y): ");
			if (name2 == null) {
				JOptionPane.showMessageDialog(null, "GoodBye");

				System.exit(0);
			} else if (!(name2.isEmpty()))
				cancel = true;

		}
		// setting the name and the score and the symbols for objects p1 and p2
		p1.setName(name1);
		p2.setName(name2);
		p1.setScore(0);
		p2.setScore(0);
		p1.setSymbol("X");
		p2.setSymbol("Y");
		// Message saying who will start
		JOptionPane.showMessageDialog(null, p1.getName() + "(X)" + " will start");

	}

	// method GetInput to show get the position the user want to put the symbol in
	public static void getInput(String[][] arr, String symbol, String pName) {

		int row, col;
		boolean choice = false;
		String position;
		while (!choice) {

			position = JOptionPane.showInputDialog(
					pName + " ,Please Enter the position you want to put (" + symbol + ") or 0 to restart the game");
			// if the user entered an empty string he will be asked again for the name

			if (position != null && !position.equals(""))
				;
			else {
				// if the user clicked ESC or cancel will get out of the program
				if (position == null) {

					JOptionPane.showMessageDialog(null, "GoodBye");
					System.out.println("Good Bye Nice play");
					System.exit(0);
				}

			}
			// if the user Enter zero the game will be restarted
			if (position.equals("0")) {

				System.out.println("The game is restarted Have a nice game");
				JOptionPane.showMessageDialog(null, "The game is restarted Have a nice game");
				start(arr);
			}
			// checking is the place the user wants is empty or not
			// if not empty then the user will be asked to enter another place
			for (row = 0; row < arr.length; row++) {
				for (col = 0; col < arr[0].length; col++) {

					if (arr[row][col].equals(position)) {
						choice = true;
						arr[row][col] = symbol;

						break;

					}
				}
			}
			if (choice) {
				break;
			} else {
				// if the user entered a string not number he will be asked to enter again
				if (tryParse(position) == null)
					choice = false;
				else {
					if (Integer.parseInt(position) <= rows * columns && Integer.parseInt(position) > 0) {
						JOptionPane.showMessageDialog(null, "This place is already occupied ");
						choice = false;
					} else

						JOptionPane.showMessageDialog(null, "Your input is invalid please enter a valid position");
				}
			}
		}

	}

//MessageWins method prints the message who win player 1 or player 2 or if the game is draw 
	public static void messageWins(String[][] arr, int winner) {

		if (winner == 0) {
			JOptionPane.showMessageDialog(null, "The game is Draw");
		} else if (winner == 1) {
			JOptionPane.showMessageDialog(null, p1.getName() + " wins, Congrats ");
			p1.setScore(p1.getScore() + 1);
		} else if (winner == 2) {
			JOptionPane.showMessageDialog(null, p2.getName() + " wins, Congrats ");
			p2.setScore(p2.getScore() + 1);
		}
		// print the sore and if the user want to replay again press 1
		String temp = JOptionPane.showInputDialog("score is " + p1.getName() + " " + p1.getScore() + " - "
				+ p2.getName() + " " + p2.getScore() + "\nEnter 1 to replay or else to Exit the game ");
		// any other key the game will be ended
		if (temp == null) {
			JOptionPane.showMessageDialog(null, "GoodBye");
			System.out.println("Good Bye Nice play");
			System.exit(0);
		}
		if (tryParse(temp) == null) {
			JOptionPane.showMessageDialog(null, "GoodBye");
			System.out.println("Good Bye Nice play");
			System.exit(0);
		}
		int ans = Integer.parseInt(temp);

		if (ans == 1) {
			start(arr);
		} else {
			JOptionPane.showMessageDialog(null, "GoodBye");
			System.out.println("Good Bye Nice play");
			System.exit(0);
		}

	}

// tryParse method to handle the error of if the user entered any string not numbers 
	public static Integer tryParse(String text) {
		try {
			return Integer.parseInt(text);
		} catch (NumberFormatException e) {
			return null;
		}
	}
}