package Arrays

class ContainerWithMaxWater {

    fun maxArea(height: IntArray): Int {
        var maxWater: Int = minOf(height[0], height[height.size-1]) * (height.size-1)

        var currentWater: Int = 0
        var left: Int = 0
        var right: Int = height.size-1

        while (left < right) {
            currentWater = minOf(height[left], height[right]) * (right - left)
            maxWater = maxOf(currentWater, maxWater)
            if (height[left] > height[right]) right--
            else left++
        }
        return maxWater
    }

}