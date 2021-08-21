package depth_first_search;

public class PalindromePartitioningII132 {

    public int minCut(String s) {
        int[][] dp = new int[s.length()][s.length()];
        int[] cut = new int[s.length() + 1];

        for (int i = s.length() - 1; i >= 0; i--) {
            cut[i] = Integer.MAX_VALUE;
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 1 || dp[i + 1][j - 1] == 1)) {
                    dp[i][j] = 1;
                    cut[i] = Math.min(1 + cut[j + 1], cut[i]);
                }
            }
        }
        return cut[0] - 1;
    }

    /* Time Limit Exceeded */
    /*
    public int minCut(String s) {
        final int[] results = new int[]{Integer.MAX_VALUE};
        final List<String> subsets = new ArrayList<>();
        final boolean[][] dp = new boolean[s.length()][s.length()];
        dfs(s, 0, subsets, results, dp);
        return results[0];
    }

    private void dfs(String s, int startIndex, List<String> subsets, int[] results, boolean[][] dp) {
        if (startIndex == s.length()) {
            results[0] = Math.min(results[0], subsets.size() - 1);
        } else {
            for (int i = startIndex; i < s.length(); i++) {
                if (s.charAt(startIndex) == s.charAt(i) && ((i - startIndex <= 2) || dp[startIndex + 1][i - 1])) {
                    if (subsets.size()-1 >= results[0]) {
                        continue;
                    }
                    subsets.add(s.substring(startIndex, i + 1));
                    dp[startIndex][i] = true;
                    dfs(s, i + 1, subsets, results, dp);
                    subsets.remove(subsets.size() - 1);
                }
            }
        }
    }
     */
    /*
    public int minCut(String s) {
        final int[] results = new int[]{Integer.MAX_VALUE};
        final List<String> subsets = new ArrayList<>();
        dfs(s, 0, subsets, results);
        return results[0];
    }

    private void dfs(String s, int startIndex, List<String> subsets, int[] results) {
        if (startIndex == s.length()) {
            results[0] = Math.min(results[0], subsets.size() - 1);
        } else {
            for (int i = startIndex; i < s.length(); i++) {
                if (isPalindrome(s, startIndex, i)) {
                    subsets.add(s.substring(startIndex, i + 1));
                    dfs(s, i + 1, subsets, results);
                    subsets.remove(subsets.size() - 1);
                }
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
     */
}
