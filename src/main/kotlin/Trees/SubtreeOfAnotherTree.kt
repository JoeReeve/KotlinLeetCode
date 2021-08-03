package Trees

class SubtreeOfAnotherTree {

    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if (root == null) return false
        else if (isSameTree(root, subRoot)) return true
        else return isSubtree(root?.left, subRoot) || isSubtree(root?.right, subRoot)
    }

    fun isSameTree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if (root == null) return root == null && subRoot == null
        else if (root?.`val` == subRoot?.`val`) {
            return isSameTree(root?.left, subRoot?.left) && isSameTree(root?.right,         subRoot?.right)
        }
        else return false
    }
    
}