package Heaps

import java.util.*
import kotlin.Comparator

class FindMedianFromDataStream {

    val smaller = PriorityQueue<Int>(Comparator{ a, b -> b - a })
    val bigger = PriorityQueue<Int>()

    fun addNum(num: Int) {
        if (smaller.isEmpty() || num < smaller.peek()) smaller.offer(num)
        else bigger.offer(num)
        if (smaller.size > bigger.size + 1) bigger.offer(smaller.poll())
        else if (bigger.size > smaller.size) smaller.offer(bigger.poll())
    }

    fun findMedian(): Double {
        val even = (bigger.size + smaller.size) % 2 == 0
        return if (even) (bigger.peek() + smaller.peek()) / 2.0
        else smaller.peek().toDouble()
    }

}