package breadth_first_search;

public class DecodeWays91 {
    private char[] chars;
    private int[] dp;

    public int numDecodings(String s) {
        this.chars = s.toCharArray();
        this.dp = new int[s.length()];
        return dfs(0);
    }

    private int dfs(int i) {
        if (i == chars.length) {
            return 1;
        } else if (i == chars.length - 1) {
            if (chars[i] != '0') {
                return 1;
            }
            return 0;
        } else {
            if (dp[i] != 0) {
                return dp[i];
            }
            int count = 0;
            final int first = chars[i] - '0';
            final int second = chars[i + 1] - '0';
            final int test = first * 10 + second;
            if (test >= 1) {
                if (test == 10 || test == 20) {
                    count += dfs(i + 2);
                } else if (test > 10) {
                    if (test <= 26) {
                        count += dfs(i + 2);
                    }
                    count += dfs(i + 1);
                }
            }
            dp[i] = count;
            return count;
        }
    }

    public static void main(String[] args) {
        final DecodeWays91 java = new DecodeWays91();
        //
        System.out.println(java.numDecodings("111111111111111111111111111111111111111111111"));
        // 1
        System.out.println(java.numDecodings("2101"));
        // 2 3 0 1 0
        System.out.println(java.numDecodings("12"));
        System.out.println(java.numDecodings("226"));
        System.out.println(java.numDecodings("0"));
        System.out.println(java.numDecodings("1"));
        System.out.println(java.numDecodings("00"));
    }
    /* Time Limit Exceeded
    private int result;
    private char[] chars;

    public int numDecodings(String s) {
        this.result = 0;
        this.chars = s.toCharArray();
        dfs(0);
        return result;
    }

    private void dfs(int i) {
        if (i == chars.length) {
            ++result;
        } else if (i == chars.length - 1) {
            if (chars[i] != '0') {
                dfs(i + 1);
            }
        } else {
            final int first = chars[i] - '0';
            final int second = chars[i + 1] - '0';
            final int test = first * 10 + second;
            if (test >= 1) {
                if (test == 10 || test == 20) {
                    dfs(i + 2);
                } else if (test > 10) {
                    if (test <= 26) {
                        dfs(i + 2);
                    }
                    dfs(i + 1);
                }
            }
        }
    }
     */
}
