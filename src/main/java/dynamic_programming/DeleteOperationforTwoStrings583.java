package dynamic_programming;

public class DeleteOperationforTwoStrings583 {
    public int minDistance(String word1, String word2) {
        return word1.length() + word2.length() - 2 * longestCommonSubstring(word1, word2);
    }

    private int longestCommonSubstring(String s1, String s2) {
        final int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
