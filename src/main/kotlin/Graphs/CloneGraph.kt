package Graphs

class CloneGraph {

    fun cloneGraph(node: GraphNode?): GraphNode? {
        if (node == null) return null
        var oldToNew = mutableMapOf<GraphNode?, GraphNode?>()

        fun dfs(node: GraphNode?): GraphNode? {
            if (oldToNew.containsKey(node)) return oldToNew[node]

            var copy = GraphNode(node!!.`val`)
            oldToNew.put(node, copy)
            for (nei in node.neighbors) {
                copy.neighbors.add(dfs(nei))
            }
            return copy
        }
        return dfs(node)
    }

}