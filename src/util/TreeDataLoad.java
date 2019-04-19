package util;

import tree.ValidateBinarySearchTree_98;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;


public class TreeDataLoad {

    public static TreeNode arrayToTreeNode(Integer[] inputs) {
        if (inputs.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(inputs[0]);
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == inputs.length) {
                break;
            }

            Integer leftNumber = inputs[index++];

            if (!(leftNumber == null)) {
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == inputs.length) {
                break;
            }

            Integer rightNumber = inputs[index++];
            if (!(rightNumber == null)) {
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }


    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }
}
