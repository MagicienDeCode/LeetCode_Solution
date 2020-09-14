package list_array;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        final List<int[]> results = new ArrayList<>();
        int current = 0;
        while (current < intervals.length && intervals[current][1] < newInterval[0]) {
            results.add(intervals[current++]);
        }
        while (current < intervals.length && intervals[current][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[current][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[current][1]);
            ++current;
        }
        results.add(newInterval);
        while (current < intervals.length) {
            results.add(intervals[current++]);
        }
        final int[][] intArray = new int[results.size()][];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = results.get(i);
        }
        return intArray;
    }
}
