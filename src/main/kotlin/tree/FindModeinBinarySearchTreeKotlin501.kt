package tree

import java.util.*

class FindModeinBinarySearchTreeKotlin501 {
    fun findMode(root: TreeNode?): IntArray {
        if (root == null) {
            return IntArray(0)
        }
        var preValue = Int.MIN_VALUE
        var max = 0
        var count = 1
        val results: MutableList<Int> = ArrayList()
        // inorder traversal using stack
        val stack: Stack<TreeNode> = Stack()
        var current = root
        while (current != null || stack.isNotEmpty()) {
            while (current != null) {
                stack.push(current)
                current = current.left
            }
            current = stack.pop()

            // compare with preValue
            if (preValue == current.`val`) {
                ++count
            } else {
                count = 1
            }
            // compare with max
            if (count > max) {
                max = count
                results.clear()
                results.add(current.`val`)
            } else if (count == max) {
                results.add(current.`val`)
            }
            // reassign preValue
            preValue = current.`val`

            current = current.right
        }
        return results.toIntArray()
    }

    /*
    private var preValue = Int.MIN_VALUE
    private var max = 0
    private var count = 1

    fun findMode(root: TreeNode?): IntArray {
        val results: MutableList<Int> = ArrayList()
        leftRootRight(root, results)
        return results.toIntArray()
    }

    // inorder traversal
    private fun leftRootRight(root: TreeNode?, results: MutableList<Int>) {
        if (root == null) {
            return
        }
        leftRootRight(root.left, results)

        // compare with preValue
        if (preValue == root.`val`) {
            ++count
        } else {
            count = 1
        }
        // compare with max
        if (count > max) {
            max = count
            results.clear()
            results.add(root.`val`)
        } else if (count == max) {
            results.add(root.`val`)
        }
        // reassign preValue
        preValue = root.`val`
        leftRootRight(root.right, results)
    }
     */
}
