package tree

import java.util.*

class PathInZigzagLabelledBinaryTreeKotlin1104 {
    fun pathInZigZagTree(label: Int): List<Int> {
        val stack = Stack<Int>()
        var level = 0
        var current = 2
        while (current - 1 < label) {
            current = current.shl(1)
            ++level
        }
        var zigzagVal = label
        var trueVal = if (level % 2 == 0) {
            label
        } else {
            calculateTrueValFromZigzag(label, level)
        }
        stack.push(zigzagVal)
        while (level > 0) {
            --level
            trueVal = trueVal.shr(1)
            zigzagVal = calculateZigZagValFromTrue(trueVal, level)
            stack.push(zigzagVal)
        }
        val results: MutableList<Int> = LinkedList()
        while (!stack.isEmpty()) {
            results.add(stack.pop())
        }
        return results
    }

    private fun calculateZigZagValFromTrue(trueVal: Int, level: Int): Int {
        return if (level % 2 == 0) {
            trueVal
        } else {
            val min = 1.shl(level)
            val max = (1.shl(level + 1)) - 1
            max - (trueVal - min)
        }
    }

    private fun calculateTrueValFromZigzag(zigzagVal: Int, level: Int): Int {
        return if (level % 2 == 0) {
            zigzagVal
        } else {
            val min = 1.shl(level)
            val max = (1.shl(level + 1)) - 1
            min + (max - zigzagVal)
        }
    }
}