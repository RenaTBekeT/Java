public class Vegetable extends ShopItem {
    public Vegetable(String name, double price) {
        super(name, price, 0);
    }

    @Override
    public int calculateFreshness() {
        if (getDaysInTheShop() > 3) {
            return 0;
        }
        if (getDaysInTheShop() > 1 && getDaysInTheShop() <= 3) {
            return 1;
        }
        if (getDaysInTheShop() <= 1) {
            return 2;
        }
        return getDaysInTheShop();
    }



    @Override
    public void reducePrice() {
        int freshness = calculateFreshness();
        if (freshness == 0) {
            double reducedPrice = getPrice() * 0.6;
            System.out.println("Old price: " + price);
            System.out.println("Reduced price (-40%): " + reducedPrice);
            price = Math.max(reducedPrice, 0);
        } else if (freshness == 1) {
            double reducedPrice = getPrice() * 0.8;
            System.out.println("Old price: " + price);
            System.out.println("Reduced price (-20%): " + reducedPrice);
            price = Math.max(reducedPrice, 0);
        }  else {
            System.out.println("Old price: " + price);
            System.out.println("Price is still same!");
        }
    }
    @Override
    public String convertFreshnessToString() {
        int freshness = calculateFreshness();
        switch (freshness) {
            case 0:
                return "bad";
            case 1:
                return "ok";
            case 2:
                return "good";
            default:
                throw new IllegalArgumentException("Unexpected freshness value: " + freshness);
        }
    }
}
