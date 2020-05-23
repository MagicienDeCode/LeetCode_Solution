package list_array;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections986 {
    public int[][] intervalIntersection(int[][] num1, int[][] nums2) {
        if (num1.length == 0 || nums2.length == 0) {
            return new int[][]{};
        }
        final List<int[]> resultList = new ArrayList<>();
        int indexA = 0;
        int indexB = 0;
        while (indexA < num1.length && indexB < nums2.length) {
            final int maxOfStart = Math.max(num1[indexA][0], nums2[indexB][0]);
            final int minOfEnd = Math.min(num1[indexA][1], nums2[indexB][1]);
            if (maxOfStart <= minOfEnd) {
                resultList.add(new int[]{maxOfStart, minOfEnd});
            }
            if (num1[indexA][1] <= nums2[indexB][1]) {
                ++indexA;
            } else {
                ++indexB;
            }
        }
        final int[][] result = new int[resultList.size()][];
        int index = 0;
        for (int[] r : resultList) {
            result[index++] = r;
        }
        return result;
    }
}
