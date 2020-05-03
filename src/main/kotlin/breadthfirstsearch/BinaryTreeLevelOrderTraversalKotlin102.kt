package breadthfirstsearch

import java.util.*

class BinaryTreeLevelOrderTraversalKotlin102 {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        if (root == null) {
            return result
        }
        val treeNodeQueue: Queue<TreeNode> = LinkedList()
        treeNodeQueue.offer(root)
        while (treeNodeQueue.isNotEmpty()) {
            val currentLevel = mutableListOf<Int>()
            /*
            val currentLevel = mutableListOf<Int>()
            for (i in 0 until currentSize) {
             */
            for (i in 0 until treeNodeQueue.size) {
                val current = treeNodeQueue.poll()
                currentLevel.add(current.`val`)
                current.left?.let { treeNodeQueue.offer(it) }
                current.right?.let { treeNodeQueue.offer(it) }
            }
            result.add(currentLevel)
        }
        return result
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}

fun main() {
    /*
    val mutableList = mutableListOf(1, 2, 3)
    /* 1 2 3 7 7 7
    for (i in 0 until mutableList.size) {
        mutableList.add(7)
    }
      */
    /* 1 2 3 7 7 7
    for (i in mutableList.indices) {
        mutableList.add(7)
    }
    */
    // Exception in thread "main" java.util.ConcurrentModificationException
    for (i in mutableList) {
        mutableList.add(7)
    }
    mutableList.forEach(::println)
     */
    val immutableList = listOf(1, 2, 3, 4, 5)
    // same as java enhanced for, can not modify original collection
    println()
    println("for (element in immutableList) 12345")
    for (element in immutableList) {
        print(element)
    }
    println()
    println(" for (i in immutableList.indices) 01234")
    for (i in immutableList.indices) {
        print(i)
    }
    println()
    // ==================include=======================
    println(" for (i in 0..3) ==> 0123")
    for (i in 0..3) {
        print(i)
    }
    println()
    println("for (i in IntRange(0,3)) ==> 0123")
    for (i in IntRange(0, 3)) {
        print(i)
    }
    println()
    println("for (i in IntRange(0,10) step 2) ==> 0246810")
    for (i in IntRange(0, 10) step 2) {
        print(i)
    }
    println("for(i in 3 downTo 0) ==> 3210")
    for (i in 3 downTo 0) {
        print(i)
    }
    // ==================exclude=======================
    println("for (i in 0 until 3) ==> 012")
    for (i in 0 until 3) {
        print(i)
    }
}