package Trees

class TrieNode {
    val children: MutableMap<Char, TrieNode> = mutableMapOf()
    var endOfWord: Boolean = false
}

class Trie {
    var root = TrieNode()

    fun insert(word: String) {
        var curr = root
        word.forEach { char ->
            if (!curr.children.containsKey(char)) curr.children[char] = TrieNode()
            curr = curr.children[char]!!
        }
        curr.endOfWord = true
    }

    fun search(word: String): Boolean {
        var curr = root
        word.forEach {char ->
            if (curr.children.containsKey(char)) curr = curr.children[char]!!
            else return false
        }
        return curr.endOfWord
    }

    fun startsWith(prefix: String): Boolean {
        var curr = root
        prefix.forEach {char ->
            if (curr.children.containsKey(char)) curr = curr.children[char]!!
            else return false
        }
        return true
    }
}