package string_integer.sort_an_array_912;

public class KthLargestElementinanArray215 {
    public int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        while (true) {
            final int index = quickSort(nums, left, right);
            if (index == k - 1) {
                return nums[index];
            }
            if (index < k - 1) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
    }

    private int quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return start;
        }
        final int pivot = nums[start];
        int left = start + 1;
        int right = end;
        while (left <= right) {
            while (left <= right && nums[left] > pivot) {
                ++left;
            }
            while (left <= right && nums[right] < pivot) {
                --right;
            }
            if (left <= right) {
                final int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        final int temp = nums[start];
        nums[start] = nums[right];
        nums[right] = temp;
        return right;
    }
    /*
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k + 1];
    }
     */
}
