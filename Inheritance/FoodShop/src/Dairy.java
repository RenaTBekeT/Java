public class Dairy extends ShopItem {
    public Dairy(String name, double price, double preservativePercentage) {
        super(name, price, preservativePercentage);
    }

    @Override
    public int calculateFreshness() {
        if (getDaysInTheShop() > 5) {
            return 0;
        }
        if (getDaysInTheShop() > 3 && getDaysInTheShop() <= 5) {
            return 1;
        }
        if (getDaysInTheShop() <= 3) {
            return 2;
        }
        return getDaysInTheShop();
    }


        @Override
        public void reducePrice () {
            int freshness = calculateFreshness();
            if (freshness == 0) {
                double reducedPrice = price * 0.5;
                System.out.println("Old price: " + price);
                System.out.println("Reduced price (-50%): " + reducedPrice);
                price = Math.max(reducedPrice, 0);
            }
            if (freshness == 1) {
                double reducedPrice = price * 0.7;
                System.out.println("Old price: " + price);
                System.out.println("Reduced price (-30%): " + reducedPrice);
                price = Math.max(reducedPrice, 0);

            } else {
                System.out.println("Old price: " + price);
                System.out.println("Price is still same");

            }
        }

        @Override
        public String convertFreshnessToString () {
            int freshness = calculateFreshness();
            if (freshness == 0) {
                return "bad";
            }
            if (freshness == 1) {
                return "ok";
            }
            if (freshness == 2) {
                return "good";
            } else {
                throw new IllegalArgumentException("Unexpected freshness value: " + freshness);
            }
        }
    }