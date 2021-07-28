package binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: post order traversal
 * @author: zhaolu
 * @createDate: 2021/5/25
 */
public class PostOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = TreeNodeUtils.generateTree(1);
        List<String> result = new ArrayList<>();
        postOrderTraversalNode(root, result);
        result.forEach(System.out::println);
    }

    public static void postOrderTraversalNode(TreeNode node, List<String> result) {
        if(node == null) {
            return;
        }
        postOrderTraversalNode(node.left, result);
        postOrderTraversalNode(node.right, result);
        result.add(node.value);
    }
}
