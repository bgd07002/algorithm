package InterviewProblems.CrackingCodingInterviews;

import DataStructures.Trees.*;
import InterviewProblems.CrackingCodingInterviews.TreesAndGraphs;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class TreesAndGraphsTest {

    /**
     * 4.2
     */
    @Test
    public void bstFromSortedArrayTest() {
        TreesAndGraphs<Integer> s = new TreesAndGraphs<>();
        int[] inputArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        IBinarySearchTree<Integer> bst = s.bstFromSortedArray(inputArr);
        Assert.assertEquals(16, bst.getSize());
        Assert.assertEquals(3, bst.height());
    }

    /**
     * 4.3
     */
    @Test
    public void listAtDepthTest() {
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

        HashMap<Integer, LinkedList<BinaryTreeNode<Integer>>> listOfDepths = s.listAtDepth(bst);
        Assert.assertEquals(1, listOfDepths.get(0).size());
        Assert.assertEquals(2, listOfDepths.get(1).size());
        Assert.assertEquals(4, listOfDepths.get(2).size());
        Assert.assertEquals(4, listOfDepths.get(3).size());
    }

    /**
     * 4.4
     */
    @Test
    public void checkBalancedTest() {
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

    /**
     * 4.5
     *
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
    public void validateBSTTest() {

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

    /**
     * 4.6
     */
    @Test
    public void findSuccessorTest() {
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

    /**
     * 4.8
     *
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
    public void firstCommonAncestorTest() {
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

        BinaryTreeNode<Integer> one = bst.getRoot().getLeftChild().getLeftChild().getLeftChild();
        BinaryTreeNode<Integer> six = bst.getRoot().getLeftChild().getRightChild().getLeftChild();
        BinaryTreeNode<Integer> seven = bst.getRoot().getLeftChild().getRightChild();
        BinaryTreeNode<Integer> ten = bst.getRoot();

        int commonAnc = s.firstCommonAncestor(one, six);
        Assert.assertEquals(5, commonAnc);

        commonAnc = s.firstCommonAncestor(one, seven);
        Assert.assertEquals(5, commonAnc);

        commonAnc = s.firstCommonAncestor(one, ten);
        Assert.assertEquals(10, commonAnc);
    }

    /**
     *                 10
     *               /    \
     *             /       \
     *           /          \
     *         5            20
     *      /    \         /  \
     *     3      7      14    21
     *   /  \    /              \
     * 1     4  6               22
     */
    @Test
    public void bstSequencesTest() {
        TreesAndGraphs<Integer> s = new TreesAndGraphs<>();
        BinarySearchTrees<Integer> bst = new BinarySearchTrees<>();
        bst.addElement(10);
        bst.addElement(5);
        bst.addElement(20);
        bst.addElement(14);
        bst.addElement(3);
        bst.addElement(7);
        bst.addElement(21);
        bst.addElement(22);
        //bst.addElement(1);
        //bst.addElement(4);
        bst.addElement(6);

        ArrayList<ArrayList<Integer>> seqList = s.bstSequences(bst);
        for (ArrayList<Integer> aList : seqList) {
            System.out.print(aList.size());
        }
    }

    /**
     *                 10
     *               /    \
     *             /       \
     *           /          \
     *         5            20
     *      /    \         /  \
     *     3      7      14    21
     *   /  \    /              \
     * 1     4  6               22
     */
    @Test
    public void checkSubtreeTest() {

        TreesAndGraphs<Integer> s = new TreesAndGraphs<>();
        BinarySearchTrees<Integer> t1 = new BinarySearchTrees<>();
        t1.addElement(10);
        t1.addElement(5);
        t1.addElement(20);
        t1.addElement(14);
        t1.addElement(3);
        t1.addElement(7);
        t1.addElement(21);
        t1.addElement(22);
        t1.addElement(1);
        t1.addElement(4);
        t1.addElement(6);

        BinarySearchTrees<Integer> t2 = new BinarySearchTrees<>();
        t2.addElement(20);
        t2.addElement(14);
        t2.addElement(21);
        Assert.assertEquals(false, s.checkSubtree(t1, t2));

        t2.addElement(22);
        Assert.assertEquals(true, s.checkSubtree(t1, t2));

        BinarySearchTrees<Integer> t3 = new BinarySearchTrees<>();
        t3.addElement(8);
        t3.addElement(14);
        t3.addElement(21);
        Assert.assertEquals(false, s.checkSubtree(t1, t3));
    }
}
