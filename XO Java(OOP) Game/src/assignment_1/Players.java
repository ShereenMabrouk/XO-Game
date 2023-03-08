//Nourhan Mohamed Ahmed Mohamed Ismail 7153
//Shereen Mostafa Hassan Mabrouk       6844

package assignment_1;

// This class is designed to take the attributes of the 2 players by name score and 
// symbol either X or Y
public class Players {
	String name;
	int score;
	String symbol;

// Getters and setters are designed to get and set the values of the attributes
	public String getSymbol() {
		return symbol;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

}
