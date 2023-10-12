import java.util.Random;

public class ItemGenerator {

    private final static String[] DEMO_ITEMS = {"Ham", "Eggs", "Chicken", "Royal Gala Apple", "Orange",
            "Cadbury Chocolate", "AA Battery 4-pack", " Broccoli", "Wholemeal Wraps", "Baguette", "Whiska's Gravy Delights",
    "Who Gives a Crap Toilet Tissue 4-pack", "Schulz Organic Dairy Full Cream 1L", "SPC Baked Beans", "Coca-Cola 2L",
    "Spring Water 1L", "Thins Sour Cream & Onion", "Kleenex Soft & Thick 3-Ply", "English Muffins", "Eye Fillet"};
    private final static String[] DEMO_ITEM_TYPE = {"COLD", "AMBIENT", "COLD", "AMBIENT", "AMBIENT", "AMBIENT", "AMBIENT",
            "AMBIENT", "AMBIENT", "AMBIENT", "AMBIENT", "AMBIENT", "COLD", "AMBIENT", "AMBIENT", "AMBIENT", "AMBIENT", "AMBIENT", "AMBIENT",
    "COLD"};

    private static final Random numGenerator = new Random();

    public static Item createRandomItem(){
        int index = numGenerator.nextInt(DEMO_ITEMS.length);
        StorageType storageType;
        if(DEMO_ITEM_TYPE[index].equals("COLD")){
            storageType = StorageType.COLD;
        }
        else{
            storageType = StorageType.AMBIENT;
        }
        String name = DEMO_ITEMS[index];
        int quantity = numGenerator.nextInt(5);
        double weight = numGenerator.nextDouble() * numGenerator.nextInt(1000);
        double cost = numGenerator.nextDouble() * numGenerator.nextInt(10 * quantity);
        Item item = new Item(name, quantity, weight, cost, storageType);
        item.setStatus(PackingStatus.UNPACKED);
        return item;
    }
}
