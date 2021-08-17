package Arrays

class TopKFrequentElements {

    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        var map = mutableMapOf<Int, Int>()
        nums.forEach{ num ->
            if (map.containsKey(num)) map[num] = map.getValue(num) + 1
            else map.put(num, 1)
        }
        var countArray = Array<MutableList<Int>>(nums.size){mutableListOf()}
        map.forEach {
            countArray[it.value-1].add(it.key)
        }
        var ans = mutableListOf<Int>()
        for (i in countArray.size - 1 downTo 0) {
            countArray[i].forEach {
                ans.add(it)
            }
            if (ans.size == k) return ans.toIntArray()
        }
        return ans.toIntArray()
    }
    
}