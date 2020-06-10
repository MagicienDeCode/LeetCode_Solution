package binary_search;

public class KthSmallestPrimeFraction786 {
    public int[] kthSmallestPrimeFraction(int[] numsA, int k) {
        double left = (double) numsA[0] / (double) numsA[numsA.length - 1];
        double right = 1;
        int q = 1;
        while (true) {
            final double mid = left + (right - left) / 2;
            int p = 0;
            int count = 0;
            int end = 1;
            for (int index = 0; index < numsA.length - 1; index++) {
                while (end < numsA.length && numsA[index] >= numsA[end] * mid) {
                    ++end;
                }
                count += numsA.length - end;
                if (end < numsA.length && p * numsA[end] < q * numsA[index]) {
                    p = numsA[index];
                    q = numsA[end];
                }
            }
            if (count == k) {
                return new int[]{p, q};
            } else if (count < k) {
                left = mid;
            } else {
                right = mid;
            }
        }
    }
}
