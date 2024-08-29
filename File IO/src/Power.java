public class Power {

        public static int powerN(int i, int n) {
            // Base case: Any number raised to the power of 0 is 1
            if (n == 0) {
                return 1;
            }

            // Recursive case: Multiply the base by powerN(base, n - 1)
            return i * powerN(i, n - 1); // 3 * 3 * 3 = 3^3 = 3^2 * 3

        }

        public static void main(String[] args) {
            int result = powerN(3, 3);
            System.out.println(result);

        }

    }


