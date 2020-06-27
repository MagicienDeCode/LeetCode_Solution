package dynamic_programming;

public class PerfectSquares279 {

    // https://zh.wikipedia.org/wiki/%E5%9B%9B%E5%B9%B3%E6%96%B9%E5%92%8C%E5%AE%9A%E7%90%86
    // 四平方和定理
    public int numSquares(int amount) {
        while (amount % 4 == 0) {
            amount /= 4;
        }
        if (amount % 8 == 7) {
            return 4;
        }
        int a1 = 0;
        while (a1 * a1 <= amount) {
            final int b2 = (int) Math.sqrt(amount - a1 * a1);
            if (a1 * a1 + b2 * b2 == amount) {
                if (a1 != 0 && b2 != 0) {
                    return 2;
                } else {
                    return 1;
                }
            }
            ++a1;
        }
        return 3;
    }
    /*
    public int numSquares(int amount) {
        final List<Integer> coins = new ArrayList<>();
        int current = 1;
        while (current * current <= amount) {
            coins.add(current * current);
            ++current;
        }
        final int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int index = 1; index <= amount; index++) {
            for (int coin : coins) {
                if (coin <= index) {
                    dp[index] = Math.min(dp[index], dp[index - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
    */
}
