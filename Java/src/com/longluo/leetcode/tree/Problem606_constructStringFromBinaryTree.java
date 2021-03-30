package com.longluo.leetcode.tree;

import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 606. 根据二叉树创建字符串
 * 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
 * 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
 * <p>
 * 示例 1:
 * 输入: 二叉树: [1,2,3,4]
 * 1
 * /   \
 * 2     3
 * /
 * 4
 * 输出: "1(2(4))(3)"
 * 解释: 原本将是“1(2(4)())(3())”，
 * 在你省略所有不必要的空括号对之后，
 * 它将是“1(2(4))(3)”。
 * <p>
 * 示例 2:
 * 输入: 二叉树: [1,2,3,null,4]
 * 1
 * /   \
 * 2    3
 * \
 * 4
 * <p>
 * 输出: "1(2()(4))(3)"
 * <p>
 * 解释: 和第一个示例相似，
 * 除了我们不能省略第一个对括号来中断输入和输出之间的一对一映射关系。
 */
public class Problem606_constructStringFromBinaryTree {

    public static String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }

        if (t != null && t.left == null && t.right == null) {
            return t.val + "";
        }

        if (t.right == null) {
            return t.val + "(" + tree2str(t.left) + ")";
        }

        return t.val + "(" + tree2str(t.left) + ")" + "(" + tree2str(t.right) + ")";
    }

    public static String tree2str2(TreeNode t) {
        if (t == null) {
            return "";
        }

        Stack<TreeNode> st = new Stack<>();
        Set<TreeNode> visited = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        st.push(t);
        while (!st.empty()) {
            t = st.peek();
            if (visited.contains(t)) {
                st.pop();
                sb.append(")");
            } else {
                visited.add(t);
                sb.append("(" + t.val);
                if (t.left == null && t.right != null) {
                    sb.append("()");
                }
                if (t.right != null) {
                    st.push(t.right);
                }
                if (t.left != null) {
                    st.push(t.left);
                }
            }
        }

        return sb.substring(1, sb.length() - 1);
    }

    public static String tree2str3(TreeNode t) {
        if (t == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        preOrder(null, t, sb);
        return sb.toString();
    }

    public static void preOrder(TreeNode parent, TreeNode node, StringBuilder sb) {
        if (node != null) {
            if (parent == null) {
                sb.append(node.val);
                preOrder(node, node.left, sb);
                preOrder(node, node.right, sb);
            } else {
                sb.append("(");
                sb.append(node.val);
                preOrder(node, node.left, sb);
                preOrder(node, node.right, sb);
                sb.append(")");
            }
        } else {
            if (parent.left == null && parent.right != null) {
                sb.append("()");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("1(2(4))(3) ?= " + tree2str(TreeUtils.constructTree(new Integer[]{1, 2, 3, 4})));
        System.out.println("1(2(4))(3) ?= " + tree2str2(TreeUtils.constructTree(new Integer[]{1, 2, 3, 4})));
        System.out.println("1(2(4))(3) ?= " + tree2str3(TreeUtils.constructTree(new Integer[]{1, 2, 3, 4})));

        System.out.println("1(2()(4))(3) ?= " + tree2str(TreeUtils.constructTree(new Integer[]{1, 2, 3, null, 4})));
        System.out.println("1(2()(4))(3) ?= " + tree2str2(TreeUtils.constructTree(new Integer[]{1, 2, 3, null, 4})));
        System.out.println("1(2()(4))(3) ?= " + tree2str3(TreeUtils.constructTree(new Integer[]{1, 2, 3, null, 4})));
    }
}
