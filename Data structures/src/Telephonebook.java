import java.util.HashMap;
import java.util.Objects;

public class Telephonebook {

    public static void main(String[] args) {
        HashMap<String, String> kontakts = new HashMap<>();

        kontakts.put("William A. Lathan", "405-709-1865");
        kontakts.put("John K. Miller", "402-247-8568");
        kontakts.put("Hortensia E. Foster", "606-481-6467");
        kontakts.put("Amanda D. Newland", "319-243-5613");
        kontakts.put("Brooke P. Askew", "307-687-2982");

        numbers(kontakts);


    }

    public static void numbers(HashMap<String, String> kontakts) {
        System.out.println(kontakts.get("John K. Miller"));

        for (HashMap.Entry<String, String> entry : kontakts.entrySet()) {
            if (entry.getValue().equals("307-687-2982")) {
                System.out.println(entry.getKey());
            }
        }
        if (kontakts.containsValue("Chris E. Myers")) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}

