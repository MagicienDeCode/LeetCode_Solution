package binarysearch

class MaximumSideLengthofaSquarewithSumLessthanorEqualtoThresholdKotlin1292 {
    fun maxSideLength(mat: Array<IntArray>, threshold: Int): Int {
        val dynamicProgramming = Array(mat.size + 1) { IntArray(mat[0].size + 1) { 0 } }
        for (row in 1 until dynamicProgramming.size) {
            for (column in 1 until dynamicProgramming[0].size) {
                dynamicProgramming[row][column] =
                    dynamicProgramming[row - 1][column] +
                            dynamicProgramming[row][column - 1] -
                            dynamicProgramming[row - 1][column - 1] +
                            mat[row - 1][column - 1]
            }
        }

        var left = 0
        var right = minOf(mat.size, mat[0].size)
        while (left + 1 < right) {
            val mid = left + (right - left).shr(1)
            when {
                isValidSide(dynamicProgramming, mid, threshold) -> left = mid
                else -> right = mid
            }
        }

        return when {
            isValidSide(dynamicProgramming, right, threshold) -> right
            else -> left
        }
    }

    private fun isValidSide(dynamicProgramming: Array<IntArray>, side: Int, threshold: Int): Boolean {
        for (row in side until dynamicProgramming.size) {
            for (column in side until dynamicProgramming[0].size) {
                if (dynamicProgramming[row][column] -
                    dynamicProgramming[row - side][column] -
                    dynamicProgramming[row][column - side] +
                    dynamicProgramming[row - side][column - side] <= threshold
                ) {
                    return true
                }
            }
        }
        return false
    }
}

fun main() {
    val solution = MaximumSideLengthofaSquarewithSumLessthanorEqualtoThresholdKotlin1292()
    val mat = Array(3) {
        intArrayOf(1, 1, 3, 2, 4, 3, 2)
        intArrayOf(1, 1, 3, 2, 4, 3, 2)
        intArrayOf(1, 1, 3, 2, 4, 3, 2)
    }
    println(solution.maxSideLength(mat, 4)) // 2
}