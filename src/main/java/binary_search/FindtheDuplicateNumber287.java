package binary_search;

public class FindtheDuplicateNumber287 {
    public int findDuplicate(int[] nums) {
        int fast = 0;
        int slow = 0;
        do {
            fast = nums[nums[fast]];
            slow = nums[slow];
        } while (fast != slow);
        fast = 0;
        do {
            fast = nums[fast];
            slow = nums[slow];
        } while (fast != slow);
        return slow;
    }
    /*
    public int findDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            final int mid = left + (right - left) / 2;
            if (Arrays.stream(nums).filter(it -> it <= mid).count() <= mid) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right;
    }
     */
    /*
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j] && i != j) {
                    return nums[i];
                }
            }
        }
        return -1;
    }
     */
}
