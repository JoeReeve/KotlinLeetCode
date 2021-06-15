package Strings

class LongestSubstringWithoutRepeatingCharacters {

    fun lengthOfLongestSubstring(s: String): Int {
        if (s.isEmpty()) return 0
        val map = mutableMapOf<Char, Int>()
        var maxLength = 0
        var pointerA = 0
        var pointerB = 0

        while (pointerB < s.length) {
            if (!map.containsKey(s[pointerB])) {
                map.put(s[pointerB], pointerB)
                maxLength = maxOf(maxLength, map.size)
                pointerB++
            } else {
                map.remove(s[pointerA])
                pointerA++
            }
        }
        return maxLength
    }
    
}