package com.greenfoxacademy.basicwebshop.services;

import com.greenfoxacademy.basicwebshop.models.ShopItem;
import org.springframework.stereotype.Service;;
import java.util.*;

@Service
public class ShopService {
    private List<ShopItem> items;

    public ShopService() {
        items = new ArrayList<>();
        items.add(new ShopItem("Running shoes", "Clothes and Shoes", "Nike running shoes for every day sport", 1000.0, 5));
        items.add(new ShopItem("Printer", "Electronics", "Some HP printer that will print pages", 3000.0, 2));
        items.add(new ShopItem("Coca cola", "Beverages and Snacks", "0.5 standart coke", 25.0, 0));
        items.add(new ShopItem("Wokin", "Beverages and Snacks", "Chicken with fried rice and WOKIN sauce", 119.0, 100));
        items.add(new ShopItem("T-shirt", "Clothes and Shoes", "Blue with a corgi on a bike", 300.0, 1));
    }

    public List<ShopItem> getAllProducts() {
        return items;
    }

    public List<ShopItem> getOnlyAvailable() {
        List<ShopItem> availables = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getQuantityOfStock() > 0) {
                availables.add(items.get(i));
            }
        }
        return availables;
    }

    public List<ShopItem> contains(String searchedWord) {
        List<ShopItem> founded = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().contains(searchedWord) || items.get(i).getDescription().contains(searchedWord)) {
                founded.add(items.get(i));
            }
        }
        return founded;
    }

    public List<ShopItem> containsNike() {
        List<ShopItem> containsNikes = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().contains("Nike") || items.get(i).getDescription().contains("Nike")) {
                containsNikes.add(items.get(i));
            }
        }
        return containsNikes;
    }

    public double averageStock() {
        double average = 0;
        for (int i = 0; i < items.size(); i++) {
            average += items.get(i).getQuantityOfStock();
        }
        return average / items.size();
    }

    public List<ShopItem> mostExpensive() {
        List<ShopItem> mostExpensives = new ArrayList<>();
        ShopItem mostexpensive = items.get(0);
        for (int i = 1; i < items.size(); i++) {
            if (items.get(i).getPrice() > mostexpensive.getPrice()) {
                mostexpensive = items.get(i);
                mostExpensives.add(mostexpensive);
            }
        }
        return mostExpensives;
    }

    public List<ShopItem> cheapestFirst() {
        Comparator<ShopItem> priceComparator = new Comparator<ShopItem>() {
            @Override
            public int compare(ShopItem item1, ShopItem item2) {
                return Double.compare(item1.getPrice(), item2.getPrice());
            }
        };
        Collections.sort(items, priceComparator);
        ArrayList<ShopItem> sortedItems = new ArrayList<>(items);
        return sortedItems;
    }

    public List<ShopItem> clothesAndShoes() {
        List<ShopItem> clothesandshoes = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getType().contains("Clothes and Shoes")) {
                clothesandshoes.add(items.get(i));
            }
        }
        return clothesandshoes;
    }

    public List<ShopItem> electronics() {
        List<ShopItem> eletronics = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getType().contains("Electronics")) {
                eletronics.add(items.get(i));
            }
        }
        return eletronics;
    }

    public List<ShopItem> snacks() {
        List<ShopItem> snacks = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getType().contains("Snacks")) {
                snacks.add(items.get(i));
            }
        }
        return snacks;
    }

    public List<ShopItem> euroCurency() {
        List<ShopItem> euroCurency = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            // items.get(i).setPrice(items.get(i).getPrice() / 25);
            ShopItem item = items.get(i);
            ShopItem shopItem = new ShopItem(item.getName(), item.getType(), item.getDescription(), item.getPrice() / 25, item.getQuantityOfStock());
            euroCurency.add(shopItem);
        }
        return euroCurency;
    }

    public List<ShopItem> originalCurency() {
        return items;
    }

    public List<ShopItem> above(int aboveNumber) {
        List<ShopItem> aboveItems = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getPrice() >= aboveNumber) {
                aboveItems.add(items.get(i));
            }
        }
        return aboveItems;
    }

    public List<ShopItem> typeUrl(String url) {
        List<ShopItem> foundByUrl = new ArrayList<>();
        url = url.toLowerCase();
        for (int i = 0; i < items.size(); i++) {
            String type = items.get(i).getType().replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
            if (type.equals(url)) {
                foundByUrl.add(items.get(i));
            }
        }
        return foundByUrl;
    }

    public List<ShopItem> below(int aboveNumber) {
        List<ShopItem> belowItems = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getPrice() <= aboveNumber) {
                belowItems.add(items.get(i));
            }
        }
        return belowItems;
    }

    public List<ShopItem> exatly(int aboveNumber) {
        List<ShopItem> exatlyItems = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getPrice() == aboveNumber) {
                exatlyItems.add(items.get(i));
            }
        }
        return exatlyItems;
    }
}


