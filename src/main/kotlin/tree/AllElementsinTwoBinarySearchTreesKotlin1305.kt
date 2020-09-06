package tree

import java.util.*

class AllElementsinTwoBinarySearchTreesKotlin1305 {
    fun getAllElements(root1: TreeNode?, root2: TreeNode?): List<Int> {
        val root1s: MutableList<Int> = ArrayList()
        val root2s: MutableList<Int> = ArrayList()
        inorder(root1, root1s)
        inorder(root2, root2s)
        val results: MutableList<Int> = ArrayList()
        merge(root1s, root2s, results)
        return results
    }

    private fun merge(root1s: List<Int>, root2s: List<Int>, results: MutableList<Int>) {
        var i1 = 0
        var i2 = 0
        while (i1 < root1s.size && i2 < root2s.size) {
            val r1 = root1s[i1]
            val r2 = root2s[i2]
            if (r1 <= r2) {
                results.add(r1)
                ++i1
            } else {
                results.add(r2)
                ++i2
            }
        }
        while (i1 < root1s.size) {
            results.add(root1s[i1++])
        }
        while (i2 < root2s.size) {
            results.add(root2s[i2++])
        }
    }

    private fun inorder(root: TreeNode?, results: MutableList<Int>) {
        if (root == null) {
            return
        }
        inorder(root.left, results)
        results.add(root.`val`)
        inorder(root.right, results)
    }
}