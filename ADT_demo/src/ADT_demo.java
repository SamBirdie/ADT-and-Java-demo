import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ADT_demo {
    // TODO-option: other functions for adt:s, for example adding and altering and their time-measuring
    long aika1, aika2; // näihin aikoja talteen

    /* Mittaamisen esimerkki:
        // kutsutaan mittausta
        long alku = System.nanoTime();
        SortedMap<Integer, Long> tulos = testattava.jononNopeus(J, min, max);
        long aika = System.nanoTime() - alku;

        // tulostetaan mittaukseen mennyt aika, max 2s/alkiomÃ¤Ã¤rÃ¤ oli tarkoitus kÃ¤yttÃ¤Ã¤
        System.out.println("Mittaus kesti " + (1.0*aika / (1000.0*1000*1000*odotetutAvaimet.size())) + " s/alkiomÃ¤Ã¤rÃ¤.");
*/
        
    public static void main(String[] args) {
        // argumentteina toiminto; jos ei anneta, tulostetaan valikko

        Scanner scanner = new Scanner(System.in);
        boolean getHashmapDemoDatabase = false;
        boolean getTreeDemoDatabase = false;

        if (args.length == 0)
            showMenu(scanner);

        else
            switch (args[0]) {
                case "hashmap":
                    getHashmapDemoDatabase = true;
                    break;

                case "tree":
                    getTreeDemoDatabase = true;
                    break;
            }

        if (getHashmapDemoDatabase)
            exampleWithHashMap(scanner);

        else if (getTreeDemoDatabase)
            exampleWithTree(scanner);
    }

    private static void showMenu(Scanner scanner) {

        boolean continueWhileLoop = true;
        while (continueWhileLoop) {
            System.out.println("\n\n\n\t--- MENU ---\n");
            System.out.println("1) Demonstration of ADT-HashMap");
            System.out.println("2) Demonstration of ADT-Tree");
            System.out.println("q) Quit/Exit");
            System.out.print("> ");
            String test = scanner.nextLine();
            System.out.println();
            

            switch (test.toLowerCase()) {
                case "1":
                    exampleWithHashMap(scanner);
                    break;
                case "2":
                    exampleWithTree(scanner);
                    break;
                case "q":
                    System.out.println("\t\tThank you and have a nice day!\n");
                    continueWhileLoop = false;
                    break;
                default:
                    System.out.println("\tPlease choose number of your choice from menu below");
            }
        }
    }

    private static void exampleWithHashMap(Scanner scanner) {
        HashMap<Integer, String> demoHM = new HashMap<>();
        ArrayList<String> demoAL = new ArrayList<>();
        int gettingHMTime = 0, gettingALTime = 0;
        String name = "";
        while (name.isEmpty()) {
            System.out.print("Enter your last name: ");
            name = scanner.nextLine();
        }

        for (int i = 0; i < 10000000; i++)
            demoHM.put(i, i + name);

        for (int i = 0; i < 10000000; i++)
            demoAL.add(i + name);

        // System.out.println(demoHM);

        // TODO: get few random strings and show get-times
        System.out.println("\n\n\n\t100 random elements fetched from HashMap and ArrayList for the reference.");
        System.out.println("\n\n\t\t- Median fetching time from HashMap: " + gettingHMTime + " milliseconds.");
        System.out.println("\n\t\t- Median fetching time from ArrayList: " + gettingALTime + " milliseconds.");

    }

    private static void exampleWithTree(Scanner scanner) {
        // TODO
        /*ArrayList<String> demoAL = new ArrayList<>();
        Tree<String> demoTree = new Tree<>(); // TÄMÄ KUNTOON
        int gettingTreeTime = 0, gettingALTime = 0;
        String name = "";
        while (name.isEmpty()) {
            System.out.print("Enter your last name: ");
            name = scanner.nextLine();
        }

        for (int i = 0; i < 10000000; i++)
            demoTree.put(i, i + name);

        for (int i = 0; i < 10000000; i++)
            demoAL.add(i + name);*/
    }
}
