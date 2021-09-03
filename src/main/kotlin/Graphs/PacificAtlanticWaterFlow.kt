package Graphs

class PacificAtlanticWaterFlow {

    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        val ROWS = heights.size
        val COLS = heights[0].size
        val pac = mutableSetOf<Pair<Int,Int>>()
        val atl = mutableSetOf<Pair<Int,Int>>()

        fun dfs(r: Int, c: Int, visit: MutableSet<Pair<Int,Int>>, prevHeight: Int) {
            if (visit.contains(Pair(r,c)) ||
                r < 0 || c < 0 || r == ROWS || c == COLS ||
                heights[r][c] < prevHeight) {
                return
            }
            visit.add(Pair(r,c))
            dfs(r + 1, c, visit, heights[r][c])
            dfs(r - 1, c, visit, heights[r][c])
            dfs(r, c + 1, visit, heights[r][c])
            dfs(r, c - 1, visit, heights[r][c])
        }

        for (c in 0 until COLS) {
            dfs(0, c, pac, heights[0][c])
            dfs(ROWS - 1, c, atl, heights[ROWS-1][c])
        }

        for (r in 0 until ROWS) {
            dfs(r, 0, pac, heights[r][0])
            dfs(r, COLS - 1, atl, heights[r][COLS - 1])
        }
        val both = mutableListOf<List<Int>>()
        for (c in 0 until COLS) {
            for (r in 0 until ROWS) {
                if (pac.contains(Pair(r,c)) && atl.contains(Pair(r,c))) both.add(listOf(r,c))
            }
        }
        return both
    }
    
}