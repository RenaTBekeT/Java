import java.util.Random;
import java.util.Scanner;

public class GuessMyNumber {
    public static void main(String[] args) {
        Random random = new Random();
        int r = random.nextInt(0, 100);
        System.out.println(r);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Guess a number between 1 and 100");
        boolean guessedCorrectly = false;

        while (!guessedCorrectly) {
            int number = scanner.nextInt();

            if (number == r) {
                guessedCorrectly = true;
                System.out.println("Congratulations. You've won!");
            } else if (number < r) {
                System.out.println("Too low. Try again:");
            } else {
                System.out.println("Too high. Try again:");
            }
        }
    }
}


