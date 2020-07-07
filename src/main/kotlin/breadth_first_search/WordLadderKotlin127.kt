package breadth_first_search

import java.util.*

class WordLadderKotlin127 {
    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        val wordSet: MutableSet<String> = wordList.toHashSet()
        if (!wordSet.contains(endWord)) {
            return 0
        }
        var count = 1
        val queue: Queue<String> = LinkedList()
        queue.offer(beginWord)
        while (queue.isNotEmpty()) {
            for (times in 0 until queue.size) {
                val currentString = queue.poll()
                if (currentString == endWord) {
                    return count
                }
                for (index in currentString.indices) {
                    val str = StringBuilder(currentString)
                    for (char in 'a'..'z') {
                        str.setCharAt(index, char)
                        val new = str.toString()
                        if (wordSet.contains(new) && new != currentString) {
                            queue.offer(new)
                            wordSet.remove(new)
                        }
                    }
                }
            }
            ++count
        }
        return 0
    }
}

fun main() {
    val solution = WordLadderKotlin127()
    println(
        solution.ladderLength(
            "hit",
            "cog",
            arrayListOf("hot", "dot", "dog", "lot", "log", "cog")
        )
    )
}