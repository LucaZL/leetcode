package binarytree;

/**
 * @description:
 * @author: zhaolu
 * @createDate: 2021/7/27
 */
public class MaxSum {

    public static int maxValue = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode("3");
        TreeNode left = new TreeNode("1");
        TreeNode right = new TreeNode("4");
        TreeNode ll = new TreeNode("-1");
        TreeNode lr = new TreeNode("2");

        root.left = left;
        root.right = right;
        left.left = ll;
        left.right = lr;
        getMax(root);
        System.out.println(maxValue);
    }

    public static int getMax(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = Math.max(0, getMax(root.left));
        int right = Math.max(0, getMax(root.right));
        maxValue = Math.max(maxValue, left + right + Integer.valueOf(root.value));

        return Integer.valueOf(root.value) + Math.max(left, right);
    }
}
