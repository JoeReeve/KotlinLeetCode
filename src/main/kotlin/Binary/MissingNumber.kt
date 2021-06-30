package Binary

class MissingNumber {

    //using a map
    fun missingNumber1(nums: IntArray): Int {
        val numsList = mutableMapOf<Int,Int>()
        nums.forEach { num ->
            numsList.put(num, 0)
        }
        for (i in 1..nums.size) {
            if (!numsList.contains(i)) return i
        }
        return 0
    }

    //using Gauss' formula
    fun missingNumber2(nums: IntArray): Int {
        var sum = 0
        nums.forEach { num ->
            sum += num
        }
        val gauss = nums.size * (nums.size + 1) / 2
        return gauss - sum
    }

    //using xor bit manipulation
    fun missingNumber(nums: IntArray): Int {
        var xorAll = 0
        var xorNums = nums[0]
        for (i in 0..nums.size) {
            xorAll = xorAll xor i
        }
        for (i in 1..nums.size-1) {
            xorNums = xorNums xor nums[i]
        }
        return xorNums xor xorAll
    }
}