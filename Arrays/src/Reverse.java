import java.util.Arrays;

public class Reverse {
        public static void main(String[] args) {
            int[] numbers = {3, 4, 5, 6, 7};
            int[] numbersreversed = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                numbersreversed[i] = numbers[numbers.length - 1-i];
            }
            numbers = numbersreversed;
            System.out.println(Arrays.toString(numbers));
        }
    }
// - Create an array variable named `numbers`
//   with the following content: `[3, 4, 5, 6, 7]`
// - Reverse the order of the elements of `numbers` programmatically
// - Print the elements of the reversed `numbers`:
//   [7, 6, 5, 4, 3]

