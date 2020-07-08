package string_integer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum15 {
    public List<List<Integer>> threeSum(int[] nums) {
        final List<List<Integer>> result = new LinkedList<>();
        if (nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);

        for (int i = 0; i <= nums.length - 3; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                final int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.add(List.of(nums[i], nums[j], nums[k]));
                    ++j;
                    --k;
                } else if (sum < 0) {
                    ++j;
                } else {
                    --k;
                }
                while (j > i + 1 && j < k && nums[j] == nums[j - 1]) {
                    ++j;
                }
                while (k < nums.length - 1 && j < k && nums[k] == nums[k + 1]) {
                    --k;
                }
            }
        }
        return result;
    }
}
