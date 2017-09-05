package InterviewProblems.ElementsOfProgrammingInterviews;

import DataStructures.ListStackQueue.IQueue;
import DataStructures.ListStackQueue.QueueArrayImp;
import DataStructures.Trees.BinarySearchTrees;
import DataStructures.Trees.BinaryTreeNode;

import java.security.InvalidParameterException;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class StacksAndQueues {

    /**
     * 9.2 Reverse Polish Notation (RPN):
     * Example: 3,4,*,1,2,+,+
     */
    public int reversePolishExpression(String exp) {
        //Case 12, -23
        String[] expressionUnits = exp.split(",");
        Stack<String> stack = new Stack<>();
        for (String s : expressionUnits) {
            //Contains only operator
            if (s.matches("^[+*/-]+$")) {
                arithmeticForRPN(stack, s);
            } else if (s.matches("^[0-9-]+$")){
                stack.push(s);
            }
            else
                throw new InvalidParameterException("RPN contains illegal characters!");
        }

        if (stack.size() == 1)
            return Integer.parseInt(stack.pop());

        return -1;
    }

    private void arithmeticForRPN(Stack<String> stack, String operator) {
        String num1Str = stack.pop();
        String num2Str = stack.pop();
        if (num1Str == null || num2Str == null)
            throw new InvalidParameterException("Format of RPN is wrong!");

        int num1 = Integer.parseInt(num1Str);
        int num2 = Integer.parseInt(num2Str);
        switch (operator) {
            case "+":
                stack.push(Integer.toString(num1 + num2));
                break;
            case "-":
                stack.push(Integer.toString(num1 - num2));
                break;
            case "*":
                stack.push(Integer.toString(num1 * num2));
                break;
            case "/":
                stack.push(Integer.toString(num1 / num2));
                break;
        }
    }

    /**
     * 9.3 Paranthesis well-formation for a string
     * For example: "([]){()}" and "[()[]{()()}]" are well-formed
     * but "{]" and "[()[]{()()" are not well-formed
     */
    public boolean paranthesisWellFormationCheck(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c: s.toCharArray()) {
            switch (c) {
                case '}':
                    if (stack.peek() == '{')
                        stack.pop();
                    break;
                case ']':
                    if (stack.peek() == '[')
                        stack.pop();
                    break;
                case ')':
                    if (stack.peek() == '(')
                        stack.pop();
                    break;
                default:
                    if (c == '{' || c == '[' || c == '(')
                        stack.push(c);
                    else
                        return false; //due to invalid character
            }
        }

        if (stack.isEmpty())
            return true;

        return false;
    }

    /**
     * 9.4 File path names (skip)
     * 9.5 Search a postings list (skip)
     * 9.6 Building with sunset view (skip)
     * 9.7 Binary tree nodes with depth order
     */
    public List<Integer> binaryTreeDepthOrder(BinarySearchTrees<Integer> bst) {

        List<Integer> nodeList = new LinkedList<>();
        IQueue<BinaryTreeNode> nodeQueue = new QueueArrayImp<>();
        nodeQueue.enqueue(bst.getRoot());

        while (nodeQueue.size() != 0) {
            BinaryTreeNode<Integer> cur = nodeQueue.dequeue();
            nodeList.add(cur.getData());

            if (cur.getLeftChild() != null)
                nodeQueue.enqueue(cur.getLeftChild());
            if (cur.getRightChild() != null)
                nodeQueue.enqueue(cur.getRightChild());
        }
        return nodeList;
    }
}
