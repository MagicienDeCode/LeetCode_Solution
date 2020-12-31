package stack;

import java.util.Stack;

public class LargestRectangleinHistogram84 {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        int result = 0;
        final Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            if (!stack.empty() && heights[stack.peek()] > heights[i]) {
                final int peekIndex = stack.peek();
                int lastPop = stack.peek();
                while (!stack.empty() && heights[stack.peek()] > heights[i]) {
                    lastPop = stack.pop();
                    result = Math.max(result, heights[lastPop] * (peekIndex - lastPop + 1));
                }
                stack.push(lastPop);
                heights[lastPop] = heights[i];
            }
            stack.push(i);
        }
        final int peekIndex = stack.peek();
        while (!stack.empty()) {
            result = Math.max(result, heights[stack.peek()] * (peekIndex - stack.pop() + 1));
        }
        return result;
    }

    public static void main(String[] args) {
        final LargestRectangleinHistogram84 java = new LargestRectangleinHistogram84();
        System.out.println(java.largestRectangleArea(new int[]{5, 4, 4, 1, 2}));
        System.out.println(java.largestRectangleArea(new int[]{2, 1, 2}));
        System.out.println(java.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }
}
