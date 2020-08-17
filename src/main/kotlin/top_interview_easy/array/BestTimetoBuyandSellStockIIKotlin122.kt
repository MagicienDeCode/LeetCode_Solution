package top_interview_easy.array

class BestTimetoBuyandSellStockIIKotlin122 {
    fun maxProfit(prices: IntArray): Int {
        var result = 0
        for (index in 1 until prices.size) {
            result += if (prices[index] > prices[index - 1]) prices[index] - prices[index - 1] else 0
        }
        return result
    }
}