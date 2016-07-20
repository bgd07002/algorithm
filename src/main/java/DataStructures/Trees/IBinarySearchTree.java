package DataStructures.Trees;

public interface IBinarySearchTree<T> {
    String preOrderTraversal();
    String postOrderTraversal();
    String inOrderTraversal();
    boolean isRoot(BinaryTreeNode<T> node);
    boolean isInternal(BinaryTreeNode<T> node);
    boolean isExternal(BinaryTreeNode<T> node);
    T minElement();
    T maxElement();
    boolean isEmpty();
    int getSize();
    int height();
    void addElement(T element);
    boolean findElement(T element);
    T removeElement(T element);
}
