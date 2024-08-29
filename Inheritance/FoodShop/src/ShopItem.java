import java.io.IOException;

public class ShopItem {
    private String name;
    public double price;
    private double preservativePercentage;
    private int daysInTheShop;

    public ShopItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.preservativePercentage = 0;
        this.daysInTheShop = 0;
    }

    public ShopItem(String name, double price, double preservativePercentage) {
        this.name = name;
        this.price = price;
        this.preservativePercentage = preservativePercentage;
        this.daysInTheShop = 0;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getPreservativePercentage() {
        return preservativePercentage;
    }

    public int getDaysInTheShop() {
        return daysInTheShop;
    }

    public int calculateFreshness() {
        throw new UnsupportedOperationException("calculateFreshness() is not implemented in the base class.");
    }

    public void reducePrice() {
        throw new UnsupportedOperationException("reducePrice() is not implemented in the base class.");
        }

    public String convertFreshnessToString() {
        throw new UnsupportedOperationException("convertFreshnessToString() is not implemented in the base class.");
    }
    public void incrementDaysInTheShop() {
        daysInTheShop++;
    }
}
