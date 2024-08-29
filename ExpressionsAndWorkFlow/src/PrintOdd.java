package ExpressionsAndWorkFlow.src;
import java.util.Scanner;

public class PrintOdd {
    public static void main(String[] args) {
        Scanner number1 = new Scanner(System.in);
        int number = number1.nextInt();

        if (number % 2 == 0) {
            System.out.println("even");
        } else {
            System.out.println("odd");
        }
    }
}
// Write a program that reads a number from the standard input,
// then prints "Odd" if the number is odd, or "Even" if it is even
//
// Please enter a number: 7
// Odd