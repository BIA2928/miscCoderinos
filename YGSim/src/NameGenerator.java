import java.util.Random;

public class NameGenerator {

    private static final Random numGenerator = new Random();
    private final static String[] FNAMES = {"Emma", "Olivia", "Sarah", "George", "Joseph", "John", "Jeff", "Albert", "Max", "Jasmine", "Julia", "Jack", "Harry", "Sam", "Elenore",
            "Jessica", "Angelina", "Martin", "Prudence", "Liam", "Noah", "Milla", "Ella", "Claudia", "Sophia", "Ava", "Luna", "Robert", "Luca", "Lily", "Jordan", "Michael", "Cesar",
            "Vivian", "Georgina", "Matthew", "Marco", "Joline", "San San", "Tom", "Britney", "Scarlett", "Ebony", "Oliver", "Lucas", "Lionel", "Olivia", "Leo", "Alverta", "Parker",
            "Delaine", "Hermelinda", "Shea", "Chaya", "Georgie", "Farah", "Brad", "Dorothy", "April", "Carolyn", "Abdul", "Avril"};
    private final static String[] LNAMES = {"O'brian", "O'connor", "Tadic", "Pulisic", "Cox", "Johnson", "Crevelli", "Adoud", "Mancini", "Jones", "Davies", "Grffith", "Murphy", "Parker",
            "Goldberg", "McKenzie", "Brown", "Kiriakidis", "Gastis", "McConville", "Gargano", "Lenaghan", "Alvarez", "Torres", "Thomas", "Alvaro-Cruz", "Garcia", "Martinez",
            "Greenwood", "Smith", "Capelli", "Rossi", "Romano", "Bianchi", "Ricci", "Regiano", "Piedimonte", "Esposito", "Fernandez", "De Luca", "Fiumicino", "Costa",
            "Khalil", "Gregory", "Blanch", "Blanchette", "Godfries", "Mumford", "Ballinger", "Dean", "Harding", "Buchanan", "Dara"};


    public NameGenerator() {
    }

    public static String getRandomName() {
        StringBuilder fullName = new StringBuilder();
        String firstName = FNAMES[numGenerator.nextInt(FNAMES.length)];
        String secondName = LNAMES[numGenerator.nextInt(LNAMES.length)];
        fullName.append(firstName);
        fullName.append(" ");
        fullName.append(secondName);
        return fullName.toString();
    }
}