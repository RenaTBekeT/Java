import java.util.HashMap;
import java.util.Map;


public class MapIntroduction2 {

    public static void main(String[] args) {


        HashMap<String, String> values = new HashMap<>();

        values.put("978-1-60309-452-8", "A Letter to Jo");
        values.put("978-1-60309-459-7", "Lupus");
        values.put("978-1-60309-444-3", "Red Panda and Moon Bear");
        values.put("978-1-60309-461-0", "The Lab");

        for (HashMap.Entry<String, String> entry : values.entrySet()) {
            System.out.println(entry.getValue() + " (Isbn: " + entry.getKey() + ")");
        }

        values.remove("978-1-60309-444-3");
        values.values().remove("The Lab");


        values.put("978-1-60309-450-4", "They Called Us Enemy");
        values.put("978-1-60309-453-5", "Why Did We Trust Him?");

        System.out.println(values.containsKey(478 - 0 - 61159 - 424 - 8));

        System.out.println(values.get("978-1-60309-453-5"));

        for (HashMap.Entry<String, String> entry : values.entrySet()) {
            System.out.println(entry.getValue() + " (Isbn: " + entry.getKey() + ")");
        }
    }
}




