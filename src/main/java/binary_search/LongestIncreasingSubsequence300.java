package binary_search;

public class LongestIncreasingSubsequence300 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        final int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < dp.length; i++) {
            int current = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    current = Math.max(current, dp[j]);
                }
            }
            dp[i] = current + 1;
            max = Math.max(max, dp[i]);
        }
        return max;
    }
    /*
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        final TreeSet<Integer> result = new TreeSet<>();
        result.add(nums[0]);
        for (int index = 1; index < nums.length; index++) {
            final Integer firstElement = result.ceiling(nums[index]);
            if (firstElement != null) {
                result.remove(firstElement);
            }
            result.add(nums[index]);
        }
        return result.size();
    }
     */
    /*
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        final List<Integer> result = new ArrayList<>();
        result.add(nums[0]);
        for (int index = 1; index < nums.length; index++) {
            final int firstIndex
            = binarySearchFirstIndexOfElementNotLessThanTarget(result, nums[index]);
            if (firstIndex != -1) {
                result.remove(firstIndex);
                result.add(firstIndex, nums[index]);
            } else {
                result.add(nums[index]);
            }
        }
        return result.size();
    }

    private int findFirstIndexOfElementNotLessThanTarget(List<Integer> result, int target) {
        for (int index = 0; index < result.size(); index++) {
            if (result.get(index) >= target) {
                return index;
            }
        }
        return -1;
    }

    public int binarySearchFirstIndexOfElementNotLessThanTarget(List<Integer> nums, int target) {
        int left = 0;
        int right = nums.size() - 1;
        while (left + 1 < right) {
            final int mid = left + (right - left) / 2;
            if (nums.get(mid) == target) {
                return mid;
            } else if (nums.get(mid) < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums.get(left) >= target) {
            return left;
        }
        if (nums.get(right) >= target) {
            return right;
        }
        return -1;
    }
     */
}
