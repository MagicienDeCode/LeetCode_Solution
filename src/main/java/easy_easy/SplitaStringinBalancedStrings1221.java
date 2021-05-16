package easy_easy;

public class SplitaStringinBalancedStrings1221 {
    public int balancedStringSplit(String s) {
        int left = 0;
        int right = 0;
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == 'L') {
                ++left;
            } else {
                ++right;
            }
            if (left == right) {
                ++count;
            }
        }
        return count;
    }
    /*
    public int balancedStringSplit(String s) {
        final Stack<Character> stack = new Stack<>();
        int count = 0;
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                if (stack.peek() == c) {
                    stack.push(c);
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        ++count;
                    }
                }
            }
        }
        return count;
    }
     */
}
