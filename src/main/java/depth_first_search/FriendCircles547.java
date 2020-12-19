package depth_first_search;

public class FriendCircles547 {

    public int findCircleNum(int[][] m) {
        int result = 0;
        final boolean[] visited = new boolean[m.length];
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                continue;
            }
            dfs(m, i, visited);
            ++result;
        }
        return result;
    }

    private void dfs(int[][] m, int index, boolean[] visited) {
        visited[index] = true;
        for (int i = 0; i < m.length; i++) {
            if (m[index][i] == 1 && !visited[i]) {
                dfs(m, i, visited);
            }
        }
    }

    /*
        public int findCircleNum(int[][] m) {
        final int[] union = new int[m.length];
        for (int i = 1; i < union.length; i++) {
            union[i] = i;
        }

        for (int i = 0; i < m.length; i++) {
            for (int j = i + 1; j < m.length; j++) {
                if (m[i][j] == 1) {
                    final int valueI = unionFind(union, i);
                    final int valueJ = unionFind(union, j);
                    union[valueI] = valueJ;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < union.length; i++) {
            if (union[i] == i) {
                ++result;
            }
        }
        return result;
    }

    private int unionFind(int[] union, int i) {
        return union[i] == i ? i : unionFind(union, union[i]);
    }
     */

}
