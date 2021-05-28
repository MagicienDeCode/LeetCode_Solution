package easy_easy;

public class MinimumOperationstoMaketheArrayIncreasing1827 {
    public int minOperations(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            final int aim = nums[i - 1] + 1;
            final int diff = aim - nums[i];
            if (diff > 0) {
                count += diff;
                nums[i] = aim;
            }
        }
        return count;
    }
}
