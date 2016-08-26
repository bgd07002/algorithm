package InterviewProblems.CrackingCodingInterview;

import DataStructures.Trees.*;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public class TreesAndGraphsTest {

    /**
     *                 10
     *               /    \
     *             /       \
     *           /          \
     *         5            20
     *      /    \         /  \
     *     3      7      14    21
     *   /  \    / \
     * 1     4  6   9
     */
    @Test
    public void validateBSTTest() throws Exception {

        TreesAndGraphs<Integer> s = new TreesAndGraphs<>();
        BinarySearchTrees<Integer> bst = new BinarySearchTrees<>();
        bst.addElement(10);
        bst.addElement(5);
        bst.addElement(20);
        bst.addElement(3);
        bst.addElement(7);
        bst.addElement(14);
        bst.addElement(21);
        bst.addElement(1);
        bst.addElement(4);
        bst.addElement(6);
        bst.addElement(9);
        bst.addElement(4);
        Assert.assertEquals(true, s.validateBST(bst));
    }

    @Test
    public void bstFromSortedArrayTest() throws Exception {
        TreesAndGraphs<Integer> s = new TreesAndGraphs<>();
        int[] inputArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        IBinarySearchTree<Integer> bst = s.bstFromSortedArray(inputArr);
        Assert.assertEquals(16, bst.getSize());
        Assert.assertEquals(5, bst.height());
    }

    @Test
    public void listAtDepthTest() throws Exception {
        TreesAndGraphs<Integer> s = new TreesAndGraphs<>();
        BinarySearchTrees<Integer> bst = new BinarySearchTrees<>();
        bst.addElement(10);
        bst.addElement(5);
        bst.addElement(20);
        bst.addElement(3);
        bst.addElement(7);
        bst.addElement(14);
        bst.addElement(21);
        bst.addElement(1);
        bst.addElement(4);
        bst.addElement(6);
        bst.addElement(9);
        bst.addElement(4);

        LinkedHashMap<Integer, LinkedList<BinaryTreeNode<Integer>>> listOfDepths = s.listAtDepth(bst);
        Assert.assertEquals(1, listOfDepths.get(0).size());
        Assert.assertEquals(2, listOfDepths.get(1).size());
        Assert.assertEquals(4, listOfDepths.get(2).size());
        Assert.assertEquals(4, listOfDepths.get(3).size());
    }

    @Test
    public void checkBalancedTest() throws Exception {
        TreesAndGraphs<Integer> s = new TreesAndGraphs<>();
        BinarySearchTrees<Integer> bst = new BinarySearchTrees<>();
        bst.addElement(10);
        bst.addElement(5);
        bst.addElement(20);
        bst.addElement(3);
        bst.addElement(7);
        bst.addElement(14);
        bst.addElement(21);
        bst.addElement(1);
        bst.addElement(4);
        bst.addElement(6);
        bst.addElement(9);
        bst.addElement(4);

        boolean isBalanced = s.checkBalanced(bst);
        Assert.assertEquals(true, isBalanced);

        bst.addElement(0);
        isBalanced = s.checkBalanced(bst);
        Assert.assertEquals(false, isBalanced);
    }

    @Test
    public void findSuccessorTest() throws Exception {
        TreesAndGraphs<Integer> s = new TreesAndGraphs<>();
        BinarySearchTrees<Integer> bst = new BinarySearchTrees<>();
        bst.addElement(10);
        bst.addElement(5);
        bst.addElement(20);
        bst.addElement(3);
        bst.addElement(7);
        bst.addElement(14);
        bst.addElement(21);
        bst.addElement(1);
        bst.addElement(4);
        bst.addElement(6);
        bst.addElement(9);
        bst.addElement(4);

        int successor = s.findSuccessor(bst.getRoot());
        Assert.assertEquals(20, successor);

        successor = s.findSuccessor(bst.getRoot().getLeftChild().getRightChild().getRightChild());
        Assert.assertEquals(10, successor);

        Integer successor2 = s.findSuccessor(bst.getRoot().getRightChild().getRightChild());
        Assert.assertEquals(null, successor2);
    }
}
