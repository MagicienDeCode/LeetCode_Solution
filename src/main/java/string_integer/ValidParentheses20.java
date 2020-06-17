package string_integer;

import java.util.Stack;

public class ValidParentheses20 {
    public boolean isValid(String s) {
        final Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c.equals('(')) {
                stack.push(')');
            } else if (c.equals('{')) {
                stack.push('}');
            } else if (c.equals('[')) {
                stack.push(']');
            } else {
                if (stack.isEmpty() || !stack.pop().equals(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
