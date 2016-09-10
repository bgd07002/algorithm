package DataStructures.Trees;

import java.awt.*;

public class RedBlackTrees<T extends Comparable<T>> extends BinarySearchTrees<T> {

    /**
     * Class for Red Black Node
     */
    private class RedBlackNode<T> extends BinaryTreeNode {
        private Color color;
        public RedBlackNode(T element, Color color) {
            super(element);
            this.color = color;
        }
    }

    @Override
    public void addElement(T element) {

    }

    @Override
    public T removeElement(T element) {
        return null;
    }


    private void adjustAfterInsertion(RedBlackNode n) {

    }

    private void adjustAfterDeletion(RedBlackNode n) {

    }

    /**
     * Some Helper methods
     */
    private Color colorOf(RedBlackNode n) {
        return n == null ? Color.black : n.color;
    }

    private boolean isRed(RedBlackNode n) {
        return n != null && colorOf(n) == Color.red;
    }

    private boolean isBlack(RedBlackNode n) {
        return n != null || colorOf(n) == Color.black;
    }

    private void setColor(RedBlackNode n, Color c) {
        if (n != null)
            n.color = c;
    }

    private RedBlackNode parentOf(RedBlackNode n) {
        return n == null ? null : (RedBlackNode) n.getParentNode();
    }

    private RedBlackNode grandparentOf(RedBlackNode n) {
        return (n == null || n.getParentNode() == null) ? null : (RedBlackNode) n.getParentNode().getParentNode();
    }

    private RedBlackNode siblingOf(RedBlackNode n) {
        return (n == null || n.getParentNode() == null) ? null : (n == n.getParentNode().getLeftChild()) ?
                (RedBlackNode) n.getParentNode().getRightChild() : (RedBlackNode) n.getParentNode().getLeftChild();
    }

    private RedBlackNode getLeftChild(RedBlackNode n) {
        return n == null ? null : (RedBlackNode) n.getLeftChild();
    }

    private RedBlackNode getRightChild(RedBlackNode n) {
        return n == null ? null : (RedBlackNode) n.getRightChild();
    }

}
