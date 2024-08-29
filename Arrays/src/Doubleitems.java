import java.util.Arrays;

class DoubleItems {
    public static void main(String[] args) {
        int [] numbers = {3, 4, 5, 6, 7};
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = numbers[i] * 2;
        }
        System.out.println(Arrays.toString(numbers));
    }
}
// - Create an array variable named `numbers`
//   with the following content: `[3, 4, 5, 6, 7]`
// - Double all the values in the array and print the modified
//   array to the console as:
//   [6, 8, 10, 12, 14]