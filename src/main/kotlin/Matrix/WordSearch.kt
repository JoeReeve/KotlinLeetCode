package Matrix

class WordSearch {

    fun exist(board: Array<CharArray>, word: String): Boolean {
        for (i in 0..board.size - 1) {
            for (j in 0..board[0].size - 1) {
                if (board[i][j] == word[0] && DFS(board, i, j, 0, word)) return true
            }
        }
        return false
    }

    fun DFS(board: Array<CharArray>, i: Int, j: Int, count: Int, word: String): Boolean {
        if (word.length == count) return true
        if (i < 0 || i >= board.size || j < 0 || j >= board[0].size || board[i][j] != word[count]) return false

        var temp = board[i][j]
        board[i][j] = ' '
        var found = DFS(board, i + 1, j, count + 1, word)
                || DFS(board, i - 1, j, count + 1, word)
                || DFS(board, i, j + 1, count + 1, word)
                || DFS(board, i, j - 1, count + 1, word)

        board[i][j] = temp
        return found
    }
    
}