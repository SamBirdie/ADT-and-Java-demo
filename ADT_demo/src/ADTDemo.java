import java.util.*;

public class ADTDemo {
    private static int maxElements = 65535; // =2^16-1 elements, when binary tree's depth is 16
    private static int warmingUpTimeInSeconds = 2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        showMenu(scanner);
    }

    private static void showMenu(Scanner scanner) {

        boolean continueWhileLoop = true;
        while (continueWhileLoop) {
            System.out.println("\n\n\n\t--- MENU ---\n");
            System.out.println("1) Demonstration of hash set");
            System.out.println("2) Demonstration of binary tree");
            System.out.println("q) Quit/Exit");
            System.out.print("> ");
            String choice = scanner.nextLine();
            System.out.println();

            switch (choice.toLowerCase()) {
                case "1":
                    exampleWithHashSet();
                    break;
                case "2":
                    exampleWithBinaryTree();
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

    private static void exampleWithBinaryTree() {

        Random random = new Random();
        Long medianGetResultFromArrayList = testGetAL(random);
        Long medianGetResultFromBinaryTree = testGetBinaryTree(random);

        printResults("BinaryTree", medianGetResultFromBinaryTree, medianGetResultFromArrayList);
    }

    private static Long testGetAL(Random random) {
        System.out.println("Creating ArrayList...");
        ArrayList<Double> demoAL = new ArrayList<>(maxElements);
        ArrayList<Double> getALValue = new ArrayList<>(maxElements);

        double rnd = random.nextDouble();
        for (int i = 0; i < maxElements; i++)
            demoAL.add(i * rnd);

        for (double d: demoAL)
            getALValue.add(d);
        Collections.shuffle(getALValue);

        // Warming up:
        System.out.println("Warming up ArrayList-engine for " + warmingUpTimeInSeconds + " seconds...");
        long endWarming = System.nanoTime() + warmingUpTimeInSeconds*1000L*1000*1000;
        while (System.nanoTime() < endWarming)
            demoAL.contains(getALValue.get(random.nextInt(maxElements)));

        // Testing ArrayList:
        System.out.println("Testing for ArrayList...");
        System.out.println();
        long start;
        long end;
        ArrayList<Long> gettingALTimes = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            start = System.nanoTime();
            for (int k = i*100; k < (i+1)*100; k++)
                demoAL.contains(getALValue.get(k)); // This could be stored into variable if needed
            end = System.nanoTime();
            gettingALTimes.add((end - start) / 100);
        }
        Collections.sort(gettingALTimes);
        return gettingALTimes.get(gettingALTimes.size() / 2);
    }

    private static Long testGetHS(Random random) {
        System.out.println("Creating HashSet...");
        HashSet<Double> demoHS = new HashSet<>();
        ArrayList<Double> getHSValue = new ArrayList<>();

        Double e;
        double rnd = random.nextDouble();
        for (int i = 0; i < maxElements; i++) {
            e = i * rnd;
            demoHS.add(e);
            getHSValue.add(e);
        }
        Collections.shuffle(getHSValue);

        // Warming up:
        System.out.println("Warming up HashSet-engine for " + warmingUpTimeInSeconds + " seconds...");
        long endWarming = System.nanoTime() + warmingUpTimeInSeconds*1000L*1000*1000;

        while (System.nanoTime() < endWarming)
            demoHS.contains(getHSValue.get(random.nextInt(maxElements)));

        // Testing HashMap:
        System.out.println("Testing for HashSet...");
        long start;
        long end;
        ArrayList<Long> gettingHSTimes = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            start = System.nanoTime();
            for (int k = i*100; k < (i+1)*100; k++)
                demoHS.contains(getHSValue.get(k)); // This could be stored into variable if needed
            end = System.nanoTime();
            gettingHSTimes.add((end - start) / 100);
        }
        Collections.sort(gettingHSTimes);
        return gettingHSTimes.get(gettingHSTimes.size() / 2);
    }

    private static Long testGetBinaryTree(Random random) {
        System.out.println("Creating BinaryTree...");
        ArrayList<Double> elementsToBinaryTree = new ArrayList<>(maxElements);
        ArrayList<Double> getBinaryTreeValue = new ArrayList<>(maxElements);

        double rnd = random.nextDouble();
        for (int i = 0; i < maxElements; i++)
            elementsToBinaryTree.add(i * rnd);
        TreeDemo demoBT = new TreeDemo(elementsToBinaryTree);
        for (double d: elementsToBinaryTree)
            getBinaryTreeValue.add(d);
        Collections.shuffle(getBinaryTreeValue);

        // Warming up:
        System.out.println("Warming up BinaryTree-engine for " + warmingUpTimeInSeconds + " seconds...");
        long endWarming = System.nanoTime() + warmingUpTimeInSeconds*1000L*1000*1000;
        while (System.nanoTime() < endWarming)
            demoBT.contains(getBinaryTreeValue.get(random.nextInt(maxElements)));

        // Testing Tree:
        System.out.println("Testing for Tree...");
        long start;
        long end;
        ArrayList<Long> gettingBTTimes = new ArrayList<>();

        // BinaryTree testing:
        for (int i = 0; i < 10; i++) {
            start = System.nanoTime();
            for (int k = i*100; k < (i+1)*100; k++)
                demoBT.contains(getBinaryTreeValue.get(k));
            end = System.nanoTime();
            gettingBTTimes.add((end - start) / 100);
        }
        Collections.sort(gettingBTTimes);
        return gettingBTTimes.get(gettingBTTimes.size() / 2);
    }

    private static void printResults(String adt, Long xTime, Long alTime) {
        System.out.println("\n\tCreated " + maxElements + " elements using the name you gave and stored them to " +
                adt + " and Arraylist");
        System.out.println("\tAND\n\tSearched 1000 random elements from " + adt + " and ArrayList.");
        System.out.println("\n\t\tRESULTS:");
        System.out.println("\n\t\t- Median searching time from ArrayList (for reference): " + alTime + " nanoseconds.");
        System.out.println("\t\t- Median searching time from " + adt + ": " + xTime + " nanoseconds.");
    }
}
