package bit_operation;

public class NonnegativeIntegerswithoutConsecutiveOnes600 {
    /*
    public int findIntegers(int num) {
        int count = 0;
        for (int i = 0; i <= num; i++) {
            if (isValid(i)) {
                ++count;
            }
        }
        return count;
    }

    private boolean isValid(int num) {
        boolean flag = false;
        for (int i = 0; i < 32; i++) {
            final boolean current = (num & (1 << i)) != 0;
            if (flag && current) {
                return false;
            }
            flag = current;
        }
        return true;
    }
     */
    public int findIntegers(int num) {
        int[] f = new int[32];
        f[0] = 1;
        f[1] = 2;
        for (int i = 2; i < f.length; i++)
            f[i] = f[i - 1] + f[i - 2];
        int i = 30, sum = 0, prev_bit = 0;
        while (i >= 0) {
            if ((num & (1 << i)) != 0) {
                sum += f[i];
                if (prev_bit == 1) {
                    sum--;
                    break;
                }
                prev_bit = 1;
            } else
                prev_bit = 0;
            i--;
        }
        return sum + 1;
    }
}
