package string_integer;

import java.util.Arrays;

public class SmallestRangeII910 {
    public int smallestRangeII(int[] a, int k) {
        if (a.length == 1) {
            return 0;
        }
        Arrays.sort(a);
        int result = a[a.length - 1] - a[0];
        final int maxB = a[a.length - 1] - k;
        final int minB = a[0] + k;
        for (int i = 0; i < a.length - 1; i++) {
            final int max = Math.max(maxB, a[i] + k);
            final int min = Math.min(minB, a[i + 1] - k);
            result = Math.min(result, max - min);
        }
        return result;
    }
}
