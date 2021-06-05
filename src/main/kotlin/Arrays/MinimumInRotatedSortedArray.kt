package Arrays

class MinimumInRotatedSortedArray {

    fun findMin(nums: IntArray): Int {
        if(nums.size == 0) return -1
        if(nums.size == 1) return nums[0]

        var left: Int = 0
        var right: Int = nums.size-1

        while (left < right) {
            var midpoint = left + (right-left) / 2

            if(midpoint > 0 && nums[midpoint] < nums[midpoint-1]) return nums[midpoint]
            else if (nums[left] <= nums[midpoint] && nums[midpoint] > nums[right])
                left = midpoint + 1
            else right = midpoint - 1
        }
        return nums[left]
    }

}