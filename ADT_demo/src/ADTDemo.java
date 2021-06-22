import java.util.*;

public class ADTDemo {

    private static int maxElements = 65535; // =2^16-1 elements, when binary tree depth is 16

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

            showMenu(scanner);

    }

    private static void showMenu(Scanner scanner) {

        boolean continueWhileLoop = true;
        while (continueWhileLoop) {
            System.out.println("\n\n\n\t--- MENU ---\n");
            System.out.println("1) Demonstration of ADT-HashSet");
            System.out.println("2) Demonstration of ADT-Tree");
            System.out.println("q) Quit/Exit");
            System.out.print("> ");
            String choice = scanner.nextLine();
            System.out.println();

            switch (choice.toLowerCase()) {
                case "1":
                    exampleWithHashSet();
                    break;
                case "2":
                    exampleWithTree();
                    break;
                case "q":
                    System.out.println("\t\tThank you and have a nice day!\n");
                    continueWhileLoop = false;
                    break;
                default:
                    System.out.println("\tPlease choose option from the menu below");
            }
        }
    }

    private static void exampleWithHashSet() {

        Random random = new Random();
        Long medianGetResultFromArrayList = testGetAL(random);
        Long medianGetResultFromHashSet = testGetHS(random);

        printResults("HashSet", medianGetResultFromHashSet, medianGetResultFromArrayList);
    }


    private static void exampleWithTree() {

        Random random = new Random();
        Long medianGetResultFromArrayList = testGetAL(random);
        Long medianGetResultFromTree = testGetTree();

        printResults("BinaryTree", medianGetResultFromTree, medianGetResultFromArrayList);
    }

    private static Long testGetAL(Random random) {
        System.out.println("Processing, this may take a few seconds...");
        ArrayList<Double> demoAL = new ArrayList<>(maxElements);
        ArrayList<Double> getALValue = new ArrayList<>(maxElements);

        for (int i = 0; i < maxElements; i++)
            demoAL.add(i * 3.14159);

        for (Double d: demoAL)
            getALValue.add(d);
        Collections.shuffle(getALValue);

        long start;
        long end;
        ArrayList<Long> gettingALTimes = new ArrayList<>();

        // Testing ArrayList:
        for (int j = 0; j < 10; j++) {
            start = System.nanoTime();
            for (int k = j*100; k < (j+1)*100; k++)
                demoAL.contains(getALValue.get(k)); // This could be stored into variable if needed
            end = System.nanoTime();
            gettingALTimes.add((end - start) / 100);
        }
        Collections.sort(gettingALTimes);

        return gettingALTimes.get(gettingALTimes.size() / 2);
    }

    private static Long testGetHS(Random random) {

        HashSet<Double> demoHS = new HashSet<>();
        ArrayList<Double> getHSValue = new ArrayList<>();

        Double e;
        for (int i = 0; i < maxElements; i++) {
            e = i * 3.14159;
            demoHS.add(e);
            getHSValue.add(e);
        }
        Collections.shuffle(getHSValue);

        long start;
        long end;
        ArrayList<Long> gettingHMTimes = new ArrayList<>();

        // Testing HashMap:
        for (int j = 0; j < 10; j++) {
            start = System.nanoTime();
            for (int k = j*100; k < (j+1)*100; k++)
                demoHS.contains(getHSValue.get(k)); // This could be stored into variable if needed
            end = System.nanoTime();
            gettingHMTimes.add((end - start) / 100);
        }
        Collections.sort(gettingHMTimes);

        return gettingHMTimes.get(gettingHMTimes.size() / 2);
    }

    private static Long testGetTree() {

        ArrayList<Double> elementsToTree = new ArrayList<>(maxElements);
        ArrayList<Double> getTreeValue = new ArrayList<>(maxElements);
        for (int i = 0; i < maxElements; i++)
            elementsToTree.add(i * 3.14159);
        TreeDemo ourTree = new TreeDemo(elementsToTree);

        for (Double d: elementsToTree)
            getTreeValue.add(d);
        Collections.shuffle(getTreeValue);

        long start;
        long end;
        ArrayList<Long> gettingTreeTimes = new ArrayList<>();

        // BinaryTree testing:
        for (int j = 0; j < 10; j++) {
            start = System.nanoTime();
            for (int k = j*100; k < (j+1)*100; k++)
                ourTree.contains(getTreeValue.get(k));
            end = System.nanoTime();
            gettingTreeTimes.add((end - start) / 100);
        }
        Collections.sort(gettingTreeTimes);

        return gettingTreeTimes.get(gettingTreeTimes.size() / 2);
    }

    private static void printResults(String s, Long x, Long al) {
        System.out.println("\n\tCreated " + maxElements + " elements using the name you gave and stored them to " +
                s + " and Arraylist");
        System.out.println("\n\tSearched 1000 random elements from " + s + " and ArrayList.");
        System.out.println("\n\t\tRESULTS:");
        System.out.println("\n\t\t- Median searching time from ArrayList: " + al + " nanoseconds.");
        System.out.println("\n\t\t- Median searching time from " + s + ": " + x + " nanoseconds.");
    }
}
