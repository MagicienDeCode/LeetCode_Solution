package breadth_first_search;

import java.util.*;

public class NetworkDelayTime743 {
    public int networkDelayTime(int[][] times, int n, int k) {
        // 1. transform times to a graph
        final Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times) {
            graph.computeIfAbsent(time[0], v -> new ArrayList<>()).add(time);
        }
        // 2. build a map and a priorityQueue
        final Map<Integer, Integer> distanceMap = new HashMap<>();
        // [0] distance, [1] node
        final PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(
                (Comparator.comparingInt(ints -> ints[0]))
        );
        // bfs
        priorityQueue.offer(new int[]{0, k});
        while (!priorityQueue.isEmpty()) {
            final int[] current = priorityQueue.poll();
            final int distance = current[0];
            final int currentNode = current[1];
            if (!distanceMap.containsKey(currentNode)) {
                distanceMap.put(currentNode, distance);
                if (graph.containsKey(currentNode)) {
                    graph.get(currentNode).forEach(it -> {
                        if (!distanceMap.containsKey(it[1])) {
                            priorityQueue.offer(new int[]{it[2] + distance, it[1]});
                        }
                    });
                }
            }
        }

        if (distanceMap.size() != n) {
            return -1;
        }
        return distanceMap.values().stream().reduce(Math::max).get();
    }
}
