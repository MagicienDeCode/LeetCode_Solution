package priority_queue;

import java.util.Collections;
import java.util.PriorityQueue;

public class MinimumNumberofRefuelingStops871 {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        final PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        int result = 0;
        int previous = 0;
        int tank = startFuel;
        for (int[] station : stations) {
            final int location = station[0];
            final int fuel = station[1];
            tank -= location - previous;
            while (!priorityQueue.isEmpty() && tank < 0) {
                tank += priorityQueue.poll();
                ++result;
            }
            if (tank < 0) {
                return -1;
            }
            priorityQueue.offer(fuel);
            previous = location;
        }
        tank -= target - previous;
        while (!priorityQueue.isEmpty() && tank < 0) {
            tank += priorityQueue.poll();
            ++result;
        }
        if (tank < 0) {
            return -1;
        }
        return result;
    }
}