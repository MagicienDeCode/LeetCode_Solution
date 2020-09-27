package tree

class MaximumBinaryTreeKotlin654 {
    fun constructMaximumBinaryTree(nums: IntArray): TreeNode? {
        return construct(nums, 0, nums.size - 1)
    }

    private fun construct(nums: IntArray, start: Int, end: Int): TreeNode? {
        if (start > end) {
            return null
        }
        val maxIndex = findMaxIndex(nums, start, end)
        val root = TreeNode(nums[maxIndex])
        root.left = construct(nums, start, maxIndex - 1)
        root.right = construct(nums, maxIndex + 1, end)
        return root
    }

    private fun findMaxIndex(nums: IntArray, start: Int, end: Int): Int {
        var result = start
        for (i in start + 1..end) {
            if (nums[i] > nums[result]) {
                result = i
            }
        }
        return result
    }
}