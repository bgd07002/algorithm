package InterviewProblems.CrackingCodingInterview;

import org.junit.Assert;
import org.testng.annotations.Test;
import InterviewProblems.CrackingCodingInterview.StackQueueProblems.StackWithThreeArrays;
import InterviewProblems.CrackingCodingInterview.StackQueueProblems.StackWithMin;
import InterviewProblems.CrackingCodingInterview.StackQueueProblems.QueueWithTwoStacks;

import java.util.Stack;

public class StackQueueProblemsTest {

    @Test
    public void threeStackInarray() {
        StackWithThreeArrays st = (new StackQueueProblems<Integer>()).new StackWithThreeArrays<Integer>(4);
        st.push(0,34);
        st.push(2,42);
        st.push(0,12);
        Assert.assertEquals(2, st.size(0));
        Assert.assertEquals(0, st.size(1));
        Assert.assertEquals(1, st.size(2));

        Assert.assertEquals(12, st.pop(0));
        Assert.assertEquals(42, st.pop(2));
        Assert.assertEquals(null, st.pop(1));
    }

    @Test
    public void stackWithMinTest() {
        StackWithMin st = (new StackQueueProblems<Integer>()).new StackWithMin<Integer>();
        st.push(34);
        st.push(42);
        st.push(12);
        st.push(5);
        st.push(16);

        Assert.assertEquals(5, st.size());
        Assert.assertEquals(5, st.getMin());

        st.pop();
        st.pop();
        Assert.assertEquals(3, st.size());
        Assert.assertEquals(12, st.getMin());
    }

    @Test
    public void setOfStacksTest() {
        StackQueueProblems.SetOfStacks st = (new StackQueueProblems<Integer>()).new SetOfStacks<Integer>(3);
        Assert.assertEquals(true, st.isEmpty());
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        st.push(6);
        st.push(7);

        Assert.assertEquals(7, st.size());
        Assert.assertEquals(7, st.pop());
        Assert.assertEquals(6, st.pop());
        Assert.assertEquals(5, st.size());
    }

    @Test
    public void queueWithTwoStacksTest() {
        QueueWithTwoStacks st = (new StackQueueProblems<Integer>()).new QueueWithTwoStacks<Integer>();
        Assert.assertEquals(true, st.isEmpty());
        st.enqueue(23);
        st.enqueue(24);
        st.enqueue(25);

        Assert.assertEquals(23, st.dequeue());
        st.enqueue(26);

        Assert.assertEquals(24, st.dequeue());
        Assert.assertEquals(25, st.dequeue());
        Assert.assertEquals(26, st.dequeue());
        Assert.assertEquals(null, st.dequeue());
    }

    @Test
    public void sortStackTest() {
        StackQueueProblems<Integer> s = new StackQueueProblems<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(4);
        stack.push(3);
        stack.push(8);
        stack.push(6);
        stack.push(12);
        stack.push(10);
        stack.push(9);

        Stack<Integer> sortedStack = s.sortStack(stack);
        Assert.assertEquals(3, (int)sortedStack.pop());
        Assert.assertEquals(4, (int)sortedStack.pop());
        Assert.assertEquals(6, (int)sortedStack.pop());
        Assert.assertEquals(8, (int)sortedStack.pop());
        Assert.assertEquals(9, (int)sortedStack.pop());
        Assert.assertEquals(10, (int)sortedStack.pop());
        Assert.assertEquals(12, (int)sortedStack.pop());
    }

    @Test
    public void animalShelter() {
        StackQueueProblems.AnimalShelter a = (new StackQueueProblems<Integer>()).new AnimalShelter();
        a.enqueue("Dog1");
        a.enqueue("Dog2");
        a.enqueue("Cat1");
        a.enqueue("Dog3");
        a.enqueue("Cat2");
        a.enqueue("Cat3");
        a.enqueue("Dog4");
        a.enqueue("Dog5");

        Assert.assertEquals("Dog1", a.dequeue());
        Assert.assertEquals("Cat1", a.dequeueCat());
        Assert.assertEquals("Dog2", a.dequeueDog());
        Assert.assertEquals("Dog3", a.dequeue());
        Assert.assertEquals(4, a.size());
    }
}
