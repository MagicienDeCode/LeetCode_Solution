package dynamic_programming;

import java.util.*;

class WordBreak139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        final Set<String> wordSet = new HashSet<>(wordDict);
        final boolean[] visited = new boolean[s.length() + 1];
        final Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            final int current = queue.poll();
            if (current == s.length()) {
                return true;
            }
            for (int index = current + 1; index <= s.length(); index++) {
                if (!visited[index] &&
                        wordSet.contains(s.substring(current, index))) {
                    queue.offer(index);
                    visited[index] = true;
                }
            }
        }
        return false;
    }
    /*
    public boolean wordBreak(String s, List<String> wordDict) {
        final Set<String> wordSet = new HashSet<>(wordDict);
        final boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
     */
}