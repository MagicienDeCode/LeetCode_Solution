package binarysearch

class TwoSumIIInputarrayissortedKotlin167 {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        if (numbers.isEmpty()) {
            return intArrayOf()
        }
        var left = 0
        var right = numbers.size - 1
        while (left + 1 < right) {
            when {
                numbers[left] + numbers[right] == target -> return intArrayOf(++left, ++right)
                numbers[left] + numbers[right] < target -> left =
                    searchWhenLessThanTarget(numbers, left, right, target)
                numbers[left] + numbers[right] > target -> right =
                    searchWhenGreaterThanTarget(numbers, left, right, target)
            }
        }
        return intArrayOf(++left, ++right)
    }

    private fun searchWhenLessThanTarget(nums: IntArray, leftVal: Int, rightVal: Int, target: Int): Int {
        var left = leftVal
        var right = rightVal
        while (left + 1 < right) {
            val mid = left + (right - left) / 2
            when {
                nums[mid] + nums[rightVal] == target -> return mid
                nums[mid] + nums[rightVal] < target -> left = mid
                nums[mid] + nums[rightVal] > target -> right = mid
            }
        }
        return when {
            nums[left] + nums[rightVal] >= target -> left
            nums[right] + nums[rightVal] >= target -> right
            else -> -1
        }
    }

    private fun searchWhenGreaterThanTarget(nums: IntArray, leftVal: Int, rightVal: Int, target: Int): Int {
        var left = leftVal
        var right = rightVal
        while (left + 1 < right) {
            val mid = left + (right - left) / 2
            when {
                nums[mid] + nums[leftVal] == target -> return mid
                nums[mid] + nums[leftVal] < target -> left = mid
                nums[mid] + nums[leftVal] > target -> right = mid
            }
        }
        return when {
            nums[left] + nums[leftVal] <= target -> left
            nums[right] + nums[leftVal] <= target -> right
            else -> -1
        }
    }

    /*   O(n)
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        if (numbers.isEmpty()) {
            return intArrayOf()
        }
        var left = 0
        var right = numbers.size - 1
        while (left + 1 < right) {
            val aim = target - numbers[left] - numbers[right]
            when {
                aim == 0 -> return intArrayOf(left + 1, right + 1)
                aim > 0 -> left += 1
                aim < 0 -> right -= 1
            }
        }
        return intArrayOf(left + 1, right + 1)
    }
     */
}