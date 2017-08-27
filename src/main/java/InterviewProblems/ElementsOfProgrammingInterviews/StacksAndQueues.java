package InterviewProblems.ElementsOfProgrammingInterviews;

import java.security.InvalidParameterException;
import java.util.Stack;

public class StacksAndQueues {

    /**
     * 9.2 Reverse Polish Notation (RPN):
     * Example: 3,4,*,1,2,+,+
     */
    public int reversePolishExpression(String exp) {

        String[] units = exp.split(",");
        String operators = "+*/-";
        Stack<String> expStack = new Stack<>();

        int expResult = 0;
        for (String s : units) {

            if (!operators.contains(s)) {
                expStack.push(s);
            } else {
                expStack.push(s);
                if (expStack.size() < 3)
                    throw new InvalidParameterException("Format of RPN is wrong!");

                String operator = expStack.pop();
                int num2 = Integer.parseInt(expStack.pop());
                int num1 = Integer.parseInt(expStack.pop());
                switch (operator) {
                    case "+":
                        expResult = num1 + num2;
                        break;
                    case "-":
                        expResult = num1 - num2;
                        break;
                    case "*":
                        expResult = num1 * num2;
                        break;
                    case "/":
                        expResult = num1 / num2;
                        break;
                }
                expStack.push(Integer.toString(expResult));
            }
        }
        return expResult;
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
