package binary_search;

public class SmallestGoodBase483 {
    public String smallestGoodBase(String n) {
        final long nLong = Long.parseLong(n);
        final int minK = 2;
        final int maxK = (int) (Math.log10(Double.parseDouble(n)) / Math.log10(2)) + 1;
        for (int k = maxK; k >= minK; k--) {
            final long base = binarySearchBase(nLong, k);
            if (base != -1) {
                return base + "";
            }
        }
        return (nLong - 1) + "";
    }

    private long binarySearchBase(long nLong, int k) {
        long left = 2;
        // long right = nLong;
        long right = (long) (Math.pow(nLong, 1.0 / (double) (k - 1)));
        while (left + 1 < right) {
            final long mid = left + ((right - left) >> 1);
            final int isValidBase = isValidBase(nLong, k, mid);
            if (isValidBase == 0) {
                return mid;
            } else if (isValidBase < 0) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (isValidBase(nLong, k, left) == 0) {
            return left;
        }
        if (isValidBase(nLong, k, right) == 0) {
            return right;
        }
        return -1;
    }

    private int isValidBase(long nLong, int k, long base) {
        long current = 0;
        for (int times = 0; times <= k; times++) {
            if ((Long.MAX_VALUE - 1) / base < current) {
                return 1;
            }
            current = current * base + 1;
        }
        return Long.compare(current, nLong);
    }

    public static void main(String[] args) {
        final SmallestGoodBase483 solution = new SmallestGoodBase483();
        System.out.println(solution.smallestGoodBase("2251799813685247"));
        System.out.println(solution.smallestGoodBase("13"));
    }
}
