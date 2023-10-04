import java.util.ArrayList;
public class TestPuzzleJava {
    
	public static void main(String[] args) {
		PuzzleJava generator = new PuzzleJava();
		ArrayList<Integer> randomRolls = generator.getTenRolls();
		System.out.println(randomRolls);
    	//..
		// Write your other test cases here.
		//..

		Character randomLetter = generator.getRandomLetter();
		System.out.println(randomLetter);

	String password = generator.generatePassword();
	System.out.println(password);

	int passwordListAmount = 8;
	ArrayList<String> newPasswords = generator.getNewPasswordSet(passwordListAmount);
	System.out.println(newPasswords);
	}

}