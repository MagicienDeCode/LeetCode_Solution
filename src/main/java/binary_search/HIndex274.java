package binary_search;

import java.util.Arrays;

public class HIndex274 {
    public int hIndex(int[] citations) {
        int left = 0;
        int right = citations.length;
        while (left + 1 < right) {
            final int mid = left + (right - left) / 2;
            if (isValidH(citations, mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (isValidH(citations, right)) {
            return right;
        }
        if (isValidH(citations, left)) {
            return left;
        }
        return -1;
    }

    private boolean isValidH(int[] citations, int target) {
        return Arrays.stream(citations).filter(it -> it >= target).count() >= target;
    }
}
