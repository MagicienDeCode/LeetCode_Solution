package breadth_first_search;

import java.util.*;

public class JumpGameIV1345 {
    public int minJumps(int[] arr) {
        if (arr.length <= 1) {
            return 0;
        }
        final Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int index = 0; index < arr.length; index++) {
            graph.computeIfAbsent(arr[index], v -> new HashSet<>()).add(index);
        }

        final boolean[] visited = new boolean[arr.length];
        final Queue<Integer> queue = new LinkedList<>();

        queue.offer(0);
        visited[0] = true;

        int level = 0;
        while (!queue.isEmpty()) {
            final int currentSize = queue.size();
            for (int size = 0; size < currentSize; size++) {
                final int current = queue.poll();
                if (current == arr.length - 1) {
                    return level;
                }
                if (graph.containsKey(arr[current])) {
                    graph.get(arr[current]).forEach(
                            it -> {
                                if (!visited[it]) {
                                    queue.offer(it);
                                    visited[it] = true;
                                }
                            }
                    );
                    // if not, time limit exceeded
                    graph.remove(arr[current]);
                }
                final int previous = current - 1;
                final int next = current + 1;
                if (inBound(arr, next)) {
                    if (!visited[next]) {
                        queue.offer(next);
                        visited[next] = true;
                    }
                }
                if (inBound(arr, previous)) {
                    if (!visited[previous]) {
                        queue.offer(previous);
                        visited[previous] = true;
                    }
                }
            }
            ++level;
        }
        return -1;
    }

    private boolean inBound(int[] arr, int i) {
        return i >= 0 && i < arr.length;
    }
}
