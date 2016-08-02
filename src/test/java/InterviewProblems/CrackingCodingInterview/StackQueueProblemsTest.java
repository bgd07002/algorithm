package InterviewProblems.CrackingCodingInterview;

import InterviewProblems.StackQueueProblems;
import org.junit.Assert;
import org.testng.annotations.Test;
import InterviewProblems.StackQueueProblems.StackWithThreeArrays;
import InterviewProblems.StackQueueProblems.StackWithMin;
import InterviewProblems.StackQueueProblems.QueueWithTwoStacks;

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
}
