package ExpressionsAndWorkFlow.src;

import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        int storedNumber = 8;
        Scanner scanner = new Scanner(System.in);
        int guess = 0;
        while (guess != storedNumber) {
            System.out.println("Please enter your guess:");
            guess = scanner.nextInt();
            if (guess < storedNumber) {
                System.out.println("The stored number is greater than " + guess);
            } else if (guess > storedNumber) {
                System.out.println("The stored number is smaller than " + guess);
            } else {
                System.out.println("You have found the stored number " + storedNumber);
            }
        }
        scanner.close();
    }
}
// Write a program that stores a number and the user has to figure it out.
// The user can input guesses. After each guess the program responds
// with a message indicating whether the stored number is smaller or
// greater than the guess.
// The program ends (exits) when the user finds the stored number
//
// Example:
//
// Please enter your guess: 3
// The stored number is greater than 3
// Please enter your guess: 10
// The stored number is smaller than 10
// Please enter your guess: 8
// You have found the stored number 8
//