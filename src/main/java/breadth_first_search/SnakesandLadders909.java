package breadth_first_search;

import java.util.LinkedList;
import java.util.Queue;

public class SnakesandLadders909 {
    public int snakesAndLadders(int[][] board) {
        if (board.length == 0) {
            return 0;
        }
        // visited, queue
        final boolean[] visited = new boolean[board.length * board.length + 1];
        final Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;
        // bfs
        int level = 0;
        while (!queue.isEmpty()) {
            final int currentSize = queue.size();
            for (int size = 0; size < currentSize; size++) {
                final int current = queue.poll();
                if (current == board.length * board.length) {
                    return level;
                }
                final int range = Math.min(current + 6, board.length * board.length);
                for (int next = current + 1; next <= range; next++) {
                    final int[] nextCoordinate = getCoordinate(next, board.length);
                    final int nextBoardValue = board[nextCoordinate[0]][nextCoordinate[1]];
                    final int nextValue = nextBoardValue == -1 ? next : nextBoardValue;
                    if (!visited[nextValue]) {
                        queue.offer(nextValue);
                        visited[nextValue] = true;
                    }
                }
            }
            ++level;
        }
        return -1;
    }

    private int[] getCoordinate(int number, int n) {
        final int row = n - 1 - (number - 1) / n;
        final int column = row % 2 == n % 2 ?
                n - 1 - (number - 1) % n :
                (number - 1) % n;
        return new int[]{row, column};
    }
}
