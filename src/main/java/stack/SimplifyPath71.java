package stack;

import java.util.Stack;

public class SimplifyPath71 {
    public String simplifyPath(String path) {
        final Stack<String> stack = new Stack<>();
        final char[] chars = path.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            while (i < chars.length && chars[i] == '/') {
                i++;
            }
            final StringBuilder current = new StringBuilder();
            while (i < chars.length && chars[i] != '/') {
                current.append(chars[i++]);
            }
            final String currentPath = current.toString();
            if (currentPath.equals("..") && !stack.empty()) {
                stack.pop();
            }
            if (!currentPath.isEmpty() && !currentPath.equals(".") && !currentPath.equals("..")) {
                stack.push(currentPath);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        final StringBuilder result = new StringBuilder("/" + stack.pop());
        while (!stack.empty()) {
            result.insert(0, "/" + stack.pop());
        }
        return result.toString();
    }
}
