package Arrays

class MaxSubArray {
    fun maxSubArray(nums: IntArray): Int {
        var maxSum = nums[0]
        var currSum = nums[0]

        for (i in 1 until nums.size) {
            currSum = maxOf(nums[i], currSum + nums[i])
            maxSum = maxOf(currSum, maxSum)
        }
        return maxSum
    }
}