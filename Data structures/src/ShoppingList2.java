import java.util.HashMap;

public class ShoppingList2 {
    public static void main(String[] args) {
        HashMap<String, Double> prices = new HashMap<>();
        prices.put("milk", 1.07);
        prices.put("Rice", 1.59);
        prices.put("Eggs", 3.14);
        prices.put("Cheese", 12.6);
        prices.put("Chicken Breasts", 9.40);
        prices.put("Apples", 2.31);
        prices.put("Tomato", 2.58);
        prices.put("Potato", 1.75);
        prices.put("Onion", 1.10);

        HashMap<String, Double> bob = new HashMap<>();
        bob.put("milk", 3.0);
        bob.put("Rice", 2.0);
        bob.put("Eggs", 2.0);
        bob.put("Cheese", 1.0);
        bob.put("Chicken Breasts", 4.0);
        bob.put("Apples", 1.0);
        bob.put("Tomato", 2.0);
        bob.put("Potato", 1.0);


        HashMap<String, Double> alice = new HashMap<>();
        alice.put("Tomato", 10.0);
        alice.put("Rice", 1.0);
        alice.put("Eggs", 5.0);
        alice.put("Apples", 1.0);
        alice.put("Chicken Breasts", 2.0);


        double bob1 = getCost(prices, bob);
        System.out.println(bob1);
        double alice1 = getCost(prices, alice);
        System.out.println(alice1);


        moreFood(bob, "Rice", alice);
        moreFood(bob, "Potato", alice);


        hasHam(bob, alice);
        hasApples(bob, alice);
        whoBuysMore(bob, alice);
        MorePcs(bob, alice);
    }

    private static void MorePcs(HashMap<String, Double> bob, HashMap<String, Double> alice) {
        double bobmorepcs = 0;
        for (double key : bob.values()) {
            bobmorepcs += key;
        }

        double alicemorepcs = 0;
        for (double key : alice.values()) {
            alicemorepcs += key;
        }

        if (bobmorepcs > alicemorepcs) {
            System.out.println("bob");
        } else {
            System.out.println("alice");
        }
    }

    private static void whoBuysMore(HashMap<String, Double> bob, HashMap<String, Double> alice) {
        int bobbuysmore = bob.size();
        int alicebuysmore = alice.size();
        if (bobbuysmore > alicebuysmore) {
            System.out.println("bob");
        } else {
            System.out.println("alice");
        }
    }

    private static void hasApples(HashMap<String, Double> bob, HashMap<String, Double> alice) {
        if (bob.containsKey("Apples") || alice.containsKey("Apples")) {
            double applesbob = bob.get("Apples");
            double applesalice = alice.get("Apples");
            if (applesbob > applesalice) {
                System.out.println("bob");
            } else if (applesbob == applesalice) {
                System.out.println("none");
            } else {
                System.out.println("alice");
            }
        }
    }

    private static void hasHam(HashMap<String, Double> bob, HashMap<String, Double> alice) {
        if (bob.containsKey("Ham") || alice.containsKey("Ham")) {
            moreFood(bob, "Ham", alice);
        } else {
            System.out.println("none");
        }
    }

    private static void moreFood(HashMap<String, Double> bob, String food, HashMap<String, Double> alice) {
        if (!alice.containsKey(food)) {
            System.out.println("bob");
            return;
        }

        if (!bob.containsKey(food)) {
            System.out.println("alice");
            return;
        }
        double ricebob = bob.get(food);
        double ricealice = alice.get(food);


        if (ricebob > ricealice) {
            System.out.println("bob");
        } else {
            System.out.println("alice");
        }
    }



    private static double getCost(HashMap<String, Double> prices, HashMap<String, Double> bob) {
        HashMap<String, Double> result = new HashMap<>();
        for (String key : prices.keySet()) {
            if (bob.containsKey(key)) {
                result.put(key, prices.get(key) * bob.get(key));
            }
        }

        double bob1 = 0;
        for (double key : result.values()) {
            bob1 += key;
        }
        return bob1;
    }
}
















