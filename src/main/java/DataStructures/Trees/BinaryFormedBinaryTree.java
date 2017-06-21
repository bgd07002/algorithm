package DataStructures.Trees;

public class BinaryFormedBinaryTree {

    private BinaryTreeNode<Integer> root;
    private int size;

    public BinaryFormedBinaryTree() {
        root = new BinaryTreeNode<>(-1);
    }

    public BinaryTreeNode<Integer> getRoot() { return root; }
    public boolean isEmpty() {
        return size == 0;
    }
    public int getSize() {
        return size;
    }

    public void addElement(int element) {
        BinaryTreeNode<Integer> cur = root;

        while (element > 0) {
            if ((element & 1) == 0) {
                if (cur.getLeftChild() == null)
                    cur.setLeftChild(new BinaryTreeNode<>(element&1));
                else
                    cur = cur.getLeftChild();
            } else {
                if (cur.getRightChild() == null)
                    cur.setRightChild(new BinaryTreeNode<>(element&1));
                else
                    cur = cur.getRightChild();
            }
            element = (element >> 1);
        }
    }
}
