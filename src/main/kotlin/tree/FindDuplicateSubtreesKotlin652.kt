package tree

import java.util.*
import kotlin.collections.HashMap

class FindDuplicateSubtreesKotlin652 {
    fun findDuplicateSubtrees(root: TreeNode?): List<TreeNode> {
        val map = HashMap<String, Int>()
        val results: MutableList<TreeNode> = LinkedList()
        dfs(root, map, results)
        return results
    }

    private fun dfs(
        node: TreeNode?,
        map: HashMap<String, Int>,
        results: MutableList<TreeNode>
    ): String {
        if (node == null) {
            return "#"
        }
        val current = node.`val`.toString() + "," +
                dfs(node.left, map, results) + "," +
                dfs(node.right, map, results)
        map[current] = 1 + map.getOrDefault(current, 0)
        if (map[current] == 2) {
            results.add(node)
        }
        return current
    }
}