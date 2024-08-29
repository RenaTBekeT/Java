import java.security.InvalidParameterException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private int age;
    private String gender;
    private List<BankAccount> banAccount;

    public Customer(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.banAccount = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public List<BankAccount> getBanAccount() {
        return banAccount;
    }

    public void createAccount(BankAccount newAccount) {
        for (BankAccount account : banAccount) {
            if (account.getName().equals(newAccount.getName())) {
                System.out.println("No account name duplication is allowed");
                return;
            }
        }
        banAccount.add(newAccount);
    }
public void sendMoney(String senderAccountName, Customer partner, String partnerAccounName, double amount) {
        BankAccount senderBakAccount = null;
    for (BankAccount account : banAccount) {
        if (account.getName().equals(senderAccountName)) {
            senderBakAccount = account;
            double balance = senderBakAccount.getBalance();
            double fee = 0;
            if (senderBakAccount instanceof Savings) {
                Savings savingsBankAccount = (Savings) senderBakAccount;
                fee = savingsBankAccount.getSendTransactionCost();
            }
            if (senderBakAccount instanceof SpeedUp) {
                SpeedUp speedUpBankAccount = (SpeedUp) senderBakAccount;
                fee = speedUpBankAccount.getSendTransactionCost();
            }
            if (senderBakAccount instanceof Balance) {
                Balance balanceUpBankAccount = (Balance) senderBakAccount;
                DayOfWeek day = DayOfWeek.of(balanceUpBankAccount.getLastUsageDate().get(ChronoField.DAY_OF_WEEK));
                if (day == DayOfWeek.SATURDAY || day ==DayOfWeek.SUNDAY) {
                    fee = amount * balanceUpBankAccount.getRecievePricekoefecientweekend();
                } else {
                    fee = amount * balanceUpBankAccount.getRecievePricekoefecientweek();
                }
            }
            balance -= (amount + fee);
            senderBakAccount.setBalance(balance);
            senderBakAccount.setLastUsageDate(LocalDate.now());
            senderBakAccount.getHistory().add(amount + " Ft sent to " + partner.name + " from the account " + senderAccountName  + " at " + senderBakAccount.getLastUsageDate());

        }
    } if (senderAccountName == null) {
        throw new InvalidParameterException("There is no sender account under the name " + senderAccountName);
    }

    }
    public void receiveMoney(String receiverAccountName, Customer sender, double amount) {
        BankAccount recieverBakAccount = null;
        for (BankAccount account : banAccount) {
            if (account.getName().equals(receiverAccountName)) {
                recieverBakAccount = account;
                double balance = recieverBakAccount.getBalance();
                double fee = 0;
                if (recieverBakAccount instanceof Savings) {
                    Savings savingsBankAccount = (Savings) recieverBakAccount;
                    fee = savingsBankAccount.getRecieveTransactionCost();
                }
                if (recieverBakAccount instanceof SpeedUp) {
                    SpeedUp speedUpBankAccount = (SpeedUp) recieverBakAccount;
                    fee = speedUpBankAccount.getRecieveTransactionCost();
                }
                if (recieverBakAccount instanceof Balance) {
                    Balance balanceUpBankAccount = (Balance) recieverBakAccount;
                   fee = balanceUpBankAccount.getRecievePricekoefecientweek() * amount;
                }
                balance += (amount - fee);
                recieverBakAccount.setBalance(balance);
                recieverBakAccount.setLastUsageDate(LocalDate.now());
                recieverBakAccount.getHistory().add(amount + " Ft recieved from " + sender.name + " to the account " + receiverAccountName+  " at " + recieverBakAccount.getLastUsageDate());

            }
        } if ( recieverBakAccount == null) {
            throw new InvalidParameterException("There is no sender account under the name " + receiverAccountName);
        }
    }
}