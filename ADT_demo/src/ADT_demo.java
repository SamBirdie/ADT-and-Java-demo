

public class ADT_demo {

    public static void main(String[] args) {
        // argumentteina toiminto; jos ei anneta tulostetaan valikko

        boolean getHashmapDemoDatabase = false;
        boolean getTreeDemoDatabase = false;

        switch (args[0]) {
            case "hashmap":
                // TODO
                getHashmapDemoDatabase = true;
                break;

            case "tree":
                getTreeDemoDatabase = true;
                break;
        }

        if (getHashmapDemoDatabase)
            exampleWithHashMap();

        else if (getTreeDemoDatabase)
            exampleWithTree();
    }

    private static void exampleWithHashMap() {
        // TODO
        System.out.println("HashMap-example here");
    }

    private static void exampleWithTree() {
        // TODO
        System.out.println("Tree-example here");
    }
}