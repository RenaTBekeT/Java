import java.util.Arrays;

public class Bubble {
    public static void main(String[] args) {
        // Create a function that takes an array of numbers as parameter
        // and returns an array where the elements are sorted in ascending numerical
        // order
        // When you are done, add a second boolean parameter to the function
        // If it is `true` sort the array descending, otherwise ascending

        // Example:
        System.out.println(Arrays.toString(bubble(new int[]{34, 12, 24, 9, 5})));
        // should print [5, 9, 12, 24, 34]
        System.out.println(Arrays.toString(advancedBubble(new int[]{34, 12, 24, 9, 5}, false)));
        // should print [34, 24, 12, 9, 5]
    }

    public static int[] bubble(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // swap array[j+1] and array[j]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    public static int[] advancedBubble(int[] array, boolean ascending) {
        if (ascending) {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length - i - 1; j++) {
                    if (array[j] > array[j + 1]) {
                        // swap array[j+1] and array[j]
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }
            }
        } else {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length - i - 1; j++) {
                    if (array[j] < array[j + 1]) {
                        // swap array[j+1] and array[j]
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }
            }
        }
        return array;
    }
}