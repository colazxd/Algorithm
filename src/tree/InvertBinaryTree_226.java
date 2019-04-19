package tree;

import jdk.nashorn.api.tree.Tree;
import util.TreeDataLoad;
import util.TreeNode;

public class InvertBinaryTree_226 {
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null)
                return null;

            invertTree(root.left);
            invertTree(root.right);

            TreeNode temp = root.right;
            root.right = root.left;
            root.left = temp;

            return root;

        }
    }

    public static void main(String[] args) {
        Integer[] items = {4,2,7,1,3,6,9};
        TreeNode root = TreeDataLoad.arrayToTreeNode(items);
        Solution solution = new InvertBinaryTree_226().new Solution();
        solution.invertTree(root);

    }
}
