package com.longluo.contest.weekly_contest_335;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

import java.util.*;

/**
 * https://leetcode.cn/contest/weekly-contest-335
 */
public class Problem2 {

    public static long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        List<Long> sums = new ArrayList<>();

        while (!queue.isEmpty()) {
            int size = queue.size();
            long sum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                sum += node.val;

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            sums.add(sum);
        }

        Collections.sort(sums);

        return sums.size() < k ? -1 : sums.get(sums.size() - k);
    }

    public static void main(String[] args) {
        TreeNode tst1 = TreeUtils.constructTree(new Integer[]{605481, null, 87336, null, 226750});
        System.out.println(" " + kthLargestLevelSum(tst1, 1));
    }
}
