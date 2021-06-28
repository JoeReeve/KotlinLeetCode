package Binary

class NumberOf1Bits {

    fun hammingWeight(n:Int):Int {
        var num = n
        var ones = 0
        while (num != 0) {
            ones++
            num = num and (num - 1)
        }
        return ones
    }

    fun hammingWeight2(n:Int):Int {
        var num = n
        var ones = 0
        while (num != 0) {
            if (num and 1 != 0) ones++
            num = num ushr 1
        }
        return ones
    }
}