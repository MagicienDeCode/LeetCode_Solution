package depth_first_search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        final List<List<Integer>> results = new LinkedList<>();
        final List<Integer> subsets = new LinkedList<>();
        dfs(candidates, 0, target, subsets, results);
        return results;
    }

    private void dfs(int[] candidates, int start, int target, List<Integer> subsets, List<List<Integer>> results) {
        if (target == 0) {
            results.add(new ArrayList<>(subsets));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            subsets.add(candidates[i]);
            dfs(candidates, i, target - candidates[i], subsets, results);
            subsets.remove(subsets.size() - 1);
        }
    }
}
