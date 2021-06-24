import java.util.ArrayList;
import java.util.Collections;

public class TreeDemo {

    private NodeDemo root;

    public TreeDemo(ArrayList<Double> nodeElements) {
        Collections.sort(nodeElements);
        root = new NodeDemo(nodeElements.get(nodeElements.size()/2));

        ArrayList<Double> leftSubTreeElements = new ArrayList();
        for (int i = 0; i < nodeElements.size()/2; i++)
            leftSubTreeElements.add(nodeElements.get(i));

        ArrayList<Double> rightSubTreeElements = new ArrayList();
        for (int i = nodeElements.size()/2+1; i < nodeElements.size(); i++)
            rightSubTreeElements.add(nodeElements.get(i));

        root.setLeft(setSubTrees(leftSubTreeElements));
        root.setRight(setSubTrees(rightSubTreeElements));
    }

    public boolean contains(Double d) {
        return subTreeContains(d, root);
    }

    private static boolean subTreeContains(Double d, NodeDemo node) {
        if (node.getElement() == d) return true;
        else if (node.getLeft() != null && node.getElement() < d)
            if (subTreeContains(d, node.getLeft())) return true;
        else if (node.getRight() != null && node.getElement() > d)
            if (subTreeContains(d, node.getRight())) return true;
        return false;
    }

    private static NodeDemo setSubTrees(ArrayList<Double> list) {
        NodeDemo node;
        if (list.size() == 3) {
            node = new NodeDemo(list.get(1));
            node.setLeft(new NodeDemo(list.get(0)));
            node.setRight(new NodeDemo(list.get(2)));
        }
        else {
            ArrayList<Double> leftSubTreeElements = new ArrayList();
            for (int i = 0; i < list.size()/2; i++)
                leftSubTreeElements.add(list.get(i));

            ArrayList<Double> rightSubTreeElements = new ArrayList();
            for (int i = list.size()/2+1; i < list.size(); i++)
                rightSubTreeElements.add(list.get(i));

            node = new NodeDemo(list.get(list.size()/2));
            node.setLeft(setSubTrees(leftSubTreeElements));
            node.setRight(setSubTrees(rightSubTreeElements));
        }
        return node;
    }
}
