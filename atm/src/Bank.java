import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Random;

public class Bank {

    private String name;
    private String abbreviation;
    private ArrayList<User> users;
    private ArrayList<Account> accounts;

    public String getNewUserID(){
        String userID;

        Random rng = new Random();
        int len = 6;
        boolean nonUnique;

        do {
            userID = "";
            for (int i = 0; i < len; i++){
                userID += ((Integer)rng.nextInt(10)).toString();
            }
            nonUnique = false;
            for (User user: users){
                if (userID.compareTo(user.getUserID()) == 0){
                    nonUnique = true;
                    break;
                }
            }

        } while (nonUnique);

        return userID;
    }

    public String getNewAccountID(){
        String accountID;

        Random rng = new Random();
        int len = 7;
        boolean nonUnique;

        do {

            accountID = "";
            accountID += abbreviation;

            for (int i = 0; i < len; i++){
                accountID += ((Integer)rng.nextInt(10)).toString();
            }
            nonUnique = false;
            for (Account account: accounts){
                if (accountID.compareTo(account.getAccountID()) == 0){
                    nonUnique = true;
                    break;
                }
            }

        } while (nonUnique);

        return accountID;
    }

    public void addNewAccount(Account acc){
        this.accounts.add(acc);
    }

    public User addUser(String firstName, String lastName, String pin) throws NoSuchAlgorithmException {

        User newUser = new User(firstName, lastName, pin, this);
        this.users.add(newUser);

        // Auto-create savings account
        Account newAccount = new Account(
                String.format("%s %s's Savings", newUser.getFirstName(), newUser.getLastName())
                , newUser
                , this);
        newUser.addNewAccount(newAccount);
        this.addNewAccount(newAccount);

        return newUser;
    }

    public User userLogin(String userID, String pin) throws NoSuchAlgorithmException {
        for (User user : this.users){
            if (user.getUserID().compareTo(userID) == 0 && user.validatePin(pin)){
                return user;
            }
        }
        return null;
    }


}
