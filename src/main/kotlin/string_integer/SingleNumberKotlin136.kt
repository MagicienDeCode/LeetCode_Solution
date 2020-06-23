package string_integer

class SingleNumberKotlin136 {
    fun singleNumber(nums: IntArray): Int = nums.reduce { acc, i -> acc.xor(i) }
}