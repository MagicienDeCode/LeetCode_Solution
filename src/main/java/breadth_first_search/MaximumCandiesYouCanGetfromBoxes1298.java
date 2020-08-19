package breadth_first_search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumCandiesYouCanGetfromBoxes1298 {
    public int maxCandies(
            int[] status,
            int[] candies,
            int[][] keys,
            int[][] containedBoxes,
            int[] initialBoxes
    ) {
        if (initialBoxes.length == 0) {
            return 0;
        }

        final List<Integer> unVisitedBox = new ArrayList<>();
        final boolean[] myKeys = new boolean[status.length];

        final Queue<Integer> queue = new LinkedList<>();
        final boolean[] visited = new boolean[status.length];

        for (int i : initialBoxes) {
            if (status[i] == 1) {
                queue.offer(i);
                visited[i] = true;
            } else {
                unVisitedBox.add(i);
            }
        }

        int result = 0;
        while (!queue.isEmpty()) {
            final int current = queue.poll();
            result += candies[current];
            for (int nextInContainer : containedBoxes[current]) {
                if (!visited[nextInContainer]) {
                    if (status[nextInContainer] == 1 || myKeys[nextInContainer]) {
                        queue.offer(nextInContainer);
                        visited[nextInContainer] = true;
                    } else {
                        unVisitedBox.add(nextInContainer);
                    }
                }
            }
            for (int key : keys[current]) {
                myKeys[key] = true;
            }
            for (int i : unVisitedBox) {
                if (!visited[i] && myKeys[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
        return result;
    }
}
