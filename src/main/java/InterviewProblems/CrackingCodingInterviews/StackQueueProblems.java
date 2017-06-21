package InterviewProblems.CrackingCodingInterviews;

import DataStructures.ListStackQueue.QueueListImp;
import DataStructures.ListStackQueue.IQueue;
import DataStructures.ListStackQueue.IStack;
import DataStructures.ListStackQueue.StackArrayImp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StackQueueProblems<T extends Comparable<T>> {

    /**
     * 3.1 Describe how you could use a single array to implement three stacks.
     */
    public class StackWithThreeArrays<T>{

        T[] stackArr;
        int[] stackPointers;
        int stackSize;

        public StackWithThreeArrays(int stackSize) {
            this.stackSize = stackSize;
            stackArr = (T[])new Object[stackSize*3];
            stackPointers = new int[3];
        }

        public void push(int stackNum, T element) {
            //Check if full
            if (stackPointers[stackNum] == stackSize) {
                T[] stackArrExpanded = (T[]) new Object[stackSize*3];
                System.arraycopy(stackArr, 0, stackArrExpanded, 0, stackSize);
                System.arraycopy(stackArr, stackSize, stackArrExpanded, 2*stackSize, stackSize);
                System.arraycopy(stackArr, 2*stackSize, stackArrExpanded, 4*stackSize, stackSize);
                stackSize *=2;
                stackArr = stackArrExpanded;
            }

            stackArr[stackNum*stackSize+ stackPointers[stackNum]] = element;
            stackPointers[stackNum]++;
        }

        public T pop(int stackNum) {
            if (stackPointers[stackNum] > 0)
                return stackArr[stackSize*stackNum + stackPointers[stackNum]-1];

            return null;
        }

        public int size(int stackNum) {
            return stackPointers[stackNum];
        }

        public boolean isEmpty(int stackNum) {
            return stackPointers[stackNum]==0;
        }
    }

    /**
     * 3.2 How would you design a stack which, in addition to push and pop, also has a function
     * min which returns the minimum element? Push, pop and min should all operate in O(1) time.
     */
    public class StackWithMin<T extends Comparable<T>> {

        T min;
        List<T> underlyingList;

        public StackWithMin() {
            underlyingList = new ArrayList<>();
        }

        public void push(T element) {
            underlyingList.add(element);

            if (size() == 1) {
                min = element;
                return;
            }

            if (element.compareTo(min) < 0)
                min = element;
        }

        public T pop() {
            if (isEmpty())
                return null;

            T element = underlyingList.remove(underlyingList.size()-1);
            if (element.equals(min) && !isEmpty()) {
                min = underlyingList.get(0);
                for (int i=1; i < underlyingList.size(); i++) {
                    if (min.compareTo(underlyingList.get(i)) > 0)
                        min = underlyingList.get(i);
                }
            }
            return element;
        }

        public T getMin() { return min; }

        public int size() { return underlyingList.size(); }

        public boolean isEmpty() { return underlyingList.isEmpty(); }
    }

    /**
     * 3.3 Implement set of stacks with threshold
     */
    public class SetOfStacks<T> implements IStack<T> {

        private int threshold;
        private List<StackArrayImp> listOfStack;

        public SetOfStacks(int threshold) {
            this.threshold = threshold;
            listOfStack = new ArrayList<>();
            listOfStack.add(new StackArrayImp());
        }

        @Override
        public void push(T element) {
            if (listOfStack.get(listOfStack.size()-1).size() == threshold)
                listOfStack.add(new StackArrayImp());

            listOfStack.get(listOfStack.size()-1).push(element);
        }

        @Override
        public T pop() {
            if (listOfStack.get(0).isEmpty())
                return null;

            T temp = (T) listOfStack.get(listOfStack.size()-1).pop();
            if (listOfStack.get(listOfStack.size()-1).isEmpty())
                listOfStack.remove(listOfStack.size()-1);

            return temp;
        }

        @Override
        public int size() {
            int size = 0;
            for (int i=0; i < listOfStack.size(); i++) {
                size += listOfStack.get(i).size();
            }
            return size;
        }

        @Override
        public boolean isEmpty() {
            return listOfStack.isEmpty() || listOfStack.get(0).isEmpty() ;
        }

        @Override
        public Iterator<T> iterator() {
            return null;
        }
    }

    /**
     * 3.4 Implement a MyQueue class which implements a queue using two stacks.
     */
    public class QueueWithTwoStacks<T> implements IQueue<T> {

        StackArrayImp<T> stack1;
        StackArrayImp<T> stack2;

        public QueueWithTwoStacks() {
            stack1 = new StackArrayImp<>();
            stack2 = new StackArrayImp<>();
        }

        @Override
        public void enqueue(T element) {
            stack1.push(element);
        }

        @Override
        public T dequeue() {
            if (isEmpty())
                return null;

            if (!stack2.isEmpty())
                return stack2.pop();

            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }

            return stack2.pop();
        }

        @Override
        public int size() {
            return stack1.size()+stack2.size();
        }

        @Override
        public boolean isEmpty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }

        @Override
        public Iterator iterator() {
            return null;
        }

        @Override
        public T peek() {
            return null;
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

        public class Dog implements Comparable<Dog> {
            private int priority;
            private String dogId;

            public Dog(String dogId, int priority) {
                this.dogId = dogId;
                this.priority = priority;
            }

            public int getPriority() { return priority; }
            public String getDogId() { return dogId; }

            @Override
            public int compareTo(Dog o) {
                return 0;
            }
        }

        public class Cat implements Comparable<Cat> {
            private int priority;
            private String catId;

            public Cat(String catId, int priority) {
                this.catId = catId;
                this.priority = priority;
            }
            public int getPriority() { return priority; }
            public String getCatId() { return catId; }

            @Override
            public int compareTo(Cat o) {
                return 0;
            }
        }

        private IQueue<Dog> dogQueue;
        private IQueue<Cat> catQueue;

        public AnimalShelter() {
            dogQueue = new QueueListImp<Dog>();
            catQueue = new QueueListImp<Cat>();
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
