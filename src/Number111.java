
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import Number111.TreeNode;
/**
 * @description: 二叉树最小深度
 * @author: zhaolu
 * @createDate: 2021/6/4
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Number111 {
//    public int minDepth(TreeNode root) {
//        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
//        queue.add(root);
//        int height = 0;
//        while(queue.size() > 0) {
//            height++;
//            int size = queue.size();
//            for(int i=0;i<size;i++) {
//                TreeNode node = queue.poll();
//                // 如果是叶子节点，判断是不是最小深度；第一次应该就是最小深度了
//                if(node.left == null && node.right == null) {
//                                        System.out.println(height);
//                    return height;
////                    if(min > height) {
////                        min = height;
////                    }
////                    if(max < height) {
////                        max = height;
////                    }
//                }
//                if(node.left != null) {
//                    queue.add(node.left);
//                }
//                if(node.right != null) {
//                    queue.add(node.right);
//                }
//            }
//        }
//        return height;
//    }
//
//    public static int min = Integer.MAX_VALUE;
//
//    public void min(TreeNode node, int height) {
//        if(node == null || height > min) return;
//        if(node.left == null && node.right == null && min > height) {
//            min = height;
//        }
//        min(node.left, height + 1);
//        min(node.right, height + 1);
//    }
//
//
//    public static int min = Integer.MAX_VALUE;
//
//    public void min(TreeNode node, int height) {
//        if(node == null || height > min) return;
//        if(node.left == null && node.right == null && min > height) {
//            min = height;
//        }
//        min(node.left, height + 1);
//        min(node.right, height + 1);
//    }
//
//    public int minDepth(TreeNode root) {
//        min(root, 1);
//        return min;
//    }


    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return left == 0 || right == 0 ? 1 + left + right : 1 + Math.min(left ,right);
    }

    public static void main(String[] args) {


        TreeNode root2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        root2.right = node3;
        node3.right = node4;
        node4.right = node5;
        node5.right = node6;

        Number111 number111 = new Number111();
        int ttt = number111.minDepth(root2);
        System.out.println("ttt=" + ttt);
    }
}
