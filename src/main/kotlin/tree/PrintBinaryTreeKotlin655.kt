package tree

import java.util.*

class PrintBinaryTreeKotlin655 {
    fun printTree(root: TreeNode?): List<List<String>> {
        val results: MutableList<List<String>> = LinkedList()
        if (root == null) {
            return results
        }
        val height = getHeight(root)
        val width = 1.shl(height)
        val valueIndex: MutableList<List<IntArray>> = ArrayList()
        val queue: Queue<Pair<TreeNode, Int>> = LinkedList()
        queue.offer(Pair(root, width.shr(1)))
        var currentDistance = width.shr(2)
        while (!queue.isEmpty()) {
            val levels: MutableList<IntArray> = ArrayList()
            val currentSize = queue.size
            for (i in 0 until currentSize) {
                val current = queue.poll()
                val node = current.first
                val index = current.second
                levels.add(intArrayOf(node.`val`, index))
                if (node.left != null) {
                    queue.offer(Pair(node.left, index - currentDistance))
                }
                if (node.right != null) {
                    queue.offer(Pair(node.right, index + currentDistance))
                }
            }
            currentDistance = currentDistance shr 1
            valueIndex.add(levels)
        }
        for (vIndex in valueIndex) {
            val levelResults: MutableList<String> = LinkedList()
            var current = 0
            for (j in 1 until width) {
                if (current != vIndex.size && vIndex[current][1] == j) {
                    levelResults.add(vIndex[current][0].toString())
                    ++current
                } else {
                    levelResults.add("")
                }
            }
            results.add(levelResults)
        }
        return results
    }

    private fun getHeight(root: TreeNode): Int {
        var level = 0
        val queue: Queue<TreeNode> = LinkedList()
        queue.offer(root)
        while (!queue.isEmpty()) {
            val currentSize = queue.size
            for (i in 0 until currentSize) {
                val node = queue.poll()
                if (node.left != null) {
                    queue.offer(node.left)
                }
                if (node.right != null) {
                    queue.offer(node.right)
                }
            }
            ++level
        }
        return level
    }
}