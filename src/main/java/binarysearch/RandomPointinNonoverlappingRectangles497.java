package binarysearch;

import java.util.Random;

public class RandomPointinNonoverlappingRectangles497 {

    private final int[] accumulateSum;
    private final int[][] rects;
    private final Random random = new Random();

    public RandomPointinNonoverlappingRectangles497(int[][] rects) {
        accumulateSum = new int[rects.length];
        this.rects = rects;
        accumulateSum[0] = calculateSum(rects[0]);
        for (int index = 1; index < rects.length; index++) {
            accumulateSum[index] = calculateSum(rects[index]) + accumulateSum[index - 1];
        }
    }

    private int calculateSum(int[] rect) {
        return (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
    }

    public int[] pick() {
        final int[] rect = rects[binarySearch()];
        final int x1 = rect[0];
        final int y1 = rect[1];
        final int x2 = rect[2];
        final int y2 = rect[3];
        final int x = x1 + random.nextInt(x2 - x1 + 1);
        final int y = y1 + random.nextInt(y2 - y1 + 1);
        return new int[]{x, y};
    }

    private int binarySearch() {
        int target = random.nextInt(accumulateSum[accumulateSum.length - 1]) + 1;
        int left = 0;
        int right = accumulateSum.length - 1;
        while (left + 1 < right) {
            final int mid = left + (right - left) / 2;
            if (accumulateSum[mid] == target) {
                return mid;
            } else if (accumulateSum[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (accumulateSum[left] >= target) {
            return left;
        }
        if (accumulateSum[right] >= target) {
            return right;
        }
        return -1;
    }
}
