package string_integer;

public class CountPrimes204 {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        final boolean[] nums = new boolean[n];
        final int max = (int) Math.sqrt(n);
        for (int i = 2; i < max; i++) {
            if (!nums[i]) {
                for (int j = i * i; j < n; j += i) {
                    nums[j] = true;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!nums[i]) {
                ++count;
            }
        }
        return count;
    }
}
