package InterviewProblems.ElementsOfProgrammingInterviews;

import DataStructures.Trees.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTrees<T extends Comparable<T>> {

    /**
     * 15.1 Test if binary tree satisfies BST property (Cracking Coding Int 4.5)
     * 15.2 Find the first key greater than a given value in BST (Ceiling function)
     * 15.3 Find kth largest element in BST
     */
    public T k_thLargestElement(DataStructures.Trees.BinarySearchTrees<T> bst, int k) {
        if (k > bst.getSize())
            return null;
        List<T> nodesInOrder = k_thLargestElementHelper(bst.getRoot(), k);
        return nodesInOrder.get(k-1);
    }

    private List<T> k_thLargestElementHelper(DataStructures.Trees.BinaryTreeNode<T> node, int k) {
        List<T> nodesInOrder = new ArrayList<>();
        if (node.getLeftChild() != null)
            nodesInOrder.addAll(k_thLargestElementHelper(node.getLeftChild(),k));

        nodesInOrder.add(node.getData());

        if (node.getRightChild() != null)
            nodesInOrder.addAll(k_thLargestElementHelper(node.getRightChild(),k));

        return nodesInOrder;
    }
}
