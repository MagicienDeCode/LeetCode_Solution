package priority_queue;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MaximumPerformanceofaTeam1383 {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        final int modulo = 1000000007;
        // build (efficiency,speed)
        final List<int[]> efficiencySpeeds = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            efficiencySpeeds.add(new int[]{efficiency[i], speed[i]});
        }
        // sort by efficiency desc
        efficiencySpeeds.sort((a, b) -> Integer.compare(b[0], a[0]));

        // priorityQueue to keep k engineers' speed
        final PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        long speedSum = 0;
        long max = 0;
        // since efficiencySpeeds is desc at efficiency
        // each time, we remove the min speed and add current
        for (int[] es : efficiencySpeeds) {
            final int e = es[0];
            final int s = es[1];
            if (priorityQueue.size() == k) {
                speedSum -= priorityQueue.poll();
            }
            priorityQueue.offer(s);
            speedSum += s;
            // test with current efficiency and total speed
            max = Math.max(max, e * speedSum);
        }

        return (int) (max % modulo);
    }
}
