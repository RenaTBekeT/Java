package ExpressionsAndWorkFlow.src;

public class DrawDiamond {
    public static void main(String[] args) {
        // Write a program that reads a number from the standard input and
        // then draws a diamond of the specified height
        //
        // Example:
        //
        // Please enter the diamond height: 4
        //    *
        //   ***
        //  *****
        // *******
        //  *****
        //   ***
        //    *
        //
        // Note: the height of the diamond is taken from its base
        // (where it is the widest) to the top.
        // The total number of lines produced is 2*height-1
        draw(4);

    }
    public static void draw(int size) {
        // Write your code to draw the diamond here

        for (int i = 1; i <= size; i++) {
            for (int j = 0; j < size - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k < i * 2; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int l = 0; l <= size * 2; l++) {
            for (int m = 0; m <= l; m++) {
                System.out.print(" ");
            }
            for (int n = 0; n < (size * 2) - (2 * l+ 3) ; n++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

