package binarytree;

/**
 * @description:
 * @author: zhaolu
 * @createDate: 2021/7/27
 */
public class MaxPath {

    public static int maxHeight = 0;

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
        getHeight(root);
        System.out.println(maxHeight);
    }

    public static int getHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = getHeight(root.left);
        int right = getHeight(root.right);
        maxHeight = Math.max(maxHeight, left + right + 1);
        return 1 + Math.max(left, right);
    }
}
