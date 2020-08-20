package breadth_first_search

import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet

class JumpGameIVKotlin1345 {
    fun minJumps(arr: IntArray): Int {
        if (arr.size <= 1) {
            return 0
        }
        val graph: MutableMap<Int, MutableSet<Int>> = HashMap()
        for (index in arr.indices) {
            graph.computeIfAbsent(arr[index]) { HashSet() }.add(index)
        }
        val visited = BooleanArray(arr.size)
        val queue: Queue<Int> = LinkedList()
        queue.offer(0)
        visited[0] = true
        var level = 0
        while (queue.isNotEmpty()) {
            for (size in queue.indices) {
                val current = queue.poll()
                if (current == arr.size - 1) {
                    return level
                }
                graph[arr[current]]?.forEach {
                    if (!visited[it]) {
                        queue.offer(it)
                        visited[it] = true
                    }
                }
                graph.remove(arr[current])
                val previous = current - 1
                val next = current + 1
                if (inBound(arr, next)) {
                    if (!visited[next]) {
                        queue.offer(next)
                        visited[next] = true
                    }
                }
                if (inBound(arr, previous)) {
                    if (!visited[previous]) {
                        queue.offer(previous)
                        visited[previous] = true
                    }
                }
            }
            ++level
        }
        return -1
    }

    private fun inBound(arr: IntArray, i: Int): Boolean {
        return i >= 0 && i < arr.size
    }
}

fun main() {
    val java = JumpGameIV1345()
    // 3
    println(java.minJumps(intArrayOf(100, -23, -23, 404, 100, 23, 23, 23, 3, 404)))
}