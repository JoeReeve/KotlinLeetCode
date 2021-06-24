package Strings

class PalindromicSubstrings {

    fun countSubstrings(s: String): Int {
        var count = 0

        s.forEachIndexed{ index, letter ->
            count += expand(s, index, index)
            count += expand(s, index, index + 1)
        }
        return count
    }

    fun expand(s: String, x: Int, y: Int): Int {
        var i = x
        var j = y
        var count = 0

        while (i >= 0 && j < s.length && s[i] == s[j]) {
            i--
            j++
            count++
        }
        return count
    }
    
}