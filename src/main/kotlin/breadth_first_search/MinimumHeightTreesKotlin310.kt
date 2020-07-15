package breadth_first_search

class MinimumHeightTreesKotlin310 {
    fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
        if (n == 1) {
            return listOf(0)
        }
        if (n == 2) {
            return listOf(0, 1)
        }

        val graph: MutableMap<Int, MutableSet<Int>> = HashMap()
        edges.forEach {
            graph.computeIfAbsent(it[0]) { mutableSetOf() }.add(it[1])
            graph.computeIfAbsent(it[1]) { mutableSetOf() }.add(it[0])
        }
        while (graph.size > 2) {
            // retrieve all nodes which have one neighbor
            val currentLevel: MutableList<Int> = ArrayList()
            graph.forEach { (i, mutableSet) ->
                if (mutableSet.size == 1) {
                    currentLevel.add(i)
                }
            }
            // 1. remove it from neighbors 2. remove it
            currentLevel.forEach {
                graph[graph[it]?.iterator()?.next()]?.remove(it)
                graph.remove(it)
            }
        }
        return graph.keys.toList()
    }
}

fun main() {
    val solution = MinimumHeightTreesKotlin310()
    // 1
    solution.findMinHeightTrees(4, arrayOf(intArrayOf(1, 0), intArrayOf(1, 2), intArrayOf(1, 3))).forEach(::print)
    println()
    // 34
    solution.findMinHeightTrees(
        6, arrayOf(
            intArrayOf(3, 0),
            intArrayOf(1, 3),
            intArrayOf(2, 3),
            intArrayOf(4, 3),
            intArrayOf(5, 4)
        )
    ).forEach(::print)
    println()
    // 3
    solution.findMinHeightTrees(
        6, arrayOf(
            intArrayOf(1, 0),
            intArrayOf(0, 3),
            intArrayOf(0, 2),
            intArrayOf(4, 3),
            intArrayOf(5, 4)
        )
    ).forEach(::print)
}