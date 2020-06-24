package binary_search

class FindinMountainArrayKotlin1095 {
    fun findInMountainArray(target: Int, mountainArr: MountainArray): Int {
        val length = mountainArr.length()
        val topIndex = topIndex(length, mountainArr)
        val index0 = mountainArr.get(0)
        val topIndexVal = mountainArr.get(topIndex)
        val indexMaxVal = mountainArr.get(length - 1)
        if (target in index0..topIndexVal) {
            val result = findInAscending(mountainArr, topIndex, target)
            if (result != -1) {
                return result
            }
        }
        if (target in indexMaxVal..topIndexVal) {
            val result = findInDescending(mountainArr, topIndex, length - 1, target)
            if (result != -1) {
                return result
            }
        }
        return -1
    }

    private fun findInAscending(
        mountainArr: MountainArray,
        end: Int,
        target: Int
    ): Int {
        var left = 0
        var right = end
        while (left + 1 < right) {
            val mid = left + (right - left) / 2
            val midVal = mountainArr.get(mid)
            when {
                midVal == target -> return mid
                midVal < target -> left = mid
                else -> right = mid
            }
        }
        return when (target) {
            mountainArr.get(left) -> left
            mountainArr.get(right) -> right
            else -> -1
        }
    }

    private fun findInDescending(
        mountainArr: MountainArray,
        start: Int,
        end: Int,
        target: Int
    ): Int {
        var left = start
        var right = end
        while (left + 1 < right) {
            val mid = left + (right - left) / 2
            val midVal = mountainArr.get(mid)
            when {
                midVal == target -> return mid
                midVal > target -> left = mid
                else -> right = mid
            }
        }
        return when (target) {
            mountainArr.get(left) -> left
            mountainArr.get(right) -> right
            else -> -1
        }
    }

    private fun topIndex(
        length: Int,
        mountainArr: MountainArray
    ): Int {
        var left = 0
        var right = length
        while (left + 1 < right) {
            val mid = left + (right - left) / 2
            val midMinus1 = mountainArr.get(mid - 1)
            val midValue = mountainArr.get(mid)
            val midPlus1 = mountainArr.get(mid + 1)
            when {
                midMinus1 < midValue && midValue > midPlus1 -> return mid
                midValue in (midMinus1 + 1) until midPlus1 -> left = mid
                else -> right = mid
            }
        }
        val leftMinus1 = mountainArr.get(left - 1)
        val leftVal = mountainArr.get(left)
        val rightVal = mountainArr.get(right)
        return when {
            leftMinus1 < leftVal && leftVal > rightVal -> left
            else -> right
        }
    }

    class MountainArray {
        fun get(index: Int): Int = 5 + index
        fun length(): Int = 5
    }
}