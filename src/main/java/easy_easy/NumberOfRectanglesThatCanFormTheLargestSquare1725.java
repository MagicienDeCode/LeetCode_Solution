package easy_easy;

import java.util.HashMap;
import java.util.Map;

public class NumberOfRectanglesThatCanFormTheLargestSquare1725 {
    public int countGoodRectangles(int[][] rectangles) {
        final Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int[] rect : rectangles) {
            final int m = Math.min(rect[0], rect[1]);
            if (m >= max) {
                max = m;
                map.put(m, 1 + map.getOrDefault(m, 0));
            }
        }
        return map.get(max);
    }
}
