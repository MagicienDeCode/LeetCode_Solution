package breadth_first_search;

import java.util.*;

public class SlidingPuzzle773 {
    private final String endString = "123450";

    private final Map<Integer, List<int[]>> swapIndexMap =
            Map.of(
                    0, List.of(
                            new int[]{0, 1},
                            new int[]{0, 3}
                    ),
                    1, List.of(
                            new int[]{0, 1},
                            new int[]{1, 2},
                            new int[]{1, 4}
                    ),
                    2, List.of(
                            new int[]{1, 2},
                            new int[]{2, 5}
                    ),
                    3, List.of(
                            new int[]{3, 4},
                            new int[]{0, 3}
                    ),
                    4, List.of(
                            new int[]{5, 4},
                            new int[]{3, 4},
                            new int[]{1, 4}
                    ),
                    5, List.of(
                            new int[]{4, 5},
                            new int[]{2, 5}
                    )
            );

    public int slidingPuzzle(int[][] board) {
        final Set<String> visited = new HashSet<>();
        final Queue<String> queue = new LinkedList<>();
        final StringBuilder sb = new StringBuilder();
        for (int[] line : board) {
            for (int i : line) {
                sb.append(i);
            }
        }
        queue.offer(sb.toString());
        visited.add(sb.toString());
        int level = 0;
        while (!queue.isEmpty()) {
            final int currentSize = queue.size();
            for (int size = 0; size < currentSize; size++) {
                final String current = queue.poll();
                if (current.equals(endString)) {
                    return level;
                }
                swapIndexMap.get(current.indexOf("0")).forEach(
                        it -> {
                            final StringBuilder sbNew = new StringBuilder(current);
                            final char temp = current.charAt(it[0]);
                            sbNew.setCharAt(it[0], current.charAt(it[1]));
                            sbNew.setCharAt(it[1], temp);
                            final String newString = sbNew.toString();
                            if (!visited.contains(newString)) {
                                queue.offer(newString);
                                visited.add(newString);
                            }
                        }
                );
            }
            ++level;
        }
        return -1;
    }
}
