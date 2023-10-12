public class Item {

    private String name;
    private int quantity;
    private double weight;
    private double cost;
    private PackingStatus status;
    private StorageType storageType;

    public void setStatus(PackingStatus status) {
        this.status = status;
    }

    public Item(String name, int quantity, double weight, double cost, StorageType storageType) {
        this.name = name;
        this.quantity = quantity;
        this.weight = weight;
        this.cost = cost;
        this.storageType = storageType;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getWeight() {
        return weight;
    }

    public double getCost() {
        return cost;
    }

    public PackingStatus getStatus() {
        return status;
    }

    public StorageType getStorageType() {
        return storageType;
    }
}
