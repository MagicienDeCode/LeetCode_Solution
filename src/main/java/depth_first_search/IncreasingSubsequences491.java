package depth_first_search;

import java.util.*;

public class IncreasingSubsequences491 {
    public List<List<Integer>> findSubsequences(int[] nums) {
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
        if (subsets.size() >= 2) {
            results.add(new ArrayList<>(subsets));
        }
        final Set<Integer> visited = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            if (!subsets.isEmpty() && subsets.get(subsets.size() - 1) > nums[i] || visited.contains(nums[i])) {
                continue;
            }
            visited.add(nums[i]);
            subsets.add(nums[i]);
            dfs(nums, i + 1, subsets, results);
            subsets.remove(subsets.size() - 1);
        }
    }
}
