package ExpressionsAndWorkFlow.src;
import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number");
        int number1 = input.nextInt();
        int numbers = 1;
        while (numbers <= 10) {
            System.out.println(numbers * number1);
            numbers += 1;
        }
    }
}
// Create a program which prints the multiplication table for a specified
// number
//
// Example:
// The number 15 should print:
//
// 1 * 15 = 15
// 2 * 15 = 30
// 3 * 15 = 45
// 4 * 15 = 60
// 5 * 15 = 75
// 6 * 15 = 90
// 7 * 15 = 105
// 8 * 15 = 120
// 9 * 15 = 135
// 10 * 15 = 150