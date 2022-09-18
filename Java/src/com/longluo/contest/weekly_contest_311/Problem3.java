package com.longluo.contest.weekly_contest_311;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

import java.util.*;

public class Problem3 {

    public static TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) {
            return root;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> nodeList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                nodeList.add(curNode);
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }

            if (level % 2 == 1) {
                int i = 0;
                int j = nodeList.size() - 1;
                while (i < j) {
                    int temp = nodeList.get(i).val;
                    nodeList.get(i).val = nodeList.get(j).val;
                    nodeList.get(j).val = temp;
                    i++;
                    j--;
                }
            }

            level++;
        }

        return root;
    }

    public static TreeNode reverseOddLevels_(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();

                list.add(cur);

                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }

            if (level % 2 == 1) {
                int count = list.size();

                for (int i = 0; i < count / 2; i++) {
                    int temp = list.get(i).val;
                    list.get(i).val = list.get(count - 1 - i).val;
                    list.get(count - 1 - i).val = temp;
                }
            }

            level++;
        }

        return root;
    }


    public static void main(String[] args) {
        TreeNode tst1 = TreeUtils.constructTree(new Integer[]{2, 3, 5, 8, 13, 21, 34});
        TreeUtils.printTree(tst1);
        TreeUtils.printTree(reverseOddLevels(tst1));
        TreeUtils.printTree(reverseOddLevels_(tst1));
    }
}
