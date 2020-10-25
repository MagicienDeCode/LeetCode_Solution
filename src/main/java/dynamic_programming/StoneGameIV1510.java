package dynamic_programming;

public class StoneGameIV1510 {
    /*
    Let's think in the backtrack way. If we have a state i that we know the current player must lose, what can we infer?
    -- Any other states that can go to i must be True.
    Let's say in another state j the current player in j can go to i by removing stones.
    In this case, the state j is True since the current player must win.
    How to find all the state j? Well, we can iterate over the square numbers and add them to i.
     */
    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            if (dp[i]) {
                continue;
            }
            for (int k = 1; i + k * k <= n; k++) {
                dp[i + k * k] = true;
            }
        }
        return dp[n];
    }
}
