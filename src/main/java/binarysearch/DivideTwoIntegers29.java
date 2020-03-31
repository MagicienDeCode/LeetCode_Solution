package binarysearch;

public class DivideTwoIntegers29 {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            return -dividend;
        }
        int flag = dividend < 0 ? -1 : 1;
        flag = divisor < 0 ? -flag : flag;
        int result = 0;

        int remain = dividend > 0 ? -dividend : dividend;
        final int negativeDivisor = divisor > 0 ? -divisor : divisor;
        // calculate max shifts left
        int maxShifts = 0;
        if (negativeDivisor >= remain) {
            int temp = negativeDivisor;
            while (temp >= remain - temp) {
                temp += temp;
                maxShifts++;
            }
            result += 1 << maxShifts;
            remain -= negativeDivisor << maxShifts;
        }
        // from max shifts left to 0, find some value that sum equal to remain
        while (negativeDivisor >= remain) {
            maxShifts--;
            if (negativeDivisor << maxShifts >= remain) {
                remain -= negativeDivisor << maxShifts;
                result += 1 << maxShifts;
            }
        }
        return flag < 0 ? -result : result;
    }
}
