package easy_easy;

import java.util.Arrays;

public class HeightChecker1051 {
    public int heightChecker(int[] heights) {
        final int[] clone = heights.clone();
        Arrays.sort(clone);
        int diff = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != clone[i]) {
                ++diff;
            }
        }
        return diff;
    }
}
