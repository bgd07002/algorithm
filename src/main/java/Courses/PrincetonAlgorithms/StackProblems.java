package Courses.PrincetonAlgorithms;

import DataStructures.ListStackQueue.IStack;
import DataStructures.ListStackQueue.StackListImp;

public class StackProblems {

    /**
     * Integer arithmetic
     * Example: ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )
     */
    public int computeArithmetic(String str) {
        //if (!str.matches("\\+\\-\\*/\\(\\)|[0-9]"))
        //    return -1;

        char[] strArr = str.toCharArray();
        IStack<Integer> operandStack = new StackListImp<>();
        IStack<Character> operatorStack = new StackListImp<>();

        for (char c: strArr) {
            if (Character.isDigit(c))
                operandStack.push((int)c-48);
            else if (c == '(' || c == ' ')
                continue;
            else if (c == ')') {
                arithmeticHelper(operandStack, operatorStack);
            }
            else
                operatorStack.push(c);
        }
        while (!operatorStack.isEmpty()) {
            arithmeticHelper(operandStack, operatorStack);
        }
        return operandStack.pop();
    }

    private void arithmeticHelper(IStack<Integer> operandStack, IStack<Character> operatorStack) {
        switch (operatorStack.pop()) {
            case '+':
                operandStack.push(operandStack.pop() + operandStack.pop());
                break;
            case '-':
                operandStack.push(operandStack.pop() - operandStack.pop());
                break;
            case '*':
                operandStack.push(operandStack.pop() * operandStack.pop());
                break;
            case '/':
                operandStack.push(operandStack.pop() / operandStack.pop());
                break;
        }
    }
}
