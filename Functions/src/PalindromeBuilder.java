public class PalindromeBuilder {
    public static void main(String[] args) {
        System.out.println(build(""));
    }

    public static String build(String word) {
        String reverse = "";
        for (int i = word.length() - 1; i >= 0; i--) {
        reverse = reverse + word.charAt(i);
        }
        return word + reverse;
    }
}
