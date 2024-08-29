import javax.swing.*;
import java.util.Scanner;

public class PalindromeSearcher {
    public static void main(String[] args) {
        System.out.println(isPalindrome("racecar"));
    }

    public static boolean isPalindrome(String word) {
        String reverse = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            reverse = reverse + word.charAt(i);
        }
        if (reverse.equals(word)) {
            return true;
        } else return false;
    }
}










