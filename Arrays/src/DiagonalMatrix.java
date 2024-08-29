public class DiagonalMatrix {
    public static void main(String[] args) {
        int[][] matrix = create(4);
        print(matrix);
    }

    public static int[][] create(int size) {
        int[][] matrix = new int[size][size];
        for (int row = 0; row < size; row++) {
            matrix[row][row] = 1;
        }
        return matrix;
    }

    public static void print(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.print(matrix[row][column] + " ");
            }
            System.out.println();
        }
    }
}
// Write a program that asks for an integer `size` from the standard input,
// then it creates a two-dimensional array (of integers) of the specified
// size (nxn) with the value of 1 on the main diagonal and the value of 0
// everywhere else. Print the 2d array into the output
//
// Example:
//
// Please enter the array (matrix) size: 4
// 1 0 0 0
// 0 1 0 0
// 0 0 1 0
// 0 0 0 1

// write your code to create an nxn matrix of the given size here
// this matrix should already have value of 1 on the main diagonal
// write your code to create an nxn matrix of the given size here
// this matrix should already have value of 1 on the main diagonal