package list_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        final List<int[]> results = new ArrayList<>();
        final int[] current = new int[2];
        current[0] = intervals[0][0];
        current[1] = intervals[0][1];
        int index = 1;
        while (index < intervals.length) {
            if (current[1] >= intervals[index][0]) {
                current[1] = Math.max(current[1], intervals[index][1]);
            } else {
                results.add(new int[]{current[0], current[1]});
                current[0] = intervals[index][0];
                current[1] = intervals[index][1];
            }
            ++index;
        }
        results.add(new int[]{current[0], current[1]});
        final int[][] arr = new int[results.size()][];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = results.get(i);
        }
        return arr;
    }
}
