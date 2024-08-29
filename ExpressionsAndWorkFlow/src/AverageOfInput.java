package ExpressionsAndWorkFlow.src;

import java.util.Scanner;

public class AverageOfInput {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the first number");
        int number1 = input.nextInt();

        System.out.println("Enter the second number ");
        int number2 = input.nextInt();

        System.out.println("Enter the third ");
        int number3 = input.nextInt();

        System.out.println("Enter the fourth number ");
        int number4 = input.nextInt();

        System.out.println("Enter the fifth number ");
        int number5 = input.nextInt();

        int sum = (number1 + number1 + number3 + number4 + number5);
        int average = ((number1 + number2 + number3 + number4 + number5) / 5);
        System.out.print("sum is: " + sum + " and avarage is " + average);
        input.close();
    }
}
// Write a program prompts the user for 5 integers in a row,
// then it prints their sum and their average:
//
// Please enter a number: 3
// Please enter a number: 7
// Please enter a number: 1
// Please enter a number: 6
// Please enter a number: 5
// Sum: 22, Average: 4.4
//