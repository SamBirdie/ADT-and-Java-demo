import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ADT_demo {
    // TODO-option: other functions for adt:s, for example adding and altering and their time-measuring

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
                    System.out.println("Thank you and have a nice day!");
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
        int addingHMTime=2, addingALTime=2, gettingHMTime, gettingALTime;
        String name = "";
        while (name.isEmpty()) {
            System.out.print("Enter your last name: ");
            name = scanner.nextLine();
        }

        // start counting time
        for (int i = 0; i < 9000000; i++)
            demoHM.put(i, i + name);
        // stop counting time

        // start counting time
        for (int i = 0; i < 9000000; i++)
            demoAL.add(i + name);
        // stop counting time

        /* Irrelevant!
        System.out.println("\n\tAdding generated strings to HashMap took " + addingHMTime + " ms and "

                + addingALTime + " ms to ArrayList.");
        */
        //System.out.println(demoHM);

        // TODO: get few random strings and show get-times
    }

    private static void exampleWithTree(Scanner scanner) {
        // TODO
        System.out.println("Tree-example here");
    }
}