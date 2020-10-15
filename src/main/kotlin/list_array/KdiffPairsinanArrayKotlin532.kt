package list_array

class KdiffPairsinanArrayKotlin532 {

    fun findPairs(nums: IntArray, k: Int): Int {
        val map = HashMap<Int, Int>()
        for (n in nums) {
            map[n] = map.getOrDefault(n, 0) + 1
        }
        var result = 0
        if (k == 0) {
            for (n in map.values) {
                result += if (n > 1) 1 else 0
            }
        } else {
            for (n in map.keys) {
                if (map.containsKey(n + k)) {
                    ++result
                }
            }
        }
        return result
    }
}