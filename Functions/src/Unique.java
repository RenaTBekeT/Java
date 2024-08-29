import java.util.ArrayList;
import java.util.Arrays;

public class Unique {
    public static void main(String[] args) {
        // Create a function that takes an array of numbers as a parameter
        // and returns an array of integers where every integer is unique
        // (occurs only once)

        // Example
        System.out.println(Arrays.toString(findUniqueItems(new int[]{1, 11, 34, 11, 52, 61, 1, 34})));
        // should print: `[1, 11, 34, 52, 61]`
    }

    public static int[] findUniqueItems(int[] notUnique) {
        ArrayList<Integer> unique = new ArrayList<>();
        for (int i = 0; i < notUnique.length; i++) {
            if (!unique.contains(notUnique[i])) {
                unique.add(notUnique[i]);
            }
        }
        int[] allUnique = new int[unique.size()];
        for (int i = 0; i < unique.size(); i++) {
            allUnique[i] = unique.get(i);
        }
        return allUnique;
    }
}