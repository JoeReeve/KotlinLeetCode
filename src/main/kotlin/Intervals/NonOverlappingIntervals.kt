package Intervals

class NonOverlappingIntervals {

    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        var intervals = intervals.sortedBy{it[0]}
        var count = 0
        var left = 0
        var right = 1

        while (right < intervals.size) {
            if (intervals[left][1] <= intervals[right][0]) {
                left = right
                right++
            } else if (intervals[left][1] <= intervals[right][1]) {
                count++
                right++
            } else if (intervals[left][1] > intervals[right][1]) {
                left = right
                right++
                count++
            }
        }
        return count
    }

}