package binary_search;

import java.util.Random;

public class RandomPickwithWeight528 {

    private final int[] accumulateSum;

    public RandomPickwithWeight528(int[] w) {
        accumulateSum = new int[w.length];
        accumulateSum[0] = w[0];
        for (int index = 1; index < w.length; index++) {
            accumulateSum[index] = w[index] + accumulateSum[index - 1];
        }
    }

    public int pickIndex() {
        int target = new Random().nextInt(accumulateSum[accumulateSum.length - 1]) + 1;
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
