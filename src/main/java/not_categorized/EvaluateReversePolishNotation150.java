package not_categorized;

import java.util.Set;
import java.util.Stack;

public class EvaluateReversePolishNotation150 {
    public int evalRPN(String[] tokens) {
        final Stack<Integer> stack = new Stack<>();
        final Set<String> operators = Set.of("+", "-", "*", "/");
        for (String tok : tokens) {
            if (operators.contains(tok)) {
                final int second = stack.pop();
                final int first = stack.pop();
                stack.push(calculate(first, second, tok));
            } else {
                stack.push(Integer.parseInt(tok));
            }
        }
        return stack.pop();
    }

    private int calculate(int first, int second, String tok) {
        switch (tok) {
            case "+":
                return first + second;
            case "-":
                return first - second;
            case "*":
                return first * second;
            case "/":
                return first / second;
            default:
                return -1;
        }
    }
}
