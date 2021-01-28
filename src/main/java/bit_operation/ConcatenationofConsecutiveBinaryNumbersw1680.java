package bit_operation;

public class ConcatenationofConsecutiveBinaryNumbersw1680 {
    /*
    n=1, f(1) = 1
    n=2, f(2) = [f(1)<<2] + 2 = 6
    n=3, f(3) = [f(2)<<2] + 3 = 27
    n=4, f(4) = [f(3)<<3] + 4 = 220
     */
    // the left shift count is equal to n's bit count
    // 4 (100)
    public int concatenatedBinary(int n) {
        final int mod = 1000000007;
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result = (result << count(i)) % mod;
            result = (result + i) % mod;
        }
        return (int) result;
    }

    private int count(int i) {
        int result = 0;
        while (i > 0) {
            result++;
            i >>= 1;
        }
        return result;
    }
}
