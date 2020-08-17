package top_interview_easy.array

class RotateImageKotlin48 {
    fun rotate(matrix: Array<IntArray>) {
        val n = matrix.size

        // along the left top to right bottom diagonal line, swap symmetrical pair
        for (i in 0 until n) {
            for (j in i + 1 until n) {
                swap(matrix, i, j, j, i)
            }
        }

        // mid vertical line, swap
        for (i in 0 until n) {
            for (j in 0 until n / 2) {
                swap(matrix, i, j, i, n - 1 - j)
            }
        }
    }

    private fun swap(matrix: Array<IntArray>, x1: Int, y1: Int, x2: Int, y2: Int) {
        val temp = matrix[x1][y1]
        matrix[x1][y1] = matrix[x2][y2]
        matrix[x2][y2] = temp
    }
}