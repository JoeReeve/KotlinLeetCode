package Arrays

class MaxProductSubarray {

    fun maxProduct(nums: IntArray): Int {
        var currentProduct: Int = 1
        var currentProductHold: Int = 1
        var maxProduct: Int = Int.MIN_VALUE
        var minimumProduct: Int = 1

        for (num in nums) {
            currentProductHold = currentProduct
            currentProduct = maxOf(num, currentProductHold * num, num * minimumProduct)
            minimumProduct = minOf(num, currentProductHold * num, num * minimumProduct)
            maxProduct = maxOf(currentProduct, maxProduct)
        }
        return maxProduct
    }
    
}