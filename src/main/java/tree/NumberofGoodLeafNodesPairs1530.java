package tree;

public class NumberofGoodLeafNodesPairs1530 {
    private int result;

    public int countPairs(TreeNode root, int distance) {
        result = 0;
        dfs(root, distance);
        return result;
    }

    private int[] dfs(TreeNode node, int distance) {
        if (node == null) {
            return new int[11];
        }
        final int[] leftResult = dfs(node.left, distance);
        final int[] rightResult = dfs(node.right, distance);

        final int[] disArray = new int[11];

        if (node.left == null && node.right == null) {
            disArray[1] = 1;
            return disArray;
        }

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (i + j <= distance) {
                    result += leftResult[i] * rightResult[j];
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            disArray[i + 1] += leftResult[i] + rightResult[i];
        }

        return disArray;
    }
}
