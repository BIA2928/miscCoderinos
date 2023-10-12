import java.util.Date;

public class Transaction {
    private double amount;
    private Date timestamp;
    private String description;
    private Account fromAccount;

    public Transaction(double amount, Account fromAccount){
        this.amount = amount;
        this.fromAccount = fromAccount;
        this.timestamp = new Date();
        this.description = "";
    }

    public Transaction(double amount, Account fromAccount, String description){
        this(amount, fromAccount);
        this.description = description;
    }

}
