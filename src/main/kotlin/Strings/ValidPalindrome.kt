package Strings

class ValidPalindrome {

    fun isPalindrome(s: String): Boolean {
        val s = s.lowercase()

        var start: Int = 0
        var end: Int = s.length-1

        while (start < end) {
            while (start < end && !s[end].isLetterOrDigit()) end--
            while (start < end && !s[start].isLetterOrDigit()) start++

            if (s[start++] != s[end--]) return false
        }
        return true
    }

}

fun main() {
    val v = ValidPalindrome()
    println(v.isPalindrome("RacecaR"))
}