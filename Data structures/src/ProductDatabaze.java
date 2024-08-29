import javax.swing.*;
import java.sql.SQLOutput;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static java.util.Map.entry;

public class ProductDatabaze {
    public static void main(String[] args) {
        HashMap<String, Double> Procucts = new HashMap<>();
        Procucts.put("Eggs", 200.0);
        Procucts.put("Milk", 200.0);
        Procucts.put("Fish", 400.0);
        Procucts.put("Apples", 150.0);
        Procucts.put("Bread", 50.0);
        Procucts.put("Chicken", 550.0);

        System.out.println(Procucts.get("Fish"));

        String maxKey = null;
        Double maxValue = Double.MIN_VALUE;

        for (Map.Entry<String, Double> entry : Procucts.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxKey = entry.getKey();
                maxValue = entry.getValue();
            }
        }

        System.out.println(maxKey);

        Double average = 0.0;
        for (Double key : Procucts.values()) {
            average += key;
        }
        int size = Procucts.size();
        System.out.println(average / size);

        double j = 0;
        for (double i : Procucts.values()) {
            if (i < 300) {
                j++; }
        }
        System.out.println(j);

        if (Procucts.containsValue(125.0)) {
            System.out.println("yes");
        }
        else {
            System.out.println("no");
        }


        String minKey = null;
        double minValue = Integer.MAX_VALUE;

        for (HashMap.Entry<String, Double> entry : Procucts.entrySet()) {
            if(entry.getValue() < minValue) {
                minKey = entry.getKey();
                minValue = entry.getValue();
            }
        }
        System.out.println(minKey);



    }
}

