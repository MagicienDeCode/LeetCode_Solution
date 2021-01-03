package depth_first_search;

public class BeautifulArrangement526 {

    private int result = 0;

    public int countArrangement(int n) {
        result = 0;
        dfs(n, 1, new boolean[n + 1]);
        return result;
    }

    private void dfs(int n, int index, boolean[] visited) {
        if (index > n) {
            ++result;
        } else {
            for (int i = 1; i <= n; i++) {
                if (!visited[i] && ((i % index == 0) || (index % i == 0))) {
                    visited[i] = true;
                    dfs(n, index + 1, visited);
                    visited[i] = false;
                }
            }
        }
    }
}
