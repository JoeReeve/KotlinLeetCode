package LinkedLists

import Node

class ReorderList {

    /**
     * This class will take in a list and then reorder it so that L0 -> l1 -> lN-1 ->lN
     * becomes L0 -> LN -> L1 - LN-1 ...
     */

    fun reorderList(head: Node?) {
        if (head == null || head.next == null) return
        val l1: Node = head
        var slow = head
        var fast = head
        var prev: Node? = null
        while (fast != null && fast.next != null) {
            prev = slow
            slow = slow!!.next
            fast = fast.next!!.next
        }
        prev!!.next = null
        val l2 = reverse(slow)
        merge(l1, l2)
    }

    fun reverse(head: Node?): Node? {
        var prev: Node? = null
        var curr = head
        var next = head
        while (curr != null) {
            next = curr.next
            curr.next = prev
            prev = curr
            curr = next
        }
        return prev
    }

    fun merge(l1: Node?, l2: Node?) {
        var l1 = l1
        var l2 = l2
        while (l1 != null) {
            val next1 = l1.next
            val next2 = l2!!.next
            l1.next = l2
            if (next1 == null) break
            l2.next = next1
            l1 = next1
            l2 = next2
        }
    }

}