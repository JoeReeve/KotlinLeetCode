package Trees

class TrieNode2 {
    val children = mutableMapOf<Char, TrieNode>()
    var isWord = false

    fun add(word:String, node: TrieNode) {
        var curr = node

        word.forEach {char ->
            if (!curr.children.containsKey(char)) curr.children[char] = TrieNode()
            curr = curr.children[char]!!
        }
        curr.isWord = true
    }

}

class Solution {
    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        val root = TrieNode()

        words.forEach{ word ->
            root.add(word, root)
        }

        val rows = board.size
        val cols = board[0].size
        val results = mutableSetOf<String>()
        val visited = mutableSetOf<Pair<Int,Int>>()

        fun dfs(r: Int, c: Int, node: TrieNode, word: String) {
            var curr = node
            var word = word
            if (r < 0 || c < 0 || r == rows || c == cols || !node.children.containsKey(board[r][c]) || visited.contains(Pair(r,c))) {
                return
            }
            visited.add(Pair(r,c))
            curr = curr.children[board[r][c]]!!
            word += board[r][c]
            if (curr.isWord) results.add(word)

            dfs(r + 1, c, curr, word)
            dfs(r - 1, c, curr, word)
            dfs(r, c + 1, curr, word)
            dfs(r, c - 1, curr, word)
            visited.remove(Pair(r,c))
        }

        for (r in 0..rows) {
            for (c in 0..cols) {
                dfs(r, c, root, "")
            }
        }
        return results.toList()
    }
}