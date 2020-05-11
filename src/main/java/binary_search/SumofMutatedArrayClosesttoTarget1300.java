package binary_search;

public class SumofMutatedArrayClosesttoTarget1300 {
    public int findBestValue(final int[] arr, final int target) {
        int left = 0;
        int right = target;
        while (left + 1 < right) {
            final int mid = left + ((right - left) >> 1);
            final int sumWithMid = calculateSum(arr, mid);
            if (sumWithMid - target == 0) {
                return mid;
            } else if (sumWithMid - target < 0) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return calculateSum(arr, right) - target < target - calculateSum(arr, left) ? right : left;
    }

    private int calculateSum(final int[] arr, final int i) {
        int sum = 0;
        for (int a : arr) {
            sum += Math.min(a, i);
        }
        return sum;
    }
}
