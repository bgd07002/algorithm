package InterviewProblems.ElementsOfProgrammingInterviews;

import org.junit.Assert;
import org.testng.annotations.Test;

public class BinarySearchTreesTest {

    /**
     * 15.1
     * 15.2
     * 15.3
     *
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
    public void k_thLargestElementTest() {
        BinarySearchTrees b = new BinarySearchTrees();
        DataStructures.Trees.BinarySearchTrees bst = new DataStructures.Trees.BinarySearchTrees();
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

        int kthElement = 3;
        Assert.assertEquals(4, b.k_thLargestElement(bst, kthElement));
        kthElement = 1;
        Assert.assertEquals(1, b.k_thLargestElement(bst, kthElement));
        kthElement = 11;
        Assert.assertEquals(21, b.k_thLargestElement(bst, kthElement));
    }

}
