package Matrix

class RotateImage {

    fun rotate(matrix: Array<IntArray>): Unit {
        var size = matrix.size
        for (i in 0 until size) {
            for (j in i until size) {
                var temp = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = temp
            }
        }

        for (i in 0 until size) {
            for (j in 0 until (size / 2)) {
                var temp = matrix[i][j]
                matrix[i][j] = matrix[i][size - 1 - j]
                matrix[i][size - 1 - j] = temp
            }
        }
    }

    //this function doesn't work in the case that you want to move a negative number into another negatives spot
//    fun rotate(matrix: Array<IntArray>): Unit {
//        var length = matrix[0].size - 1
//        for (row in 0..length) {
//            for (col in 0..length) {
//                if (matrix[row][col] >= 0) {
//                    if (matrix[row][col] <= 1000) {
//                        matrix[col][length - row] += matrix[row][col] * 10000
//                    } else {
//                        var num = matrix[row][col] % 10000
//                        matrix[col][length - row] += num * 10000
//                    }
//                } else {
//                    if (matrix[row][col] >= -1000) {
//                        matrix[col][length - row] = (matrix[col][length - row] - matrix[row][col]) * -10000
//                    } else {
//                        var num = (-1 * matrix[row][col]) % 10000
//                        matrix[col][length - row] += num * -10000
//                    }
//                }
//            }
//        }
//        for (row in 0..length) {
//            for (col in 0..length) {
//                if (matrix[row][col] >= 0) {
//                    matrix[row][col] = (matrix[row][col] - matrix[row][col] % 10000) / 10000
//                } else {
//                    matrix[row][col] *= -1
//                    matrix[row][col] = (matrix[row][col] - matrix[row][col] % 10000) / 10000
//                    matrix[row][col] *= -1
//                }
//            }
//        }
//    }
}