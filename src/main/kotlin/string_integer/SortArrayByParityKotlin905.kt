package string_integer

class SortArrayByParityKotlin905 {
    fun sortArrayByParity(nums: IntArray): IntArray {
        var lastNonZeroIndex = 0
        for (index in nums.indices) {
            if (nums[index] % 2 == 0) {
                if (index != lastNonZeroIndex) {
                    val temp = nums[index]
                    nums[index] = nums[lastNonZeroIndex]
                    nums[lastNonZeroIndex] = temp
                }
                ++lastNonZeroIndex
            }
        }
        return nums
    }
}