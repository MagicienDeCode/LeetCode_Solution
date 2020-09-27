package tree;

public class MaximumBinaryTree654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }

    private TreeNode construct(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        final int maxIndex = findMaxIndex(nums, start, end);
        final TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = construct(nums, start, maxIndex - 1);
        root.right = construct(nums, maxIndex + 1, end);
        return root;
    }

    private int findMaxIndex(int[] nums, int start, int end) {
        int result = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > nums[result]) {
                result = i;
            }
        }
        return result;
    }
}
