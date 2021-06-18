package Strings

class MinimumWindowSubstring {

    fun minWindow(s: String, t: String): String {
        val charMap = HashMap<Char, Int>()
        var count = t.length
        var l = 0
        var r = 0
        var minString = ""

        t.forEach { charMap[it] = charMap.getOrDefault(it, 0) + 1 }

        while (r <= s.length) {
            if (count == 0) {
                // shrink
                val char = s[l++]
                if (charMap.contains(char)) {
                    charMap[char] = charMap.getValue(char) + 1
                    if (charMap[char]!! > 0)
                        count++
                }
            }

            if (count != 0) {
                // extend
                if (r == s.length) return minString
                val char = s[r++]
                if (charMap.contains(char)) {
                    charMap[char] = charMap.getValue(char) - 1
                    if (charMap[char]!! >= 0)
                        count--
                }
            }

            if (count == 0 && (minString == "" || r - l < minString.length)) {
                minString = s.slice(l until r)
            }
        }

        return minString
    }

}