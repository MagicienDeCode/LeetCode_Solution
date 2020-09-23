package tree

class ConstructStringfromBinaryTreeKotlin606 {
    fun tree2str(t: TreeNode?): String = when {
        t == null -> ""
        t.left == null && t.right == null -> t.`val`.toString() + ""
        t.right == null -> t.`val`.toString() + "(" + tree2str(t.left) + ")"
        else -> t.`val`.toString() + "(" + tree2str(t.left) + ")(" + tree2str(t.right) + ")"
    }
}