package tree;

import util.TreeNode;

public class CountCompleteTreeNodes_222 {

    class Solution {
        public int countNodes(TreeNode root) {
            if (root == null)
                return 0;
            int leftNodesNum = countNodes(root.left);
            int rightNodesNum = countNodes(root.right);
            return leftNodesNum + rightNodesNum + 1;
        }
    }
}
