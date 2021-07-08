class LinkedList(var head: Node? = null) {

    fun add(data: Int) {
        var newNode = Node(data)
        if (head == null) head = newNode
        else {
            var curr = head
            while (curr?.next != null) {
                curr = curr.next
            }
            curr?.next = newNode
        }
    }

    fun get(index: Int): Int {
        var curr = head
        repeat(index) {
            curr = curr?.next
        }
        return curr!!.data
    }

    fun size(): Int {
        var count = 0
        var curr = head
        while (curr != null) {
            count++
            curr = curr.next
        }
        return count
    }

    fun remove(index: Int) {
        var before = head
        repeat(index - 1) {
            before = before?.next
        }
        before?.next = before?.next?.next
    }

    fun removeNthFromEnd(head: Node?, n: Int): Node? {
        if (head?.next == null) return null

        var curr = head
        var count = 0
        while(curr != null) {
            count++
            curr = curr.next
        }

        if(n == count) return head.next

        curr = head

        repeat(count - n -1) {
            curr = curr?.next
        }
        curr?.next = curr?.next?.next
        return head
    }

    fun display(): List<Int> {
        var curr = head
        var list = mutableListOf<Int>()
        while (curr != null) {
            list.add(curr.data)
            curr = curr.next
        }
        return list
    }

    fun reverse() {
        var curr = head
        var prev: Node? = null
        var next: Node? = null
        while (curr != null) {
            next = curr.next
            curr.next = prev
            prev = curr
            curr = next
        }
        head = prev
    }

    fun hasCycle(head: Node?): Boolean {
        if (head == null) return false
        var slow:Node? = head
        var fast:Node? = head.next

        while(slow != fast) {
            if (fast == null || fast.next == null) return false

            slow = slow?.next
            fast = fast.next?.next
        }
        return true
    }

    fun hasCycle2(head: Node?): Boolean {
        var curr = head
        var pos: Int = 0 //pos isn't necessary for the problem but
                        // in a real world scenario it might be nice to have
        var indices = mutableMapOf<Node?, Int>()

        while (curr?.next != null) {
            if (indices.containsKey(curr)) return true
            indices.put(curr, pos) //again you could just put 0 in as the value
                                  // for every node but its nice to have
            pos++
            curr = curr.next
        }
        return false
    }
}

    data class Node(
        val data: Int,
        var next: Node? = null
    )