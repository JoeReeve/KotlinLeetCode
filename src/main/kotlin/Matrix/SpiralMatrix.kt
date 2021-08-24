package Matrix

class SpiralMatrix {

    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        var list = mutableListOf<Int>()
        if (matrix.size == 0) return list

        var left = 0
        var right = matrix[0].size - 1
        var top = 0
        var bottom = matrix.size - 1
        var size = matrix.size * matrix[0].size

        while (list.size != size) {
            for (i in left..right) {
                if (list.size < size) {
                    list.add(matrix[top][i])
                }
            }
            top++
            for (i in top..bottom) {
                if (list.size < size) {
                    list.add(matrix[i][right])
                }
            }
            right--
            for (i in right downTo left) {
                if (list.size < size) {
                    list.add(matrix[bottom][i])
                }
            }
            bottom--
            for (i in bottom downTo top) {
                if (list.size < size) {
                    list.add(matrix[i][left])
                }
            }
            left++
        }
        return list
    }
    
}