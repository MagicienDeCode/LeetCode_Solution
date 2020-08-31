package tree

class DeleteNodeinaBSTKotlin450 {
    fun deleteNode(rootVal: TreeNode?, key: Int): TreeNode? {
        var root: TreeNode? = rootVal ?: return null
        when {
            root!!.`val` > key -> {
                root.left = deleteNode(root.left, key)
            }
            root.`val` < key -> {
                root.right = deleteNode(root.right, key)
            }
            else -> {
                when {
                    root.left == null -> {
                        root = root.right
                    }
                    root.right == null -> {
                        root = root.left
                    }
                    else -> {
                        var delete = root.right
                        while (delete.left != null) {
                            delete = delete.left
                        }
                        root.`val` = delete.`val`
                        root.right = deleteNode(root.right, delete.`val`)
                    }
                }
            }
        }
        return root
    }
}