package Trees

class WordDictionary() {

    val root = TrieNode()


    fun addWord(word: String) {
        var curr = root
        word.forEach {char ->
            if (!curr.children.containsKey(char)) curr.children[char] = TrieNode()
            curr = curr.children[char]!!
        }
        curr.endOfWord = true
    }

    fun search(word: String): Boolean {
        return dfs(0, root, word)
    }

    fun dfs(index: Int, node: TrieNode, word: String): Boolean {
        var curr = node

        for (idx in index..word.length - 1) {
            var char = word[idx]
            if (char == '.') {
                for (value in curr.children.values) {
                    if (dfs(idx + 1, value, word)) return true
                }
                return false
            } else {
                if (!curr.children.containsKey(char)) return false
                curr = curr.children[char]!!
            }
        }
        return curr.endOfWord
    }
}
