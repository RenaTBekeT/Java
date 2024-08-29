import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String name;
    private Customer owner;
    private double balance;
    private List<String> history;
    private List<Customer> transactionPartners;
    private LocalDate lastUsageDate;

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setLastUsageDate(LocalDate lastUsageDate) {
        this.lastUsageDate = lastUsageDate;
    }

    public String getName() {
        return name;
    }

    public Customer getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public List<String> getHistory() {
        return history;
    }

    public List<Customer> getTransactionPartners() {
        return transactionPartners;
    }

    public LocalDate getLastUsageDate() {
        return lastUsageDate;
    }

    public BankAccount(String name, Customer owner, double startingBalace) {
        this.name = name;
        this.owner = owner;
        this.balance = startingBalace;
        this.history = new ArrayList<>();
        this.transactionPartners = new ArrayList<>();
        this.lastUsageDate = LocalDate.now();


    }
}