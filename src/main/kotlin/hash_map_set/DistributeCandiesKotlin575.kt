package hash_map_set

import java.util.*

class DistributeCandiesKotlin575 {
    fun distributeCandies(candies: IntArray): Int {
        val set: MutableSet<Int> = HashSet()
        for (c in candies) {
            set.add(c)
        }
        return minOf(set.size, candies.size / 2)
    }
}