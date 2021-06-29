package Binary

class CountingBits {

    //using dynamic programming, O(n) time, O(n) space
    fun countBits(n: Int): IntArray {
        val dp = mutableMapOf<Int, Int>()
        dp.put(0,0)

        for (i in 1..n) {
            dp.put(i, dp.getValue(i/2) + i % 2)
        }
        return dp.values.toIntArray()
    }

    //the iterative approach, O(nlogn) time, O(1) space
    fun countBits2(n: Int): IntArray {
        val oneBits = mutableListOf<Int>(0)
        for (i in 1..n) {
            oneBits.add(ones(i))
        }
        return oneBits.toIntArray()
    }

    //helper function for countBits2, which counts the 1 bits of an int
    fun ones(n: Int): Int {
        var n = n
        var count = 0
        while (n != 0) {
            count++
            n = n and (n - 1)
        }
        return count
    }
}