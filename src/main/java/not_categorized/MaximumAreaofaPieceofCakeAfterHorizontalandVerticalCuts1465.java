package not_categorized;

import java.util.Arrays;

public class MaximumAreaofaPieceofCakeAfterHorizontalandVerticalCuts1465 {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        final int modulo = 1000000007;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int horizontalMax = Math.max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.length - 1]);
        int verticalMax = Math.max(verticalCuts[0], w - verticalCuts[verticalCuts.length - 1]);
        for (int i = 1; i < horizontalCuts.length; i++) {
            horizontalMax = Math.max(horizontalMax, horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        for (int i = 1; i < verticalCuts.length; i++) {
            verticalMax = Math.max(verticalMax, verticalCuts[i] - verticalCuts[i - 1]);
        }
        return (int) ((long) horizontalMax * verticalMax % modulo);
    }
}
