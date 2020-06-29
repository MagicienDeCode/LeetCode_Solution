package binary_search;

public class MinimumNumberofDaystoMakemBouquets1482 {
    public int minDays(int[] bloomDay, int m, int k) {
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        for (int b : bloomDay) {
            left = Math.min(left, b);
            right = Math.max(right, b);
        }
        while (left + 1 < right) {
            final int mid = left + (right - left) / 2;
            if (isValid(bloomDay, m, k, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (isValid(bloomDay, m, k, left)) {
            return left;
        }
        if (isValid(bloomDay, m, k, right)) {
            return right;
        }
        return -1;
    }

    private boolean isValid(
            int[] bloomDay,
            int m,
            int k,
            int target) {
        int total = 0;
        int current = 0;
        for (int b : bloomDay) {
            if (target >= b) {
                if (++current == k) {
                    ++total;
                    current = 0;
                }
            } else {
                current = 0;
            }
        }
        return total >= m;
    }
}
