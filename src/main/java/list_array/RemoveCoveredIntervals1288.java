package list_array;

import java.util.Arrays;
import java.util.Comparator;

public class RemoveCoveredIntervals1288 {
    public int removeCoveredIntervals(int[][] intervals) {
        int result = 1;

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(b[1], a[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        int minY = intervals[0][1];

        for (int[] interval : intervals) {
            if (interval[1] > minY) {
                ++result;
                minY = interval[1];
            }
        }

        return result;
    }
}
