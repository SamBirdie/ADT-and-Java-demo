import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class TreeDemo implements Collection {

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

    @Override
    public boolean contains(Object d) {
        return subTreeContains((Double)d, root);
    }

    private static boolean subTreeContains(Double d, NodeDemo node) {
        if (node.getElement() == d) return true;
        else if (node.getLeft() != null && node.getElement() < d)
            if (subTreeContains(d, node.getLeft())) return true;
            else if (node.getRight() != null && node.getElement() > d)
                if (subTreeContains(d, node.getRight())) return true;
        return false;
    }

    // Rest of these are just to satisfy the implementation of Collection:
    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
