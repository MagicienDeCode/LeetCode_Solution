package dynamic_programming;

public class MinimumASCIIDeleteSumforTwoStrings712 {
    public int minimumDeleteSum(String s1, String s2) {
        final int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    /*
                    2 3
                    3 ?
                    Take the max of 3 possibilities:
                    1. take left 3 which is dp[i][j - 1]
                    2. take right 3 which is dp[i - 1][j]
                    3. take the 2 and add the current: dp[i - 1][j - 1] + s1.charAt(i - 1) - 'a' + 97
                     */
                    dp[i][j] = Math.max(Math.max(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1] + s1.charAt(i - 1) - 'a' + 97);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int count = 0;
        for (char c : s1.toCharArray()) {
            count += 97 + c - 'a';
        }
        for (char c : s2.toCharArray()) {
            count += 97 + c - 'a';
        }
        return count - 2 * dp[s1.length()][s2.length()];
    }
}
