package binary_search

class FindKClosestElementsKotlin658 {
    fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
        val index = search(arr, k, x)
        return arr.slice(IntRange(index, index + k - 1))
    }

    fun search(nums: IntArray, k: Int, target: Int): Int {
        var left = 0
        var right = nums.size - k
        while (left + 1 < right) {
            val mid = left + (right - left) / 2
            val diff = target - nums[mid] - (nums[mid + k - 1] - target)
            when {
                // diff == 0 -> return mid
                diff > 0 -> left = mid
                else -> right = mid
            }
        }
        return when {
            target - nums[left] <= nums[right + k - 1] - target -> left
            else -> right
        }
    }

    /*
    fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
        return when {
            x < arr[0] -> {
                arr.slice(IntRange(0, k - 1))
            }
            x > arr[arr.size - 1] -> {
                arr.slice(IntRange(arr.size - k, arr.size - 1))
            }
            else -> {
                var startIndex = search(arr, x)
                var endIndex = startIndex
                var count = k - 1
                while (count > 0) {
                    count--
                    if (endIndex == arr.size - 1 ||
                        (startIndex > 0 &&
                                x - arr[startIndex - 1] <= arr[endIndex + 1] - x)
                    ) {
                        startIndex--
                    } else {
                        endIndex++
                    }
                }
                arr.slice(IntRange(startIndex, endIndex))
            }
        }
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
        return if (target - nums[left] <= nums[right] - target) left else right
    }
     */
}

fun main() {
    val solution = FindKClosestElementsKotlin658()
    println(solution.findClosestElements(intArrayOf(0, 2, 2, 3, 4, 6, 7, 8, 9, 9), 4, 5)) // 3467
    println(solution.findClosestElements(intArrayOf(1, 1, 1, 10, 10, 10), 1, 9)) // 10
    println(solution.findClosestElements(intArrayOf(0, 0, 1, 2, 3, 3, 4, 7, 7, 8), 3, 5)) // 334
    println(solution.findClosestElements(intArrayOf(1, 2, 3, 4, 5), 4, 10)) // 2345
    println(solution.findClosestElements(intArrayOf(1, 1, 2, 3, 3, 3, 4, 6, 8, 8), 6, 1)) // 11
    println(solution.findClosestElements(intArrayOf(1, 2, 3, 4, 5), 4, 3))
    println(solution.findClosestElements(intArrayOf(1, 2, 3, 4, 5), 4, -1))
}