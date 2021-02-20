package stack;

import java.util.Stack;

public class MinimumRemovetoMakeValidParentheses1249 {
    private static final char EMPTY = '#';

    public String minRemoveToMakeValid(String s) {
        final char[] chars = s.toCharArray();
        final Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            final char c = chars[i];
            if (!Character.isLetter(c)) {
                if (c == '(') {
                    stack.push(i);
                } else {
                    if (stack.isEmpty()) {
                        chars[i] = EMPTY;
                    } else {
                        stack.pop();
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            chars[stack.pop()] = EMPTY;
        }
        final StringBuilder stringBuilder = new StringBuilder();
        for (char c : chars) {
            if (c != EMPTY) {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }
}
