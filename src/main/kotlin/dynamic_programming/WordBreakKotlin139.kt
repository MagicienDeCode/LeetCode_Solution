package dynamic_programming

class WordBreakKotlin139 {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val wordSet = wordDict.toSet()
        val visited = BooleanArray(s.length + 1)
        return dfs(s, wordSet, visited, 0)
    }

    private fun dfs(
        s: String,
        wordSet: Set<String>,
        visited: BooleanArray,
        current: Int
    ): Boolean {
        if (current == s.length) {
            return true
        }
        for (index in current + 1..s.length) {
            if (!visited[index] && wordSet.contains(s.substring(current, index))) {
                visited[index] = true
                if (dfs(s, wordSet, visited, index)) {
                    return true
                }
            }
        }
        return false
    }

    /*
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val wordSet = wordDict.toSet()
        val visited = BooleanArray(s.length + 1)
        val queue: Queue<Int> = LinkedList()
        queue.offer(0)
        visited[0] = true
        while (queue.isNotEmpty()) {
            val current = queue.poll()
            if (current == s.length) {
                return true
            }
            for (index in current + 1..s.length) {
                if (!visited[index] && wordSet.contains(s.substring(current, index))) {
                    queue.offer(index)
                    visited[index] = true
                }
            }
        }
        return false
    }
     */
    /*
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val wordSet = wordDict.toSet()
        val dp = BooleanArray(s.length + 1)
        dp[0] = true
        for (i in dp.indices) {
            for (j in 0..i) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true
                    break
                }
            }
        }
        return dp[s.length]
    }
     */
}

fun main() {
    val solution = WordBreakKotlin139()
    println(solution.wordBreak("leetcode", listOf("leet", "code")))
}