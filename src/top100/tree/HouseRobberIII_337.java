package top100.tree;

import util.TreeDataLoad;
import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//TODO 未完成
public class HouseRobberIII_337 {
    /**
     * 二叉树的层序
     */
    class Pair {
        TreeNode treeNode;
        int level;
        Pair(TreeNode t, int l) {
            this.treeNode = t;
            this.level = l;
        }
    }

    class Solution {
        public int rob(TreeNode root) {
            if(root == null)
                return 0;
            Queue<Pair> queue = new LinkedList<>();
            List<Integer> levelSumList = new ArrayList<>();
            int curLevel = 0;
            queue.offer(new Pair(root, 0));
            int levelSum = 0;
            while (!queue.isEmpty()) {
                Pair p = queue.remove();
                if (p.treeNode.left != null)
                    queue.offer(new Pair(p.treeNode.left, p.level+1));
                if (p.treeNode.right != null)
                    queue.offer(new Pair(p.treeNode.right, p.level+1));

                if (p.level == curLevel) {
                    levelSum += p.treeNode.val;
                } else {
                    levelSumList.add(levelSum);
                    curLevel++;
                    levelSum = p.treeNode.val;
                }
            }
            levelSumList.add(levelSum);
            System.out.println(levelSumList);
            int res = 0;
            int i = 0;
            while(i < levelSumList.size()) {
                if (levelSumList.get(i) > levelSumList.get(i + 1)) {
                    res+=levelSumList.get(i);
                    i+=2;
                } else {
                    res+=levelSumList.get(i+1);
                    i+=3;
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Integer[] values = {3,2,3,null,3,null,1};
//
//        Integer[] values = {4,1,null,2,null,3};


        TreeNode tree = TreeDataLoad.arrayToTreeNode(values);
        int a = new HouseRobberIII_337().new Solution().rob(tree);
        System.out.println(a);
    }
}
