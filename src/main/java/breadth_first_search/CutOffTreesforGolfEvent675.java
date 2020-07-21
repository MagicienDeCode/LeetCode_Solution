package breadth_first_search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CutOffTreesforGolfEvent675 {
    private final int[] deltaX = {0, 0, -1, 1};
    private final int[] deltaY = {-1, 1, 0, 0};

    private boolean inBound(
            List<List<Integer>> grid,
            int x,
            int y
    ) {
        return x >= 0 && y >= 0 && x < grid.size() && y < grid.get(0).size();
    }

    public int cutOffTree(List<List<Integer>> forest) {
        final List<int[]> trees = new ArrayList<>();
        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(0).size(); j++) {
                final int currentVal = forest.get(i).get(j);
                if (currentVal > 1) {
                    trees.add(new int[]{currentVal, i, j});
                }
            }
        }
        trees.sort((ints1, ints2) -> Integer.compare(ints1[0], ints2[0]));
        int result = 0;
        int startX = 0;
        int startY = 0;
        for (int[] it : trees) {
            final int distance = bfs(forest, startX, startY, it[1], it[2]);
            if (distance < 0) {
                return -1;
            }
            result += distance;
            startX = it[1];
            startY = it[2];
        }
        return result;
    }

    private int bfs(List<List<Integer>> forest, int startX, int startY, int endX, int endY) {
        int level = 0;
        final Queue<int[]> queue = new LinkedList<>();
        final boolean[][] visited = new boolean[forest.size()][forest.get(0).size()];
        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;
        while (!queue.isEmpty()) {
            final int currentSize = queue.size();
            for (int size = 0; size < currentSize; size++) {
                final int[] current = queue.poll();
                if (current[0] == endX && current[1] == endY) {
                    return level;
                }
                for (int index = 0; index < 4; index++) {
                    final int nextX = current[0] + deltaX[index];
                    final int nextY = current[1] + deltaY[index];
                    if (inBound(forest, nextX, nextY) &&
                            !visited[nextX][nextY] &&
                            forest.get(nextX).get(nextY) > 1) {
                        queue.offer(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                    }
                }
            }
            ++level;
        }
        return -1;
    }
}
