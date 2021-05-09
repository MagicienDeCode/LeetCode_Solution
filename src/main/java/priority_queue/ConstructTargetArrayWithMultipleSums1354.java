package priority_queue;

import java.util.PriorityQueue;

public class ConstructTargetArrayWithMultipleSums1354 {
    public boolean isPossible(int[] target) {
        final PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        long sum = 0;
        for (int t : target) {
            sum += t;
            priorityQueue.add(t);
        }
        while (true) {
            final int current = priorityQueue.poll();
            sum -= current;
            if (current == 1 || sum == 1) {
                return true;
            }
            if (sum >= current || sum == 0) {
                return false;
            }
            final int previous = (int) (current % sum);
            if (previous == 0) {
                return false;
            }
            priorityQueue.add(previous);
            sum += previous;
        }
    }
}
