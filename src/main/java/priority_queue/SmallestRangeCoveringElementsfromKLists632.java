package priority_queue;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SmallestRangeCoveringElementsfromKLists632 {
    public int[] smallestRange(List<List<Integer>> nums) {
        int minX = 0;
        int minY = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        boolean flag = true;
        final int[] next = new int[nums.size()];
        final PriorityQueue<Integer> minQueue = new PriorityQueue<>(Comparator.comparingInt(i -> nums.get(i).get(next[i])));
        for (int i = 0; i < nums.size(); i++) {
            minQueue.offer(i);
            max = Math.max(max, nums.get(i).get(0));
        }
        for (int i = 0; i < nums.size() && flag; i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                final int min = minQueue.poll();
                if (minY - minX > max - nums.get(min).get(next[min])) {
                    minX = nums.get(min).get(next[min]);
                    minY = max;
                }
                next[min]++;
                if (next[min] == nums.get(min).size()) {
                    flag = false;
                    break;
                }
                minQueue.offer(min);
                max = Math.max(max, nums.get(min).get(next[min]));
            }
        }
        return new int[]{minX, minY};
    }
}
