package list_array;

import java.util.*;
import java.util.stream.Collectors;

public class RankTransformofaMatrix1632 {
    public int[][] matrixRankTransform(int[][] matrix) {
        final int r = matrix.length;
        final int c = matrix[0].length;
        final int[] row = new int[r];
        final int[] col = new int[c];
        final Map<Integer, List<Number>> map = new HashMap<>();
        final Map<Integer, Map<Integer, List<Number>>> rowMap = new HashMap<>();
        final Map<Integer, Map<Integer, Set<Integer>>> rowColMap = new HashMap<>();
        final Map<Integer, Integer> groupMap = new HashMap<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                final Number number = new Number(i, j, 0);
                map.computeIfAbsent(matrix[i][j], v -> new ArrayList<>()).add(number);
                rowMap.computeIfAbsent(matrix[i][j], v -> new HashMap<>()).computeIfAbsent(i, v -> new ArrayList<>()).add(number);
                rowColMap.computeIfAbsent(matrix[i][j], v -> new HashMap<>()).computeIfAbsent(i, v -> new HashSet<>()).add(j);
            }
        }
        for (int v : map.keySet()) {
            regroup(groupMap, v, rowMap, rowColMap);
        }
        final List<Integer> sorted = map.keySet().stream().sorted().collect(Collectors.toList());
        final int[][] result = new int[r][c];
        for (int s : sorted) {
            for (int i = 1; i <= groupMap.get(s); i++) {
                int rank = 0;
                final int currentGroup = i;
                final List<Number> numbers = map.get(s).stream().filter(n -> n.group == currentGroup).collect(Collectors.toList());
                for (Number number : numbers) {
                    int rRank = row[number.i];
                    int cRank = col[number.j];
                    rank = Math.max(rank, Math.max(rRank, cRank) + 1);
                }
                for (Number number : numbers) {
                    result[number.i][number.j] = rank;
                    row[number.i] = rank;
                    col[number.j] = rank;
                }
            }
        }
        return result;
    }

    private void regroup(Map<Integer, Integer> groupMap, int target, Map<Integer, Map<Integer, List<Number>>> rowMap, Map<Integer, Map<Integer, Set<Integer>>> rowColMap) {
        final Set<Integer> rowVisited = new HashSet<>();
        int g = 1;
        for (int r : rowMap.get(target).keySet()) {
            if (!rowVisited.contains(r)) {
                dfs(r, rowMap.get(target), rowVisited, g, rowColMap.get(target));
                g++;
            }
        }
        groupMap.put(target, g);
    }

    private void dfs(int r, Map<Integer, List<Number>> rowMapNumbers, Set<Integer> rowVisited, int g, Map<Integer, Set<Integer>> rowCol) {
        rowVisited.add(r);
        for (Number number : rowMapNumbers.get(r)) {
            number.group = g;
        }
        for (int eachRow : rowMapNumbers.keySet()) {
            if (!rowVisited.contains(eachRow)) {
                final Set<Integer> currentCol = rowCol.get(r);
                final Set<Integer> eachCol = rowCol.get(eachRow);
                final Set<Integer> temp = new HashSet<>(currentCol);
                temp.retainAll(eachCol);
                if (temp.size() > 0) {
                    dfs(eachRow, rowMapNumbers, rowVisited, g, rowCol);
                }
            }
        }
    }

    static class Number {
        final int i;
        final int j;
        int group;
        boolean visited = false;

        public Number(int i, int j, int group) {
            this.i = i;
            this.j = j;
            this.group = group;
        }

        public boolean isSameGroup(int x, int y) {
            return x == i || y == j;
        }
    }

    /*
    public int[][] matrixRankTransform(int[][] matrix) {
        final int r = matrix.length;
        final int c = matrix[0].length;
        final int[] row = new int[r];
        final int[] col = new int[c];
        final Map<Integer, List<Number>> map = new HashMap<>();
        final Map<Integer, Integer> groupMap = new HashMap<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                map.computeIfAbsent(matrix[i][j], v -> new ArrayList<>()).add(new Number(i, j, 0));
            }
        }
        for (List<Number> numbers : map.values()) {
            regroup(numbers, groupMap, matrix[numbers.get(0).i][numbers.get(0).j]);
        }
        final List<Integer> sorted = map.keySet().stream().sorted().collect(Collectors.toList());
        final int[][] result = new int[r][c];
        for (int s : sorted) {
            for (int i = 1; i <= groupMap.get(s); i++) {
                int rank = 0;
                final int currentGroup = i;
                final List<Number> numbers = map.get(s).stream().filter(n -> n.group == currentGroup).collect(Collectors.toList());
                for (Number number : numbers) {
                    int rRank = row[number.i];
                    int cRank = col[number.j];
                    rank = Math.max(rank, Math.max(rRank, cRank) + 1);
                }
                for (Number number : numbers) {
                    result[number.i][number.j] = rank;
                    row[number.i] = rank;
                    col[number.j] = rank;
                }
            }
        }
        return result;
    }

    private void regroup(List<Number> numbers, Map<Integer, Integer> groupMap, int target) {
        final boolean[] visited = new boolean[numbers.size()];
        int g = 1;
        if (target == -48){
            System.out.println(48);
        }
        for (int i = 0; i < numbers.size(); i++) {
            if (!visited[i]) {
                dfs(numbers, i, visited, g);
                g++;
            }
        }
        groupMap.put(target, g);
    }

    private void dfs(List<Number> numbers, int i, boolean[] visited, int g) {
        numbers.get(i).group = g;
        visited[i] = true;
        for (int j = 0; j < numbers.size(); j++) {
            if (!visited[j] && numbers.get(j).isSameGroup(numbers.get(i).i, numbers.get(i).j)) {
                dfs(numbers, j, visited, g);
            }
        }
    }

    static class Number {
        final int i;
        final int j;
        int group;

        public Number(int i, int j, int group) {
            this.i = i;
            this.j = j;
            this.group = group;
        }

        public boolean isSameGroup(int x, int y) {
            return x == i || y == j;
        }
    }
     */
}
