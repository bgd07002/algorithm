package DataStructures.Trees;

public class BinaryTreeNode<T> extends TreeNode<T> {

    private TreeNode<T> leftChild;
    private TreeNode<T> rightChild;

    public BinaryTreeNode(T element) {
        super.setData(element);
    }

    public TreeNode<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode<T> rightChild) {
        this.rightChild = rightChild;
    }
}
