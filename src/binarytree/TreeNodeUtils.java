package binarytree;

/**
 * @description: tree node utils
 * @author: zhaolu
 * @createDate: 2021/5/25
 */
public class TreeNodeUtils {

    public static TreeNode generateTree(int n) {
        TreeNode root = new TreeNode("G");

        TreeNode nodeD = new TreeNode("D");
        TreeNode nodeA = new TreeNode("A");
        TreeNode nodeF = new TreeNode("F");
        TreeNode nodeE = new TreeNode("E");
        TreeNode nodeH = new TreeNode("H");
        TreeNode nodeM = new TreeNode("M");
        TreeNode nodeZ = new TreeNode("Z");
        root.left = nodeD;
        root.right = nodeM;
        nodeD.left = nodeA;
        nodeD.right = nodeF;
        nodeF.left = nodeE;
        nodeM.left = nodeH;
        nodeM.right = nodeZ;

        return root;
    }
}
