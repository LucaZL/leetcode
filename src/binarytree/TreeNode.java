package binarytree;

/**
 * @description: tree node
 * @author: zhaolu
 * @createDate: 2021/5/25
 */
public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public String value;

    public TreeNode(String v) {
        this.value = v;
    }
    TreeNode() {}
}
