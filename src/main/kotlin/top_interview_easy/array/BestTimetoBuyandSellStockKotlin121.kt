package top_interview_easy.array

class BestTimetoBuyandSellStockKotlin121 {
    fun maxProfit(prices: IntArray): Int {
        var minPrice = Int.MAX_VALUE
        var result = 0
        for (price in prices) {
            minPrice = minOf(minPrice, price)
            result = maxOf(result, price - minPrice)
        }
        return result
    }
}