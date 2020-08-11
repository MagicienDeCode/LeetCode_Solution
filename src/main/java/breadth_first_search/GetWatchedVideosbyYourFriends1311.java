package breadth_first_search;

import java.util.*;
import java.util.stream.Collectors;

public class GetWatchedVideosbyYourFriends1311 {
    public List<String> watchedVideosByFriends(
            List<List<String>> watchedVideos,
            int[][] friends,
            int id,
            int level
    ) {
        final Queue<Integer> queue = new LinkedList<>();
        final Set<Integer> visited = new HashSet<>();
        queue.offer(id);
        visited.add(id);

        final Map<String, Integer> map = new HashMap<>();

        int count = 0;
        while (!queue.isEmpty()) {
            if (count == level) {
                while (!queue.isEmpty()) {
                    final int current = queue.poll();
                    watchedVideos
                            .get(current)
                            .forEach(it ->
                                    map.put(it,
                                            1 + map.getOrDefault(
                                                    it,
                                                    0
                                            )
                                    )

                            );
                }
            } else {
                final int currentSize = queue.size();
                for (int size = 0; size < currentSize; size++) {
                    final int current = queue.poll();
                    for (int it : friends[current]) {
                        if (!visited.contains(it)) {
                            queue.offer(it);
                            visited.add(it);
                        }
                    }
                }
                ++count;
            }
        }
        return map
                .entrySet()
                .stream()
                .sorted((p1, p2) -> {
                    if (p1.getValue() == p2.getValue()) {
                        return p1.getKey().compareTo(p2.getKey());
                    } else {
                        return Integer.compare(p1.getValue(), p2.getValue());
                    }
                })
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
