package top100.tree;

import util.TreeDataLoad;
import util.TreeNode;

public class PathSumIII_437 {

    class Solution {
        /**
         * 以root为根的二叉树，包含路径和为sum的path数
         * @param root
         * @param sum
         * @return
         */
        public int pathSum(TreeNode root, int sum) {
            if (root == null)
                return 0;
            int res = 0;
            res += findPath(root, sum);
            res += pathSum(root.left, sum);
            res += pathSum(root.right, sum);
            return res;
        }

        /**
         *  从root开始包含路径和为sum的path数
         * @param root
         * @param sum
         * @return
         */
        private int findPath(TreeNode root, int sum)  {
            if (root == null)
                return 0;
            int res = 0;
            if (root.val == sum)
                res+=1;           // 找到一条路径，因为节点存在负值，再往下找可能还有，所以不能直接返回1
            return res + findPath(root.left, sum-root.val) + findPath(root.right, sum-root.val);
        }
    }

    public static void main(String[] args) {
        Integer[] values = {1,-2,-3,1,3,-2,null,-1};
        TreeNode tree = TreeDataLoad.arrayToTreeNode(values);
        int n = new PathSumIII_437().new Solution().pathSum(tree, -1);
        System.out.println(n);
    }
}
