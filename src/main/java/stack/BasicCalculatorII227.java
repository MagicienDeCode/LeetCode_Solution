package stack;

import java.util.Stack;

public class BasicCalculatorII227 {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        final int length = s.length();
        final Stack<Integer> stack = new Stack<>();
        int current = 0;
        char operation = '+';
        for (int i = 0; i < length; i++) {
            final char c = s.charAt(i);
            if (Character.isDigit(c)) {
                current = current * 10 + (c - '0');
            }
            if (!Character.isDigit(c) && !Character.isWhitespace(c) || i == length - 1) {
                switch (operation) {
                    case '+':
                        stack.push(current);
                        break;
                    case '-':
                        stack.push(-current);
                        break;
                    case '*':
                        stack.push(stack.pop() * current);
                        break;
                    case '/':
                        stack.push(stack.pop() / current);
                        break;
                }
                operation = c;
                current = 0;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}
