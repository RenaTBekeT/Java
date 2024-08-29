package ExpressionsAndWorkFlow.src;

import java.util.*;
public class MileToKmConverter {
    public static void main(String args[]){
        double Miles ;
        Scanner input = new Scanner (System.in);
        System.out.println("Enter lenght in Miles");
        Miles = input.nextDouble();

        System.out.print("lengt in kilometres is" + Miles * 1.6);
        input.close();
    }
}
