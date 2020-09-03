package tree

class ConvertSortedArraytoBinarySearchTreeKotlin108 {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        return helper(nums, 0, nums.size - 1)
    }

    private fun helper(nums: IntArray, start: Int, end: Int): TreeNode? {
        if (start > end) {
            return null
        }
        if (start == end) {
            return TreeNode(nums[start])
        }
        val mid = start + (end - start shr 1)
        val root = TreeNode(nums[mid])
        root.left = helper(nums, start, mid - 1)
        root.right = helper(nums, mid + 1, end)
        return root
    }
}