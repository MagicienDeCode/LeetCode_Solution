package tree

import java.util.*

class LeafSimilarTreesKotlin872 {
    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
        val leaf1: MutableList<Int> = ArrayList()
        val leaf2: MutableList<Int> = ArrayList()
        inorder(root1, leaf1)
        inorder(root2, leaf2)
        if (leaf1.size != leaf2.size) {
            return false
        }
        for (i in leaf1.indices) {
            if (leaf1[i] != leaf2[i]) {
                return false
            }
        }
        return true
    }

    private fun inorder(node: TreeNode?, leaf: MutableList<Int>) {
        if (node == null) {
            return
        }
        inorder(node.left, leaf)
        if (node.left == null && node.right == null) {
            leaf.add(node.`val`)
        }
        inorder(node.right, leaf)
    }
}