package tree;

import util.TreeNode;

public class MinimumDepthofBinaryTree_111 {


    class Solution {
        public int minDepth(TreeNode root) {
            if (root == null)
                return 0;

            int leftMinDepth = minDepth(root.left);
            int rightMinDepth = minDepth(root.right);
            int minDepth = (leftMinDepth == 0 || rightMinDepth == 0) ? leftMinDepth + rightMinDepth : Math.min(leftMinDepth, rightMinDepth)+ 1;
            return minDepth;

        }
    }
}
