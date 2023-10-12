import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class IdGenerator {
    private static final char[] ALPHABET = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P'};
    Random random = new Random();

    private HashSet<String> crateIDs = new HashSet<String>();
    private HashSet<String> orderIDs = new HashSet<String>();

    public String newCrateID(){
        boolean incomplete = true;
        StringBuilder stringBuilder = new StringBuilder();
        while(incomplete){

            for (int i = 0; i < 3; i++){
                stringBuilder.append(ALPHABET[random.nextInt(ALPHABET.length)]);
            }
            stringBuilder.append('-');
            for (int i = 0; i < 3; i++){
                stringBuilder.append(random.nextInt(9));
            }

            if (!crateIDs.contains(stringBuilder.toString())){
                incomplete = false;
                crateIDs.add(stringBuilder.toString());
            }
            else{
                stringBuilder.setLength(0);
            }
        }
        return stringBuilder.toString();
    }

    public String newOrderId(){
        boolean incomplete = true;
        StringBuilder stringBuilder = new StringBuilder();
        while(incomplete) {
            stringBuilder.append('R');
            for (int i = 0; i < 4; i++) {
                stringBuilder.append(random.nextInt(9));
            }
            stringBuilder.append(ALPHABET[random.nextInt(ALPHABET.length)]);
            for (int i = 0; i < 4; i++) {
                stringBuilder.append(random.nextInt(9));
            }

            if (!orderIDs.contains(stringBuilder.toString())){
                incomplete = false;
                orderIDs.add(stringBuilder.toString());
            }
            else{
                stringBuilder.setLength(0);
            }
        }
        return stringBuilder.toString();
    }

    public String newCustomerId(){
        return String.valueOf(random.nextInt(20000));
    }
}
