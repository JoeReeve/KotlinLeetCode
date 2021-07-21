package Trees

class SameTree {

    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) return true
        else if (p == null || q == null) return false
        else if (p.`val`!= q.`val`) return false
        else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
        }
    }

}