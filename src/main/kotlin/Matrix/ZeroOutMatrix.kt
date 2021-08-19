package Matrix

import java.security.KeyStore

class ZeroOutMatrix {

    fun setZeroes(matrix: Array<IntArray>): Unit {
        for (i in 0 until matrix.size) {
            for (j in 0 until matrix[0].size) {
                if (matrix[i][j] == 0) {
                    helper(matrix, i, j)
                }
            }
        }
        for (i in 0 until matrix.size) {
            for (j in 0 until matrix[0].size) {
                if (matrix[i][j] == Integer.MAX_VALUE + 2) {
                    matrix[i][j] = 0
                }
            }
        }
    }

    fun helper(matrix: Array<IntArray>, row: Int, col: Int) {
        //setting the row to 0
        for (i in 0 until matrix[0].size) {
            if (matrix[row][i] != 0) {
                matrix[row][i] = Integer.MAX_VALUE + 2
            }
        }
        //setting the column to 0
        for (i in 0 until matrix.size) {
            if (matrix[i][col] != 0) {
                matrix[i][col] = Integer.MAX_VALUE + 2
            }
        }
    }

    fun setZeroes2(matrix: Array<IntArray>): Unit {
        val ROW = matrix.size
        val COL = matrix[0].size
        var rowZero = false

        for (r in 0 until ROW) {
            for (c in 0 until COL) {
                if (matrix[r][c] == 0) {
                    matrix[0][c] = 0
                    if (r > 0) {
                        matrix[r][0] = 0
                    } else rowZero = true
                }
            }
        }

        for (r in 1 until ROW) {
            for (c in 1 until COL) {
                if (matrix[0][c] == 0 || matrix[r][0] == 0) matrix[r][c] = 0
            }
        }

        if (matrix[0][0] == 0) {
            for (r in 0 until ROW) {
                matrix[r][0] = 0
            }
        }

        if (rowZero) {
            for (c in 0 until COL) {
                matrix[0][c] = 0
            }
        }
    }
}