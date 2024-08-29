package ExpressionsAndWorkFlow.src;
import java.util.Scanner;

public class PrintBigger {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number 1");
        int number1 = input.nextInt();
        System.out.println("Enter the number 2");
        int number2 = input.nextInt();

        if (number1 < number2) {
            System.out.println(number2);
        } else if (number1 > number2) {
            System.out.println(number1);
        }
    }
}