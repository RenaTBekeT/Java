import java.util.HashMap;
import java.util.Map;

public class ProductDatabase2 {
    public static void main(String[] args) {
        HashMap<String, Integer> products = new HashMap<>();
        products.put("Eggs", 200);
        products.put("Milk", 200);
        products.put("Fish", 400);
        products.put("Apples", 150);
        products.put("Bread", 50);
        products.put("Chicken", 550);

        for (Map.Entry<String, Integer> allFood : products.entrySet()) {
            if (allFood.getValue() < 201) {
                System.out.println(allFood.getKey());
            }
        }
        for (Map.Entry<String, Integer> allFood : products.entrySet()) {
            if (allFood.getValue() > 150) {
                System.out.println(allFood.getKey() + " " + allFood.getValue());
            }
        }
    }
}