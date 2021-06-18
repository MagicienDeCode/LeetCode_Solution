package sliding_window;

public class NumberofSubarrayswithBoundedMaximum795 {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int i = 0;
        int count = 0;
        int total = 0;
        for (int j = 0; j < nums.length; j++) {
            if (inRange(left, right, nums[j])) {
                count = j - i + 1;
                total += j - i + 1;
            } else if (nums[j] < left) {
                total += count;
            } else {
                i = j + 1;
                count = 0;
            }
        }
        return total;
    }

    private boolean inRange(int left, int right, int target) {
        return target >= left && target <= right;
    }
}
