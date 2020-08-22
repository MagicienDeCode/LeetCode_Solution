package string_integer

class SortArrayByParityIIKotlin922 {
    fun sortArrayByParityII(nums: IntArray): IntArray {
        var lastOdd = 1
        for (index in nums.indices step 2) {
            if (nums[index] % 2 == 1) {
                while (nums[lastOdd] % 2 != 0) {
                    lastOdd += 2
                }
                val temp = nums[index]
                nums[index] = nums[lastOdd]
                nums[lastOdd] = temp
            }
        }
        return nums
    }
}