package string_integer;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesinStringII1209 {
    public String removeDuplicates(String s, int k) {
        if (s.isEmpty()) {
            return s;
        }
        final Stack<CharCount> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().c == c) {
                if (stack.peek().count + 1 == k) {
                    stack.pop();
                } else {
                    stack.peek().count++;
                }
            } else {
                stack.push(new CharCount(c, 1));
            }
        }
        final StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, String.valueOf(stack.peek().c).repeat(stack.pop().count));
        }
        return sb.toString();
    }

    static class CharCount {
        char c;
        int count;

        public CharCount(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }
}
