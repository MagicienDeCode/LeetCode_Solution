package binary_search;

public class FindtheSmallestDivisorGivenaThreshold1283 {
    public int smallestDivisor(final int[] nums, final int threshold) {
        int left = 1;
        int right = Integer.MIN_VALUE;
        for (int i : nums) {
            right = Math.max(right, i);
        }
        while (left + 1 < right) {
            final int mid = left + ((right - left) >> 1);
            if (calculateSum(nums, mid) > threshold) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (calculateSum(nums, left) > threshold) {
            return right;
        }
        return left;
    }

    private int calculateSum(final int[] nums, final int target) {
        int sum = 0;
        for (int i : nums) {
            sum += i / target + (i % target == 0 ? 0 : 1);
        }
        return sum;
    }
}
