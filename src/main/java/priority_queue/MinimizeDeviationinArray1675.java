package priority_queue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimizeDeviationinArray1675 {
    public int minimumDeviation(int[] nums) {
        final PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        int min = Integer.MAX_VALUE;
        for (int n : nums) {
            final int current = n % 2 == 1 ? n * 2 : n;
            min = Math.min(current, min);
            priorityQueue.offer(current);
        }
        int result = priorityQueue.peek() - min;
        while (!priorityQueue.isEmpty() && priorityQueue.peek() % 2 == 0) {
            final int current = priorityQueue.poll() >> 1;
            min = Math.min(min, current);
            priorityQueue.offer(current);
            result = Math.min(result, priorityQueue.peek() - min);
        }
        return result;
    }

    public static void main(String[] args) {
        final MinimizeDeviationinArray1675 java = new MinimizeDeviationinArray1675();
        // 7
        System.out.println(java.minimumDeviation(new int[]{9, 4, 3, 6, 2}));
    }
}
