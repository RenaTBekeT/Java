package ExpressionsAndWorkFlow.src;

import java.sql.SQLOutput;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

class Mamintroduction1 {
    public static void main(String[] args) {
        HashMap<Integer, String> values = new HashMap<Integer, String>();

        System.out.println(values.size() == 0);

        values.put(97, "a");
        values.put(98, "b");
        values.put(99, "c");
        values.put(65, "A");
        values.put(66, "B");
        values.put(67, "C");



        Set<Integer> keys = values.keySet();
        for (Integer key : keys)
            System.out.print(key + " ");

        System.out.println();

        for (String i : values.values())
            System.out.print(i + " ");

        System.out.println();
        values.put(68, "D");

        System.out.println(values);

        System.out.println(values.size());

        System.out.println(values.get(99));

        values.remove(97);

        System.out.println(values.get(100) != null);



        values.clear();

        System.out.println(values.size());




        }




            }



