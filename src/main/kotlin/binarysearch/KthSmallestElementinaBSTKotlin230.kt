package binarysearch

/*
class TreeNode230(var `val`: Int) {
    var left: TreeNode230? = null
    var right: TreeNode230? = null
}

class KthSmallestElementinaBSTKotlin230 {
    fun kthSmallest(root: TreeNode230?, k: Int): Int {
        val leftCount = count(root?.left) + 1
        return when {
            leftCount == k -> return root!!.`val`
            leftCount < k -> kthSmallest(root?.right, k - leftCount)
            else -> kthSmallest(root?.left, k)
        }
    }

    private fun count(root: TreeNode230?): Int {
        if (root == null) {
            return 0
        }
        return 1 + count(root.left) + count(root.right)
    }


    /*
    fun kthSmallest(root: TreeNode230?, k: Int): Int {
        val result = mutableListOf<Int>()
        searchInOrder(root, result)
        return result[k - 1]
    }

    private fun searchInOrder(current: TreeNode230?, result: MutableList<Int>) {
        if(current == null){
            return
        }
        searchInOrder(current.left,result)
        result.add(current.`val`)
        searchInOrder(current.right,result)
    }

     */


    /*
    var k = 0
    fun kthSmallest(root: TreeNode230?, k: Int): Int {
        this.k = k
        return searchInOrder(root)!!.`val`
    }

    private fun searchInOrder(current: TreeNode230?): TreeNode230? {
        if (current == null) {
            return null
        }
        val resultLeft = searchInOrder(current.left)
        if (resultLeft != null && k == 0) {
            return resultLeft
        }
        this.k--
        if (k == 0) {
            return current
        }
        return searchInOrder(current.right)
    }

     */
}


fun main() {
    val solution = KthSmallestElementinaBSTKotlin230()

    val root33 = TreeNode230(3)
    val node111 = TreeNode230(1)
    val node22 = TreeNode230(2)
    val node44 = TreeNode230(4)
    root33.left = node111
    node111.right = node22
    root33.right = node44
    println(solution.kthSmallest(root33, 1))

    val test = TreeNode230(1)
    val test2 = TreeNode230(2)
    test2.left = test
    println(solution.kthSmallest(test2, 1))

    val node1 = TreeNode230(1)
    val node2 = TreeNode230(2)
    val node3 = TreeNode230(3)
    val node4 = TreeNode230(4)
    val node5 = TreeNode230(5)
    val node6 = TreeNode230(6)
    node5.right = node6
    node5.left = node3
    node3.left = node2
    node3.right = node4
    node2.left = node1
    println(solution.kthSmallest(node5, 3))
}

 */