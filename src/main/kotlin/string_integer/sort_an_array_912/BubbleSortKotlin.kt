package array.sort_an_array_912

class BubbleSortKotlin {
    fun sortArray(nums: IntArray): IntArray {
        // Time Limit Exceeded
        /*
        a = a ^ b
        b = a ^ b
        a = a ^ b
         */
        for (i in nums.indices) {
            for (j in 0 until nums.size - 1 - i) {
                if (nums[j] > nums[j + 1]) {
                    nums[j] = nums[j].xor(nums[j + 1])
                    nums[j + 1] = nums[j].xor(nums[j + 1])
                    nums[j] = nums[j].xor(nums[j + 1])
                }
            }
        }
        return nums
    }
}