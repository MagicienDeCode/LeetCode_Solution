package top_interview_easy.array

class BestTimetoBuyandSellStockIIIKotlin123 {
    fun maxProfit(prices: IntArray): Int {
        if (prices.isEmpty()) {
            return 0
        }
        var firstBuy = Int.MIN_VALUE
        var firstSell = 0
        var secondBuy = Int.MIN_VALUE
        var secondSell = 0
        prices.forEach {
            firstBuy = maxOf(firstBuy, -it)
            firstSell = maxOf(firstSell, firstBuy + it)
            secondBuy = maxOf(secondBuy, firstSell - it)
            secondSell = maxOf(secondSell, secondBuy + it)
        }
        return secondSell
    }
}