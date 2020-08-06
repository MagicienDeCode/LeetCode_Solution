package breadth_first_search;

import java.util.*;

public class EscapeaLargeMaze1036 {
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        // prepare blockedMap, maxLevel
        final Map<Integer, Set<Integer>> blockedMap = new HashMap<>();
        for (int[] it : blocked) {
            blockedMap.computeIfAbsent(it[0], v -> new HashSet<>()).add(it[1]);
        }
        final int maxLevel = blocked.length;

        return bfs(blockedMap, maxLevel, source, target) &&
                bfs(blockedMap, maxLevel, target, source);
    }

    private boolean bfs(
            final Map<Integer, Set<Integer>> blockedMap,
            final int maxLevel,
            final int[] start,
            final int[] end
    ) {
        final Map<Integer, Set<Integer>> visited = new HashMap<>();
        final Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        visited.computeIfAbsent(start[0], v -> new HashSet<>()).add(start[1]);

        int level = 0;
        while (!queue.isEmpty()) {
            if (level >= maxLevel) {
                return true;
            }
            final int currentSize = queue.size();
            // iterate by level
            for (int size = 0; size < currentSize; size++) {
                final int[] current = queue.poll();
                // if start can access end, return true
                if (end[0] == current[0] && end[1] == current[1]) {
                    return true;
                }
                for (int index = 0; index < 4; index++) {
                    final int nextX = current[0] + deltaX[index];
                    final int nextY = current[1] + deltaY[index];
                    if (inBound(nextX, nextY) &&
                            !exist(blockedMap, nextX, nextY) &&
                            !exist(visited, nextX, nextY)) {
                        queue.offer(new int[]{nextX, nextY});
                        visited.computeIfAbsent(nextX, v -> new HashSet<>()).add(nextY);
                    }
                }
            }
            ++level;
        }
        return false;
    }

    private boolean exist(
            final Map<Integer, Set<Integer>> map,
            int x,
            int y
    ) {
        if (map.containsKey(x)) {
            return map.get(x).contains(y);
        }
        return false;
    }

    private final int[] deltaX = {0, 0, -1, 1};
    private final int[] deltaY = {-1, 1, 0, 0};

    private boolean inBound(
            int x,
            int y
    ) {
        return x >= 0 && y >= 0 && x < 1000000 && y < 1000000;
    }
}
