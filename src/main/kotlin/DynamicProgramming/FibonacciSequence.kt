package DynamicProgramming

class FibonacciSequence {

    val memo = IntArray(31)
    
    fun fib(num: Int): Int {
        if (num <= 1) return num
        if (memo[num] != 0) return memo[num]

        val result = fib(num - 1) + fib(num - 2)
        memo[num] = result
        return result
    }
}

fun main() {

    var fib = FibonacciSequence()

    println(fib.fib(5))
}