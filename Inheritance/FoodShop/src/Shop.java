import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<ShopItem> stock;

    public Shop() {
        this.stock = new ArrayList<>();
    }

    public Shop(List<ShopItem> stock) {
        this.stock = stock;
    }

    public void fillstock(ShopItem shopItem) {
        stock.add(shopItem);
    }

    public List<String> showStock() {
        List<String> listOfInfo = new ArrayList<>();
        for (int i = 0; i < stock.size(); i++) {
            ShopItem item = stock.get(i);
            String iteminfo = ((i + 1) + ", Item: " + item.getName() + ", " + item.getPrice() + ", " + item.convertFreshnessToString());
            listOfInfo.add(iteminfo);
        }
        return listOfInfo;
    }

    public double getStockValue() {
        double sum = 0;
        for (int i = 0; i < stock.size(); i++) {
            ShopItem item = stock.get(i);
            sum += item.price;
        }
        return sum;
    }

    public void sellItems(double amount, Boolean superHealthy) {
        if (superHealthy) {
            for (int i = 0; i < stock.size(); i++) {
                ShopItem item = stock.get(i);
                if (item.calculateFreshness() == 2 && item.getPreservativePercentage() < 2) {
                    if (amount >= item.price) {
                        stock.remove(i);
                    }
                }
            }
        } else {
            for (int i = 0; i < stock.size(); i++) {
                ShopItem item = stock.get(i);
                if(amount >= item.price) {
                    stock.remove(i);
                }

            }
        }
    }
    public void closeshop() {
        for (int i = 0; i < stock.size(); i++) {
            ShopItem item = stock.get(i);
            item.incrementDaysInTheShop();
            item.calculateFreshness();
            System.out.println(item.getName() + ": ");
            item.reducePrice();
        }
    }
}


