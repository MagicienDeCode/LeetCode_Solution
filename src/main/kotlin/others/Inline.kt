package others

fun main() {
    val testList = listOf(0, 1, 2, 3, 4, 5)
    println("===========test begin==========")
    val result = testList.xiangMap { it * 2 }
    println("===========test end==========")
    result.forEach(::println)
}

/**
 * Returns a list containing the results of applying the given [transform] function
 * to each element in the original collection.
 *
 * @sample samples.collections.Collections.Transformations.map
 */
inline fun <T, R> Iterable<T>.xiangMap(transform: (T) -> R): List<R> {
    val destination = ArrayList<R>(if (this is Collection<*>) this.size else 10)
    for (item in this)
        destination.add(transform(item))
    return destination
}