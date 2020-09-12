package depth_first_search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumIII216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        final List<List<Integer>> results = new LinkedList();
        if (k == 0 || n == 0) {
            return results;
        }
        final List<Integer> subsets = new LinkedList();
        dfs(k, n, 1, subsets, results);
        return results;
    }

    private void dfs(
            int k,
            int remain,
            int start,
            List<Integer> subsets,
            List<List<Integer>> results
    ) {
        // end condition
        if (remain == 0 && k == subsets.size()) {
            results.add(new ArrayList<>(subsets));
        }
        // not valid results, so return
        if (remain < 0 || k == subsets.size()) {
            return;
        }
        // backtracking
        for (int i = start; i <= 9; i++) {
            subsets.add(i);
            dfs(k, remain - i, i + 1, subsets, results);
            subsets.remove(subsets.size() - 1);
        }
    }
}
