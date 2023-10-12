import java.util.ArrayList;

public class Account {
    
    private String name;
    
    private String accountID;

    private User accountHolder;

    private ArrayList<Transaction> transactions;

    public Account(String name, User accountHolder, Bank bank){

        this.name = name;
        this.accountHolder = accountHolder;

        this.accountID = bank.getNewAccountID();

        this.transactions = new ArrayList<Transaction>();

    }

    public String getAccountID(){
        return accountID;
    }
    
}
