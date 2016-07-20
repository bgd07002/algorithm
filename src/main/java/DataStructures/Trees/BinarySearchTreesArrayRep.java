package DataStructures.Trees;

import java.util.ArrayList;


public class BinarySearchTreesArrayRep<T extends Comparable<T>> implements IBinarySearchTree<T> {

    private int size;
    private ArrayList<BinaryTreeNode<T>> bstList;

    public BinarySearchTreesArrayRep() {
        bstList = new ArrayList<>();
    }

    public String preOrderTraversal() {
        return null;
    }

    public String postOrderTraversal() {
        return null;
    }

    public String inOrderTraversal() {
        return null;
    }

    public boolean isRoot(BinaryTreeNode<T> node) {
        return bstList.get(0).getData().equals(node.getData());
    }

    public boolean isInternal(BinaryTreeNode<T> node) {
        return false;
    }

    public boolean isExternal(BinaryTreeNode<T> node) {
        return false;
    }

    public T minElement() {
        if (bstList.size() == 0)
            return null;

        int i =0;
        while ((2*i+1) < bstList.size() && bstList.get(2*i+1) != null) {
            i = 2*i+1;
        }
        return bstList.get(i).getData();
    }

    public T maxElement() {
        if (bstList.size() == 0)
            return null;

        int i =0;
        while ((2*i+2) < bstList.size() && bstList.get(2*i+2) != null) {
            i = 2*i+2;
        }
        return bstList.get(i).getData();
    }

    public boolean isEmpty() {
        return size ==0;
    }

    public int getSize() {
        return size;
    }

    public int height() {
        int reduceDepth = bstList.size();
        int height = 0;
        while (reduceDepth != 1) {
            reduceDepth /=2;
            height++;
        }
        return height;
    }

    /**
     * Child element for x is:
     * 2x+1 and 2x+2
     */
    public void addElement(T element) {
        if (bstList.size() == 0) {
            bstList.add(new BinaryTreeNode<>(element));
            size=1;
            return;
        }

        int idx =0;
        while (bstList.size() > idx && bstList.get(idx) != null) {
            int compared = bstList.get(idx).getData().compareTo(element);
            if (compared == 0)
                return;
            else if (compared > 0)
                idx = 2*idx +1;
            else
                idx = 2*idx +2;
        }

        //while (bstList.size() <= idx + 1) {
        //    bstList.add(null);
        //}

        bstList.add(idx, new BinaryTreeNode<>(element));
        size++;
    }

    public boolean findElement(T element) {
        if (bstList.size() == 0)
            return false;

        int idx = 0;
        while (bstList.size() > idx && bstList.get(idx) != null) {
            int compared = bstList.get(idx).getData().compareTo(element);
            if (compared == 0)
                return true;
            else if (compared > 0)
                idx = 2*idx +1;
            else
                idx = 2*idx +2;
        }
        return false;
    }

    public T removeElement(T element) {
        return null;
    }
}
