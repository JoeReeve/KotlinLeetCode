package Binary

class ReverseBits {

    fun reverseBits(n:Int):Int {
        if (n == 0) return 0

        var n = n
        var ans = 0

        for (i in 0..31) {
            ans = ans shl 1
            if (n % 2 != 0) ans++
            n = n shr 1
        }
        return ans
    }
    
}