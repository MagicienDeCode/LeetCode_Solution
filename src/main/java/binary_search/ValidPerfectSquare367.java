package binary_search;

public class ValidPerfectSquare367 {
    public boolean isPerfectSquare(int num) {
        int left = 0;
        //  sqrt (Int.MAX_VALUE) = 46340.95
        int right = 46340;
        while (left + 1 < right) {
            final int mid = left + (right - left) / 2;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right * right == num;
    }
}
