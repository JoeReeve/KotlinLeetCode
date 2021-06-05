package Arrays

class ThreeSum {

    fun threeSum(nums: IntArray): List<List<Int>> {
        var sums = mutableSetOf<List<Int>>()
        if (nums.size < 3) return sums.toList()

        nums.sort()

        for (num in 0..nums.size - 2) {
            var left = num + 1
            var right = nums.size-1
            var sum = 0 - nums[num]

            while (left < right) {
                if (nums[left] + nums[right] == sum) {
                    sums.add(listOf<Int>(nums[num], nums[left], nums[right]))
                    left++
                    right--
                } else if (nums[left] + nums[right] > sum) right--
                else left++
            }
        }
        return sums.toList()
    }
    
}