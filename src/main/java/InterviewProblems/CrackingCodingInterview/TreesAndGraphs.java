package InterviewProblems.CrackingCodingInterview;

import DataStructures.Trees.BinarySearchTrees;
import DataStructures.Trees.BinaryTreeNode;
import DataStructures.Trees.IBinarySearchTree;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class TreesAndGraphs<T extends Comparable<T>> {

    /**
     * 4.1 Route between nodes: Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
     */


    /**
     * 4.2 Minimal Tree: Given a sorted (increasing) array with unique integer elements, write an algorithm to create binary search
     * tree with minimal height.
     */
    public IBinarySearchTree<Integer> bstFromSortedArray(int[] sortedArray) {

        IBinarySearchTree<Integer> bst = new BinarySearchTrees<>();
        if (sortedArray.length < 1)
            return bst;

        bstFromSortedArrayHelper(bst, sortedArray, 0, sortedArray.length-1);
        return bst;
    }

    private void bstFromSortedArrayHelper(IBinarySearchTree<Integer> bst, int[] sortedArray, int start, int finish) {
        int mid = (start+finish)/2;
        bst.addElement(sortedArray[mid]);

        if (start <= mid-1)
            bstFromSortedArrayHelper(bst, sortedArray, start, mid-1);

        if (mid+1 <= finish)
            bstFromSortedArrayHelper(bst, sortedArray, mid+1, finish);
    }

    /**
     * 4.3 List of depths: Given a binary tree, design an algorithm which creates a linked list of all nodes at each depth
     * (if you have tree with depth D, you will have D linked lists)
     */
    public LinkedHashMap<Integer, LinkedList<T>> listAtDepth(BinarySearchTrees<T> bst) {
        LinkedHashMap<Integer, LinkedList<T>> listOfDepths = new LinkedHashMap<>();
        listAtDepthHelper(listOfDepths, bst.getRoot());
        return listOfDepths;
    }

    private void listAtDepthHelper(LinkedHashMap<Integer, LinkedList<T>> listOfDepths, BinaryTreeNode<T> node) {

    }

    /**
     * 4.5 BST Validation: Implement a function to check if a binary tree is a binary search tree
     */
    public boolean validateBST(BinarySearchTrees<T> inputTree) {
        if (inputTree.getSize() < 2)
            return true;

        return validateBSTHelper(inputTree, inputTree.getRoot());
    }

    private boolean validateBSTHelper(BinarySearchTrees<T> inputTree, BinaryTreeNode<T> subRoot) {
        if (subRoot.getRightChild() != null) {
            if (subRoot.getData().compareTo(subRoot.getRightChild().getData()) <= 0)
                validateBSTHelper(inputTree, (BinaryTreeNode<T>) subRoot.getRightChild());
            else
                return false;
        }

        if (subRoot.getLeftChild() != null) {
            if (subRoot.getData().compareTo(subRoot.getLeftChild().getData()) >= 0)
                validateBSTHelper(inputTree, (BinaryTreeNode<T>) subRoot.getLeftChild());
            else
                return false;
        }
        return true;
    }
}
