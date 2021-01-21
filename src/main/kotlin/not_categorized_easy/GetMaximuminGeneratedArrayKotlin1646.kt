package not_categorized_easy

class GetMaximuminGeneratedArrayKotlin1646 {
    fun getMaximumGenerated(n: Int): Int {
        val nums: Array<Int> = Array(n + 1) { 0 }
        if (n < 2) {
            return n
        }
        nums[0] = 0
        nums[1] = 1
        var max = 1
        for (i in 2..n) {
            nums[i] = if (i % 2 == 0) nums[i.shr(1)] else nums[i.shr(1)] + nums[i.shr(1) + 1]
            max = maxOf(max, nums[i])
        }
        return max
    }
}