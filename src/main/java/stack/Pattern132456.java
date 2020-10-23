package stack;

import java.util.Stack;

public class Pattern132456 {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        final Stack<Integer> stack = new Stack<>();
        final int[] min = new int[nums.length];
        min[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min[i] = Math.min(min[i - 1], nums[i]);
        }
        for (int j = nums.length - 1; j >= 0; j--) {
            if (nums[j] > min[j]) {
                while (!stack.isEmpty() && stack.peek() <= min[j])
                    stack.pop();
                if (!stack.isEmpty() && stack.peek() < nums[j])
                    return true;
                stack.push(nums[j]);
            }
        }
        return false;
    }

    // i j k
    // 1 3 2
    /*
    public boolean find132pattern(int[] nums) {
        int minI = nums[0];
        for (int j = 1; j < nums.length - 1; j++) {
            minI = Math.min(minI, nums[j]);
            for (int k = j + 1; k < nums.length; k++) {
                if (nums[k] > minI && nums[j] > nums[k]) {
                    return true;
                }
            }
        }
        return false;
    }
     */
}
