package InterviewProblems.ElementsOfProgrammingInterviews;

import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class StacksAndQueuesTest {

    /**
     * 9.2
     */
    @Test
    public void reversePolishExpressionTest() {
        StacksAndQueues s = new StacksAndQueues();
        String exp = "3,4,*,1,2,+,+";
        Assert.assertEquals(15, s.reversePolishExpression(exp));

        exp = "1,1,+,-2,*";
        Assert.assertEquals(-4, s.reversePolishExpression(exp));

        exp = "4,6,/,-25,+";
        Assert.assertEquals(-24, s.reversePolishExpression(exp));
    }

    /**
     * 9.3
     */
    @Test
    public void paranthesisWellFormationCheckTest() {
        StacksAndQueues s = new StacksAndQueues();
        Assert.assertEquals(true, s.paranthesisWellFormationCheck("([]){()}"));
        Assert.assertEquals(true, s.paranthesisWellFormationCheck("[()[]{()()}]"));

        Assert.assertEquals(false, s.paranthesisWellFormationCheck("{]"));
        Assert.assertEquals(false, s.paranthesisWellFormationCheck("[()[]{()()"));
    }

    /**
     * 9.4, 9.5, 9.6, and 9.7
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
    public void binaryTreeDepthOrderTest() {
        StacksAndQueues s = new StacksAndQueues();

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

        List<Integer> depthOrder = s.binaryTreeDepthOrder(bst);
        Assert.assertArrayEquals(new int[] {10,5,20,3,7,14,21,1,4,6,9}, depthOrder.stream().mapToInt(i->i).toArray());
    }
}
