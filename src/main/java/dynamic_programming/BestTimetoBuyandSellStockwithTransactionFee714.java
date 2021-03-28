package dynamic_programming;

public class BestTimetoBuyandSellStockwithTransactionFee714 {
    public int maxProfit(int[] prices, int fee) {
        int result = 0;
        for (int index = 1; index < prices.length; index++) {
            result += prices[index] - fee > prices[index - 1] ?
                    prices[index] - prices[index - 1] - fee :
                    0;
        }
        return result;
    }
}
