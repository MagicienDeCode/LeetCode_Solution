package dynamic_programming;

public class CountVowelsPermutation1220 {
    public int countVowelPermutation(int n) {
        long a = 1;
        long e = 1;
        long i = 1;
        long o = 1;
        long u = 1;
        final int MOD = 1000000007;
        for (int j = 1; j < n; j++) {
            final long newA = (e + i + u) % MOD;
            final long newE = (a + i) % MOD;
            final long newI = (e + o) % MOD;
            final long newO = (i) % MOD;
            final long newU = (i + o) % MOD;
            a = newA;
            e = newE;
            i = newI;
            o = newO;
            u = newU;
        }
        return (int) ((a + e + i + o + u) % MOD);
    }
}
