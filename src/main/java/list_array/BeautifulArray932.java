package list_array;

import java.util.HashMap;
import java.util.Map;

public class BeautifulArray932 {

    final Map<Integer, int[]> memo = new HashMap<>();

    public int[] beautifulArray(int n) {
        memo.put(1, new int[]{1});
        return dfs(n);
    }

    private int[] dfs(int n) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        final int[] result = new int[n];
        int i = 0;
        for (int x : dfs((n + 1) / 2)) {
            result[i++] = 2 * x - 1;
        }
        for (int x : dfs(n / 2)) {
            result[i++] = x * 2;
        }
        memo.put(n, result);
        return result;
    }
}
