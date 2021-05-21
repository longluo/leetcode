package com.longluo.leetcode.tree;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

import java.util.*;

/**
 * 501. 二叉搜索树中的众数
 * <p>
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * <p>
 * 假定 BST 有如下定义：
 * <p>
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 * 1
 * \
 * 2
 * /
 * 2
 * 返回[2].
 * <p>
 * 提示：如果众数超过1个，不需考虑输出顺序
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 * <p>
 * https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
 */
public class Problem501_findModeInBinarySearchTree {

    public static int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }

        List<Integer> numsList = new ArrayList<>();
        inOrder(root, numsList);
        int n = numsList.size();
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            freq.put(numsList.get(i), freq.getOrDefault(numsList.get(i), 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(freq.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        int maxFreq = list.get(0).getValue();
        List<Integer> res = new ArrayList<>();
        res.add(list.get(0).getKey());
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).getValue() == maxFreq) {
                res.add(list.get(i).getKey());
            } else {
                break;
            }
        }

        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i).intValue();
        }

        return ans;
    }

    public static void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    public static int[] findMode_1(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }

        List<Integer> numsList = new ArrayList<>();
        inOrder(root, numsList);
        int n = numsList.size();
        int base = 0;
        int count = 0;
        int maxCount = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (numsList.get(i) == base) {
                count++;
            } else {
                base = numsList.get(i);
                count = 1;
            }
            if (count == maxCount) {
                ans.add(base);
            }
            if (count > maxCount) {
                maxCount = count;
                ans.clear();
                ans.add(base);
            }
        }

        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }

        return res;
    }

    static int base, count, maxCount;
    static List<Integer> answer = new ArrayList<Integer>();

    public static int[] findMode_2(TreeNode root) {
        TreeNode cur = root;
        TreeNode pre = null;
        base = 0;
        count = 0;
        maxCount = 0;
        answer.clear();
        while (cur != null) {
            if (cur.left == null) {
                update(cur.val);
                cur = cur.right;
                continue;
            }
            pre = cur.left;
            while (pre.right != null && pre.right != cur) {
                pre = pre.right;
            }
            if (pre.right == null) {
                pre.right = cur;
                cur = cur.left;
            } else {
                pre.right = null;
                update(cur.val);
                cur = cur.right;
            }
        }
        int[] mode = new int[answer.size()];
        for (int i = 0; i < answer.size(); ++i) {
            mode[i] = answer.get(i);
        }
        return mode;
    }

    public static void update(int x) {
        if (x == base) {
            ++count;
        } else {
            count = 1;
            base = x;
        }
        if (count == maxCount) {
            answer.add(base);
        }
        if (count > maxCount) {
            maxCount = count;
            answer.clear();
            answer.add(base);
        }
    }

    public static void main(String[] args) {
        TreeNode tst1 = TreeUtils.constructTree(new Integer[]{1, null, 2, 2});
        System.out.println("[2] ?= " + Arrays.toString(findMode(tst1)));
        System.out.println("[2] ?= " + Arrays.toString(findMode_1(tst1)));
        System.out.println("[2] ?= " + Arrays.toString(findMode_2(tst1)));

        TreeNode tst2 = TreeUtils.constructTree(new Integer[]{1, null, 2});
        System.out.println("[2, 1] ?= " + Arrays.toString(findMode(tst2)));
        System.out.println("[2, 1] ?= " + Arrays.toString(findMode_1(tst2)));
        System.out.println("[2, 1] ?= " + Arrays.toString(findMode_2(tst2)));
    }
}
