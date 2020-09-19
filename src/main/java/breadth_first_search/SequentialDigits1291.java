package breadth_first_search;

import java.util.LinkedList;
import java.util.List;

class SequentialDigits1291 {
    private static final int[] candidate = new int[]{
            12, 23, 34, 45, 56, 67, 78, 89,
            123, 234, 345, 456, 567, 678, 789,
            1234, 2345, 3456, 4567, 5678, 6789,
            12345, 23456, 34567, 45678, 56789,
            123456, 234567, 345678, 456789,
            1234567, 2345678, 3456789,
            12345678, 23456789,
            123456789
    };

    public List<Integer> sequentialDigits(int low, int high) {
        final List<Integer> results = new LinkedList<>();
        for (int j : candidate) {
            if (j < low) {
                continue;
            }
            if (j > high) {
                break;
            }
            results.add(j);
        }
        return results;
    }
    /*
    public List<Integer> sequentialDigits(int low, int high) {
        final List<Integer> results = new LinkedList<>();
        final Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= 9; i++) {
            queue.offer(i);
        }
        while (!queue.isEmpty()) {
            final int current = queue.poll();
            if (current > high) {
                break;
            }
            if (current >= low && current <= high) {
                results.add(current);
            }
            // 789 continue
            // 67 -> 678
            if (current % 10 != 9) {
                queue.offer(current * 10 + current % 10 + 1);
            }
        }
        return results;
    }
     */
}