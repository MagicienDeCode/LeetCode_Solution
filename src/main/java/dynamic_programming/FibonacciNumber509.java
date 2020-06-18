package dynamic_programming;

public class FibonacciNumber509 {
    public int fib(int n) {
        if (n < 1) {
            return n;
        }
        int current = n - 1;
        int int1 = 0;
        int int2 = 1;
        while (current > 0) {
            final int sum = int1 + int2;
            int1 = int2;
            int2 = sum;
            --current;
        }
        return int2;
    }
}
