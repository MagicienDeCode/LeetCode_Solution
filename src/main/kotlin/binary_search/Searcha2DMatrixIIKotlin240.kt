package binary_search

class Searcha2DMatrixIIKotlin240 {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        if (matrix.isNullOrEmpty() || matrix[0].isEmpty()) {
            return false
        }
        return matrix.filter { it[it.size - 1] >= target }.fold(false) { acc, ints ->
            acc.or(search(ints, target) != -1)
        }
        /*
        var result = false
        matrix.filter { it[it.size - 1] >= target }.forEach {
            if (search(it, target) != -1) {
                result = true
            }
        }
        return result
         */
    }

    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        while (left + 1 < right) {
            val mid = left + (right - left) / 2
            when {
                nums[mid] == target -> return mid
                nums[mid] < target -> left = mid
                nums[mid] > target -> right = mid
            }
        }
        return when (target) {
            nums[left] -> left
            nums[right] -> right
            else -> -1
        }
    }
    /*
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        if (matrix.isNullOrEmpty() || matrix[0].isEmpty()) {
            return false
        }
        var column = 0
        var row = matrix.size - 1
        while (column < matrix[0].size || row >= 0) {
            when {
                matrix[row][column] == target -> return true
                matrix[row][column] > target -> if (row == 0) return false else row--
                matrix[row][column] < target -> if (column == matrix[0].size - 1) return false else column++
            }
        }
        return false
    }

     */
}