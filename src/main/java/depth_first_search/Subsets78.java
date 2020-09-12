package depth_first_search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets78 {
    public List<List<Integer>> subsets(int[] nums) {
        final List<List<Integer>> results = new LinkedList();
        if (nums == null || nums.length == 0) {
            return results;
        }
        final List<Integer> subsets = new LinkedList();
        dfs(nums, 0, subsets, results);
        return results;
    }

    private void dfs(
            int[] nums,
            int startIndex,
            List<Integer> subsets,
            List<List<Integer>> results
    ) {
        // clone, deep copy
        results.add(new ArrayList(subsets));
        for (int i = startIndex; i < nums.length; i++) {
            subsets.add(nums[i]);
            dfs(nums, i + 1, subsets, results);
            subsets.remove(subsets.size() - 1);
        }
    }
}
