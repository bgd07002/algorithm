package InterviewProblems.ElementsOfProgrammingInterviews;

import java.security.InvalidParameterException;
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
     *  8.5 Towers of Hanoi
     */
    public String towersOfHanoi(Stack<Integer> bar) {
        int hanoiSize = bar.size();
        Stack<Integer> bar1 = bar;
        Stack<Integer> bar2 = new Stack<>();
        Stack<Integer> bar3 = new Stack<>();

        while (bar2.size() != hanoiSize &&  bar3.size() != hanoiSize) {
            if (bar2.empty() || bar2.peek().compareTo(bar1.peek()) > 0)
                bar2.push(bar1.pop());

            if (bar3.empty() || bar3.peek().compareTo(bar1.peek()) > 0)
                bar3.push(bar1.pop());
        }
        return null;
    }
}
