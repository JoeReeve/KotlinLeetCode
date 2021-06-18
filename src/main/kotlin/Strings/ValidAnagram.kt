package Strings

class ValidAnagram {

    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false

        val sMap = mutableMapOf<Char, Int>()
        val tMap = mutableMapOf<Char, Int>()

        s.forEach { letter ->
            sMap.put(letter, sMap.getOrDefault(letter, 0) + 1)
        }

        t.forEach { letter ->
            tMap.put(letter, tMap.getOrDefault(letter, 0) + 1)
        }

        s.forEach { letter ->
            if (sMap[letter] != tMap[letter]) return false
        }

        return true
    }

}