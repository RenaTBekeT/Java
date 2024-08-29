public class ReverseList {
    public static void main(String[] args) {
        int array[] = {3, 4, 5, 6, 7};
        int array1[] = {5, 6, 7, 8, 9};

        reverse(array);
        reverse(array1);

    }
        // - Create an array variable named `numbers`


        private static void reverse (int[] array) {

            String reversed = "";
            for (int i = 0; i < array.length; i++) {
                reversed = array[i] + reversed;

            }
            System.out.println(reversed);


        }
        // - Reverse the order of the elements of `numbers` programmatically
        // - Print the elements of the reversed `numbers`:
        //   [7, 6, 5, 4, 3]
    }
