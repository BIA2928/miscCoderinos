public class Customer {
    private String fullname;
    private String customerID;

    public Customer(String fullname, String customerID){
        this.fullname = fullname;
        this.customerID = customerID;
    }

    public String getFullname() {
        return fullname;
    }

    public String getCustomerID() {
        return customerID;
    }
}
