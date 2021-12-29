import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class ADTDemo {
    private static final int maxElements = 65535; // =2^16-1 elements, when binary tree's depth is 16
    private static final int warmingUpTimeInSeconds = 2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        showMenu(scanner, random);
    }

    private static void showMenu(Scanner scanner, Random random) {

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
                case "1" -> printResults("HashSet", testDT(random, "HashSet"), testDT(random, "ArrayList"));
                case "2" -> printResults("BinaryTree", testDT(random, "BinaryTree"), testDT(random, "ArrayList"));
                case "q" -> {
                    System.out.println("\t\tThank you and have a nice day!\n");
                    continueWhileLoop = false;
                }
                default -> System.out.println("\tPlease choose option from the menu below");
            }
        }
    }

    private static Long testDT(Random random, String dataType) {
        ArrayList<Double> getDTValue = new ArrayList<>(maxElements);

        Collection<Double> c;
        double rnd = random.nextDouble();

        for (int i = 0; i < maxElements; i++)
            getDTValue.add(i * rnd);

        if (dataType.equals("BinaryTree")) {
            c = (Collection<Double>) new TreeDemo(getDTValue);
        }
        else {
            if (dataType.equals("ArrayList"))
                c = new ArrayList<>(maxElements);
            else // dataType == HashSet
                c = new HashSet<>();
            for (double value : getDTValue)
                c.add(value);
        }

        Collections.shuffle(getDTValue);
        warmUp(c, getDTValue, random, dataType);
        return runTest(c, getDTValue, dataType);
    }

    private static void warmUp(Collection<Double> c, ArrayList<Double> getDTValue, Random random, String dataType) {
        System.out.println("Warming up " + dataType + "-engine for " + warmingUpTimeInSeconds + " seconds...");
        long endWarming = System.nanoTime() + warmingUpTimeInSeconds*1000L*1000*1000;
        while (System.nanoTime() < endWarming)
            c.contains(getDTValue.get(random.nextInt(maxElements)));
    }

    private static Long runTest(Collection<Double> c, ArrayList<Double> getDTValue, String dataType) {
        System.out.println("Testing for " + dataType + "...");
        System.out.println();
        long start;
        long end;
        ArrayList<Long> gettingDTTimes = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            start = System.nanoTime();
            for (int k = i * 100; k < (i + 1) * 100; k++)
                c.contains(getDTValue.get(k)); // This could be stored into variable if needed
            end = System.nanoTime();
            gettingDTTimes.add((end - start) / 100);
        }
        Collections.sort(gettingDTTimes);
        return gettingDTTimes.get(gettingDTTimes.size() / 2);
    }

    private static void printResults(String dt, Long xTime, Long alTime) {
        System.out.println("\n\tCreated " + maxElements + " elements using the name you gave and stored them to " +
                dt + " and Arraylist");
        System.out.println("\tAND\n\tSearched 1000 random elements from " + dt + " and ArrayList.");
        System.out.println("\n\t\tRESULTS:");
        System.out.println("\t\t- Median searching time from " + dt + ": " + xTime + " nanoseconds.");
        System.out.println("\n\t\t- Median searching time from ArrayList (for reference): " + alTime + " nanoseconds.");
    }
}
