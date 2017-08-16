package DataStructures.Trees;

import org.junit.Assert;
import org.testng.annotations.Test;

public class TreesTest {

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
    public void binarySearchTreeTest() throws Exception {
        IBinarySearchTree<Integer> bst = new BinarySearchTrees<>();
        binarySearchTestHelper(bst);
    }

    @Test
    public void binarySearchTreeOnArrayListTest() throws Exception {
        IBinarySearchTree<Integer> bst = new BinarySearchTreesArrayRep<>();
        binarySearchTestHelper(bst);
    }

    private void binarySearchTestHelper(IBinarySearchTree<Integer> bst) {
        Assert.assertTrue("BST is supposed to be empty", bst.isEmpty() == true);
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

        Assert.assertEquals(11, bst.getSize());
        Assert.assertEquals(1, (int)bst.minElement());
        Assert.assertEquals(21, (int)bst.maxElement());

        Assert.assertTrue("Element 6 is not found", bst.findElement(6));
        Assert.assertFalse("Element 11 is accidentally found", bst.findElement(11));
        Assert.assertEquals("Pre-order traversals are not equal", "10, 5, 3, 1, 4, 7, 6, 9, 20, 14, 21, ", bst.preOrderTraversal());
        Assert.assertEquals("Post-order traversals are not equal", "1, 4, 3, 6, 9, 7, 5, 14, 21, 20, 10, ", bst.postOrderTraversal());
        Assert.assertEquals("In-order traversals are not equal", "1, 3, 4, 5, 6, 7, 9, 10, 14, 20, 21, ", bst.inOrderTraversal());
        Assert.assertEquals(3, bst.height());

        Assert.assertTrue("Root is not correct", bst.isRoot(new BinaryTreeNode<>(10)));
        Assert.assertTrue("3 is an internal node", bst.isInternal(bst.getRoot().getLeftChild().getLeftChild()));
        Assert.assertTrue("21 is an external node", bst.isExternal(bst.getRoot().getRightChild().getLeftChild()));

        Assert.assertEquals(6, (int)bst.ceilingElement(bst.getRoot().getLeftChild())); //Ceiling of 5
        Assert.assertEquals(7, (int)bst.ceilingElement(bst.getRoot().getLeftChild().getRightChild().getLeftChild())); //Ceiling of 6
        Assert.assertEquals(10, (int)bst.ceilingElement(bst.getRoot().getLeftChild().getRightChild().getRightChild())); //Ceiling of 9

        Assert.assertEquals(4, (int)bst.floorElement(bst.getRoot().getLeftChild())); //Floor of 5
        Assert.assertEquals(7, (int)bst.floorElement(bst.getRoot().getLeftChild().getRightChild().getRightChild())); //Ceiling of 9
        Assert.assertEquals(5, (int)bst.floorElement(bst.getRoot().getLeftChild().getRightChild().getLeftChild())); //Ceiling of 6

        bst.removeElement(9);
        Assert.assertEquals(false, bst.findElement(9));

        bst.removeElement(7);
        Assert.assertEquals("Pre-order traversals are not equal", "10, 5, 3, 1, 4, 6, 20, 14, 21, ", bst.preOrderTraversal());

        bst.addElement(8);
        bst.removeElement(5);
        Assert.assertEquals("Pre-order traversals are not equal", "10, 6, 3, 1, 4, 8, 20, 14, 21, ", bst.preOrderTraversal());
    }
}
