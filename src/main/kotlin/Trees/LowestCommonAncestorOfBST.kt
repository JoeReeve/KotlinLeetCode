package Trees

class LowestCommonAncestorOfBST {

    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (p!!.`val` < root!!.`val` && q!!.`val` < root!!.`val`) return lowestCommonAncestor(root!!.left, p, q)
        else if (p!!.`val` > root!!.`val` && q!!.`val` > root!!.`val`) return lowestCommonAncestor(root!!.right, p, q)
        else return root
    }
    
}