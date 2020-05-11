package binary_search;

public class GuessNumberHigherorLower374 {
    public int guessNumber(int n) {
        int left = 0;
        int right = n;
        while (left + 1 < right) {
            final int mid = left + (right - left) / 2;
            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) == 1) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (guess(left) == 0) {
            return left;
        }
        if (guess(right) == 0) {
            return right;
        }
        return -1;
    }

    int guess(int num) {
        return Integer.compare(num, 6);
    }
}
