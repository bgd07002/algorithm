package DataStructures.Trees;

public class BinaryTreeNode<T> extends TreeNode<T> {

    private BinaryTreeNode<T> leftChild;
    private BinaryTreeNode<T> rightChild;
    private BinaryTreeNode<T> parent;

    public BinaryTreeNode(T element) {
        super.setData(element);
    }

    public BinaryTreeNode<T> getLeftChild() { return leftChild; }

    public void setLeftChild(BinaryTreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryTreeNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryTreeNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    public BinaryTreeNode<T> getParentNode() {
        return parent;
    }

    public void setParent(BinaryTreeNode<T> parent) {
        this.parent = parent;
    }
}
