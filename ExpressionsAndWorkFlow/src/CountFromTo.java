package ExpressionsAndWorkFlow.src;
import java.util.Scanner;

public class CountFromTo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number 1");
        int number1 = input.nextInt();

        System.out.println("Enter the number 2");
        int number2 = input.nextInt();

        if (number2 < number1) {
            System.out.println("The second number should be bigger");
        } else {      //3        6//
            while (number1 < number2) {
                System.out.println(number1);
                number1++;
            }
        }
    }
}
// Create a program that asks for two numbers. If the second number
// is not greater than the first the program should print:
// "The second number should be bigger"
//
// Otherwise it should output all integers between the first and
// the second number (excluding the second number)
//
// Example:
//
// Please enter the first number: 3
// Please enter the second number: 6
// 3
// 4
// 5
