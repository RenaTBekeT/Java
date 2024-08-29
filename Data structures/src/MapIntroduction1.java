import java.util.HashMap;
public class MapIntroduction1 {

    public static void main(String... args) {
        HashMap<Integer, Character> values = new HashMap<Integer, Character>();

        values.put(97, 'a');
        values.put(98, 'b');
        values.put(99, 'c');
        values.put(65, 'A');
        values.put(66, 'B');
        values.put(67, 'C');

        for (int i : values.keySet()) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (char i : values.values()) {
            System.out.print(i + " ");
        }
        values.put(68, 'D');

        System.out.println(values.size());
        System.out.println(values.get(99));
        values.remove(97);
        System.out.println(values.containsKey(100));
        values.clear();
        System.out.println(values.size());
    }
}











