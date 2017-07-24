package DataStructures.Trees;

public class BinarySearchTrees<T extends Comparable<T>> implements IBinarySearchTree<T> {

    private BinaryTreeNode<T> root;
    private int size;

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public BinaryTreeNode<T> getRoot() {
        return root;
    }

    @Override
    public boolean isRoot(BinaryTreeNode<T> node) {
        return node.getData().equals(root.getData());
    }

    @Override
    public boolean isInternal(BinaryTreeNode<T> node) {
        return node.getLeftChild()!= null || node.getRightChild() != null;
    }

    @Override
    public boolean isExternal(BinaryTreeNode<T> node) {
        return !isInternal(node);
    }

    @Override
    public T minElement() {
        if (isEmpty())
            return null;

        BinaryTreeNode<T> cur = root;
        while (cur.getLeftChild() != null) {
            cur = cur.getLeftChild();
        }
        return cur.getData();
    }

    @Override
    public T maxElement() {
        if (isEmpty())
            return null;

        BinaryTreeNode<T> cur = root;
        while (cur.getRightChild() != null) {
            cur = cur.getRightChild();
        }
        return cur.getData();
    }

    @Override
    public void addElement(T element) {
        if (isEmpty()) {
            root = new BinaryTreeNode<>(element);
            size++;
            return;
        }

        BinaryTreeNode<T> cur = root;
        while (cur != null) {
            int compare = cur.getData().compareTo(element);
            if (compare > 0)
                if (cur.getLeftChild() == null) {
                    BinaryTreeNode<T> newNode = new BinaryTreeNode<>(element);
                    cur.setLeftChild(newNode);
                    newNode.setParent(cur);
                    size++;
                }
                else
                    cur = cur.getLeftChild();
            else if (compare < 0)
                if (cur.getRightChild() == null) {
                    BinaryTreeNode<T> newNode = new BinaryTreeNode<>(element);
                    cur.setRightChild(newNode);
                    newNode.setParent(cur);
                    size++;
                }
                else
                    cur = cur.getRightChild();
            else
                return;
        }
    }

    @Override
    public boolean findElement(T element) {
        if (isEmpty())
            return false;

        BinaryTreeNode<T> cur = root;
        while (cur != null) {
            int compare = cur.getData().compareTo(element);
            if (compare > 0)
                cur = cur.getLeftChild();
            else if (compare < 0)
                cur = cur.getRightChild();
            else
                return true;
        }
        return false;
    }

    @Override
    public String preOrderTraversal() {
        return printPreOrder(root).toString();
    }
    private StringBuilder printPreOrder(BinaryTreeNode<T> node) {
        StringBuilder sb = new StringBuilder();
        sb.append(node.getData().toString()).append(", ");
        if (node.getLeftChild() != null)
            sb.append(printPreOrder(node.getLeftChild()));

        if (node.getRightChild() != null)
            sb.append(printPreOrder(node.getRightChild()));
        return sb;
    }

    @Override
    public String postOrderTraversal() { return printPostOrder(root).toString(); }
    private StringBuilder printPostOrder(BinaryTreeNode<T> node) {
        StringBuilder sb = new StringBuilder();
        if (node.getLeftChild() != null)
            sb.append(printPostOrder(node.getLeftChild()));

        if (node.getRightChild() != null)
            sb.append(printPostOrder(node.getRightChild()));

        sb.append(node.getData().toString()).append(", ");
        return sb;
    }

    @Override
    public String inOrderTraversal() { return printInOrder(root).toString(); }
    private StringBuilder printInOrder(BinaryTreeNode<T> node) {
        StringBuilder sb = new StringBuilder();
        if (node.getLeftChild() != null)
            sb.append(printInOrder(node.getLeftChild()));

        sb.append(node.getData().toString()).append(", ");

        if (node.getRightChild() != null)
            sb.append(printInOrder(node.getRightChild()));
        return sb;
    }

    @Override
    public int height() {
        if (this.size < 2)
            return 0;
        return computeHeight(root);
    }

    public int computeHeight(BinaryTreeNode<T> curNode) {
        if (curNode.getLeftChild() == null || curNode.getRightChild() == null)
            return 0;

        return Math.max(computeHeight(curNode.getLeftChild()), computeHeight(curNode.getRightChild()))+1;

    }

    @Override
    public T removeElement(T element) {
        BinaryTreeNode<T> removedElement = null;
        BinaryTreeNode<T> nodeElement = locateElement(element);

        if (isExternal(nodeElement)) {
            removedElement = nodeElement;
            nodeElement = null;
            size--;
        } else {

        }

        if (removedElement == null)
            return null;

        return removedElement.getData();
    }

    public BinaryTreeNode locateElement(T element) {
        if (isEmpty())
            return null;

        BinaryTreeNode<T> cur = root;
        while (cur != null) {
            int compare = cur.getData().compareTo(element);
            if (compare > 0)
                cur = cur.getLeftChild();
            else if (compare < 0)
                cur = cur.getRightChild();
            else
                return cur;
        }
        return null;
    }
}
