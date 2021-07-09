package DynamicProgramming

class CombinationSumIV {

    fun combinationSum4(nums: IntArray, target: Int): Int {
        val dp = IntArray(target + 1) {0}
        dp[0] = 1

        for (i in dp.indices) {
            for (num in nums) {
                dp[i] += dp.getOrNull(i - num) ?: 0
            }
        }
        return dp.last()
    }

}