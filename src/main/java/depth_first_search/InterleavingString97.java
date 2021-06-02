package depth_first_search;

public class InterleavingString97 {

    int[][][] dp;

    public boolean isInterleave(String s1, String s2, String s3) {
        dp = new int[s1.length() + 1][s2.length() + 1][s3.length() + 1];
        return dfs(s1.toCharArray(), s2.toCharArray(), s3.toCharArray(), 0, 0, 0);
    }

    private boolean dfs(char[] s1, char[] s2, char[] target, int i, int j, int t) {
        if (dp[i][j][t] != 0) {
            return dp[i][j][t] == 1;
        }
        if (t == target.length) {
            return i == s1.length && j == s2.length;
        }
        final boolean si1 = i != s1.length && s1[i] == target[t];
        final boolean sj2 = j != s2.length && s2[j] == target[t];
        boolean result = false;
        if (si1 && sj2) {
            result = dfs(s1, s2, target, i + 1, j, t + 1) || dfs(s1, s2, target, i, j + 1, t + 1);
        } else if (si1) {
            result = dfs(s1, s2, target, i + 1, j, t + 1);
        } else if (sj2) {
            result = dfs(s1, s2, target, i, j + 1, t + 1);
        }
        dp[i][j][t] = result ? 1 : -1;
        return result;
    }
}
