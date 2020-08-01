package top_interview_easy.array;

public class BestTimetoBuyandSellStockII122 {
    public int maxProfit(int[] prices) {
        int result = 0;
        for (int index = 1; index < prices.length; index++) {
            result += prices[index] > prices[index - 1] ?
                    prices[index] - prices[index - 1] :
                    0;
        }
        return result;
    }
}
