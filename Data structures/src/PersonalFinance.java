import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PersonalFinance {
    public static void main(String[] args) {
        List<Integer> Items = Arrays.asList(500, 1000, 1250, 175, 800, 120);
        int spend = 0;
        for (int i = 0; i < Items.size(); i++) {
            spend += Items.get(i);
        }
        System.out.println(spend);
        System.out.println(Collections.max(Items));
        System.out.println(Collections.min(Items));

        float sum = 0;
        for (int i = 0; i < Items.size(); i++) {
            sum += Items.get(i);
        }
        System.out.println(sum / Items.size());
    }
}

