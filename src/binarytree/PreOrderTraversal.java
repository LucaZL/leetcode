package binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: pre order traversel
 * @author: zhaolu
 * @createDate: 2021/5/25
 */
public class PreOrderTraversal {

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
        result.add(node.value);
        preOrderTraversalNode(node.left, result);
        preOrderTraversalNode(node.right, result);
    }
}
