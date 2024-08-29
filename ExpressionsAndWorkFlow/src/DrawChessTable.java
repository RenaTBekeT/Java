package ExpressionsAndWorkFlow.src;

import java.util.Scanner;

public class DrawChessTable {
    public static void main(String[] args) {
        Scanner chess = new Scanner(System.in);
        int size = chess.nextInt();
        draw(size);
    }

    public static void draw(int size) {
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                if ((row + column) % 2 == 0) {
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
// then draws a chess table of the specified size
//
// Example:
//
// Please enter the chess table size: 8
// % % % %
//  % % % %
// % % % %
//  % % % %
// % % % %
//  % % % %
// % % % %
//  % % % %
