package breadth_first_search;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGameIII1306 {
    public boolean canReach(int[] arr, int start) {
        final Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            final int current = queue.poll();
            if (arr[current] == 0) {
                return true;
            }
            final int nextIndex1 = current + arr[current];
            final int nextIndex2 = current - arr[current];
            arr[current] = -arr[current];
            if (inBound(arr, nextIndex1) && arr[nextIndex1] >= 0) {
                queue.offer(nextIndex1);
            }
            if (inBound(arr, nextIndex2) && arr[nextIndex2] >= 0) {
                queue.offer(nextIndex2);
            }
        }
        return false;
    }

    private boolean inBound(int[] arr, int index) {
        return index >= 0 && index < arr.length;
    }
}
