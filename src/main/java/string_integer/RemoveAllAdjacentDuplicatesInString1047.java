package string_integer;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString1047 {
    public String removeDuplicates(String s) {
        if (s.isEmpty()) {
            return s;
        }
        final Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        final StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}
