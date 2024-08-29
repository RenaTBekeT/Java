package ExpressionsAndWorkFlow.src;
import java.util.*;

public class HelloUser {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.print("Enter your name:");
        String str= scanner.nextLine();
        System.out.println("hello" + str);
    }
}
// Modify this program to greet the User instead of the World!
// The program should ask for the name of the User
//
// Example:
//
// Please enter your name: John Doe
// Hello, John Doe!
//