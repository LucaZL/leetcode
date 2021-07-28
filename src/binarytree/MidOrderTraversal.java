package binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: mid order traversal
 * @author: zhaolu
 * @createDate: 2021/5/25
 */
public class MidOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = TreeNodeUtils.generateTree(1);
        List<String> result = new ArrayList<>();
        preOrderTraversalNode(root, result);
        result.forEach(System.out::println);
    }

    public static void preOrderTraversalNode(TreeNode node, List<String> result) {
        if(node == null) {
            return;
        }
        preOrderTraversalNode(node.left, result);
        result.add(node.value);
        preOrderTraversalNode(node.right, result);
    }
}
