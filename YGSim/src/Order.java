import java.util.ArrayList;

public class Order {
    private ArrayList<Crate> crates = null;
    private ArrayList<Item> items = null;
    private String orderID;
    private Customer customer;
    private String bayNumber;

    public Order(Customer customer, String orderID, String bayNumber){
        this.customer = customer;
        this.orderID = orderID;
        this.bayNumber = bayNumber;
    }

    public void addItem(Item item){
        if (items == null){
            items = new ArrayList<Item>();
        }
        items.add(item);
    }

    public void removeItem(Item itemToRemove){
        for (Item item: items){
            if (item.getName().equals(itemToRemove.getName())){
                items.remove(item);
                return;
            }
        }
        System.out.println(String.format("Item '%s' not found in order", itemToRemove.getName()));
    }

    public double getTotal(){
        double total = 0.0;
        for (Item item : items){
            total += item.getCost();
        }
        return total;
    }

    public void addCrate(Crate crate){
        if (crates == null){
            crates = new ArrayList<Crate>();
        }
        crates.add(crate);
    }

    public void removeCrate(String crateID){
        for (Crate crate : crates){
            if (crate.getCrateID().equals(crateID)){
                crates.remove(crate);
                return;
            }
        }
        System.out.printf("Crate '%s' not found in crateList\n", crateID);
    }

    public String getBayNumber() {
        return bayNumber;
    }

    public void printOrderQC(){

    }

    public void printOrderLabels(){

    }

    public void printCrates(){

    }

    public Customer getCustomer() {
        return customer;
    }

    public String getOrderID() {
        return orderID;
    }
}
