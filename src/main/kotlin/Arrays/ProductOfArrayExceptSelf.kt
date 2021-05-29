package Arrays

class SolutionDivison {
    fun productExceptSelf(nums: IntArray): IntArray {
        var product: Int = 0
        val answer = mutableListOf<Int>()
        var zeroes = 0

        for (num in nums) {
            if(num == 0) {
                zeroes += 1
            } else if(product == 0) product = num
            else product = product * num
        }
        for (num in nums) {
            if (zeroes == 0) answer.add(product/num)
            else if (zeroes == 1) {
                if (num == 0) answer.add(product)
                else answer.add(0)
            }
            else answer.add(0)
        }

        return answer.toIntArray()
    }
}

class SolutionReverseList {
    fun productExceptSelf(nums: IntArray): IntArray {
        var front = mutableListOf<Int>()
        var back = mutableListOf<Int>()
        var product = 1
        var answer = mutableListOf<Int>()

        for (num in nums) {
            front.add(product)
            product = product * num
        }

        product = 1

        nums.reversed().forEach { num ->
            back.add(product)
            product = product * num
        }
        nums.forEachIndexed { index, num ->
            answer.add(front[index] * back[nums.size-index-1])
        }
        return answer.toIntArray()
    }
}

class SolutionReverseListNoSpace {
    fun productExceptSelf(nums: IntArray): IntArray {
        var product = 1
        var answer = mutableListOf<Int>()

        for (num in nums) {
            answer.add(product)
            product = product * num
        }

        product = 1

        for (i in nums.size-1 downTo 0) {
            answer[i] *= product
            product = product * nums[i]
        }

        return answer.toIntArray()
    }
}