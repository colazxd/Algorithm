package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal_102 {


     // Definition for a binary tree node.
     public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

      public class Pair {
         TreeNode node;
         int level;
         Pair(TreeNode x, int y) {
             node = x;
             level = y;
         }
      }

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new LinkedList<>();
            Queue<Pair> queue = new LinkedList<>();
            int level = 0;
            queue.offer(new Pair(root, level));
            while(!queue.isEmpty()) {
                Pair pair = queue.poll();
                TreeNode node = pair.node;
                level = pair.level;
                if (level >= result.size()) {
                    result.add(new LinkedList<>());
                }
                result.get(level).add(node.val);
            }
            return result;
        }
    }
}
