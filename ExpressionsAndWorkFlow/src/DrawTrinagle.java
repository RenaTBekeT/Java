package ExpressionsAndWorkFlow.src;
import java.util.Scanner;

class DrawTriangle {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of triangle");
        int triangleSize = scanner.nextInt();
        draw(triangleSize);
    }

    public static void draw(int triangleSize) {
        for (int row = 0; row <= triangleSize; row++) {
            for (int column = 0; column <= row; column++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}


