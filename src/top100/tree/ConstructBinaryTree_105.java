package top100.tree;

import util.TreeNode;

import java.util.HashMap;

public class ConstructBinaryTree_105 {
    class Solution1 {
        public TreeNode buildTree(int[] preorder, int[] inorder) {

            // val pos
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            TreeNode root = new TreeNode(preorder[0]);
            int pos = map.get(preorder[0]);
            for (int i = 1; i < preorder.length;) {
                int cur_pos = map.get(preorder[i]);
                TreeNode p = new TreeNode(preorder[i]);
                if (cur_pos > pos)
                    root.right = p;
                else
                    root.left = p;
                pos = cur_pos;

            }
            return root;
        }
    }

    class Solution {
        HashMap<Integer, Integer> map = new HashMap<>();
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            return help(preorder, inorder, 0, 0, inorder.length-1);
        }

        // 在preorder and inorder序列里，以前序preStart开始，在中序[inStart, inEnd]区间构造树
        private TreeNode help(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
            if (inEnd - inStart < 0 || preStart >= preorder.length)
                return null;

            TreeNode root = new TreeNode(preorder[preStart]);
            int pos = map.get(preorder[preStart]);


            root.left  = help(preorder, inorder, preStart+1, inStart, pos-1);
            //pos-inStart表示左子树的节点数，递归右子树要跳过这些节点
            root.right = help(preorder, inorder, preStart+pos-inStart+1, pos+1, inEnd);

            return root;

        }
    }
}
