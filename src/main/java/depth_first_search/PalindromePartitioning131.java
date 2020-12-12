package depth_first_search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PalindromePartitioning131 {
    public List<List<String>> partition(String s) {
        final List<List<String>> results = new LinkedList<>();
        final List<String> subsets = new ArrayList<>();
        final boolean[][] dp = new boolean[s.length()][s.length()];
        dfs(s, 0, subsets, results, dp);
        return results;
    }

    private void dfs(String s, int startIndex, List<String> subsets, List<List<String>> results, boolean[][] dp) {
        if (startIndex == s.length()) {
            results.add(new ArrayList<>(subsets));
        } else {
            for (int i = startIndex; i < s.length(); i++) {
                if (s.charAt(startIndex) == s.charAt(i) && ((i - startIndex <= 2) || dp[startIndex + 1][i - 1])) {
                    subsets.add(s.substring(startIndex, i + 1));
                    dp[startIndex][i] = true;
                    dfs(s, i + 1, subsets, results, dp);
                    subsets.remove(subsets.size() - 1);
                }
            }
        }
    }

    /*
    public List<List<String>> partition(String s) {
        final List<List<String>> results = new LinkedList<>();
        final List<String> subsets = new ArrayList<>();
        dfs(s, 0, subsets, results);
        return results;
    }

    private void dfs(String s, int startIndex, List<String> subsets, List<List<String>> results) {
        if (startIndex == s.length()) {
            results.add(new ArrayList<>(subsets));
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
