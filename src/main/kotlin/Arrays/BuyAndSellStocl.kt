package Arrays

class SolutionBuyAndSellStock {
    fun maxProfit(prices: IntArray): Int {

        var low = Int.MAX_VALUE
        var maxProfit = 0

        prices.forEach { currentPrice ->
            low = minOf(currentPrice, low)
            maxProfit = maxOf(currentPrice - low, maxProfit)
        }
        return maxProfit
    }
}