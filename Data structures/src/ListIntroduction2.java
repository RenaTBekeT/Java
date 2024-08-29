import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;

public class ListIntroduction2 {

    public static void main(String[] args) {
        ArrayList<String> ListA = new ArrayList<String>();

        ListA.add("apple");
        ListA.add("avokado");
        ListA.add("Blueberrys");
        ListA.add("Dorian");
        ListA.add("Lychee");

        ArrayList ListB = (ArrayList)ListA.clone();

        System.out.println(ListA.contains("Dorian"));

        ListB.remove("Dorian");

        ListA.add(4, "Kiwifruit");

        boolean Compare = ListA.equals(ListB);
        System.out.println(Compare);

        System.out.println(ListA.indexOf("avokado"));
        System.out.println(ListB.indexOf("Dorian"));

        Collections.addAll(ListB, "passion fruit", "pomelo");

        System.out.println(ListB.get(2));

        System.out.println(ListA);
        System.out.println(ListB);




    }
}
