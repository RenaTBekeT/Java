import java.util.Arrays;

public class AppendA {

   /* public static void main(String[] args) {
        String[] animals = {"koal", "pand", "zebr", "anacond", "bo", "chinchill", "cobr",
                "gorill", "hyen", "hydr", "iguan", "impal", "pum", "tarantul",
                "piranh"};

        String[] animalsCorrect = new String[animals.length];
        for (int i = 0; i < animals.length; i++) {
            animalsCorrect[i] = animals[i] + 'a';
        }
        System.out.println(Arrays.toString(animalsCorrect));
    }*/

    public static void main(String[] args) {
        String[] transFormers = {"denis", "dominik", "petra"};
        String[] result = new String[transFormers.length];

        for (int i = 0; i < transFormers.length; i++) {
            String wasted = transFormers[i];
            if (wasted.charAt(wasted.length() - 1) == 'a') {
                result[i] = wasted.substring(0,wasted.length() - 1);
            } else {
                result[i] = wasted + 'a';
            }
        }
        System.out.println(Arrays.toString(result));
    }
}
// - Create an array variable named `animals`
//   with the following content:
//   `["koal", "pand", "zebr", "anacond", "bo", "chinchill", "cobr",
//     "gorill", "hyen", "hydr", "iguan", "impal", "pum", "tarantul",
//     "piranh"]`
//
// - Add an `"a"` at the end of all elements (use a loop!)
// - Print the 'fixed' array to the console:
//   [koala, panda, zebra, anaconda, boa, ..., puma, tarantula, piranha]

