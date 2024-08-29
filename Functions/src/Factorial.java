public class Factorial {
    public static void main(String[] args) {
        int i = fakt(5);
        System.out.println(i);
    }

    public static int fakt(int input) {
        int faktorial = 1;
        for (int i = 1; i <= input; i++) {
            faktorial *= i;
        }
        return faktorial;
    }
}
