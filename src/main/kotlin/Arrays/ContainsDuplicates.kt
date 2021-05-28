package Arrays

class SolutionContainsDups {
    fun containsDuplicate(nums: IntArray): Boolean {
        val map = mutableMapOf<Int, Int>()
        nums.forEach { num ->
            if (map.containsKey(num)) return true
            else map.put(num, 0)
        }
        return false
    }
}