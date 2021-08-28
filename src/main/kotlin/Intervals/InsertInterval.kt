package Intervals

class InsertInterval {

    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        var result = mutableListOf<IntArray>()
        var newInterval = newInterval

        for (i in 0 until intervals.size) {
            if (newInterval[1] < intervals[i][0]) {
                result.add(newInterval)
                for (j in i until intervals.size) result.add(intervals[j])
                return result.toTypedArray()
            }
            else if (newInterval[0] > intervals[i][1]) {
                result.add(intervals[i])
            } else {
                var min = minOf(newInterval[0], intervals[i][0])
                var max = maxOf(newInterval[1], intervals[i][1])
                newInterval = IntArray(2)
                newInterval.set(0, min)
                newInterval.set(1, max)
            }
        }
        result.add(newInterval)
        return result.toTypedArray()
    }

}