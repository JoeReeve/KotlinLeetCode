package DynamicProgramming

class DecodeWays {

    fun numDecodings(s: String): Int {
        val dp = IntArray(s.length + 1)
        dp[0] = 1
        dp[1] = if (s[0] == '0') 0 else 1
        for (i in 2..s.length) {
            var oneDigit = s.substring(i-1 until i).toInt()
            var twoDigits = s.substring(i-2 until i).toInt()
            if (oneDigit >= 1) dp[i] += dp[i-1]
            if (twoDigits >= 10 && twoDigits <= 26) dp[i] += dp[i-2]
        }
        return dp.last()
    }

}