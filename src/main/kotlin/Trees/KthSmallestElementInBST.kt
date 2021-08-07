package Trees

class KthSmallestElementInBST {

    fun kthSmallest(root: TreeNode?, k: Int): Int {
        var answer = DFS(root, mutableListOf<Int>())
        return answer[k-1]
    }

    fun DFS(node: TreeNode?, list: MutableList<Int>): List<Int> {
        if (node == null) return list
        if (node.left != null) DFS(node.left, list)
        list.add(node.`val`)
        if (node.right != null) DFS(node.right, list)
        return list
    }

}