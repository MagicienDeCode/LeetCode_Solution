package dynamic_programming;

public class OnesandZeroes474 {
    public int findMaxForm(String[] strs, int m, int n) {
        final int[][] dp = new int[m + 1][n + 1];
        for (String s : strs) {
            int zero = 0;
            for (char c : s.toCharArray()) {
                if (c == '0') {
                    ++zero;
                }
            }
            final int one = s.length() - zero;
            for (int i = m; i >= zero; i--) {
                for (int j = n; j >= one; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zero][j - one] + 1);
                }
            }
        }
        return dp[m][n];
    }
    /*
    Time Limit Exceeded
    int result = 0;
    int m = 0;
    int n = 0;

    public int findMaxForm(String[] strs, int m, int n) {
        this.m = m;
        this.n = n;
        dfs(strs, 0, 0, 0, 0);
        return result;
    }

    private void dfs(String[] strs, int index, int cm, int cn, int count) {
        if (cm > m || cn > n) {
            return;
        }
        for (int i = index; i < strs.length; i++) {
            int zero = 0;
            for (char c : strs[i].toCharArray()) {
                if (c == '0') {
                    ++zero;
                }
            }
            int one = strs[i].length() - zero;
            cm += zero;
            cn += one;
            count += 1;
            if (cm <= m && cn <= n) {
                result = Math.max(result, count);
                dfs(strs, i + 1, cm, cn, count);
            }
            cm -= zero;
            cn -= one;
            count -= 1;
        }
    }
     */

    public static void main(String[] args) {
        final OnesandZeroes474 java = new OnesandZeroes474();
        System.out.println(java.findMaxForm(
                new String[]{"10", "0001", "111001", "1", "0"},
                4, 3
        ));
    }
}