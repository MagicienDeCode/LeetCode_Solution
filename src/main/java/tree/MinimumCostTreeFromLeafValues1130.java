package tree;

import java.util.Stack;

public class MinimumCostTreeFromLeafValues1130 {
    /*
    // 7 12 8 10
    public int mctFromLeafValues(int[] arr) {
        Arrays.sort(arr);
        int result = 0;
        for (int i = 1; i < arr.length; i++) {
            result += arr[i] * arr[i - 1];
        }
        return result;
    }
     */

    // [15,13,5,3,15] - 500
    public int mctFromLeafValues(int[] arr) {
        final Stack<Integer> stack = new Stack<>();
        int result = 0;
        stack.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] >= stack.peek()) {
                final int pop = stack.pop();
                if (stack.size() == 0) {
                    result += pop * arr[i];
                } else {
                    result += pop * Math.min(arr[i], stack.peek());
                }
            }
            stack.push(arr[i]);
        }
        while (stack.size() > 1) {
            result += stack.pop() * stack.peek();
        }
        return result;
    }

    public static void main(String[] args) {
        final MinimumCostTreeFromLeafValues1130 java = new MinimumCostTreeFromLeafValues1130();
        System.out.println(11 * 12 + 12 * 12);
        // 276
        System.out.println(java.mctFromLeafValues(new int[]{11, 12, 12}));
        System.out.println(java.mctFromLeafValues(new int[]{15, 13, 5, 3, 15}));
    }
}
