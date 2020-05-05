package binarysearch;

public class UglyNumberIII1201 {
    public int nthUglyNumber(int n, int a, int b, int c) {
        final long lcmab = lcm(a, b);
        final long lcmac = lcm(a, c);
        final long lcmbc = lcm(b, c);
        final long lcmabc = lcm(lcmab, c);
        final int minOfabc = Math.min(Math.min(a, b), c);
        int left = minOfabc;
        int right = minOfabc * n;
        while (left + 1 < right) {
            final int mid = left + ((right - left) >> 1);
            if (mid / a - mid / lcmab +
                    mid / b - mid / lcmbc +
                    mid / c - mid / lcmac +
                    mid / lcmabc < n) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (left / a - left / lcmab +
                left / b - left / lcmbc +
                left / c - left / lcmac +
                left / lcmabc == n) {
            return left;
        } else {
            return right;
        }
    }

    // LCM, Least Common Multiple
    private long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    // GCD, Greatest Common Divisor
    private long gcd(long a, long b) {
        if (a < b) {
            a = a ^ b;
            b = a ^ b;
            a = a ^ b;
        }
        while (a % b != 0) {
            final long remainder = a % b;
            if (b < remainder) {
                a = remainder;
            } else {
                a = b;
                b = remainder;
            }
        }
        return b;
    }

    public static void main(String... args) {
        final UglyNumberIII1201 solution = new UglyNumberIII1201();
        System.out.println(solution.nthUglyNumber(3, 2, 3, 5));
        System.out.println(solution.nthUglyNumber(1000000000, 2, 217983653, 336916467));
    }
}
