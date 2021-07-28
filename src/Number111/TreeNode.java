package Number111;

/**
 * @description:
 * @author: zhaolu
 * @createDate: 2021/6/4
 */
public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int val;

    public TreeNode(Integer v) {
        this.val = v;
    }
    TreeNode() {}
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
