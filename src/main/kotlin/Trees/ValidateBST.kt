package Trees

class ValidateBST {

    fun isValidBST(root: TreeNode?): Boolean {
        return validate(root, Long.MAX_VALUE, Long.MIN_VALUE)
    }

    fun validate(root: TreeNode?, max: Long, min: Long): Boolean {
        if (root == null) return true
        else if (root.`val` >= max || root.`val` <= min) return false
        else return validate(root.left, root.`val`.toLong(), min) && validate(root.right, max, root.`val`.toLong())
    }
    
}