package com.longluo.offer;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

import java.util.*;

/**
 * 剑指 Offer 37. 序列化二叉树
 * <p>
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 * 你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，
 * 你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 * 提示：输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。
 * 你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * <p>
 * 示例：
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 * <p>
 * https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof/
 */
public class Offer37_xuLieHuaErChaShuLcof {

    public static class Codec {

        // Encodes a tree to a single string.
        public static String serialize(TreeNode root) {
            if (root == null) {
                return "[]";
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node != null) {
                    sb.append(node.val).append(",");
                    queue.offer(node.left);
                    queue.offer(node.right);
                } else {
                    sb.append("null").append(",");
                }
            }

            sb.deleteCharAt(sb.length() - 1);
            sb.append("]");

            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public static TreeNode deserialize(String data) {
            if (data == null || data.length() == 0 || data.equals("[]")) {
                return null;
            }

            data = data.replace(" ", "");
            String treeStr = data.substring(1, data.length() - 1);
            String[] nodeStrArray = treeStr.split("\\,");
            Queue<TreeNode> queue = new LinkedList<>();
            TreeNode head = new TreeNode(Integer.parseInt(nodeStrArray[0]));
            queue.offer(head);
            int idx = 1;
            while (!queue.isEmpty()) {
                int size = queue.size();
                TreeNode node = queue.poll();
                if (!nodeStrArray[idx].equals("null")) {
                    int leftChild = Integer.parseInt(nodeStrArray[idx]);
                    TreeNode leftNode = new TreeNode(leftChild);
                    node.left = leftNode;
                    queue.offer(leftNode);
                }
                idx++;
                if (!nodeStrArray[idx].equals("null")) {
                    int rightChild = Integer.parseInt(nodeStrArray[idx]);
                    TreeNode rightNode = new TreeNode(rightChild);
                    node.right = rightNode;
                    queue.offer(rightNode);
                }
                idx++;
            }

            return head;
        }
    }

    public static void main(String[] args) {
        TreeNode tst1 = TreeUtils.constructTree(new Integer[]{1, 2, 3, null, null, 4, 5});
        System.out.println("[1,2,3,null,null,4,5] ?= " + Codec.serialize(tst1));
        TreeNode rst1 = Codec.deserialize(Codec.serialize(tst1));
        TreeUtils.printTree(rst1);

        String str = "[1, 2, 3, null, null, 4, 5, null, null, null, null]";
        str = str.trim();
        str = str.replace(" ", "");
        String[] array = str.substring(1, str.length() - 1).split("\\,");
    }
}
