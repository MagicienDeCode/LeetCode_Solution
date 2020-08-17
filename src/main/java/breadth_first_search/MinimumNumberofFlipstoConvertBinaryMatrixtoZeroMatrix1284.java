package breadth_first_search;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumNumberofFlipstoConvertBinaryMatrixtoZeroMatrix1284 {
    public int minFlips(int[][] mat) {
        if (mat.length == 0) {
            return 0;
        }
        final int n = mat[0].length;
        final String endString = "0".repeat(mat.length * n);
        final StringBuilder startStringBuilder = new StringBuilder();
        for (int[] ints : mat) {
            for (int i : ints) {
                startStringBuilder.append(i);
            }
        }
        final String startString = startStringBuilder.toString();
        if (endString.equals(startString)) {
            return 0;
        }
        final Queue<String> queue = new LinkedList<>();
        final Set<String> visited = new HashSet<>();
        queue.offer(startString);
        visited.add(startString);

        int level = 0;
        while (!queue.isEmpty()) {
            final int currentSize = queue.size();
            for (int size = 0; size < currentSize; size++) {
                final String current = queue.poll();
                if (endString.equals(current)) {
                    return level;
                }
                for (int aimIndex = 0; aimIndex < current.length(); aimIndex++) {
                    final int currentX = aimIndex / n;
                    final int currentY = aimIndex % n;
                    final StringBuilder newStringBuilder =
                            new StringBuilder(current);
                    change(newStringBuilder, aimIndex);
                    for (int index = 0; index < 4; index++) {
                        final int nextX = currentX + deltaX[index];
                        final int nextY = currentY + deltaY[index];
                        if (inBound(mat, nextX, nextY)) {
                            change(newStringBuilder, nextX * n + nextY);
                        }
                    }
                    final String newString = newStringBuilder.toString();
                    if (!visited.contains(newString)) {
                        queue.offer(newString);
                        visited.add(newString);
                    }
                }
            }
            ++level;
        }
        return -1;
    }

    private void change(StringBuilder stringBuilder, int i) {
        if (stringBuilder.charAt(i) == '0') {
            stringBuilder.setCharAt(i, '1');
        } else {
            stringBuilder.setCharAt(i, '0');
        }
    }

    private final int[] deltaX = {0, 0, -1, 1};
    private final int[] deltaY = {-1, 1, 0, 0};

    private boolean inBound(
            int[][] grid,
            int x,
            int y
    ) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
    }
}
