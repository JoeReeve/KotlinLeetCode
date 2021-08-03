package Trees

import java.util.*

class BinaryTreeLevelOrderTraversal {

    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) return mutableListOf<List<Int>>()
        val bigList = mutableListOf<List<Int>>()
        val queue = LinkedList<TreeNode>()
        queue.add(root)

        while (queue.size != 0) {
            val smallList = mutableListOf<Int>()
            for (i in 1..queue.size) {
                val curr = queue.removeFirst()
                smallList.add(curr!!.`val`)
                if (curr.left != null) queue.add(curr.left!!)
                if (curr.right != null) queue.add(curr.right!!)
            }
            bigList.add(smallList)
        }
        return bigList
    }

}