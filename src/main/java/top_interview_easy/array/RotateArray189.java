package top_interview_easy.array;

public class RotateArray189 {
    /*
    Original List                   : 1 2 3 4 5 6 7
    After reversing all numbers     : 7 6 5 4 3 2 1
    After reversing first k numbers : 5 6 7 4 3 2 1
    After revering last n-k numbers : 5 6 7 1 2 3 4 --> Result
     */
    public void rotate(int[] nums, int k) {
        // three steps to reverse
        final int kk = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, kk - 1);
        reverse(nums, kk, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            final int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            ++start;
            --end;
        }
    }
}
