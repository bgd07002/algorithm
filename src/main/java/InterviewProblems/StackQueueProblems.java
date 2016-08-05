package InterviewProblems;

import DataStructures.ListStackQueue.CustomQueue;
import DataStructures.ListStackQueue.IQueue;
import DataStructures.ListStackQueue.IStack;
import DataStructures.ListStackQueue.Stack;

import java.util.ArrayList;

public class StackQueueProblems<T extends Comparable<T>> {

    /**
     * 3.1 Describe how you could use a single array to implement three stacks.
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
     * 3.2 How would you design a stack which, in addition to push and pop, also has a function
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
     * 3.3 Implement set of stacks with threshold
     */
    public class SetOfStacks<T> implements IStack<T> {

        private int threshold;
        private ArrayList<Stack> listOfStack;

        public SetOfStacks(int threshold) {
            this.threshold = threshold;
            listOfStack = new ArrayList<>();
        }

        @Override
        public void push(T element) {
            if (listOfStack.isEmpty() || listOfStack.get(listOfStack.size()-1).size() == threshold) {
                Stack<T> newStack = new Stack<>();
                newStack.push(element);
                listOfStack.add(newStack);
            } else {
                listOfStack.get(listOfStack.size()-1).push(element);
            }
        }

        @Override
        public T pop() {
            if (listOfStack.isEmpty())
                return null;

            Stack<T> lastStack = listOfStack.get(listOfStack.size()-1);
            T removedElement = (T)lastStack.pop();
            if (lastStack.isEmpty())
                listOfStack.remove(lastStack);

            return removedElement;
        }

        @Override
        public int size() {
            int size = 0;
            for (Stack<T> aStack : listOfStack)
                size += aStack.size();

            return size;
        }

        @Override
        public boolean isEmpty() {
            return size() == 0;
        }
    }

    /**
     * 3.4 Implement a MyQueue class which implements a queue using two stacks.
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
     * 3.5 Write a program to sort a stack in ascending order. You should not make any assumptions about
     * how the stack is implemented. The following are the only functions that should be used to
     * write this program: push | pop | peek | isEmpty.
     */
    public java.util.Stack<T> sortStack(java.util.Stack<T> stack){
        java.util.Stack<T> newStack = new java.util.Stack<>();

        while(!stack.isEmpty()) {
            T min = stack.pop();
            int elementToCompare = stack.size();
            while (!stack.isEmpty()) {
                T temp = stack.pop();
                if (min.compareTo(temp) < 0) {
                    newStack.push(min);
                    min = temp;
                } else
                    newStack.push(temp);
            }

            while (elementToCompare > 0) {
                stack.push(newStack.pop());
                elementToCompare--;
            }
            newStack.push(min);
        }
        return newStack;
    }

    /**
     * 3.6 Animal shelter holds dog and cats. enqueue(), dequeueAny(), dequeueDog(), dequeueCat()
     */
    public class AnimalShelter {

        private int priority;

        public class Dog {
            private int priority;
            private String dogId;

            public Dog(String dogId, int priority) {
                this.dogId = dogId;
                this.priority = priority;
            }

            public int getPriority() { return priority; }
            public String getDogId() { return dogId; }
        }

        public class Cat {
            private int priority;
            private String catId;

            public Cat(String catId, int priority) {
                this.catId = catId;
                this.priority = priority;
            }
            public int getPriority() { return priority; }
            public String getCatId() { return catId; }
        }

        private CustomQueue<Dog> dogQueue;
        private CustomQueue<Cat> catQueue;

        public AnimalShelter() {
            dogQueue = new CustomQueue<>();
            catQueue = new CustomQueue<>();
        }

        public void enqueue(String animalName) {
            if (animalName.startsWith("Dog"))
                dogQueue.enqueue(new Dog(animalName, priority));
            else if (animalName.startsWith("Cat"))
                catQueue.enqueue(new Cat(animalName, priority));

            priority++;
        }

        public String dequeue() {
            if (dogQueue.peek().priority < catQueue.peek().priority)
                return dogQueue.dequeue().dogId;
            else
                return catQueue.dequeue().catId;
        }

        public String dequeueDog() {
            return dogQueue.dequeue().dogId;
        }

        public String dequeueCat() {
            return catQueue.dequeue().catId;
        }

        public int size() {
            return dogQueue.size()+catQueue.size();
        }

        public boolean isEmpty() {
            return dogQueue.isEmpty() && catQueue.isEmpty();
        }
    }
}
