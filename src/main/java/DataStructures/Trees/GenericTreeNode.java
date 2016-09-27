package DataStructures.Trees;

import java.util.ArrayList;

public class GenericTreeNode<T> extends TreeNode<T> {

    private ArrayList<TreeNode<T>> childrenNodes;
    public ArrayList<TreeNode<T>> getChildrenNodes() {
        return childrenNodes;
    }
    public void setChildrenNodes(ArrayList<TreeNode<T>> childrenNodes) {
        this.childrenNodes = childrenNodes;
    }
}
