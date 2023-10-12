import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class YgDriver {

    final static String EXIT_COMMAND = "exit";
    final static String PRINT_COMMAND = "print";
    final static String UPDATE_EMAIL_COMMAND = "update_email";
    final static String UPDATE_PHONE_COMMAND = "update_phone";
    final static String VIEW_ORDER_COMMAND = "view_orders";
    final static String VIEW_DETAILS_COMMAND = "view_details";
    final static String CANCEL_COMMAND = "cancel";

    private static ArrayList<Order> orders = null;
    private ArrayList<Crate> crates;

    public static void main(String[] args) throws IOException {
        boolean simulationNotActive = true;

        String buffer;
        Scanner scanner = new Scanner(System.in);
        while(simulationNotActive){
            System.out.println("YG Ops Simulator. Enter number of orders");
            if (scanner.hasNextInt()){
                int nOrders = scanner.nextInt();
                orders = OrderFactory.getInstance().initialiseOrders(nOrders);
                if (orders == null){
                    System.out.printf("Invalid number of orders. Please try a number between 1 and %d",
                            OrderFactory.getInstance().getMaxOrders());
                }
                else{
                    System.out.printf("Simulation initialised with %d orders\nUse 'exit' to exit, 'view_order' to query an order," +
                            " 'print' to enter print mode and\n'cancel to exit any commands", nOrders);
                    simulationNotActive = false;
                }
            }
        }

        Order selected = null;
        boolean isSelected = false;
        boolean printMode = false;

        while(scanner.hasNext()){
            buffer = scanner.next();
            if(buffer.equals(EXIT_COMMAND)){
                System.out.println(("Process terminated."));
                break;
            }else if(buffer.equals(CANCEL_COMMAND)){
                if(isSelected) {
                    System.out.print(String.format("%s deselected. Re-select a new order using its ID.\n",
                            selected.getOrderID()));
                    selected = null;
                    isSelected = false;
                }else{
                    System.out.println("No customer to deselect. Select a valid customer first.");
                }
            }else if(buffer.equals(VIEW_ORDER_COMMAND)){
                if(!isSelected){
                    System.out.println("No customer selected. Try again with a valid customer.");
                }else{
                    selected.printDetails();
                }
            }else if(buffer.equals(VIEW_DETAILS_COMMAND)){
                if(!isSelected){
                    System.out.println("No customer selected. Try again with a valid customer.");
                }else{
                    selected.printDetails();
                }
            }else{
                if(customerDatabase.containsKey(buffer.replace("_", " "))){
                    System.out.println(String.format("Customer %s selected. Use command '%s', '%s','%s', '%s' or '%s' for further action.",
                            buffer, VIEW_DETAILS_COMMAND, VIEW_ORDER_COMMAND, UPDATE_EMAIL_COMMAND, UPDATE_PHONE_COMMAND, CANCEL_COMMAND));
                    selected = customerDatabase.get(buffer.replace("_", " "));
                    isSelected = true;
                }else{
                    System.out.println("No customer with that name on file. Please try again.");
                }
            }
        }
        return;

    }
}
