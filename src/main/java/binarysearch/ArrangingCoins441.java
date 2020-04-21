package binarysearch;

public class ArrangingCoins441 {
    public int arrangeCoins(int n) {
        long left = 1L;
        long right = (long) n >> 1;
        right = right <= left ? left + 1 : right;
        while (left + 1 < right) {
            final long mid = left + ((right - left) >> 1);
            final long current = (mid * (mid + 1)) >> 1;
            if (current == n) {
                return (int) mid;
            } else if (current < n) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if ((right * (right + 1)) >> 1 <= n) {
            return (int) right;
        }
        if ((left * (left + 1)) >> 1 <= n) {
            return (int) left;
        }
        return 0;
    }

    public static void main(String... args) {
        final int a = 5 + (11 - 5) / 2; // 8
        final int b = 5 + (11 - 5) >> 1; // 5
        final int c = 5 + ((11 - 5) >> 1); // 8
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
