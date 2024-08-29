package ExpressionsAndWorkFlow.src;

import java.util.*;

public class AnimalsAndLegs {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the amount of chickens: ");
        int chickens = input.nextInt();

        System.out.println("Enter the amount of pigs: ");
        int pigs = input.nextInt();

        int total = ((chickens * 2) + (pigs * 4));
        System.out.print("Animals has : " + total + " legs");
        input.close();
    }
}
// Write a program that asks for two integers
// The first represents the number of chickens the farmer has
// The second represents the number of pigs owned by the farmer
// Print how many legs all the animals have in total
//
// Example
//
// Please enter the number of chickens: 4
// Please enter the number of pigs: 2
// The number of legs: 16
