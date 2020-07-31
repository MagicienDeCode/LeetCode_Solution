package breadth_first_search

import java.util.*
import kotlin.collections.HashSet

class KSimilarStringsKotlin854 {
    fun kSimilarity(A: String, B: String): Int {
        val visited: MutableSet<String> = HashSet()
        val queue: Queue<String> = LinkedList()
        queue.offer(A)
        visited.add(A)
        var level = 0
        while (queue.isNotEmpty()) {
            for (size in queue.indices) {
                val current = queue.poll()
                if (current == B) {
                    return level
                }
                for (next in getNexts(current, B)) {
                    if (!visited.contains(next)) {
                        queue.offer(next)
                        visited.add(next)
                    }
                }
                /*
                for (i in 0..current.length - 2) {
                    for (j in i + 1 until current.length) {
                        val newSb = StringBuilder(current)
                        val temp = current[i]
                        newSb.setCharAt(i, current[j])
                        newSb.setCharAt(j, temp)
                        val newString = newSb.toString()
                        if (!visited.contains(newString)) {
                            queue.offer(newString)
                            visited.add(newString)
                        }
                    }
                }
                 */
            }
            ++level
        }
        return -1
    }

    private fun getNexts(current: String, target: String): List<String> {
        val results: MutableList<String> = LinkedList()
        var i = 0
        while (i < target.length && current[i] == target[i]) {
            ++i
        }
        for (j in i + 1 until target.length) {
            if (target[j] == current[i]) {
                val newSb = StringBuilder(current)
                val temp = current[i]
                newSb.setCharAt(i, current[j])
                newSb.setCharAt(j, temp)
                results.add(newSb.toString())
            }
        }
        return results
    }
}

fun main() {
    val solution = KSimilarStringsKotlin854()
    println(solution.kSimilarity("abc", "bca"))
    println(solution.kSimilarity("abac", "baca"))
    println(solution.kSimilarity("abccaacceecdeea", "bcaacceeccdeaae"))
}