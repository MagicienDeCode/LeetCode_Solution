package binary_search;

public class Powxn50 {
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0.0;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }
        if (n == 0) {
            return 1.0;
        }
        if (n == Integer.MIN_VALUE) {
            return 1 / (powLog(x, Integer.MAX_VALUE) * x);
        }
        if (n > 0) {
            return powLog(x, n);
        }
        return 1 / powLog(x, -n);
    }

    private double powLog(double x, int n) {
        if (n == 1) {
            return x;
        }
        final double result = powLog(x, n / 2);
        if (n % 2 == 0) {
            return result * result;
        }
        if (n % 2 == 1) {
            return result * result * x;
        }
        return -1.0;
    }
}
