package Arrays

class SearchRotatedSortedArray {

    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size-1

        while (left < right) {
            var midpoint = left + (right - left) / 2

            if (nums[midpoint] > nums[right]) left = midpoint + 1
            else right = midpoint
        }

        var start = left
        left = 0
        right = nums.size - 1

        if (target >= nums[start] && target <= nums[right]) left = start
        else right = start

        while (left <= right) {
            var midpoint = left + (right - left) / 2
            if (nums[midpoint] == target) return midpoint
            else if (target > nums[midpoint]) left = midpoint + 1
            else right = midpoint - 1
        }

        return -1
    }
    
}