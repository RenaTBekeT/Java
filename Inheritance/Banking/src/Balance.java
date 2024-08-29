public class Balance extends BankAccount{
    final private double sendPricekoefecient = 0.002;
    final private double recievePricekoefecientweekend = 0.003;
    final private double recievePricekoefecientweek = 0.003;
    public Balance(String name, Customer owner, double startingBalace) {
        super(name, owner, startingBalace);
    }

    public double getSendPricekoefecient() {
        return sendPricekoefecient;
    }

    public double getRecievePricekoefecientweekend() {
        return recievePricekoefecientweekend;
    }

    public double getRecievePricekoefecientweek() {
        return recievePricekoefecientweek;
    }
}