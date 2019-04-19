package tree;

import util.TreeNode;

/**
 * 判断二叉树是否存在从根到叶子节点的路径之和等于sum
 */
public class PathSum_112 {

    class Solution {
        public boolean hasPathSum(TreeNode root, int sum) {

            if (root == null)
                return false;
            //叶子节点，值为sum    return true
            if(root.left == null && root.right == null) {
                return root.val == sum;
            }

            return (hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val));

        }
    }
}
