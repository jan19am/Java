import java.util.ArrayList;
import java.util.Random;

public class PuzzleJava {

    public ArrayList<Integer> getTenRolls() {
        Random random = new Random();
        ArrayList<Integer> num = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            num.add(random.nextInt(20)+1);
        }
        return num;
    }


    public Character getRandomLetter() {
		Character alphabet[] = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 
            'h', 'i', 'j', 'k', 'l', 'm', 'n', 
            'o', 'p', 'q', 'r', 's', 't', 'u', 
            'v', 'w', 'x', 'y', 'z'
        };
        Random random = new Random();
        int index = random.nextInt(25);
        return alphabet[index];
    }

    public String generatePassword() {
		String alphabet[] = {
            "a", "b", "c", "d", "e", "f", "g", "h",
            "i", "j", "k", "l", "m", "n", "o", "p",
            "q", "r", "s", "t", "u", "v", "w", "x",
            "y", "z"
        };
        Random random = new Random();
        String sumOfLetters = new String();
        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(25);
            sumOfLetters = sumOfLetters + alphabet[index];
        }
        return sumOfLetters;
    }

    public ArrayList<String> getNewPasswordSet(int passwordListAmount) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < passwordListAmount; i++) {
            list.add(this.generatePassword());
        }
        return list;
    }
}