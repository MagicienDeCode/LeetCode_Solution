package breadth_first_search;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumMovestoMoveaBoxtoTheirTargetLocation1263 {
    public int minPushBox(char[][] grid) {
        final Queue<int[]> queue = new LinkedList<>();
        final boolean[][][] visited =
                new boolean[grid.length][grid[0].length][4];
        final int[] target = new int[2];
        final int[] player = new int[2];
        final int[] box = new int[2];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 'T') {
                    target[0] = i;
                    target[1] = j;
                    grid[i][j] = '.';
                }
                if (grid[i][j] == 'S') {
                    player[0] = i;
                    player[1] = j;
                    grid[i][j] = '.';
                }
                if (grid[i][j] == 'B') {
                    box[0] = i;
                    box[1] = j;
                    grid[i][j] = '.';
                }
            }
        }
        queue.offer(new int[]{
                box[0], box[1], player[0], player[1]
        });
        int level = 0;
        while (!queue.isEmpty()) {
            final int currentSize = queue.size();
            // iterate by level
            for (int size = 0; size < currentSize; size++) {
                final int[] current = queue.poll();
                if (current[0] == target[0] &&
                        current[1] == target[1]
                ) {
                    return level;
                }
                for (int index = 0; index < 4; index++) {
                    // next box position
                    final int nextX = current[0] + deltaX[index];
                    final int nextY = current[1] + deltaY[index];
                    // next player position is opposite to box
                    final int playerX = current[0] - deltaX[index];
                    final int playerY = current[1] - deltaY[index];
                    // next box player should be in bound, equals to '.'
                    // player can move from current player position to (playerX,playerY)
                    if (inBound(grid, nextX, nextY) &&
                            inBound(grid, playerX, playerY) &&
                            !visited[nextX][nextY][index] &&
                            grid[nextX][nextY] == '.' &&
                            grid[playerX][playerY] == '.' &&
                            canPush(grid,
                                    playerX,
                                    playerY,
                                    current[2],
                                    current[3],
                                    current[0],
                                    current[1])
                    ) {
                        queue.offer(new int[]{nextX, nextY, playerX, playerY});
                        visited[nextX][nextY][index] = true;
                    }
                }
            }
            ++level;
        }
        return -1;
    }

    // as we mark box as '.', so we need its position to block player's moves
    private boolean canPush(
            char[][] grid,
            int targetX,
            int targetY,
            int x,
            int y,
            int boxX,
            int boxY) {
        final Queue<int[]> queue = new LinkedList<>();
        final boolean[][] visited =
                new boolean[grid.length][grid[0].length];
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            final int[] current = queue.poll();
            if (current[0] == targetX && current[1] == targetY) {
                return true;
            }
            for (int index = 0; index < 4; index++) {
                final int nextX = current[0] + deltaX[index];
                final int nextY = current[1] + deltaY[index];
                if (inBound(grid, nextX, nextY) &&
                        !visited[nextX][nextY] &&
                        grid[nextX][nextY] == '.' &&
                        (nextX != boxX || nextY != boxY)
                ) {
                    queue.offer(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true;
                }
            }
        }
        return false;
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
