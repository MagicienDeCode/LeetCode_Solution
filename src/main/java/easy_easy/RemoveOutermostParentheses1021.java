package easy_easy;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class RemoveOutermostParentheses1021 {
    public String removeOuterParentheses(String s) {
        final Set<Integer> ignoreIndex = new HashSet<>();
        final Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            if (c == '(') {
                if (stack.isEmpty()) {
                    ignoreIndex.add(i);
                }
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    ignoreIndex.add(i);
                }
            }
        }
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!ignoreIndex.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
