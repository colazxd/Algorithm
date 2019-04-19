package tree;

import util.TreeDataLoad;
import util.TreeNode;


public class ValidateBinarySearchTree_98 {

    class Solution {

        public boolean isValidBST(TreeNode root) {
            // method1
//            return isValidBSTHelper(root, null, null);
            // method2
            return inOrder(root);

        }

        /**
         * 中序遍历，记录前驱
         * @param root
         * @return
         */
        private TreeNode pre;
        private boolean inOrder(TreeNode root) {
            if (root != null) {
                if(!inOrder(root.left))
                    return false;

                if (pre != null) {
                    if (root.val <= pre.val)        //
                        return false;
                }
                pre = root;
                if (!inOrder(root.right)) {
                    return false;
                }
            }
            return true;
        }


        private boolean isValidBSTHelper(TreeNode root, Integer min, Integer max) {
            // 空树也是
            if (root == null)
                return true;

            if (min != null && root.val <= min) return false;
            if (max != null && root.val >= max) return false;

            return (isValidBSTHelper(root.left, min, root.val) && isValidBSTHelper(root.right, root.val, max));

        }
    }

    public static void main(String[] args) {
        // testcase
//        Integer[] inputs = {5,1,4,null,null,3,6};
        Integer[] inputs = {1, 1};

        TreeNode root = TreeDataLoad.arrayToTreeNode(inputs);

        Solution solution = new ValidateBinarySearchTree_98().new Solution();
        boolean ret = solution.isValidBST(root);
        String out = TreeDataLoad.booleanToString(ret);

        System.out.print(out);
    }
}
