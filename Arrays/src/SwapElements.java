import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SwapElements {
    public static void main(String[] args) {
        String[] orders = {"first", "second", "third"};
        String temp = orders[0];
        orders[0] = orders[2];
        orders[2] = temp;
        System.out.println(Arrays.toString(orders));
    }
}

// - Create an array variable named `orders`
//   with the following content: `["first", "second", "third"]`
// - Swap the first and the third element of `orders` programmatically
// - Print the swapped array into the console:
//   [third, second, first]
