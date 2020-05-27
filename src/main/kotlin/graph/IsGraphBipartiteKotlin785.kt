package graph

import java.util.*

class IsGraphBipartiteKotlin785 {
    fun isBipartite(graph: Array<IntArray>): Boolean {
        val nArray = IntArray(graph.size)
        Arrays.fill(nArray, 7)
        for (index in nArray.indices) {
            if (nArray[index] == 7) {
                val queue: Queue<Int> = LinkedList()
                nArray[index] = 1
                queue.offer(index)
                while (queue.isNotEmpty()) {
                    val current = queue.poll()
                    graph[current].forEach {
                        when {
                            nArray[it] == nArray[current] -> return false
                            nArray[it] == 7 -> {
                                nArray[it] = -nArray[current]
                                queue.offer(it)
                            }
                        }
                    }
                }
            }
        }
        return true
    }
    /*
    fun isBipartite(graph: Array<IntArray>): Boolean {
        val hashArray = IntArray(graph.size)
        for (index in hashArray.indices) {
            hashArray[index] = index
        }
        for (index in hashArray.indices) {
            if (graph[index].isNotEmpty()) {
                val currentHash = hash(hashArray, index)
                val dislikeList = graph[index]
                val first = hash(hashArray, dislikeList[0])
                if (currentHash == first) {
                    return false
                }
                for (d in 1 until dislikeList.size) {
                    val dislikeHash = hash(hashArray, dislikeList[d])
                    if (currentHash == dislikeHash) {
                        return false
                    }
                    hashArray[dislikeHash] = first
                }
            }
        }
        return true
    }

    private fun hash(hashArray: IntArray, target: Int): Int = when (target) {
        hashArray[target] -> target
        else -> hash(hashArray, hashArray[target])
    }
     */
    /*
    fun isBipartite(graph: Array<IntArray>): Boolean {
        val nArray = IntArray(graph.size)
        Arrays.fill(nArray, 7)
        for (index in nArray.indices) {
            if (nArray[index] == 7 && canNotGroup(index, 1, nArray, graph)) {
                return false
            }
        }
        return true
    }

    private fun canNotGroup(
        n: Int,
        group: Int,
        nArray: IntArray,
        dpDislikes: Array<IntArray>
    ): Boolean = !canGroup(n, group, nArray, dpDislikes)

    private fun canGroup(
        n: Int,
        group: Int,
        nArray: IntArray,
        dpDislikes: Array<IntArray>
    ): Boolean {
        nArray[n] = group
        for (index in dpDislikes[n]) {
            when {
                nArray[index] == group -> return false
                nArray[index] == 7 && canNotGroup(index, -group, nArray, dpDislikes) -> return false
            }
        }
        return true
    }
     */
}

fun main() {
    val solution = IsGraphBipartiteKotlin785()
    println(solution.isBipartite(arrayOf(intArrayOf(1, 3), intArrayOf(0, 2), intArrayOf(1, 3), intArrayOf(0, 2))))
}