package depth_first_search;

import java.util.*;

public class ReconstructItinerary332 {
    public List<String> findItinerary(List<List<String>> tickets) {
        final List<String> result = new LinkedList<>();
        if (tickets.isEmpty()) {
            return result;
        }
        final Map<String, PriorityQueue<String>> map =
                new HashMap<>();
        tickets.forEach(it ->
                map.computeIfAbsent(it.get(0), v -> new PriorityQueue<>()).offer(it.get(1))
        );
        dfs(map, "JFK", result);
        return result;
    }

    private void dfs(Map<String, PriorityQueue<String>> map,
                     String s,
                     List<String> result) {
        if (map.containsKey(s)) {
            final PriorityQueue<String> current = map.get(s);
            while (!current.isEmpty()) {
                dfs(map, current.poll(), result);
            }
        }
        result.add(0, s);
    }
}
