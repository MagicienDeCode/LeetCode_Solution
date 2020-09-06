package tree

import java.util.*

class SerializeandDeserializeBinaryTreeKotlin297 {
    private val DELIMITER = ","
    private val NULL_NODE = "null"

    // Encodes a tree to a single string.
    fun serialize(root: TreeNode?): String {
        val results = StringBuilder()
        preorder(root, results)
        return results.substring(0, results.length - 1)
    }

    private fun preorder(root: TreeNode?, results: StringBuilder) {
        if (root == null) {
            results.append(NULL_NODE).append(DELIMITER)
        } else {
            results.append(root.`val`).append(DELIMITER)
            preorder(root.left, results)
            preorder(root.right, results)
        }
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String?): TreeNode? {
        if (data.isNullOrEmpty()) {
            return null
        }
        val queue: Queue<String> = LinkedList()
        Collections.addAll(queue, *data.split(DELIMITER).toTypedArray())
        return preorderBuilder(queue)
    }

    private fun preorderBuilder(queue: Queue<String>): TreeNode? {
        if (queue.isEmpty()) {
            return null
        }
        val current = queue.poll()
        if (current == NULL_NODE) {
            return null
        }
        val root = TreeNode(current.toInt())
        root.left = preorderBuilder(queue)
        root.right = preorderBuilder(queue)
        return root
    }
}