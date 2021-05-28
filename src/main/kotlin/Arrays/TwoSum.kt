package Arrays

class SolutionTwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()

        nums.forEachIndexed { index, num ->
            if(map.containsKey(target-num)) {
                return intArrayOf(map.getValue(target-num), index)
            } else map.put(num, index)
        }
        return intArrayOf(0,0)
    }
}