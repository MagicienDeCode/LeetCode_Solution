package dynamic_programming;

class BestTimetoBuyandSellStockwithCooldown309 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        final int[] cooldown = new int[prices.length];
        final int[] buy = new int[prices.length];
        final int[] sell = new int[prices.length];
        buy[0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            cooldown[i] = Math.max(cooldown[i - 1], sell[i - 1]);
            buy[i] = Math.max(buy[i - 1], cooldown[i - 1] - prices[i]);
            sell[i] = buy[i - 1] + prices[i];
        }
        return Math.max(cooldown[prices.length - 1], sell[prices.length - 1]);
    }
}