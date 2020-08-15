package not_categorized;

import java.util.Arrays;
import java.util.Comparator;

class NonoverlappingIntervals435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        int result = 0;
        int last = 0;
        Arrays.sort(intervals, Comparator.comparingInt(anInt -> anInt[0]));
        for (int index = 1; index < intervals.length; index++) {
            if (intervals[index][0] < intervals[last][1]) {
                ++result;
                if (intervals[index][1] < intervals[last][1]) {
                    last = index;
                }
            } else {
                last = index;
            }
        }
        return result;
    }
}