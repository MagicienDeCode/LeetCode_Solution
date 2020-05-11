package binary_search;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class KthSmallestElementinaBST230 {

    public int kthSmallest(TreeNode root, int k) {
        final int leftCount = count(root.left) + 1;
        if (leftCount == k) {
            return root.val;
        } else if (leftCount > k) {
            return kthSmallest(root.left, k);
        } else {
            return kthSmallest(root.right, k - leftCount);
        }
    }

    private int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + count(root.left) + count(root.right);
    }

    /*
    public int kthSmallest(TreeNode root, int k) {
        final List<Integer> result = new ArrayList<>();
        searchInOrder(root, result);
        return result.get(k - 1);
    }

    private void searchInOrder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        searchInOrder(root.left, result);
        result.add(root.val);
        searchInOrder(root.right, result);
    }
     */
}
