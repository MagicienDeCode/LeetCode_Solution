package breadth_first_search;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Minesweeper529 {
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        final Queue<Pair<Integer, Integer>> queue = new LinkedList();
        final boolean[][] visited = new boolean[board.length][board[0].length];
        queue.offer(new Pair<>(click[0], click[1]));
        visited[click[0]][click[1]] = true;
        while (!queue.isEmpty()) {
            final Pair<Integer, Integer> current = queue.poll();
            board[current.getKey()][current.getValue()] = 'B';
            final List<Pair<Integer, Integer>> nextLevel = new ArrayList<>();
            int count = 0;
            for (int index = 0; index < 8; index++) {
                final int nextX = current.getKey() + deltaX[index];
                final int nextY = current.getValue() + deltaY[index];
                if (inBound(board, nextX, nextY) &&
                        !visited[nextX][nextY]) {
                    nextLevel.add(new Pair<>(nextX, nextY));
                    if (board[nextX][nextY] == 'M') {
                        ++count;
                    }
                }
            }
            if (count == 0) {
                for (Pair<Integer, Integer> it : nextLevel) {
                    queue.offer(it);
                    visited[it.getKey()][it.getValue()] = true;
                }
            } else {
                board[current.getKey()][current.getValue()] = (char) ('0' + count);
            }
        }
        return board;
    }

    private final int[] deltaX = {0, 0, -1, 1, 1, 1, -1, -1};
    private final int[] deltaY = {-1, 1, 0, 0, 1, -1, -1, 1};

    private boolean inBound(
            char[][] grid,
            int x,
            int y
    ) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
    }
}