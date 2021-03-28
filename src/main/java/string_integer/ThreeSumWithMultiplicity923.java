package string_integer;

public class ThreeSumWithMultiplicity923 {
    public int threeSumMulti(int[] arr, int target) {
        final int MOD = 1000000007;
        final long[] count = new long[101];
        for (int i : arr) {
            count[i]++;
        }
        long r = 0;

        // all diff
        for (int x = 0; x < 101; x++) {
            for (int y = x + 1; y < 101; y++) {
                int z = target - x - y;
                if (y < z && z < 101) {
                    r += count[x] * count[y] * count[z] % MOD;
                }
            }
        }

        // x == y != z
        for (int x = 0; x < 101; x++) {
            int z = target - x * 2;
            if (x < z && z < 101) {
                r += (count[x] * (count[x] - 1) / 2 * count[z]) % MOD;
            }
        }

        // x != y == z
        for (int x = 0; x < 101; x++) {
            if (target % 2 == x % 2) {
                int y = (target - x) >> 1;
                if (x < y && y < 101) {
                    r += (count[x] * count[y] * (count[y] - 1) / 2) % MOD;
                }
            }
        }

        // x == y == z
        if (target % 3 == 0) {
            int x = target / 3;
            if (x < 101) {
                r += (count[x] * (count[x] - 1) * (count[x] - 2) / 6) % MOD;
            }
        }

        return (int) r;
    }
}
