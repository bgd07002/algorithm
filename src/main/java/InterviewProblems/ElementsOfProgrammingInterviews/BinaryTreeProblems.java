package InterviewProblems.ElementsOfProgrammingInterviews;

import DataStructures.Trees.BinarySearchTrees;
import DataStructures.Trees.BinaryTreeNode;

public class BinaryTreeProblems<T extends Comparable<T>> {

    /**
     * 10.2 Test if binary tree is symmetric
     */
    public boolean isBinaryTreeSymmetric(BinarySearchTrees<T> bst) {
        if (bst.getSize() < 2)
            return true;
        else if (bst.getSize() % 2 == 0)
            return false;

        return isBinaryTreeSymmetricHelper(bst.getRoot(), bst.getRoot());
    }

    private boolean isBinaryTreeSymmetricHelper(BinaryTreeNode<T> node1, BinaryTreeNode<T> node2) {
        if (node1 == null && node2 == null)
            return true;

        if (node1 != null && node2 != null)
            return isBinaryTreeSymmetricHelper(node1.getLeftChild(), node2.getRightChild()) &&
                    isBinaryTreeSymmetricHelper(node1.getRightChild(), node2.getLeftChild());

        return false;
    }

    /**
     * 10.5 Sum the root to leaf paths in a binary formed tree. Each its node consists of
     * binary numbers
     */
    /*
    public int binaryFormedTreeSum(BinaryFormedBinaryTree tree) {
        return binaryFormedTreeSumHelper(tree.getRoot(),0);
    }

    private int binaryFormedTreeSumHelper(BinaryTreeNode<Integer> node, int partialSum) {
        if (node == null)
            return 0;

        partialSum = partialSum*2 + node.getData();
        //If leaf
        if (node.getRightChild() == null && node.getLeftChild() == null)
            return partialSum;

        //Non-leaf case
        return binaryFormedTreeSumHelper(node.getLeftChild(), partialSum) +
                binaryFormedTreeSumHelper(node.getRightChild(), partialSum);
    }
    */
}
