package binary_search;

public class KthSmallestNumberinMultiplicationTable668 {
    public int findKthNumber(int m, int n, int k) {
        int left = 1;
        int right = n * m;
        while (left + 1 < right) {
            final int mid = left + (right - left) / 2;
            if (countOfLessEqualThanTarget(m, n, mid) < k) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (countOfLessEqualThanTarget(m, n, left) >= k) {
            return left;
        }
        return right;
    }

    private int countOfLessEqualThanTarget(int m, int n, int target) {
        int count = 0;
        for (int index = 1; index <= m; index++) {
            count += index * n <= target ? n : target / index;
        }
        return count;
    }
    /*
    private int countOfLessEqualThanTarget(int m, int n, int target) {
        int count = 0;
        for (int index = 1; index <= m; index++) {
            if (index <= target) {
                count += binarySearchLessEqualThanTarget(index, n, target);
            }
        }
        return count;
    }

    private int binarySearchLessEqualThanTarget(int line, int n, int target) {
        int left = 1;
        int right = n;
        while (left + 1 < right) {
            final int mid = left + (right - left) / 2;
            if (mid * line <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (right * line <= target) {
            return right;
        }
        return left;
    }
     */
}
