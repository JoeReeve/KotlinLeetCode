package DynamicProgramming

class LongestIncreasingSubsequence {

    fun lengthOfLIS(nums: IntArray): Int {
        //this array keeps track of the best subsequence so far, with a base case of 1 at each index
        val dp = IntArray(nums.size) {1}

        for (i in 1 until dp.size) {
            //checking all the numbers before i
            for (j in i - 1 downTo 0) {
                //first we check to make sure our current number is greater than the previous one, then we check to see
                    //if adding it increases our longest subsequence found so far
                if (nums[i] > nums[j] && dp[j] + 1 > dp[i]) {
                    //if those cases our true then we append the current longest subsequence with the current number
                    dp[i] = dp[j] + 1
                }
            }
        }
        //checking to find our maximum subsequence in the dp array
        var max = 1
        dp.forEach{ num ->
            max = maxOf(max, num)
        }
        return max
    }

}