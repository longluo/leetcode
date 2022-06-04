package com.longluo.top_interviews;

import java.util.*;

/**
 * 341. 扁平化嵌套列表迭代器
 * <p>
 * 给你一个嵌套的整数列表 nestedList 。每个元素要么是一个整数，要么是一个列表；该列表的元素也可能是整数或者是其他列表。请你实现一个迭代器将其扁平化，使之能够遍历这个列表中的所有整数。
 * <p>
 * 实现扁平迭代器类 NestedIterator ：
 * <p>
 * NestedIterator(List<NestedInteger> nestedList) 用嵌套列表 nestedList 初始化迭代器。
 * int next() 返回嵌套列表的下一个整数。
 * boolean hasNext() 如果仍然存在待迭代的整数，返回 true ；否则，返回 false 。
 * 你的代码将会用下述伪代码检测：
 * <p>
 * initialize iterator with nestedList
 * res = []
 * while iterator.hasNext()
 * append iterator.next() to the end of res
 * return res
 * 如果 res 与预期的扁平化列表匹配，那么你的代码将会被判为正确。
 * <p>
 * 示例 1：
 * 输入：nestedList = [[1,1],2,[1,1]]
 * 输出：[1,1,2,1,1]
 * 解释：通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。
 * <p>
 * 示例 2：
 * 输入：nestedList = [1,[4,[6]]]
 * 输出：[1,4,6]
 * 解释：通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,4,6]。
 * <p>
 * 提示：
 * 1 <= nestedList.length <= 500
 * 嵌套列表中的整数值在范围 [-10^6, 10^6] 内
 * <p>
 * https://leetcode.com/problems/flatten-nested-list-iterator/
 */
public class Problem341_flattenNestedListIterator {

    public interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    // DFS
    public class NestedIterator implements Iterator<Integer> {
        List<Integer> numList;
        Iterator<Integer> curIterator;

        public NestedIterator(List<NestedInteger> nestedList) {
            numList = new ArrayList<>();
            dfs(nestedList);
            curIterator = numList.iterator();
        }

        private void dfs(List<NestedInteger> nestedList) {
            if (nestedList == null) {
                return;
            }

            for (NestedInteger nested : nestedList) {
                if (nested.isInteger()) {
                    numList.add(nested.getInteger());
                } else {
                    dfs(nested.getList());
                }
            }
        }

        @Override
        public Integer next() {
            return curIterator.next();
        }

        @Override
        public boolean hasNext() {
            return curIterator.hasNext();
        }
    }

    public class NestedIterator_stack implements Iterator<Integer> {
        Deque<Iterator<NestedInteger>> stk;

        public NestedIterator_stack(List<NestedInteger> nestedList) {
            stk = new ArrayDeque<>();
            stk.push(nestedList.iterator());
        }

        @Override
        public Integer next() {
            return stk.peek().next().getInteger();
        }

        @Override
        public boolean hasNext() {
            while (!stk.isEmpty()) {
                Iterator<NestedInteger> iterator = stk.peek();
                if (!iterator.hasNext()) {
                    stk.pop();
                    continue;
                }

                NestedInteger nested = iterator.next();
                if (nested.isInteger()) {
                    List<NestedInteger> list = new ArrayList<>();
                    list.add(nested);
                    stk.push(list.iterator());
                    return true;
                }

                stk.push(nested.getList().iterator());
            }

            return false;
        }
    }

    public static void main(String[] args) {

    }
}
