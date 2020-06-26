package breadth_first_search;

class SumRoottoLeafNumbers129 {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root, "");
    }

    private int dfs(TreeNode node, String s) {
        final String currentString = s + node.val;
        final TreeNode left = node.left;
        final TreeNode right = node.right;
        if (left == null && right == null) {
            return Integer.parseInt(currentString);
        }
        final int leftVal = left == null ? 0 : dfs(left, currentString);
        final int rightVal = right == null ? 0 : dfs(right, currentString);
        return leftVal + rightVal;
    }

    /*
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        final Queue<Pair<TreeNode, String>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, ""));
        int sum = 0;
        while (!queue.isEmpty()) {
            final Pair<TreeNode, String> currentPair = queue.poll();
            final TreeNode currentNode = currentPair.getKey();
            final String currentString = currentPair.getValue() + currentNode.val;
            final TreeNode left = currentNode.left;
            final TreeNode right = currentNode.right;
            if (left == null && right == null) {
                sum += Integer.parseInt(currentString);
            }
            if (left != null) {
                queue.offer(new Pair<>(left, currentString));
            }
            if (right != null) {
                queue.offer(new Pair<>(right, currentString));
            }
        }
        return sum;
    }
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}