package depth_first_search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinations77 {
    public List<List<Integer>> combine(int n, int k) {
        final List<List<Integer>> results = new LinkedList();
        final List<Integer> subsets = new LinkedList();
        dfs(n, 1, k, subsets, results);
        return results;
    }

    private void dfs(int n, int now, int k, List<Integer> subsets, List<List<Integer>> results) {
        if (k == 0) {
            results.add(new ArrayList<>(subsets));
        } else {
            for (int i = now; i <= n; i++) {
                subsets.add(i);
                dfs(n, i + 1, k - 1, subsets, results);
                subsets.remove(subsets.size() - 1);
            }
        }
    }
}
