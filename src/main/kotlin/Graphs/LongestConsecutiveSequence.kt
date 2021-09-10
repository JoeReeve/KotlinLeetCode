package Graphs

class LongestConsecutiveSequence {

    fun longestConsecutive(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        val numSet = mutableMapOf<Int,Int>()
        var longestCS = 1

        nums.forEach { num ->
            numSet[num] = 1
        }

        nums.forEach { num ->
            if (!numSet.containsKey(num - 1)) {
                var length = 0
                while(numSet.contains(num + length)) {
                    length += 1
                    longestCS = maxOf(longestCS, length)
                }
            }
        }
        return longestCS
    }

}