package com.longluo.leetcode.backtrace;

import com.longluo.datastructure.ArrayUtils;

import java.util.*;

/**
 * 90. 子集 II
 * 给你一个整数数组 nums，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * <p>
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * <p>
 * 提示：
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 */
public class Problem90_subsets_ii {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> ans = new ArrayList<>();
        backtrace(ans, new ArrayList<>(), nums, 0);
        Collections.sort(ans, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.size() - o2.size();
            }
        });

        Set<Integer> remove = new HashSet<>();
        for (int i = 0; i < ans.size(); i++) {
            List<Integer> curList = ans.get(i);
            for (int j = i + 1; j < ans.size(); j++) {
                List<Integer> otherList = ans.get(j);
                Collections.sort(curList);
                Collections.sort(otherList);
                if (curList.size() == otherList.size()) {
                    if (curList.toString().equalsIgnoreCase(otherList.toString())) {
                        remove.add(j);
                    }
                } else {
                    break;
                }
            }
        }

        Integer[] arr = remove.toArray(new Integer[0]);
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = arr[i];
            ans.remove(temp);
        }

        return ans;
    }

    public static void backtrace(List<List<Integer>> ans, List<Integer> oneList, int[] numbers, int index) {
        if (index == numbers.length) {
            ans.add(new ArrayList<>(oneList));
            return;
        }

        oneList.add(numbers[index]);
        backtrace(ans, oneList, numbers, index + 1);
        oneList.remove(oneList.size() - 1);
        backtrace(ans, oneList, numbers, index + 1);
    }

    public static void main(String[] args) {
        System.out.println("[[],[1],[1,2],[1,2,2],[2],[2,2]] ?= " + ArrayUtils.print2DList(subsetsWithDup(new int[]{1, 2, 2})));
        System.out.println("[[],[1],[1,1],[1,1,2],[1,1,2,2],[1,2],[1,2,2],[2],[2,2]] ?= " + ArrayUtils.print2DList(subsetsWithDup(new int[]{1, 1, 2, 2})));
        System.out.println("[[],[0]] ?= " + ArrayUtils.print2DList(subsetsWithDup(new int[]{0})));
    }
}
