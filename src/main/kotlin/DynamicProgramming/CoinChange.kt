package DynamicProgramming

class CoinChange {

    fun coinChange(coins: IntArray, amount: Int): Int {
        if (amount == 0) return 0
        //making an array to store results. The array is amount + 1 because we're interested in 0 and amount.
        //Populating it with amount+1 as a placeholder to compare new low coin counts to
        val dp = IntArray(amount+1) {amount+1}
        //takes 0 coins to get to 0, we'll use this value for later values to build on
        dp[0] = 0
        //calculating the min number of coins needed to get to each index
        for (i in 1..amount) {
            //looping through each coin to check if it's needed
            for (j in coins.indices) {
                //if our current coin is greater than our current index, we obviously can't use it
                    //(say we want to see how many coins we need to get to 2, we wouldn't use the 5 coin)
                if (coins[j] <= i) {
                 /*
                then we do a min check to update our fewest number of coins, checking our
                current value against the current value minus the coin we're on plus 1 (for the new coin). For example
                say we're checking index 12 and we're on the 2 coin, we'd check to see if dp[10] + 1 (our 2 coin) is
                smaller than our current value
                */
                    dp[i] = minOf(dp[i], dp[i - coins[j] + 1])
                }
            }
        }
        //finally if our dp[amount] is greater than the actual amount,
        //no combinations of coins were found and we return -1
        return if (dp[amount] <= amount) dp[amount] else -1
    }
}