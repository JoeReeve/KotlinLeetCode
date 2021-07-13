package DynamicProgramming

class HouseRobber2 {

    fun rob(nums: IntArray): Int {
        if (nums.size < 1) return 0
        if (nums.size == 1) return nums[0]
        var max1 = robHelper(nums.sliceArray(0..nums.size - 2))
        var max2 = robHelper(nums.sliceArray(1..nums.size-1))
        return maxOf(max1, max2)
    }

    fun robHelper(nums: IntArray): Int {
        if (nums.size < 1) return 0
        if (nums.size == 1) return nums[0]
        val dp = IntArray(nums.size) {0}
        dp[0] = nums[0]
        dp[1] = maxOf(nums[0], nums[1])

        for (i in 2 until nums.size) {
            dp[i] = maxOf(nums[i] + dp[i-2], dp[i - 1])
        }
        return dp.last()
    }
    
}