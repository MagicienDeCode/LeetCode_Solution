package binary_search;

public class SplitArrayLargestSum410 {
    /*
    public int splitArray(int[] nums, int m) {
        final int[] sums = new int[nums.length + 1];
        final int[][] dpMatrix = new int[m + 1][nums.length + 1];
        for (int[] matrix : dpMatrix) {
            Arrays.fill(matrix, Integer.MAX_VALUE);
        }
        for (int index = 1; index < sums.length; index++) {
            sums[index] = sums[index - 1] + nums[index - 1];
            dpMatrix[1][index] = sums[index];
        }
        for (int i = 1; i < dpMatrix.length; i++) {
            for (int j = 2; j < dpMatrix[0].length; j++) {
                for (int p = i - 1; p < j; p++) {
                    dpMatrix[i][j] = Math.min(
                            dpMatrix[i][j],
                            Math.max(
                                    dpMatrix[i - 1][p],
                                    sums[j] - sums[p]
                            )
                    );
                }
            }
        }
        return dpMatrix[m][nums.length];
    }
     */
    public int splitArray(int[] nums, int m) {
        int left = 0;
        int right = 0;
        for (int n : nums) {
            left = Math.max(left, n);
            right += n;
        }
        while (left + 1 < right) {
            final int mid = left + ((right - left) >> 1);
            if (isValid(nums, m, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (isValid(nums, m, left)) {
            return left;
        }
        return right;
    }

    private boolean isValid(int[] nums, int m, int targetSum) {
        int count = 1;
        int current = 0;
        for (int n : nums) {
            current += n;
            if (current > targetSum) {
                current = n;
                if (++count > m) {
                    return false;
                }
            }
        }
        return true;
    }
}
