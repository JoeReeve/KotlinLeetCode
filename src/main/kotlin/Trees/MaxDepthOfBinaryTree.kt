package Trees

class MaxDepthOfBinaryTree {

    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0

        var left = maxDepth(root.left)
        var right = maxDepth(root.right)
        return maxOf(left, right) + 1
    }

}