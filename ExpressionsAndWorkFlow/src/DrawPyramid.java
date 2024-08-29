package ExpressionsAndWorkFlow.src;
import java.util.Scanner;

public class DrawPyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of pyramid");
        int pyramidHeight = scanner.nextInt();
        draw(pyramidHeight);
        scanner.close();
    }

    public static void draw(int pyramidHeight) {
        for (int row = 0; row < pyramidHeight; row++) {
            for (int column = 0; column < pyramidHeight - row - 1; column++) {
                System.out.print(" ");
            }
            for (int i = 0; i < 2 * row + 1; i++) {
                System.out.print("%");
            }
            System.out.println();
        }
    }
}

