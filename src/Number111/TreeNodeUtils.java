package Number111;

/**
 * @description:
 * @author: zhaolu
 * @createDate: 2021/6/4
 */
public class TreeNodeUtils {
    public static TreeNode changeArrayToTreeNode(int[] arr) {
        TreeNode root = new TreeNode(arr[0]);
        for(int i = 1; i < arr.length; i++) {
            root = new TreeNode(arr[i]);
        }
        return root;
    }
}
