package easy_easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MinimumSubsequenceinNonIncreasingOrder1403 {
    public List<Integer> minSubsequence(int[] nums) {
        final List<Integer> results = new LinkedList<>();
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        Arrays.sort(nums);
        int current = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            current += nums[i];
            sum -= nums[i];
            results.add(nums[i]);
            if (current > sum) {
                return results;
            }
        }
        return results;
    }
}
