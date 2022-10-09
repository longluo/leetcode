package com.longluo.algo200;

import com.longluo.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 314. 二叉树的垂直遍历
 * <p>
 * 给你一个二叉树的根结点，返回其结点按 垂直方向（从上到下，逐列）遍历的结果。
 * <p>
 * 如果两个结点在同一行和列，那么顺序则为 从左到右。
 * <p>
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[9],[3,15],[20],[7]]
 * <p>
 * 示例 2：
 * 输入：root = [3,9,8,4,0,1,7]
 * 输出：[[4],[9],[3,0,1],[8],[7]]
 * <p>
 * 示例 3：
 * 输入：root = [3,9,8,4,0,1,7,null,null,null,2,5]
 * 输出：[[4],[9,5],[3,0,1],[8,2],[7]]
 * <p>
 * 提示：
 * 树中结点的数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 * <p>
 * https://leetcode.cn/problems/binary-tree-vertical-order-traversal/
 */
public class Problem314_verticalOrderTraversal {

    public static List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        return ans;
    }

    public static void main(String[] args) {

    }
}
