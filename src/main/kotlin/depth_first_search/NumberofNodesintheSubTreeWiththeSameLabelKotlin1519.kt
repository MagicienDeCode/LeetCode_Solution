package depth_first_search

class NumberofNodesintheSubTreeWiththeSameLabelKotlin1519 {
    fun countSubTrees(n: Int, edges: Array<IntArray>, labels: String): IntArray {
        val graph: MutableMap<Int, MutableList<Int>> = HashMap()
        edges.forEach {
            graph.computeIfAbsent(it[0]) { ArrayList() }.add(it[1])
            graph.computeIfAbsent(it[1]) { ArrayList() }.add(it[0])
        }
        val result = IntArray(n)
        val value = IntArray(26)
        dfs(graph, result, value, 0, -99, labels)
        return result
    }

    private fun dfs(
        graph: MutableMap<Int, MutableList<Int>>,
        result: IntArray,
        value: IntArray,
        current: Int,
        previous: Int,
        labels: String
    ) {
        val currentIndex = labels[current] - 'a'
        ++value[currentIndex]
        val currentValue = value[currentIndex]
        graph[current]?.forEach {
            if (it != previous) {
                dfs(graph, result, value, it, current, labels)
            }
        }
        result[current] = value[currentIndex] - currentValue + 1
    }
    /*
    // time limit exceeded
    fun countSubTrees(n: Int, edges: Array<IntArray>, labels: String): IntArray {
        val graph: MutableMap<Int, MutableList<Int>> = HashMap()
        edges.forEach {
            graph.computeIfAbsent(it[0]) { ArrayList() }.add(it[1])
            graph.computeIfAbsent(it[1]) { ArrayList() }.add(it[0])
        }
        val result = IntArray(n)
        val unionFind = IntArray(n)
        for (index in unionFind.indices) {
            unionFind[index] = index
        }
        val queue: Queue<Int> = LinkedList()
        val visited: MutableSet<Int> = HashSet()
        queue.offer(0)
        visited.add(0)
        var index = 0
        while (queue.isNotEmpty()) {
            val current = queue.poll()
            val currentChar = labels[current]
            var uf = unionFind[current]
            ++result[current]
            while (unionFind[uf] != uf) {
                if (currentChar == labels[uf]) {
                    ++result[uf]
                }
                uf = unionFind[uf]
            }
            if (current != 0 && currentChar == labels[0]) {
                ++result[0]
            }
            ++index
            graph[current]?.forEach {
                if (!visited.contains(it)) {
                    queue.offer(it)
                    visited.add(it)
                    unionFind[it] = current
                }
            }
        }
        return result
    }
     */
}

fun main() {
    val solution = NumberofNodesintheSubTreeWiththeSameLabelKotlin1519()
    // 4 2 1 1
    solution.countSubTrees(
        4,
        arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(0, 3)), "bbbb"
    ).forEach(::print)
}