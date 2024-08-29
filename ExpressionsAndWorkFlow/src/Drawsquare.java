package ExpressionsAndWorkFlow.src;
import java.util.Scanner;

public class Drawsquare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int squareSize = scanner.nextInt();
        draw(squareSize);
    }

    public static void draw(int squareSize) {
        for (int row = 0; row < squareSize; row++) {
            for (int column = 0; column < squareSize; column++) {
                if (row == 0 || row == squareSize - 1 || column == 0 || column == squareSize - 1) {
                    System.out.print("%");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
// Write a program that reads a number from the standard input and
// then draws a square of the specified size
//
// Example:
//
// Please enter the square size: 6
// %%%%%%
// %    %
// %    %
// %    %
// %    %
// %%%%%%





