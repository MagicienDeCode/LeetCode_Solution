package depth_first_search;

import java.util.Arrays;

public class FreedomTrail514 {

    private String ring = "";
    private String key = "";
    private int[][] dp;

    public int findRotateSteps(String ring, String key) {
        this.ring = ring;
        this.key = key;
        // for a given index of ring, the minimum steps to find the char at index of key
        dp = new int[ring.length()][key.length()];
        // default value INT.MAX_VALUE
        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        return dfs(0, 0);
    }

    private int dfs(final int indexRing, final int keyIndex) {
        // if key is at the end, return 0
        if (keyIndex == key.length()) {
            return 0;
        }
        final char keyChar = key.charAt(keyIndex);
        // if we have calculated the result, return it.
        if (dp[indexRing][keyIndex] != Integer.MAX_VALUE) {
            return dp[indexRing][keyIndex];
        }
        final int len = ring.length();
        // clockwise to find the char at index of key
        int clockwise = Integer.MAX_VALUE;
        for (int i = 0; i <= len / 2; i++) {
            if (keyChar == ring.charAt((indexRing + i) % len)) {
                clockwise = i + 1 + dfs((indexRing + i) % len, keyIndex + 1);
                break;
            }
        }
        // antiClockwise to find the char at index of key
        int antiClockwise = Integer.MAX_VALUE;
        for (int i = 0; i <= len / 2; i++) {
            if (keyChar == ring.charAt((indexRing + len - i) % len)) {
                antiClockwise = i + 1 + dfs((indexRing + len - i) % len, keyIndex + 1);
                break;
            }
        }
        // return the minimum and update dp
        final int result = Math.min(clockwise, antiClockwise);
        dp[indexRing][keyIndex] = result;
        return result;
    }

    public static void main(String[] args) {
        final FreedomTrail514 java = new FreedomTrail514();
        // 4 204 137
        System.out.println(java.findRotateSteps("godding", "gd"));
        System.out.println(java.findRotateSteps("xrrakuulnczywjs", "jrlucwzakzussrlckyjjsuwkuarnaluxnyzcnrxxwruyr"));
        System.out.println(java.findRotateSteps("caotmcaataijjxi", "oatjiioicitatajtijciocjcaaxaaatmctxamacaamjjx"));
    }
}
