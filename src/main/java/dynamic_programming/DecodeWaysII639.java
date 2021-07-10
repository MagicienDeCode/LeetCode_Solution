package dynamic_programming;

public class DecodeWaysII639 {
    private final static int MODULO = 1000000007;

    public int numDecodings(String s) {
        final long[] dp = new long[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '*' ? 9 : s.charAt(0) == '0' ? 0 : 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                dp[i + 1] = 9 * dp[i] % MODULO;
                if (s.charAt(i - 1) == '1')
                    // 11 - 19
                    dp[i + 1] = (dp[i + 1] + 9 * dp[i - 1]) % MODULO;
                else if (s.charAt(i - 1) == '2')
                    // 21 22 23 24 25 26
                    dp[i + 1] = (dp[i + 1] + 6 * dp[i - 1]) % MODULO;
                else if (s.charAt(i - 1) == '*')
                    // 11- 19 21 22 23 24 25 26
                    dp[i + 1] = (dp[i + 1] + 15 * dp[i - 1]) % MODULO;
            } else {
                dp[i + 1] = s.charAt(i) != '0' ? dp[i] : 0;
                if (s.charAt(i - 1) == '1')
                    // 10 -> 19
                    dp[i + 1] = (dp[i + 1] + dp[i - 1]) % MODULO;
                else if (s.charAt(i - 1) == '2' && s.charAt(i) <= '6')
                    // 20 -> 26
                    dp[i + 1] = (dp[i + 1] + dp[i - 1]) % MODULO;
                else if (s.charAt(i - 1) == '*')
                    // [*= 1 or 2][1-6]  or [*=2][7,8,9]
                    dp[i + 1] = (dp[i + 1] + (s.charAt(i) <= '6' ? 2 : 1) * dp[i - 1]) % MODULO;
            }
        }
        return (int) dp[s.length()];
    }
}
/*
    private final static int MODULO = 1000000007;

    private char[] chars;
    private long[] dp;

    public int numDecodings(String s) {
        this.chars = s.toCharArray();
        this.dp = new long[s.length()];
        return (int) (dfs(0) % MODULO);
    }

    private long dfs(int i) {
        if (i == chars.length) {
            return 1;
        } else if (i == chars.length - 1) {
            if (chars[i] == '*') {
                // 1 2 3 4 5 6 7 8 9
                return 9;
            } else if (chars[i] != '0') {
                return 1;
            }
            return 0;
        } else {
            if (dp[i] != 0) {
                return dp[i];
            }
            int count = 0;
            if (chars[i] == '*' && chars[i + 1] == '*') {
                // 1 - 9
                count += dfs(i + 1) * 9 % MODULO;
                // 11 - 26 without 20
                count += dfs(i + 2) * 15 % MODULO;
            }
            // * [0-9]
            else if (chars[i] == '*') {
                if (chars[i + 1] == '0') {
                    // 10 or 20
                    count += dfs(i + 2) * 2 % MODULO;
                } else {
                    // * = 1 - 9
                    count += dfs(i + 1) * 9 % MODULO;
                    if (chars[i + 1] >= '7') {
                        // *=1 [7-9]
                        count += dfs(i + 2) % MODULO;
                    } else {
                        // *=1 [1-6] or *=2 [1-6]
                        count += dfs(i + 2) * 2 % MODULO;
                    }
                }
            }
            // [1-9] *
            else if (chars[i + 1] == '*') {
                if (chars[i] == '1') {
                    // 11 12 13 14 15 16 17 18 19
                    count += dfs(i + 2) * 9 % MODULO;
                } else if (chars[i] == '2') {
                    // 21 22 23 24 25 26
                    count += dfs(i + 2) * 6 % MODULO;
                }
                if (chars[i] != '0') {
                    count += dfs(i + 1) % MODULO;
                }
            } else {
                // first / second without *
                final int first = chars[i] - '0';
                final int second = chars[i + 1] - '0';
                final int test = first * 10 + second;
                if (test >= 1) {
                    if (test == 10 || test == 20) {
                        // 10 or 20
                        count += dfs(i + 2) % MODULO;
                    } else if (test > 10) {
                        if (test <= 26) {
                            // 11 12 13 14 15 16 17 18 19 21 22 23 24 25 26
                            count += dfs(i + 2) % MODULO;
                        }
                        count += dfs(i + 1) % MODULO;
                    }
                }
            }
            dp[i] = count;
            return count;
        }
    }

    public static void main(String[] args) {
        final DecodeWaysII639 java = new DecodeWaysII639();
        System.out.println(java.numDecodings("1*")); // 18
        System.out.println(java.numDecodings("2*")); // 15
        System.out.println(java.numDecodings("1*2")); // 20
        System.out.println(java.numDecodings("**1")); // 114
    }
 */