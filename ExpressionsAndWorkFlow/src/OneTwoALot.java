package ExpressionsAndWorkFlow.src;
import java.sql.SQLOutput;
import java.util.Scanner;

public class OneTwoALot {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number");
        int number = input.nextInt();
        if (number <= 0) {
            System.out.println("Not enough");
        } else if (number == 1) {
            System.out.println("one");
        } else if (number == 2) {
            System.out.println("two");
        } else if (number > 2) {
            System.out.println("a lot");
        }
    }
}