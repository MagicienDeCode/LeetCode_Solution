package binary_search;

public class TwoSumIIInputarrayissorted167 {

    public int[] twoSumOn(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left + 1 < right) {
            if (numbers[left] + numbers[right] == target) {
                return new int[]{++left, ++right};
            } else if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{++left, ++right};
    }

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left + 1 < right) {
            if (numbers[left] + numbers[right] == target) {
                return new int[]{++left, ++right};
            } else if (numbers[left] + numbers[right] < target) {
                left = searchWhenLessThanTarget(numbers, target, left, right);
            } else {
                right = searchWhenGreaterThanTarget(numbers, target, left, right);
            }
        }
        return new int[]{++left, ++right};
    }

    private int searchWhenLessThanTarget(
            int[] nums,
            int target,
            final int leftVal,
            final int rightVal
    ) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = leftVal;
        int right = rightVal;
        while (left + 1 < right) {
            final int mid = left + (right - left) / 2;
            if (nums[mid] + nums[rightVal] == target) {
                return mid;
            } else if (nums[mid] + nums[rightVal] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[left] + nums[rightVal] >= target) {
            return left;
        }
        if (nums[right] + nums[rightVal] >= target) {
            return right;
        }
        return -1;
    }

    private int searchWhenGreaterThanTarget(
            int[] nums,
            int target,
            final int leftVal,
            final int rightVal
    ) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = leftVal;
        int right = rightVal;
        while (left + 1 < right) {
            final int mid = left + (right - left) / 2;
            if (nums[mid] + nums[leftVal] == target) {
                return mid;
            } else if (nums[mid] + nums[leftVal] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[left] + nums[leftVal] <= target) {
            return left;
        }
        if (nums[right] + nums[leftVal] <= target) {
            return right;
        }
        return -1;
    }
}
