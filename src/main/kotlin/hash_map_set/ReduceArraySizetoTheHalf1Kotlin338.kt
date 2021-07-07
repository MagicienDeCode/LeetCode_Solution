package hash_map_set

class ReduceArraySizetoTheHalf1Kotlin338 {
    fun minSetSize(arr: IntArray): Int {
        val half = arr.size.shr(1)
        arr.toList()
                .groupingBy { it }
                .eachCount()
                .map { it.value }
                .sortedDescending()
                .reduceIndexed { index, acc, i ->
                    if (acc >= half) {
                        return index
                    }
                    acc + i
                }
        return 1
    }
}