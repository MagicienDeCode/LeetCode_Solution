package breadth_first_search

import java.util.*
import kotlin.collections.HashSet

class RemoveInvalidParenthesesKotlin301 {
    fun removeInvalidParentheses(s: String): List<String> {
        val result: MutableList<String> = LinkedList()
        val queue: Queue<String> = LinkedList()
        val set: MutableSet<String> = HashSet()
        queue.offer(s)
        while (queue.isNotEmpty()) {
            val current = queue.poll()
            if (isValid(current)) {
                result.add(current)
                queue.forEach {
                    if (isValid(it)) {
                        result.add(it)
                    }
                }
                return result
            }
            current.forEachIndexed { index, c ->
                if (c == '(' || c == ')') {
                    val new = current.removeRange(index, index + 1)
                    if (!set.contains(new)) {
                        queue.offer(new)
                        set.add(new)
                    }
                }
            }
        }
        return result
    }

    private fun isValid(str: String): Boolean {
        var count = 0
        str.forEach {
            if (it == '(') {
                ++count
            }
            /*
            if (it == ')') {
                --count
            }
             */
            if (it == ')' && --count < 0) {
                return false
            }
        }
        return count == 0
    }
}