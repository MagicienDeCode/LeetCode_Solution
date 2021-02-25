package stack;

import java.util.Stack;

public class ScoreofParentheses856 {
    public int scoreOfParentheses(String s) {
        final Stack<Integer> stack = new Stack();
        stack.push(0); // The score of the current frame

        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(0);
            else {
                int v = stack.pop();
                int w = stack.pop();
                stack.push(w + Math.max(v << 1, 1));
            }
        }

        return stack.pop();
    }
}
