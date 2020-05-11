package binary_search;

import java.util.Arrays;

public class CapacityToShipPackagesWithinDDays1011 {
    public int shipWithinDays(final int[] weights, final int dDay) {
        final int maxWeight = Arrays.stream(weights).reduce(Integer::max).orElse(500);
        int left = maxWeight;
        int right = maxWeight * 50000;
        while (left + 1 < right) {
            final int mid = left + ((right - left) >> 1);
            if (isValidCapacity(weights, dDay, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (isValidCapacity(weights, dDay, left)) {
            return left;
        }
        return right;
    }

    private boolean isValidCapacity(final int[] weights, final int dDay, final int target) {
        int days = 1;
        int count = target;
        for (int weight : weights) {
            count -= weight;
            if (count < 0) {
                days++;
                count = target - weight;
            }
        }
        return days <= dDay;
    }

    /*
    private boolean isValidCapacity(final int[] weights, final int D, final int target) {
        int days = 0;
        int count = target;
        for (int index = 0; index < weights.length; index++) {
            count -= weights[index];
            if (count == 0) {
                days++;
                count = target;
            } else if (count < 0) {
                days++;
                count = target - weights[index];
                if (index == weights.length - 1) {
                    days++;
                }
            } else if (index == weights.length - 1) {
                days++;
            }
        }
        return days <= D;
    }
     */
}
