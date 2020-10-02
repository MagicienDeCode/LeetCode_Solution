package string_integer

class FirstMissingPositiveKotlin41 {
    fun firstMissingPositive(nums: IntArray): Int {
        val set = HashSet<Int>()
        for (n in nums) {
            set.add(n)
        }
        var result = 1
        while (true) {
            if (set.contains(result)) {
                ++result
            } else {
                return result
            }
        }
    }
}
