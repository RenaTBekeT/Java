public class Bunnies {
    public static int countEars(int bunnies) {
        // Base case: If there are no bunnies, there are no ears
        if (bunnies == 0) {
            return 0;
        }

        // Recursive case: Each bunny contributes 2 ears
        // Call countEars(bunnies - 1) for the remaining bunnies
        return 2 + countEars(bunnies - 1);
    }

    public static void main(String[] args) {
        int totalEars = countEars(5);
        System.out.println(totalEars); // Output: 10
    }

}
