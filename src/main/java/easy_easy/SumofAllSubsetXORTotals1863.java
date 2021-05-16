package easy_easy;

import java.util.ArrayList;
import java.util.List;

public class SumofAllSubsetXORTotals1863 {

    int result = 0;

    public int subsetXORSum(int[] nums) {
        dfs(nums, 0, new ArrayList<>());
        return result;
    }

    private void dfs(int[] nums, int start, List<Integer> subsets) {
        calculateXor(subsets);
        for (int i = start; i < nums.length; i++) {
            subsets.add(nums[i]);
            dfs(nums, i + 1, subsets);
            subsets.remove(subsets.size() - 1);
        }
    }

    private void calculateXor(List<Integer> list) {
        if (list.isEmpty()) {
            return;
        }
        int r = 0;
        for (int l : list) {
            r ^= l;
        }
        result += r;
    }

    /*
    public int subsetXORSum(int[] nums) {
        int bits = 0;
        for (int n : nums) {
            bits |= n;
        }
        return bits * (int) Math.pow(2, nums.length - 1);
    }
     */
}
