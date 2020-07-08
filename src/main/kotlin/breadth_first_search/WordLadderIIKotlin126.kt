package breadth_first_search

import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet

class WordLadderIIKotlin126 {
    fun findLadders(beginWord: String, endWord: String, wordList: List<String>): List<List<String>> {
        val result: MutableList<List<String>> = LinkedList()
        val wordMap: MutableMap<String, Int> = HashMap()
        for (index in wordList.indices) {
            wordMap[wordList[index]] = index
        }
        if (!wordMap.contains(endWord)) {
            return result
        }
        val queue: Queue<Pair<String, String>> = LinkedList()
        queue.offer(Pair(beginWord, ""))
        var flag = true
        while (flag && queue.isNotEmpty()) {
            val currentLevelUsedWord: MutableSet<String> = HashSet()
            for (times in 0 until queue.size) {
                val currentPair = queue.poll()
                if (currentPair.first == endWord) {
                    flag = false
                    result.add(
                        currentPair.second.split(",")
                            .fold(mutableListOf(beginWord)) { acc: MutableList<String>, c: String ->
                                acc.add(wordList[c.toInt()])
                                acc
                            }
                    )
                }
                if (flag) {
                    for (index in currentPair.first.indices) {
                        val str = StringBuilder(currentPair.first)
                        for (char in 'a'..'z') {
                            str.setCharAt(index, char)
                            val new = str.toString()
                            if (wordMap.contains(new) && new != currentPair.first) {
                                if (new == endWord) {
                                    queue.offer(Pair(new, currentPair.second + wordMap.getValue(new)))
                                } else {
                                    currentLevelUsedWord.add(new)
                                    queue.offer(Pair(new, currentPair.second + wordMap.getValue(new) + ","))
                                }
                            }
                        }
                    }
                }
            }
            currentLevelUsedWord.forEach { wordMap.remove(it) }
        }
        return result
    }
}

fun main() {
    val solution = WordLadderIIKotlin126()
    /*
    teachpeachpeaceplace
    hithotdotdogcog
    hithotlotlogcog
    ac
    redtedtadtax
    redtedtextax
    redrextextax
     */
    solution.findLadders(
        "teach",
        "place",
        arrayListOf(
            "peale",
            "wilts",
            "place",
            "fetch",
            "purer",
            "pooch",
            "peace",
            "poach",
            "berra",
            "teach",
            "rheum",
            "peach"
        )
    ).forEach {
        it.forEach(::print)
        println()
    }

    solution.findLadders(
        "hit",
        "cog",
        arrayListOf("hot", "dot", "dog", "lot", "log", "cog")
    ).forEach {
        it.forEach(::print)
        println()
    }

    solution.findLadders(
        "a",
        "c",
        arrayListOf("a", "b", "c")
    ).forEach {
        it.forEach(::print)
        println()
    }

    solution.findLadders(
        "red",
        "tax",
        arrayListOf("ted", "tex", "red", "tax", "tad", "den", "rex", "pee")
    ).forEach {
        it.forEach(::print)
        println()
    }
}