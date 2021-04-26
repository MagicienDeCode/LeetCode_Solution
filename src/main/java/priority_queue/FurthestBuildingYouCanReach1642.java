package priority_queue;

import java.util.PriorityQueue;

public class FurthestBuildingYouCanReach1642 {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        final PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < heights.length - 1; i++) {
            final int gap = heights[i + 1] - heights[i];
            if (gap > 0) {
                priorityQueue.offer(gap);
                if (priorityQueue.size() > ladders) {
                    bricks -= priorityQueue.poll();
                    if (bricks < 0) {
                        return i;
                    }
                }
            }
        }
        return heights.length - 1;
    }
    /*
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        final Queue<int[]> queue = new LinkedList<>();
        final Map<Integer, Set<Integer>> visited = new HashMap<>();
        queue.offer(new int[]{bricks, ladders});
        int index = 0;
        while (index != heights.length - 1 && !queue.isEmpty()) {
            visited.clear();
            final int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                final int[] candidate = queue.poll();
                final int b = candidate[0];
                final int l = candidate[1];
                if (heights[index] < heights[index + 1]) {
                    if (b >= heights[index + 1] - heights[index]) {
                        final int newB = b - heights[index + 1] + heights[index];
                        if (!visited.containsKey(newB) || !visited.get(newB).contains(l)) {
                            queue.offer(new int[]{newB, l});
                            visited.computeIfAbsent(newB, v -> new HashSet<>()).add(l);
                        }
                    }
                    if (l > 0) {
                        if (!visited.containsKey(b) || !visited.get(b).contains(l - 1)) {
                            queue.offer(new int[]{b, l - 1});
                            visited.computeIfAbsent(b, v -> new HashSet<>()).add(l - 1);
                        }
                    }
                } else {
                    if (!visited.containsKey(b) || !visited.get(b).contains(l)) {
                        queue.offer(new int[]{b, l});
                        visited.computeIfAbsent(b, v -> new HashSet<>()).add(l);
                    }
                }
            }
            if (!queue.isEmpty()) {
                ++index;
            }
        }
        return index;
    }
     */
}
