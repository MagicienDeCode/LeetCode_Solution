package not_categorized;

public class FlipStringtoMonotoneIncreasing926 {
    public int minFlipsMonoIncr(String s) {
        final int N = s.length();
        final int[] P = new int[N + 1];
        for (int i = 0; i < N; i++) {
            P[i + 1] = P[i] + (s.charAt(i) == '1' ? 1 : 0);
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < N + 1; i++) {
            result = Math.min(result, P[i] + N - i - (P[N] - P[i]));
        }
        return result;
    }
}
