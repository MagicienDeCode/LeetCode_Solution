package breadth_first_search;

import java.util.*;

public class BusRoutes815 {
    public int numBusesToDestination(int[][] routes, int s, int t) {
        if (s == t) {
            return 0;
        }
        final List<Set<Integer>> buses = new ArrayList<>();
        // bus index => stops HashSet
        for (int[] it : routes) {
            final Set<Integer> stops = new HashSet<>();
            for (int i : it) {
                stops.add(i);
            }
            buses.add(stops);
        }
        // build the graph, bus connect bus
        final Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i <= routes.length - 2; i++) {
            for (int j = i + 1; j < routes.length; j++) {
                if (isConnected(buses.get(i), buses.get(j))) {
                    graph.computeIfAbsent(
                            i,
                            v -> new ArrayList<>()
                    ).add(j);
                    graph.computeIfAbsent(
                            j,
                            v -> new ArrayList<>()
                    ).add(i);
                }
            }
        }
        // visited, queue, endSet
        // bus not stops
        final Set<Integer> visited = new HashSet<>();
        final Queue<Integer> queue = new LinkedList<>();
        final Set<Integer> endSet = new HashSet<>();

        // add start to queue visited, end to endSet
        for (int index = 0; index < buses.size(); index++) {
            final boolean containsStart = buses.get(index).contains(s);
            final boolean containsEnd = buses.get(index).contains(t);
            if (containsEnd && containsStart) {
                return 1;
            }
            if (containsEnd) {
                endSet.add(index);
            }
            if (containsStart) {
                queue.offer(index);
                visited.add(index);
            }
        }
        // bfs
        var level = 1;
        while (!queue.isEmpty()) {
            final int currentSize = queue.size();
            for (int size = 0; size < currentSize; size++) {
                final int currentBus = queue.poll();
                if (endSet.contains(currentBus)) {
                    return level;
                }
                if (graph.containsKey(currentBus)){
                    graph.get(currentBus).forEach(
                            nextBus -> {
                                if (!visited.contains(nextBus)) {
                                    queue.offer(nextBus);
                                    visited.add(nextBus);
                                }
                            }
                    );
                }
            }
            ++level;
        }
        return -1;
    }

    private boolean isConnected(Set<Integer> stop1, Set<Integer> stop2) {
        for (int s : stop1) {
            if (stop2.contains(s)) {
                return true;
            }
        }
        return false;
    }
}
