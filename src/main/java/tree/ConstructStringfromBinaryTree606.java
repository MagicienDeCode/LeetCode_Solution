package tree;

public class ConstructStringfromBinaryTree606 {
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        } else if (t.left == null && t.right == null) {
            return t.val + "";
        } else if (t.right == null) {
            return t.val + "(" + tree2str(t.left) + ")";
        } else if (t.left == null) {
            return t.val + "(" + tree2str(t.right) + ")";
        } else {
            return t.val + "(" + tree2str(t.left) + ")(" + tree2str(t.right) + ")";
        }
    }
}
