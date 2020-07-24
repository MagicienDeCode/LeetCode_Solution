package depth_first_search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllPathsFromSourcetoTarget797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        final List<List<Integer>> results = new LinkedList();
        final List<Integer> subsets = new LinkedList();

        dfs(results, subsets, graph, 0);

        return results;
    }

    private void dfs(
            List<List<Integer>> results,
            List<Integer> subsets,
            int[][] graph,
            int index
    ) {
        subsets.add(index);
        if (graph[index].length == 0) {
            // deep copy
            results.add(new ArrayList(subsets));
        } else {
            for (int next : graph[index]) {
                dfs(results, subsets, graph, next);
                subsets.remove(subsets.size() - 1);
            }
        }
    }
}
