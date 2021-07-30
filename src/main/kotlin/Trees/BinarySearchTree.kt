package Trees

import com.sun.source.tree.Tree
import java.util.*

class BinarySearchTree(var root: TreeNode) {

    fun insert(node: TreeNode) {
        if (root == null) root = node
        var curr = node
        while (true) {
            if (node.`val` < curr.`val`) {
                if (curr.left == null) {
                    curr.left = node
                    return
                } else curr = curr.left!!
            } else {
                if (curr.right == null) {
                    curr.right = node
                    return
                } else curr = curr.right!!
            }
        }
    }
    
    fun interativeSearch(value: Int):TreeNode? {
        if (root == null) return null
        var curr = root
        while (curr != null) {
            if (value < curr.`val`) curr = curr.left!!
            else if (value > curr.`val`) curr = curr.right!!
            else return curr
        }
        return root
    }

    fun recursiveSearch(root: TreeNode?, `val`: Int): TreeNode? {
        if (root == null) return null
        if (root.`val` == `val`) return root

        if (root.`val` < `val`) return recursiveSearch(root.right, `val`)
        else return recursiveSearch(root.left, `val`)
    }

    fun breadthFirstSearch(): List<Int> {
        var curr = root
        var list = mutableListOf<Int>()
        var queue = LinkedList<TreeNode>()
        queue.add(curr)

        while (queue.size > 0) {
            curr = queue.removeFirst()
            list.add(curr.`val`)
            if (curr.left != null) queue.add(curr.left!!)
            if (curr.right != null) queue.add(curr.right!!)
        }
        return list
    }

    fun breadthFirstSearchR(queue: LinkedList<TreeNode>, list: MutableList<Int>): List<Int> {
        if (queue.size == 0) return list
        var curr = queue.removeFirst()
        list.add(curr.`val`)
        if (curr.left != null) queue.add(curr.left!!)
        if (curr.right != null) queue.add(curr.right!!)

        return breadthFirstSearchR(queue, list)
    }

    fun DFSPreOrder(node: TreeNode, list: MutableList<Int>): List<Int> {
        list.add(node.`val`)
        if (node.left != null) DFSInOrder(node.left!!, list)
        if (node.right != null) DFSInOrder(node.right!!, list)
        return list
    }

    fun DFSInOrder(node: TreeNode, list: MutableList<Int>): List<Int> {
        if (node.left != null) DFSInOrder(node.left!!, list)
        list.add(node.`val`)
        if (node.right != null) DFSInOrder(node.right!!, list)
        return list
    }

    fun DFSPostOrder(node: TreeNode, list: MutableList<Int>): List<Int> {
        if (node.left != null) DFSInOrder(node.left!!, list)
        if (node.right != null) DFSInOrder(node.right!!, list)
        list.add(node.`val`)
        return list
    }

}