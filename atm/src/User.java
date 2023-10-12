import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.security.MessageDigest;

public class User {

    private String firstName;
    private String lastName;
    private String userID;
    private byte pinHash[];
    private ArrayList<Account> accounts;

    public User(String firstName, String lastName, String pin, Bank bank) throws NoSuchAlgorithmException {
        this.firstName = firstName;
        this.lastName = lastName;

        // MD5 alg. for hashing
        MessageDigest md = MessageDigest.getInstance("MD5");
        this.pinHash = md.digest(pin.getBytes());

        // Generate a uuid
        this.userID = bank.getNewUserID();

        this.accounts = new ArrayList<Account>();

        System.out.printf("new user %s, %s", this.userID, this.firstName + " " + this.lastName);
    }

    public boolean validatePin(String pin) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        return MessageDigest.isEqual(md.digest(pin.getBytes()), pinHash);
    }

    public void addNewAccount(Account acc){
        this.accounts.add(acc);
    }

    public String getUserID() {
        return userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
