
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int turns = 6;
        String[] choices = {"cannon", "muscles", "giraffe", "pellets", "vibrate"};
        int arrayLength = choices.length;
        int number = (int)(Math.random() * (arrayLength));
        String computer = choices[number];
        char[] letters = computer.toCharArray();

        char[] result = new char[letters.length];
        for(int i = 0; i < letters.length; i++){
            result[i] = '-';
        }

        while(turns > 0) {
            System.out.println("This is the word:");
            for(int i = 0; i < letters.length; i++){
                System.out.print(result[i]);
            }
            System.out.println(" ");

            boolean isComplete = true;
            for(char letter:result){
                if(letter == '-') {
                    isComplete = false;
                }
            }

            if(isComplete){
                System.out.println("Congrats!");
                break;
            }

            System.out.print("You have ");
            System.out.print(turns);
            System.out.println(" turns left.");

            System.out.println("Guess a letter: ");
            Scanner inputReader = new Scanner(System.in);
            char userGuess = inputReader.nextLine().charAt(0);

            boolean hasLetter = false;
            int place = -1;
            for (char letter : letters) {
                place++;
                if (userGuess == letter) {
                    result[place] = userGuess;
                    hasLetter = true;
                }
            }

            if (!hasLetter) {
            	System.out.print("The word does not contain ");
            	System.out.println(userGuess);
            	turns--;
            }
           
            if(turns == 0 && !isComplete){
                System.out.println("Sorry! You did not guess the word.");
                System.out.print("The word was ");
                System.out.println(computer);
            }
        }
	}
}
