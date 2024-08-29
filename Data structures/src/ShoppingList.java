import java.util.ArrayList;
import java.util.Collections;

public class ShoppingList {
    public static void main(String[] args) {

        ArrayList<String> shopping = new ArrayList<>();
        Collections.addAll(shopping, "eggs", "milk", "fish", "apples", "bread", "chicken");
        cart(shopping);
    }

    public static void cart(ArrayList<String> shopping) {

        for (int i = 0; i < shopping.size(); i++) {

        }
        if (shopping.contains("milk")) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

        for (int i = 0; i < shopping.size(); i++) {

        }
        if (shopping.contains("bananas")) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}




