package binary_search;

public class NthMagicalNumber878 {
    public int nthMagicalNumber(int n, int a, int b) {
        long left = Math.min(a, b);
        long right = left * n;
        final double modulo = 1e9 + 7;
        final long lcm = lcm(a, b);
        while (left + 1 < right) {
            final long mid = left + (right - left) / 2;
            final long countMid = mid / a - mid / lcm + mid / b;
            if (countMid < n) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if ((left / a - left / lcm + left / b) == n) {
            return (int) (left % modulo);
        }
        return (int) (right % modulo);
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
}
