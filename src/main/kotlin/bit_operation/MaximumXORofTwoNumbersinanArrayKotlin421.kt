package bit_operation

class MaximumXORofTwoNumbersinanArrayKotlin421 {
    fun findMaximumXOR(nums: IntArray): Int {
        var result = 0
        var mask = 0
        for (i in 31 downTo 0) {
            mask = mask.or(1.shl(i))
            val set = HashSet<Int>()
            for (n in nums) {
                set.add(n.and(mask))
            }
            val temp = result.or(1.shl(i))
            for (it in set) {
                if (set.contains(it.xor(temp))) {
                    result = temp
                    break
                }
            }
        }
        return result
    }
}

fun main() {
    val kotlin = MaximumXORofTwoNumbersinanArrayKotlin421()
    kotlin.findMaximumXOR(intArrayOf(3, 10, 5, 25, 2, 8))
}