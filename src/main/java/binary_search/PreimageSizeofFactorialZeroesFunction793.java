package binary_search;

public class PreimageSizeofFactorialZeroesFunction793 {
    public int preimageSizeFZF(int k) {
        long left = (k - 1) * 5L;
        left = left < 0 ? 0 : left;
        long right = (k + 1) * 5L;
        while (left + 1 < right) {
            final long mid = left + ((right - left) >> 1);
            final int numberOfZero = numberOfZero(mid);
            if (numberOfZero == k) {
                return 5;
            } else if (numberOfZero < k) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (numberOfZero(left) == k || numberOfZero(right) == k) {
            return 5;
        } else {
            return 0;
        }
    }

    private int numberOfZero(long target) {
        long count = 0;
        while (target != 0L) {
            count += target / 5;
            target /= 5;
        }
        return (int) count;
    }
}
