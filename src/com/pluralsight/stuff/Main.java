package com.pluralsight.stuff;

import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        int turns = 6;

        char[] letters = getWord().toCharArray();
        char[] result = new char[letters.length];
        for(int i = 0; i < letters.length; i++){
            result[i] = '-';
        }

        while(turns > 0) {
            printResult(result);

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

            System.out.println("Guess a letter or type your guess: ");
            char[] userGuess = inputReader.nextLine().toLowerCase().toCharArray();

            if(userGuess.length > 1){
                if(userGuess.length == letters.length){
                    boolean guessedCorrectly = false;

                    if (Arrays.equals(userGuess, letters)) {
                        result = userGuess;
                        guessedCorrectly = true;
                    }

                    if(!guessedCorrectly){
                        System.out.println("Incorrect guess");
                        turns--;
                    }
                } else {
                    System.out.println("Incorrect guess");
                    turns--;
                }
            } else if(Character.isLetter(userGuess[0])){
                boolean hasLetter = false;

                int place = -1;
                for (char letter : letters) {
                    place++;
                    if (userGuess[0] == letter) {
                        result[place] = userGuess[0];
                        hasLetter = true;
                    }
                }

                if (!hasLetter) {
                    System.out.print("The word does not contain ");
                    System.out.println(userGuess[0]);
                    turns--;
                }
            } else {
                System.out.println("Invalid guess");
            }


            if(turns == 0 && !isComplete){
                System.out.println("Sorry! You did not guess the word.");
                System.out.print("The word was ");
                System.out.println(letters.toString());
            }

            System.out.println(" ");
        }
        inputReader.close();
    }

    private static String getWord() {
        int number = (int)(Math.random() * 201);
        String computer = " ";

        try {
            File choices = new File("C:\\Users\\Hania\\IdeaProjects\\Hangman\\src\\com\\pluralsight\\stuff\\words.txt");
            Scanner reader = new Scanner(choices);
            for (int i = 0; i < 200; i++) {
                if (reader.hasNextLine()) {
                    String word = reader.nextLine();
                    if (i == number) {
                        computer = word;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return computer;
    }

    private static void printResult(char[] result) {
        System.out.println("This is the word:");
        for(char r : result){
            System.out.print(r);
        }
        System.out.println(" ");
    }

}
