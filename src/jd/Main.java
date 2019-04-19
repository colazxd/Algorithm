package jd;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static class TreeNode {
        int val;
        ArrayList<TreeNode> next = new ArrayList<>();

        TreeNode(int x) {
            this.val = x;
        }

        @Override
        public String toString() {
            return Integer.toString(this.val);
        }
    }

    public static void main(String[] args) throws IOException {
        TreeNode root = new TreeNode(1);
        ArrayList<TreeNode> tree = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        tree.add(new TreeNode(n));
        tree.add(root);
        sc.nextLine();  //nextInt()的结束符Enter
        while (sc.hasNextLine()) {
            String rel = sc.nextLine();
            if ("".equals(rel))
                break;
            String[] ss = rel.split(" ");
            int x = Integer.parseInt(ss[0]);
            int y = Integer.parseInt(ss[1]);
            TreeNode p = new TreeNode(x);
            tree.add(p);
            TreeNode father = tree.get(y);
            father.next.add(p);
        }
        int[] childsOfRoot = new int[root.next.size()];
        for (int i = 0; i < root.next.size(); i++) {
            childsOfRoot[i] = allChilds(root.next.get(i));
        }
        int time = maxAll(childsOfRoot);
        System.out.println(time);
    }

    private static int maxAll(int[] all) {
        int max = all[0];
        for (int i=1; i<all.length; i++) {
            max = Math.max(max, all[i]);
        }
        return max;
    }

    // 以root节点为根的树的总结点个数
    private static int allChilds(TreeNode root) {
        if (root.next.size() == 0)
            return 1;

        int numChild = 0;
        for (TreeNode child: root.next) {
            numChild += allChilds(child);
        }
        return numChild+1;

    }
}

