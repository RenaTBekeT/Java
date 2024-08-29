import java.util.Arrays;

public class SumElements {
    public static void main(String[] args) {
        int [] numbers = {54, 23, 66, 12};
        int [] multipleFive = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            multipleFive[i] = numbers[i] * 5;
        }
        System.out.println(Arrays.toString(multipleFive));
    }
}
// - Create an array variable named `numbers`
//   with the following content: `[54, 23, 66, 12]`
// - Print the sum of the second and the third element
// - i make it multiple five its more intersting