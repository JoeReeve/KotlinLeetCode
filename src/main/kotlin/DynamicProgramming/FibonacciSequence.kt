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

    fun fibBottomUp(num: Int): Int {

        val memo = IntArray(num + 1)
        memo[1] = 1
        memo[2] = 1
        for (i in 3..num) {
            memo[i] = memo[i - 1] + memo[i - 2]
        }
        return memo[num]
    }
}

fun main() {

    var fib = FibonacciSequence()

    println(fib.fib(5))
    println(fib.fibBottomUp(5))
}