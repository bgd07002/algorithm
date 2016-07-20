package InterviewProblems;

import DataStructures.ListStackQueue.IQueue;
import DataStructures.ListStackQueue.Stack;

import java.util.ArrayList;

public class StackQueueProblems<T> {

    /**
     * Describe how you could use a single array to implement three stacks.
     */
    public class StackWithThreeArrays<T>{

        T[] stackArray;
        int[] stackPointer;
        int stackSize;

        public StackWithThreeArrays(int stackSize) {
            this.stackSize = stackSize;
            stackArray = (T[])new Object[stackSize * 3];
            stackPointer = new int[]{0,0,0};
        }

        public void push(int stackNum, T element) {
            int idx = stackNum * stackSize + stackPointer[stackNum];
            stackArray[idx] = element;
            stackPointer[stackNum]++;
        }

        public T pop(int stackNum) {
            if (stackPointer[stackNum] == 0)
                return null;

            int idx = stackNum * stackSize + stackPointer[stackNum];
            T element = stackArray[--idx];
            stackPointer[stackNum]--;
            return element;
        }

        public int size(int stackNum) {
            return stackPointer[stackNum];
        }

        public boolean isEmpty(int stackNum) {
            return stackPointer[stackNum] == 0;
        }
    }

    /**
     * How would you design a stack which, in addition to push and pop, also has a function
     * min which returns the minimum element? Push, pop and min should all operate in O(1) time.
     */
    public class StackWithMin<T extends Comparable<T>> {

        T min;
        private ArrayList<T> underlyingArray;

        public StackWithMin() {
            underlyingArray = new ArrayList<>();
            min = null;
        }

        public T getMin() {
            return min;
        }

        public void push(T element) {
            if (min == null)
                min = element;

            underlyingArray.add(element);

            if (min.compareTo(element) > 0)
                min = element;
        }

        public T pop() {
            if (isEmpty())
                return null;

            if (min == underlyingArray.get(underlyingArray.size()-1)) {
                T newMin = underlyingArray.get(0);
                for (int i=1; i < underlyingArray.size()-1; i++) {
                    if (newMin.compareTo(underlyingArray.get(i)) > 0)
                        newMin = underlyingArray.get(i);
                }
                min = newMin;
            }
            return underlyingArray.remove(underlyingArray.size()-1);
        }

        public int size() {
            return underlyingArray.size();
        }

        public boolean isEmpty() {
            return underlyingArray.isEmpty();
        }
    }

    /**
     * Implement a MyQueue class which implements a queue using two stacks.
     */
    public class QueueWithTwoStacks<T> implements IQueue<T> {

        private Stack<T> stack1;
        private Stack<T> stack2;

        public QueueWithTwoStacks() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        @Override
        public void enqueue(T element) {
            stack1.push(element);
        }

        @Override
        public T dequeue() {
            if (isEmpty())
                return null;

            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }

        @Override
        public int size() {
            return stack1.size() + stack2.size();
        }

        @Override
        public boolean isEmpty() {
            return (stack1.isEmpty() && stack2.isEmpty());
        }
    }
    /**
     * Write a program to sort a stack in ascending order. You should not make any assumptions about
     * how the stack is implemented. The following are the only functions that should be used to
     * write this program: push | pop | peek | isEmpty.
     */
}
