import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class OrderFactory {

    private static OrderFactory instance = null;
    private final IdGenerator idGenerator = new IdGenerator();
    private ArrayList<String> bayNumbers = new ArrayList<String>();
    private int bayNumberIndex = 0;
    private int maxOrders = 0;

    private OrderFactory(){}

    public static synchronized  OrderFactory getInstance(){
        if(instance == null){
            instance = new OrderFactory();
        }
        return instance;
    }

    public String getNextBayNumber(){
        String retVal = bayNumbers.get(bayNumberIndex);
        bayNumberIndex++;
        return retVal;
    }

    public ArrayList<Order> initialiseOrders(int nOrders) throws IOException {
        ArrayList<Order> retVal = new ArrayList<Order>();
        parseBayNumbers();
        if (nOrders > maxOrders){
            System.out.println("Too many orders to simulate");
            return null;
        }
        for (int i = 0; i < nOrders; i++){
            Order nextOrder = new Order(new Customer(NameGenerator.getRandomName(), idGenerator.newCustomerId()),
                    idGenerator.newOrderId(), getNextBayNumber());

            nextOrder.addCrate(makeNewCrate(StorageType.COLD));
            initialiseItemList(nextOrder);
            retVal.add(nextOrder);
        }
        return retVal;
    }

    public void initialiseItemList(Order order){
        for (int i = 0; i < new Random().nextInt(10); i++){
            order.addItem(ItemGenerator.createRandomItem());
        }
    }

    public Crate makeNewCrate(StorageType storageType){
        Crate crate = new Crate(storageType, idGenerator.newCrateID());
        return crate;
    }

    private void parseBayNumbers() throws IOException {
    if (maxOrders > 0){
        //Already parsed
        return;
    }
        BufferedReader bufferedReader = new BufferedReader(new FileReader("bay_numbers.txt"));
        String line;
        int i = 0;
        while ((line = bufferedReader.readLine()) != null){
            bayNumbers.add(line);
            i++;
        }
        maxOrders = i;
    }

    public int getMaxOrders() {
        return maxOrders;
    }
}
