//Nourhan Mohamed Ahmed Mohamed Ismail 7153
//Shereen Mostafa Hassan Mabrouk       6844

package assignment_1;

// Class Game is the logic class of the Game it contains all the methods of checking 3 same consecutive 
// symbols (Horizontal - Vertical or Diagonal)

public class Game {
	// rows and columns are initialized as constants they can be changed to any
	// number to have the size
	// of Grid the user want
	static final int ROWS = 6;
	static final int COLUMNS = 7;
	// p1 and p2 are objects of the class Players to get the data of the 2 Players
	static Players p1 = new Players();
	static Players p2 = new Players();

    // horizontalCheck method used to check the board if there exist 3 Same consecutive symbols horizontally
	public static boolean horizontalCheck(String[][] arr, String symbol) {
		int row, col;
		// looping over the all rows of board to check for same symbols and looping over
		// all columns-2
		// so as not to be out of range
		for (row = 0; row < arr.length; row++) {
			for (col = 0; col < arr[0].length - 2; col++) {

				if (arr[row][col].equals(symbol) && arr[row][col + 1].equals(symbol)
						&& arr[row][col + 2].equals(symbol)) {
     // if found 3 Same consecutive symbols the function return true 
					return true;

				}
			}
		}
  // if not found it will return false 
		return false;
	}

  // verticalCheck method used to check the board if there exist 3 Same consecutive symbols vertically
	public static boolean verticalCheck(String[][] arr, String symbol) {
		int row, col;
		// looping over the all columns of board to check for same symbols and looping
		// over all rows-2
		// so as not to be out of range
		for (row = 0; row < arr.length - 2; row++) {
			for (col = 0; col < arr[0].length; col++) {

				if (arr[row][col].equals(symbol) && arr[row + 1][col].equals(symbol)
						&& arr[row + 2][col].equals(symbol)) {
					// if found 3 Same consecutive symbols the function return true
					return true;

				}
			}
		}
		// if not found it will return false
		return false;
	}

	// diagonalRcheck method used to check the board if there exist 3 Same
	// consecutive symbols in Right Diagonal (upwards)
	public static boolean diagonalRCheck(String[][] arr, String symbol) {
		int row, col;
		// looping over the all columns-2 of board to check for same symbols and looping
		// over all rows-2
		// so as not to be out of range
		for (row = 0; row < arr.length - 2; row++) {
			for (col = 0; col < arr[0].length - 2; col++) {

				if (arr[row][col].equals(symbol) && arr[row + 1][col + 1].equals(symbol)
						&& arr[row + 2][col + 2].equals(symbol)) {
					// if found 3 Same consecutive symbols the function return true
					return true;

				}
			}
		}
		// if not found it will return false
		return false;
	}

	// diagonalLcheck method used to check the board if there exist 3 Same
	// consecutive symbols in Left Diagonal (downwards)
	public static boolean diagonalLCheck(String[][] arr, String symbol) {
		int row, col;
		// looping over the all rows of board to check for same symbols and looping over
		// all col-2
		// so as not to be out of range
		for (row = 2; row < arr.length; row++) {
			for (col = 0; col < arr[0].length - 2; col++) {

				if (arr[row][col].equals(symbol) && arr[row - 1][col + 1].equals(symbol)
						&& arr[row - 2][col + 2].equals(symbol)) {
					// if found 3 Same consecutive symbols the function return true
					return true;

				}
			}
		}
		// if not found it will return false
		return false;
	}

	// playerTurn method to control who will play (whose turn it is)
	public static int playerTurn(String[][] arr, int turn) {
		// whoWin varible is the number of the player who won the game if it is equal 1
		// then player 1 won
		// if 2 means that player 2 won if zero then the game is draw
		int whoWin = 0;
		boolean win = false;
		// turn is the number of plays done before someone win or the game is draw
		// if turn mod 2 is zero then its player 1 turn means that player 1 plays the
		// even turn and
		// player 2 plays the odd turns
		if (turn % 2 == 0) {
			// win holds the value of the isWinner method (which checks the board if 3
			// consecutive same symbol found)
			// if win holds true then player 1 won
			win = isWinner(arr, p1.getSymbol());
			if (win)
				whoWin = 1;
		} else {
        // if turn is odd number then is was player 2's turn and if win is true then player 2 won
			win = isWinner(arr, p2.getSymbol());
			if (win)
				whoWin = 2;
		}
		// increasing turn by 1 to be ready for the next play
		turn++;
		// if turns reached its max (means that all the squares are filled) and win
		// still holds false the function return 0
		// which means that the game is draw
		if (turn >= ROWS * COLUMNS && !win)
			return 0;
		return whoWin;
	}

     // isWinner method check for all the logic methods (horizontalCheck,verticalCheck,diagonalRcheck,diagonalLcheck)
	// and if any function returns true isWinner returns true
	public static boolean isWinner(String[][] arr, String symbol) {
		boolean win = false;
		if (!win)
			win = horizontalCheck(arr, symbol);
		else
			return win;
		if (!win)
			win = verticalCheck(arr, symbol);
		else
			return win;
		if (!win)
			win = diagonalRCheck(arr, symbol);
		else
			return win;
		if (!win)
			win = diagonalLCheck(arr, symbol);
		else
			return win;
		return win;

	}
}
