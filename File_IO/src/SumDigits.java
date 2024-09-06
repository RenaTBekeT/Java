import java.util.Scanner;

public class SumDigits {
    public static void main(String[] args) {

        int sum = sumDigits(126);
        System.out.println(sum);
    }

    public static int sumDigits(int i) {
        {
            if (i < 10) {
                return i;
            } else {
                return i % 10 + sumDigits(i/10 );
            }
        }

    }
}