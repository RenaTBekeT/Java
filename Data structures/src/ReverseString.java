public class ReverseString {
    public static void main(String... args) {
        // Create a method that can reverse a string which is passed as parameter
        // The method should return the reversed string
        // Pass the `toBeReversed` variable to this method to check if it works well
        // At first, solve this task using the `charAt()` function
        // Try other solutions when you are done
        String reversed = ".eslaf eb t'ndluow ecnetnes siht ,dehctiws erew eslaf dna eurt fo sgninaem eht fI";
        String correct = "";

        for (int i = 0; i < reversed.length(); i++) {
            correct = reversed.charAt(i) + correct;
        }


        System.out.println(correct);
    }
}