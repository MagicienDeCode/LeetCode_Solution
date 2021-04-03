package stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class ValidParenthesisString678 {
    public boolean checkValidString(String s) {
        final Stack<Integer> stack = new Stack<>();
        final Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            }
            if (c == ')') {
                if (stack.isEmpty()) {
                    if (deque.isEmpty()) {
                        return false;
                    }
                    deque.pollLast();
                } else {
                    stack.pop();
                }
            }
            if (c == '*') {
                deque.offerFirst(i);
            }
        }
        while (!stack.isEmpty()) {
            final int leftPosition = stack.pop();
            if (deque.isEmpty()) {
                return false;
            }
            final int largestStarPosition = deque.pollFirst();
            if (leftPosition > largestStarPosition) {
                return false;
            }
        }
        return true;
    }
}
