package InterviewProblems.CrackingCodingInterview;

import DataStructures.Trees.*;
import org.junit.Assert;
import org.testng.annotations.Test;

public class TreesAndGraphsTest {

    /**
     *                10
     *              /    \
     *            /       \
     *          /          \
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
        int[] inputArr = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        IBinarySearchTree<Integer> bst = s.bstFromSortedArray(inputArr);
        Assert.assertEquals(16, bst.getSize());
        Assert.assertEquals(4, bst.height());
    }
}
