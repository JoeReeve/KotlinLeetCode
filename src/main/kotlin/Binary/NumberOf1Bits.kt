package Binary

class NumberOf1Bits {

    fun hammingWeight(n: Int): Int {
        var num = n
        var ones = 0
        while (num != 0) {
            if (num and 1 != 0) ones++
            num = num ushr 1
        }
        return ones
    }

    fun hammingWeight2(n: Int): Int {
        var num = n
        var ones = 0
        while (num != 0) {
            ones++
            num = num and (num - 1)
        }
        return ones
    }

    /* What's happening in the While loop: ( Input (num) = 91 (0101 1100) )
    Count = 1 - 0101 1100 (91) AND 0101 1011 (90, which is the last number - 1) = 0101 1000
    Count = 2 - 0101 1000 AND 0101 0111 = 0101 0000
    Count = 3 - 0101 0000 AND 0100 1111 = 0100 0000
    Count = 4 - 0100 0000 AND 0011 1111 = 0000 0000
    Break out of loop because num now equals 0, return 4, the correct amount of 1s found in our input 0101 1100
     */
}