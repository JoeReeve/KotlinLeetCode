package DynamicProgramming

class JumpGame {

    fun canJump(nums: IntArray): Boolean {
        var lastGoodPosition = nums.size-1
        for (i in nums.size-2 downTo 0) {
            if (i + nums[i] >= lastGoodPosition) lastGoodPosition = i
        }
        return lastGoodPosition == 0
    }

    //brute force
    fun canJump2(nums: IntArray): Boolean {
        val dp = BooleanArray(nums.size){false}
        dp[0] = true
        nums.forEachIndexed{index, num ->
            if (dp[index] == true) {
                var jumps = 0
                while (jumps <= nums[index] && index + jumps <= nums.size - 1) {
                    dp[index + jumps] = true
                    jumps++
                }
            }
        }
        return dp.last()
    }

}