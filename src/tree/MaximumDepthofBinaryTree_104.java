package tree;

import util.TreeNode;

public class MaximumDepthofBinaryTree_104 {

    class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null)
                return 0;

            int leftMaxDepth = maxDepth(root.left);
            int rightMaxDepth = maxDepth(root.right);

            return Math.max(leftMaxDepth, rightMaxDepth) + 1;
        }
    }
}
