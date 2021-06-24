package Strings

class LongestPalindromicSubstring {

    var pal = ""

    fun longestPalindrome(s: String): String {

        s.forEachIndexed { index, letter ->
            expand(s, index, index)
            expand(s, index, index + 1)
        }
        return pal
    }

    fun expand(s: String, i: Int, j: Int) {
        var i = i
        var j = j

        while (i >= 0 && j < s.length && s[i] == s[j]) {
            i--
            j++
        }
        pal = if (j - i - 1 > pal.length) s.slice(i+1..j-1) else pal
    }
}

//This is the brute force solution, which is O(n^3) time and O(1) space

//fun longestPalindrome(s: String): String {
//    if (s.isEmpty()) return ""
//
//    var start = 0
//    var end = 0
//    var longestIndice = 0
//    var maxLength = 0
//
//    s.forEachIndexed { i, letter ->
//        s.forEachIndexed { j, letter2 ->
//            if (validPalindrome(s.slice(i..j))) {
//                if (j - i > maxLength) {
//                    maxLength = j - i
//                    longestIndice = i
//                }
//            }
//        }
//    }
//    return s.slice(longestIndice..longestIndice + maxLength)
//}
//
//fun validPalindrome(s: String): Boolean {
//
//    var start = 0
//    var end = s.length - 1
//
//    while (start < end) {
//        if (s[start] == s[end]) {
//            start++
//            end--
//        } else return false
//    }
//    return true
//}