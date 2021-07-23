package Trees

class SearchInABinarySearchTree {

    fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
        if (root == null) return null
        if (root.`val` == `val`) return root

        if (root.`val` < `val`) return searchBST(root.right, `val`)
        else return searchBST(root.left, `val`)
    }

}