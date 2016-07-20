package DataStructures.Trees;

public abstract class TreeNode<T>{
    private TreeNode<T> parentNode;
    private T data;

    public TreeNode<T> getParentNode() {
        return parentNode;
    }

    public void setParentNode(TreeNode<T> parentNode) {
        this.parentNode = parentNode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
