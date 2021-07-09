package DynamicProgramming

class WordBreak {

    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val dp = Array<Boolean>(s.length + 1) {false}
        dp[0] = true

        for (i in 0..s.length) {
            for (j in 0..i) {
                if (dp[j] && wordDict.contains(s.substring(j until i))) {
                    dp[i] = true
                    break
                }
            }
        }
        return dp[s.length]
    }

}