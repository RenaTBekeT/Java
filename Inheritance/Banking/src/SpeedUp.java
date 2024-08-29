public class SpeedUp extends BankAccount{
    private int sendTransactionCost = 1000;
    private int recieveTransactionCost = 200;
    public SpeedUp(String name, Customer owner, double startingBalace) {
        super(name, owner, startingBalace);
    }

    public int getSendTransactionCost() {
        return sendTransactionCost;
    }

    public int getRecieveTransactionCost() {
        return recieveTransactionCost;
    }
}