package breadth_first_search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BinaryTreeLevelOrderTraversal102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        final List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // 1. create a queue FIFO, then put root in it
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.offer(root);
        // 2. while queue is not null, take itself add its children
        while (!treeNodeQueue.isEmpty()) {
            final int currentSize = treeNodeQueue.size();
            final List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < currentSize; i++) {
                TreeNode treeNode = treeNodeQueue.poll();
                currentLevel.add(treeNode.val);
                if (treeNode.left != null) {
                    treeNodeQueue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    treeNodeQueue.offer(treeNode.right);
                }
            }
            result.add(currentLevel);
        }
        return result;
    }

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

    public static void main(String... args) {
        final List<Integer> integers = new ArrayList<>(List.of(1, 2, 3));
        /*
        Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
        for(int index =0;index < integers.size();index++){
            integers.add(7);
        }
         */
        /*
        // Exception in thread "main" java.util.ConcurrentModificationException
        for (int integer:integers){
            integers.add(7);
        }
         */
        /*
        final Iterator<Integer> iterator = integers.iterator();
        // replace with enhanced for
        while (iterator.hasNext()){
            iterator.next();
            // Exception in thread "main" java.util.ConcurrentModificationException
            integers.add(7);
        }
         */
        final int currentSize = integers.size();
        for (int index = 0; index < currentSize; index++) {
            integers.add(7);
        }
        integers.forEach(System.out::println);
    }
}
