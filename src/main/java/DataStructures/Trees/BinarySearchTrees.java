package DataStructures.Trees;

public class BinarySearchTrees<T extends Comparable<T>> implements IBinarySearchTree<T> {

    private BinaryTreeNode<T> root;
    private int size;

    public String preOrderTraversal() {
        return printPreOrder(root).toString();
    }

    private StringBuilder printPreOrder(BinaryTreeNode<T> node) {
        StringBuilder sb = new StringBuilder();
        sb.append(node.getData().toString()).append(", ");
        if (node.getLeftChild() != null)
            sb.append(printPreOrder((BinaryTreeNode<T>)node.getLeftChild()));

        if (node.getRightChild() != null)
            sb.append(printPreOrder((BinaryTreeNode<T>)node.getRightChild()));
        return sb;
    }

    public String postOrderTraversal() {
        return printPostOrder(root).toString();
    }

    private StringBuilder printPostOrder(BinaryTreeNode<T> node) {
        StringBuilder sb = new StringBuilder();
        if (node.getLeftChild() != null)
            sb.append(printPostOrder((BinaryTreeNode<T>)node.getLeftChild()));

        if (node.getRightChild() != null)
            sb.append(printPostOrder((BinaryTreeNode<T>)node.getRightChild()));

        sb.append(node.getData().toString()).append(", ");
        return sb;
    }

    public String inOrderTraversal() {
        return printInOrder(root).toString();
    }

    private StringBuilder printInOrder(BinaryTreeNode<T> node) {
        StringBuilder sb = new StringBuilder();
        if (node.getLeftChild() != null)
            sb.append(printInOrder((BinaryTreeNode<T>)node.getLeftChild()));

        sb.append(node.getData().toString()).append(", ");

        if (node.getRightChild() != null)
            sb.append(printInOrder((BinaryTreeNode<T>)node.getRightChild()));
        return sb;
    }

    public boolean isRoot(BinaryTreeNode<T> node) {
        return node.equals(root);
    }

    public boolean isInternal(BinaryTreeNode<T> node) {
        return !isExternal(node);
    }
    public boolean isExternal(BinaryTreeNode<T> node) {
        return (node.getRightChild() == null || node.getLeftChild() == null);
    }

    public T minElement() {
        if (root == null)
            return null;

        BinaryTreeNode<T> cur = root;
        while (cur.getLeftChild() != null) {
            cur = (BinaryTreeNode<T>) cur.getLeftChild();
        }
        return cur.getData();
    }

    public T maxElement() {
        if (root == null)
            return null;

        BinaryTreeNode<T> cur = root;
        while (cur.getRightChild() != null) {
            cur = (BinaryTreeNode<T>) cur.getRightChild();
        }
        return cur.getData();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public int height() {
        if (this.size < 2)
            return 0;
        return computeHeight(root);
    }

    private int computeHeight(BinaryTreeNode<T> curNode) {

        if (curNode == null)
            return -1;

        return Math.max(computeHeight((BinaryTreeNode<T>)curNode.getLeftChild()),
                computeHeight((BinaryTreeNode<T>)curNode.getRightChild())) +1;

    }

    public void addElement(T element) {
        if (root == null) {
            root = new BinaryTreeNode<T>(element);
        } else {
            BinaryTreeNode<T> cur = root;

            while (cur != null) {
                int compare = cur.getData().compareTo(element);
                if (compare > 0) {
                    if (cur.getLeftChild() == null) {
                        cur.setLeftChild(new BinaryTreeNode<T>(element));
                        break;
                    } else
                        cur = (BinaryTreeNode<T>) cur.getLeftChild();
                }
                else if (compare < 0) {
                    if (cur.getRightChild() == null) {
                        cur.setRightChild(new BinaryTreeNode<T>(element));
                        break;
                    } else
                        cur = (BinaryTreeNode<T>) cur.getRightChild();
                }
                else
                    return;
            }
        }
        size++;
    }

    public boolean findElement(T element) {
        if (size == 0)
            return false;

        BinaryTreeNode<T> cur = root;
        while (cur != null) {
            int compare = cur.getData().compareTo(element);
            if (compare > 0)
                cur = (BinaryTreeNode<T>) cur.getLeftChild();
            else if (compare < 0)
                cur = (BinaryTreeNode<T>) cur.getRightChild();
            else
                return true;
        }
        return false;
    }

    public T removeElement(T element) {
        return null;
    }
}
