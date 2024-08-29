import java.util.Scanner;

public class NumberAdder {
    public static void main(String[] args) {

       int result = numberAdder(5);
        System.out.println(result);
    }

    public static int numberAdder(int i) {
        if (i < 1) {
            return 0;
        } else {
            return i + numberAdder(i - 1);
        }
    }

}


// Implement "numberAdder" which is a recursive function that takes one parameter: n (number)
// and returns the sum of integers from 1 to n.
// The function should return 0 for inputs less than 1.




