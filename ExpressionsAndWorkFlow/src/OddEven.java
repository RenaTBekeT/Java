package ExpressionsAndWorkFlow.src;
import java.util.Scanner;

public class OddEven {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int times = 100;
        for (int i = 0; i < times; i++) {

            System.out.println("Enter the number");
            int number = input.nextInt();
            if (number % 2 == 0)
                System.out.println("even");
            else
                System.out.println("odd");
        }
    }
}
// Write a program that reads a number from the standard input,
// then prints "Odd" if the number is odd, or "Even" if it is even
//
// Please enter a number: 7
// Odd
// do it multiple times