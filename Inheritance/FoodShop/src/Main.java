import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop();
        ShopItem pork = new Vegetable("Pork", 20);
        ShopItem milk = new Dairy("Milk", 30, 1);
        ShopItem onion = new Vegetable("Onion", 25);
        ShopItem Yogurt = new Dairy("Yogurt", 10, 1);

        shop.fillstock(pork);
        shop.fillstock(milk);
        shop.fillstock(onion);
        shop.fillstock(Yogurt);
        System.out.println(shop.showStock());
        shop.closeshop();
        System.out.println();
        shop.closeshop();



    }
}