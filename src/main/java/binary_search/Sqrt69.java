package binary_search;

public class Sqrt69 {
    public int mySqrt(int x) {
        int left = 0;
        //  sqrt (Int.MAX_VALUE) = 46340.95
        int right = 46340;
        while (left + 1 < right) {
            final int mid = left + (right - left) / 2;
            if (mid * mid == x) {
                return mid;
            } else if (mid * mid < x) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (right * right <= x) {
            return right;
        } else {
            return left;
        }
    }
}
