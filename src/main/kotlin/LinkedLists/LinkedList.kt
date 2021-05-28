class LinkedListPractice(var head: Node? = null) {

    fun add(data: String) {
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

    fun get(index: Int): String {
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

    fun display(): List<String> {
        var curr = head
        var list = mutableListOf<String>()
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
}

    data class Node(val data: String, var next: Node? = null)