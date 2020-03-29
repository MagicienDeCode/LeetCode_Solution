package binarysearch

class TheKWeakestRowsinaMatrixKotlin1337 {
    fun kWeakestRows(mat: Array<IntArray>, k: Int): IntArray {
        val resultList = mutableListOf<Pair<Int, Int>>()
        mat.forEachIndexed { index, ints ->
            resultList.add(Pair(index, ints.sum()))
        }
        resultList.sortBy { it.second }
        return resultList.subList(0, k).map { it.first }.toIntArray()
    }

    private fun search(nums: IntArray): Int {
        var left = 0
        var right = nums.size - 1
        while (left + 1 < right) {
            val mid = left + (right - left) / 2
            when {
                nums[mid] == 1 -> left = mid
                nums[mid] == 0 -> right = mid
            }
        }
        return when {
            nums[right] == 1 -> right + 1
            nums[left] == 1 -> right
            else -> 0
        }
    }
}