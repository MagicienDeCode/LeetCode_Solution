package easy_easy;

public class MaximumNestingDepthoftheParentheses1614 {
    public int maxDepth(String s) {
        int stack = 0;
        int result = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                ++stack;
                result = Math.max(result, stack);
            }
            if (c == ')') {
                --stack;
            }
        }
        return result;
    }
}
