

public class ADT_demo {
    public static void main(String[] args) {
        // argumentteina toiminto; jos ei anneta tulostetaan valikko

        boolean getHashmapDemoDatabase = false;
        boolean getTreeDemoDatabase = false;

        if (getHashmapDemoDatabase)
            exampleWithHashMap();

        else if (getTreeDemoDatabase)
            exampleWithTree();
    }

    private static void exampleWithHashMap() {
        System.out.println("HashMap-example here");
    }

    private static void exampleWithTree() {
        System.out.println("Tree-example here");
    }
}