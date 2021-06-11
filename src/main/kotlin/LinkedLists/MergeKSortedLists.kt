package LinkedLists

import Node
import java.util.*

class MergeKSortedLists {

    fun mergeKLists(lists: Array<Node?>): Node? {
        val pq = PriorityQueue<Int>()
        for (i in 0..lists.size-1) {
            var head = lists[i]
            while(head != null) {
                pq.add(head.data)
                head = head.next
            }
        }

        val dummy = Node(-1)
        var head = dummy

        while(!pq.isNullOrEmpty()) {
            head.next = Node(pq.poll())
            head = head.next!!
        }
        return dummy.next
    }
}