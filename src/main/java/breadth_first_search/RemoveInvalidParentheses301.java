package breadth_first_search;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RemoveInvalidParentheses301 {
    public List<String> removeInvalidParentheses(String s) {
        final List<String> result = new LinkedList<>();
        final Queue<String> queue = new LinkedList<>();
        queue.offer(s);
        while (!queue.isEmpty()) {
            final String current = queue.poll();
            if (isValid(current)) {
                result.add(current);
                queue.forEach(it -> {
                    if (isValid(it)) {
                        result.add(it);
                    }
                });
                return result;
            }
            for (int index = 0; index < current.length(); index++) {
                final char c = current.charAt(index);
                if (c == '(' || c == ')') {
                    final String newStr
                            = current.substring(0, index) + current.substring(index + 1);
                    if (index > 0 && c != current.charAt(index - 1)) {
                        queue.offer(newStr);
                    }
                }
            }
        }
        result.add("");
        return result;
    }

    private boolean isValid(String str) {
        int count = 0;
        for (int index = 0; index < str.length(); index++) {
            final char c = str.charAt(index);
            if (c == '(') {
                ++count;
            }
            if (c == ')' && --count < 0) {
                return false;
            }
        }
        return count == 0;
    }
}
