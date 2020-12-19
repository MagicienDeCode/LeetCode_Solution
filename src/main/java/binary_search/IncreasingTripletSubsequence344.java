package binary_search;

public class IncreasingTripletSubsequence344 {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int first = nums[0];
        int second = Integer.MAX_VALUE;
        for (int index = 1; index < nums.length; index++) {
            if (nums[index] > second) {
                return true;
            } else {
                if (nums[index] > first) {
                    second = nums[index];
                }
                if (first > nums[index]) {
                    first = nums[index];
                }
            }
        }
        return false;
    }
}
