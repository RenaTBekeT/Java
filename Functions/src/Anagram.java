import java.util.Arrays;

public class Anagram {
    public static void main(String[] args) {
        boolean result = isAnagram("Astronomer", "Moon starer!");
        System.out.println(result);
    }

    public static boolean isAnagram(String string1, String string2) {
        string1 = string1.replaceAll("[^a-zA-Z0-9]", "");
        string2 = string2.replaceAll("[^a-zA-Z0-9]", "");

        string1 = string1.toLowerCase();
        string2 = string2.toLowerCase();

        if (string1.length() == string2.length()) {
            char[] string1chars = string1.toCharArray();
            char[] string2chars = string2.toCharArray();
            Arrays.sort(string1chars);
            Arrays.sort(string2chars);
            return Arrays.equals(string1chars, string2chars);
        } else {
            return false;
        }
    }
}
