package DynamicProgramming

class HouseRobber {

    fun rob(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]
        val dp = IntArray(nums.size) {0}

        dp[0] = nums[0]
        dp[1] = maxOf(nums[0], nums[1])

        for (i in 2 until nums.size) {
            dp[i] = maxOf(dp[i - 2] + nums[i], dp[i-1])
        }

        return dp.last()
    }

}