package breadth_first_search

import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet

class GetWatchedVideosbyYourFriendsKotlin1311 {
    fun watchedVideosByFriends(
        watchedVideos: List<List<String>>,
        friends: Array<IntArray>,
        id: Int,
        level: Int
    ): List<String> {
        val queue: Queue<Int> = LinkedList()
        val visited: MutableSet<Int> = HashSet()
        queue.offer(id)
        visited.add(id)

        val map: MutableMap<String, Int> = HashMap()

        var count = 0
        while (queue.isNotEmpty()) {
            if (count == level) {
                while (queue.isNotEmpty()) {
                    val current = queue.poll()
                    watchedVideos[current].forEach {
                        map[it] = 1 + map.getOrDefault(it, 0)
                    }
                }
            } else {
                for (size in queue.indices) {
                    val current = queue.poll()
                    friends[current].forEach {
                        if (!visited.contains(it)) {
                            queue.offer(it)
                            visited.add(it)
                        }
                    }
                }
                ++count
            }
        }

        return map.toList().sortedWith(Comparator { p1, p2 ->
            if (p1.second == p2.second) {
                compareValues(p1.first, p2.first)
            } else {
                compareValues(p1.second, p2.second)
            }
        }).map { it.first }
    }
}

fun main() {
    val solution = GetWatchedVideosbyYourFriendsKotlin1311()
    // B C
    solution.watchedVideosByFriends(
        listOf(listOf("A", "B"), listOf("C"), listOf("B", "C"), listOf("D")),
        arrayOf(intArrayOf(1, 2), intArrayOf(0, 3), intArrayOf(0, 3), intArrayOf(1, 2)),
        0,
        1
    ).forEach(::print)
    println()
    // D
    solution.watchedVideosByFriends(
        listOf(listOf("A", "B"), listOf("C"), listOf("B", "C"), listOf("D")),
        arrayOf(intArrayOf(1, 2), intArrayOf(0, 3), intArrayOf(0, 3), intArrayOf(1, 2)),
        0,
        2
    ).forEach(::print)
    println()
    solution.watchedVideosByFriends(
        listOf(listOf("xk", "qvgjjsp", "sbphxzm"), listOf("rwyvxl", "ov")),
        arrayOf(intArrayOf(1, 0)),
        0,
        1
    ).forEach(::print)
}