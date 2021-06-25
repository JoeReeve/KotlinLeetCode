package Binary

class SumOfTwoIntegers {

    fun getSum(a: Int, b: Int): Int {
        var a = a
        var b = b

        while (b != 0) {
            var carry = a.and(b)
            a = a.xor(b)
            carry = carry.shl(1)
            b = carry
        }
        return a
    }

    fun getSumCheat(a: Int, b: Int): Int {
        return intArrayOf(a, b).sum()
    }
}