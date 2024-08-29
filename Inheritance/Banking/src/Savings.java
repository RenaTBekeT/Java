public class Savings extends BankAccount{
private int sendTransactionCost = 100;
private int recieveTransactionCost = 20;
    public Savings(String name, Customer owner, double startingBalace) {
        super(name, owner, startingBalace);
    }

    public int getSendTransactionCost() {
        return sendTransactionCost;
    }

    public int getRecieveTransactionCost() {
        return recieveTransactionCost;
    }
}
