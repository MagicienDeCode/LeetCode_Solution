package dynamic_programming;

public class TrappingRainWater42 {
    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int result = 0;
        final int[] leftMax = new int[height.length];
        leftMax[0] = height[0];
        final int[] rightMax = new int[height.length];
        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            result += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return result;
    }
    /*
    public int trap(int[] height) {
        int result = 0;
        int current = 0;
        // stock index
        final Stack<Integer> stack = new Stack<>();
        while (current < height.length) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                final int previous = stack.pop();
                if (stack.isEmpty()){
                    break;
                }
                final int distance = current - stack.peek() - 1;
                final int minHeight = Math.min(height[current], height[stack.peek()]) - height[previous];
                result += distance * minHeight;
            }
            stack.push(current++);
        }
        return result;
    }
     */
}
