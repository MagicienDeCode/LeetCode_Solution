package dynamic_programming;

public class EditDistance72 {
    public int minDistance(String word1, String word2) {
        final int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int index = 0; index < dp.length; index++) {
            dp[index][0] = index;
        }
        for (int index = 0; index < dp[0].length; index++) {
            dp[0][index] = index;
        }
        for (int i1 = 1; i1 < dp.length; i1++) {
            for (int j2 = 1; j2 < dp[0].length; j2++) {
                dp[i1][j2] = word1.charAt(i1 - 1) == word2.charAt(j2 - 1) ?
                        dp[i1 - 1][j2 - 1] :
                        1 + Math.min(dp[i1 - 1][j2 - 1],
                                Math.min(dp[i1][j2 - 1], dp[i1 - 1][j2]));
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
