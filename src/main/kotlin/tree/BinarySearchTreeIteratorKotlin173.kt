package tree

import java.util.*
import kotlin.collections.ArrayList

class BinarySearchTreeIteratorKotlin173(root: TreeNode?) {

    val value: MutableList<Int> = ArrayList()
    var index = -1

    init {
        val stack: Stack<TreeNode> = Stack()
        var current = root
        while (current != null || stack.isNotEmpty()) {
            while (current != null) {
                stack.push(current)
                current = current.left
            }
            current = stack.pop()
            value.add(current.`val`)
            current = current.right
        }
    }

    /** @return the next smallest number */
    fun next(): Int = value[++index]

    /** @return whether we have a next smallest number */
    fun hasNext(): Boolean = index < value.size - 1
}