package depth_first_search;

public class DistinctSubsequences115 {
    public int numDistinct(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return 0;
        }
        final int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <= t.length(); j++) {
                /*
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
                */
                dp[i][j] = s.charAt(i - 1) == t.charAt(j - 1) ?
                        dp[i - 1][j - 1] + dp[i - 1][j] :
                        dp[i - 1][j];
            }
        }
        return dp[s.length()][t.length()];
    }

    /* Time Limit Exceeded
    int result = 0;

    public int numDistinct(String s, String t) {
        final char[] chars = s.toCharArray();
        final char[] target = t.toCharArray();
        result = 0;
        dfs(chars, 0, target, 0);
        return result;
    }

    private void dfs(char[] chars, int indexC, char[] target, int indexT) {
        if (indexT == target.length) {
            result++;
            return;
        }
        for (int i = indexC; i < chars.length; i++) {
            if (chars[i] == target[indexT]) {
                ++indexT;
                dfs(chars, i + 1, target, indexT);
                --indexT;
            }
        }
    }
     */
}
