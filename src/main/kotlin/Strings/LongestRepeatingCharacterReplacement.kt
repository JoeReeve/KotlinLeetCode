package Strings

class LongestRepeatingCharacterReplacement {

    fun characterReplacement(s: String, k: Int): Int {
        if (s.isEmpty())  return 0

        var mostFrequentCharCount = 0; var start = 0; var max = 0
        val charCounts = mutableMapOf<Char, Int>()

        for (end in 0..s.length-1) {
            charCounts.put(s[end], charCounts.getOrDefault(s[end], 0) + 1)
            mostFrequentCharCount = maxOf(mostFrequentCharCount, charCounts.get(s[end])!!)

            if (end - start + 1 > mostFrequentCharCount + k) {
                charCounts.put(s[start], charCounts.get(s[start])!! - 1)
                start++
            }
            max = maxOf(max, end - start + 1)
        }
        return max
    }
    
}