package breadth_first_search;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ShortestPathtoGetAllKeys864 {
    public int shortestPathAllKeys(String[] grid) {
        final char[][] myGrid = new char[grid.length][grid[0].length()];
        for (int i = 0; i < myGrid.length; i++) {
            myGrid[i] = grid[i].toCharArray();
        }
        final Set<Character> keys = Set.of('a', 'b', 'c', 'd', 'e', 'f');
        // get count, start x,y , endKey
        int count = 0;
        int startX = 0;
        int startY = 0;
        for (int i = 0; i < myGrid.length; i++) {
            for (int j = 0; j < myGrid[0].length; j++) {
                if (keys.contains(myGrid[i][j])) {
                    ++count;
                }
                if (myGrid[i][j] == '@') {
                    startX = i;
                    startY = j;
                }
            }
        }
        if (count == 0) {
            return 0;
        }
        final int endKey = (1 << count) - 1;

        // visited, queue
        final boolean[][][] visited =
                new boolean[myGrid.length][myGrid[0].length][1 << count];
        final Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY, 0});
        visited[startX][startY][0] = true;

        // bfs
        int level = 0;
        while (!queue.isEmpty()) {
            final int currentSize = queue.size();
            for (int size = 0; size < currentSize; size++) {
                final int[] current = queue.poll();
                if (current[2] == endKey) {
                    return level;
                }
                for (int index = 0; index < 4; index++) {
                    final int nextX = current[0] + deltaX[index];
                    final int nextY = current[1] + deltaY[index];
                    if (inBound(myGrid, nextX, nextY) && '#' != myGrid[nextX][nextY]) {
                        final char nextChar = myGrid[nextX][nextY];
                        if (nextChar >= 'a' && nextChar <= 'f') {
                            final int nextState = (1 << (nextChar - 'a')) | (current[2]);
                            if (!visited[nextX][nextY][nextState]) {
                                queue.offer(new int[]{nextX, nextY, nextState});
                                visited[nextX][nextY][nextState] = true;
                            }
                        } else if (nextChar >= 'A' && nextChar <= 'F') {
                            final int currentLockIndex = nextChar - 'A';
                            final int unLock = 1 & (current[2] >> currentLockIndex);
                            if (unLock == 1 && !visited[nextX][nextY][current[2]]) {
                                queue.offer(new int[]{nextX, nextY, current[2]});
                                visited[nextX][nextY][current[2]] = true;
                            }
                        } else {
                            if (!visited[nextX][nextY][current[2]]) {
                                queue.offer(new int[]{nextX, nextY, current[2]});
                                visited[nextX][nextY][current[2]] = true;
                            }
                        }
                    }
                }
            }
            ++level;
        }
        return -1;
    }

    private final int[] deltaX = {0, 0, -1, 1};
    private final int[] deltaY = {-1, 1, 0, 0};

    private boolean inBound(
            char[][] grid,
            int x,
            int y
    ) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
    }
}
