package top_interview_easy.array;

public class BestTimetoBuyandSellStock121 {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int result = 0;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            result = Math.max(result, price - minPrice);
        }
        return result;
    }
}
