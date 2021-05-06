package depth_first_search;

public class MostStonesRemovedwithSameRoworColumn947 {
    public int removeStones(int[][] stones) {
        final int[] ints = new int[stones.length];
        for (int i = 1; i < ints.length; i++) {
            ints[i] = i;
        }
        for (int i = 0; i < stones.length; i++) {
            for (int j = i + 1; j < stones.length; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    ints[unionFind(ints, i)] = unionFind(ints, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == i) {
                ++count;
            }
        }
        return ints.length - count;
    }

    private int unionFind(int[] ints, int target) {
        return ints[target] == target ? target : unionFind(ints, ints[target]);
    }
    /*
    public int removeStones(int[][] stones) {
        final Map<Integer, List<Integer>> rowMap = new HashMap<>();
        final Map<Integer, List<Integer>> colMap = new HashMap<>();
        for (int[] stone : stones) {
            rowMap.computeIfAbsent(stone[0], v -> new ArrayList<>()).add(stone[1]);
            colMap.computeIfAbsent(stone[1], v -> new ArrayList<>()).add(stone[0]);
        }
        final Set<Integer> visited = new HashSet<>();
        int result = 0;
        for (int r : rowMap.keySet()) {
            if (!visited.contains(r)) {
                result += dfs(rowMap, colMap, r, visited) - 1;
            }
        }
        return result;
    }

    private int dfs(Map<Integer, List<Integer>> rowMap, Map<Integer, List<Integer>> colMap, int row, Set<Integer> visited) {
        visited.add(row);
        int result = rowMap.get(row).size();
        for (int c : rowMap.get(row)) {
            for (int r : colMap.get(c)) {
                if (!visited.contains(r)) {
                    result += dfs(rowMap, colMap, r, visited);
                }
            }
        }
        return result;
    }
     */
}
