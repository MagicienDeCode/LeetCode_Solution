package tree;

public class RecoveraTreeFromPreorderTraversal1028 {
    public TreeNode recoverFromPreorder(String s) {
        final char[] chars = s.toCharArray();
        return build(chars, 0, chars.length - 1, 1);
    }

    private TreeNode build(char[] chars, int start, int end, int level) {
        if (start > end) {
            return null;
        }
        // convert chars to integer, take example of "405 - - 1 - - 22", the first int is 405, NOT 4
        final StringBuilder stringBuilder = new StringBuilder();
        while (start <= end && chars[start] != '-') {
            stringBuilder.append(chars[start]);
            start++;
        }
        // root of node
        final TreeNode root = new TreeNode(Integer.parseInt(stringBuilder.toString()));
        if (start == end) {
            return root;
        }
        // calculate left start
        final int leftStart = start + level;
        int interval = 0;
        int rightStart = leftStart + 1;
        // calculate right start, if exists one, it must have count of "-" equals to level
        while (rightStart < chars.length) {
            if (chars[rightStart] == '-') {
                interval++;
            } else {
                if (interval == level) {
                    break;
                }
                interval = 0;
            }
            ++rightStart;
        }
        // recalculate left end, it may have rightStart > end, so we take end
        final int leftEnd = rightStart > end ? end : rightStart - level - 1;
        // build tree recursively
        root.left = build(chars, leftStart, leftEnd, level + 1);
        root.right = build(chars, rightStart, end, level + 1);
        return root;
    }

    public static void main(String[] args) {
        final RecoveraTreeFromPreorderTraversal1028 java = new RecoveraTreeFromPreorderTraversal1028();
        final TreeNode r3 = java.recoverFromPreorder("1-401--349---90--88");
        final TreeNode r2 = java.recoverFromPreorder("1-2--3---4-5--6---7");
        final TreeNode r = java.recoverFromPreorder("1-2--3--4-5--6--7");
        System.out.println("end");
    }
}
