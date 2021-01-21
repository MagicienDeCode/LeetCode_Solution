package stack;

import java.util.Arrays;
import java.util.Stack;

public class FindtheMostCompetitiveSubsequence1673 {
    public int[] mostCompetitive(int[] nums, int k) {
        final Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && stack.peek() > nums[i] && (k - stack.size()) < nums.length - i) {
                stack.pop();
            }
            if (stack.size() < k) {
                stack.push(nums[i]);
            }
        }
        final int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        final FindtheMostCompetitiveSubsequence1673 java = new FindtheMostCompetitiveSubsequence1673();
        // 26
        Arrays.stream(java.mostCompetitive(new int[]{3, 5, 2, 6}, 2)).boxed().forEach(System.out::print);
        System.out.println();
        // 2334
        Arrays.stream(java.mostCompetitive(new int[]{2, 4, 3, 3, 5, 4, 9, 6}, 4)).boxed().forEach(System.out::print);
        System.out.println();
        Arrays.stream(java.mostCompetitive(new int[]{2, 4, 3, 3, 5, 4, 9, 6, 1, 2, 3, 4}, 4)).boxed().forEach(System.out::print);
        System.out.println();
        // 8802
        Arrays.stream(java.mostCompetitive(new int[]{71, 18, 52, 29, 55, 73, 24, 42, 66, 8, 80, 2}, 3)).boxed().forEach(System.out::print);
        System.out.println();
        Arrays.stream(java.mostCompetitive(new int[]{11, 52, 57, 91, 47, 95, 86, 46, 87, 47, 70, 56, 54, 61, 89, 44, 3, 73, 1, 7, 87, 48, 17, 25, 49, 54, 6, 72, 97, 62, 16, 11, 47, 34, 68, 58, 14, 36, 46, 65, 2, 15}, 18)).boxed().forEach(System.out::print);
        System.out.println();
    }
}
