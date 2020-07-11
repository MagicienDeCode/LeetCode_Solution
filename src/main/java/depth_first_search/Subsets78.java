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
        final List<Integer> subset = new LinkedList();
        dfs(nums, 0, subset, results);
        return results;
    }

    private void dfs(
            int[] nums,
            int startIndex,
            List<Integer> subset,
            List<List<Integer>> results
    ) {
        // clone, deep copy
        results.add(new ArrayList(subset));
        for (int i = startIndex; i < nums.length; i++) {
            subset.add(nums[i]);
            dfs(nums, i + 1, subset, results);
            subset.remove(subset.size() - 1);
        }
    }
}
