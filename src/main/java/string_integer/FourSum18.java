package string_integer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FourSum18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        final List<List<Integer>> results = new LinkedList<>();
        Arrays.sort(nums);
        int sum4 = target;
        for (int i = 0; i < nums.length - 3; i++) {
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int k = j + 1;
                int p = nums.length - 1;
                while (k < p) {
                    sum4 = nums[i] + nums[j] + nums[k] + nums[p] - target;
                    if (sum4 == 0) {
                        results.add(List.of(nums[i], nums[j], nums[k], nums[p]));
                        k++;
                        p--;
                    } else if (sum4 < 0) {
                        k++;
                    } else {
                        p--;
                    }
                    while (nums[k] == nums[k - 1] && k > j + 1 && k < p) {
                        k++;
                    }
                    while (p < nums.length - 1 && nums[p] == nums[p + 1] && k < p) {
                        p--;
                    }
                }
            }
        }
        return results;
    }
}
