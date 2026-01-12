import java.util.Arrays;

public class Colors {
    public static void main(String[] args) {
        String[][] colors = new String [3][];
        colors[0] = new String[]{"lime", "forest green", "olive", "pale green", "spring green"};
        colors[1] = new String[]{"orange red", "red", "tomato"};
        colors[2] = new String[]{"orchid", "violet", "pink", "hot pink"};

        for (int row = 0; row < colors.length; row++) {
            for (int column = 0; column < colors[row].length; column++) {
                System.out.print(colors[row][column] + ",");
            }
            System.out.println();
        }
    }
}
// - Create a two-dimensional array (of Strings)
//   which can contain the different shades of specified colors
// - In `colors[0]` store the shades of green:
//   `"lime", "forest green", "olive", "pale green", "spring green"`
// - In `colors[1]` store the shades of red:
//   `"orange red", "red", "tomato"`
// - In `colors[2]` store the shades of pink:
//   `"orchid", "violet", "pink", "hot pink"`
// - Print the array in the following format:
//
//   lime, forest green, oline, pale green, spring green
//   orange red, red, tomato
//   orchid, violet, pink, hot pink
//
//   public static void main(String[] args) {
//        String[][] colors = new String[3][]; // two-dimensional array
//        colors[0] = new String[]{"lime", "forest green", "olive", "pale green", "spring green"};
//        colors[1] = new String[]{"orange red", "red", "tomato"};
//        colors[2] = new String[]{"orchid", "violet", "pink", "hot pink"};
//
//        for (int row = 0; row < colors.length; row++) {
//            for (int column = 0; column < colors[row].length; column++) {
//                System.out.print(colors[row][column] + ", ");
//            }
//            System.out.println();
//        }
//    }