package LinkedLists
import LinkedList
import Node

class MergeTwoSortedLists {

    fun mergeTwoLists(l1: Node?, l2: Node?): Node? {
        var curr1 = l1
        var curr2 = l2
        val head = Node(0)
        var curr3 = head


        while(true) {
            if (curr1 == null && curr2 == null) break
            if (curr1 == null) {
                curr3.next = curr2
                break
            }
            if (curr2 == null) {
                curr3.next = curr1
                break
            }
            if (curr1.data <= curr2.data) {
                curr3.next = curr1
                curr1 = curr1.next
                curr3 = curr3.next!!
            } else {
                curr3.next = curr2
                curr2 = curr2.next
                curr3 = curr3.next!!
            }
        }
        return head.next
    }

}