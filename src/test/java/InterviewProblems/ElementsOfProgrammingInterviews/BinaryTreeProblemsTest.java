package InterviewProblems.ElementsOfProgrammingInterviews;

import DataStructures.Trees.BinaryFormedBinaryTree;
import DataStructures.Trees.BinarySearchTrees;
import org.junit.Assert;
import org.testng.annotations.Test;

public class BinaryTreeProblemsTest {

    @Test
    public void isBinaryTreeSymmetricTest() {
        BinaryTreeProblems b = new BinaryTreeProblems();

        BinarySearchTrees<Integer> bst = new BinarySearchTrees<>();
        bst.addElement(10);
        bst.addElement(5);
        bst.addElement(15);
        bst.addElement(4);
        bst.addElement(16);
        bst.addElement(3);
        bst.addElement(17);
        Assert.assertEquals(true, b.isBinaryTreeSymmetric(bst));
        bst.addElement(6);
        bst.addElement(14);
        Assert.assertEquals(true, b.isBinaryTreeSymmetric(bst));
        bst.addElement(7);
        bst.addElement(18);
        Assert.assertEquals(false, b.isBinaryTreeSymmetric(bst));
    }

    @Test
    public void binaryFormedTreeSumTest() {
        BinaryTreeProblems b = new BinaryTreeProblems();

        BinaryFormedBinaryTree binTree = new BinaryFormedBinaryTree();
        binTree.addElement(8);
        binTree.addElement(9);
        binTree.addElement(12);
        binTree.addElement(22);
        binTree.addElement(24);
        binTree.addElement(51);
        int sum = b.binaryFormedTreeSum(binTree);
        System.out.println(sum);
    }
}
