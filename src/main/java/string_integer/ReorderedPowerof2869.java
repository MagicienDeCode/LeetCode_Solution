package string_integer;

import java.util.Arrays;

public class ReorderedPowerof2869 {
    public boolean reorderedPowerOf2(int n) {
        final int[] nCount = count(n);
        for (int i = 0; i < 31; i++) {
            if (Arrays.equals(nCount, count(1 << i))) {
                return true;
            }
        }
        return false;
    }

    private int[] count(int n) {
        final int[] result = new int[10];
        while (n > 0) {
            result[n % 10]++;
            n /= 10;
        }
        return result;
    }
}
