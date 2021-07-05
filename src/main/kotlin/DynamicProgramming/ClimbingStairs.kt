package DynamicProgramming

class ClimbingStairs {

    fun climbStairs(n: Int): Int {
        if (n <= 2) return n
        val steps = IntArray(n+1)
        steps[1] = 1
        steps[2] = 2

        for (i in 3..n) {
            steps[i] = steps[i-1] + steps[i-2]
        }
        return steps[n]
    }

    fun climbStairs2(n: Int): Int {
        val dp = IntArray(n + 1)
        fun ways(n: Int): Int {
            if (n <= 2) return n
            if (dp[n] == 0) {
                dp[n] = ways(n - 1) + ways(n - 2)
            }
            return dp[n]
        }
        return ways(n)
    }
}