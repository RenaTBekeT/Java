import java.util.Arrays;

public class IncrementElement {
    public static void main(String[] args) {
        int [] numbers  = {1,2,3,4,5};
        numbers [3] = numbers [3] + 1;
        System.out.println(numbers[3]);
        System.out.println(Arrays.toString(numbers)); // print all elements

        for (int i = 0; i < numbers.length; i++) { // Increment all elements by 10
            numbers[i] = numbers[i] + 10;
        }
        System.out.println(Arrays.toString(numbers));
    }
}
// - Create an array variable named `numbers`
//   with the following content: `[1, 2, 3, 4, 5]`
// - Increment the third element
// - Print the third element