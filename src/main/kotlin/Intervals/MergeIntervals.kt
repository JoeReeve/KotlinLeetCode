package Intervals

class MergeIntervals {

    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        var result = mutableListOf<IntArray>()
        var intervals = intervals.sortedBy {it[0]}
        var newInterval = intervals[0]

        for (i in 0 until intervals.size - 1) {
            if (newInterval[1] >= intervals[i + 1][0]) {
                var min = minOf(newInterval[0], intervals[i+1][0])
                var max = maxOf(newInterval[1], intervals[i+1][1])
                newInterval[0] = min
                newInterval[1] = max
            } else {
                result.add(newInterval)
                newInterval = intervals[i+1]
            }
        }
        result.add(newInterval)
        return result.toTypedArray()
    }
    
}