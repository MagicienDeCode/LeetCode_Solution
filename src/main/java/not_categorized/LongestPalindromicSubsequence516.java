package not_categorized;

public class LongestPalindromicSubsequence516 {
    public int longestPalindromeSubseq(String s) {
        final int[][] dp = new int[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }
    /*
    public int longestPalindromeSubseq(String s) {
        final Queue<String> queue = new LinkedList<>();
        int length = s.length();
        final Set<String> set = new HashSet<>();
        queue.offer(s);
        set.add(s);
        while (!queue.isEmpty()) {
            final int currentSize = queue.size();
            for (int size = 0; size < currentSize; size++) {
                final String currentStr = queue.poll();
                if (isPalindromic(currentStr)) {
                    return length;
                }
                for (int i = 0; i < currentStr.length(); i++) {
                    final StringBuilder sb = new StringBuilder(currentStr);
                    sb.deleteCharAt(i);
                    final String newStr = sb.toString();
                    if (!set.contains(newStr)) {
                        set.add(newStr);
                        queue.offer(newStr);
                    }
                }
            }
            --length;
        }
        return 1;
    }

    private boolean isPalindromic(String s) {
        final char[] chars = s.toCharArray();
        int left = chars.length % 2 == 1 ? chars.length / 2 : chars.length / 2 - 1;
        int right = chars.length / 2;
        while (left >= 0 && right < chars.length) {
            if (chars[left] != chars[right]) {
                return false;
            }
            --left;
            ++right;
        }
        return true;
    }
     */
}
