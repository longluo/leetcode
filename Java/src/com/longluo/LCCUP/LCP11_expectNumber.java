package com.longluo.LCCUP;

import java.util.*;

/**
 * LCP 11. 期望个数统计
 * <p>
 * 某互联网公司一年一度的春招开始了，一共有 n 名面试者入选。每名面试者都会提交一份简历，
 * 公司会根据提供的简历资料产生一个预估的能力值，数值越大代表越有可能通过面试。
 * <p>
 * 小 A 和小 B 负责审核面试者，他们均有所有面试者的简历，并且将各自根据面试者能力值从大到小的顺序浏览。
 * 由于简历事先被打乱过，能力值相同的简历的出现顺序是从它们的全排列中等可能地取一个。
 * 现在给定 n 名面试者的能力值 scores，设 X 代表小 A 和小 B 的浏览顺序中出现在同一位置的简历数，求 X 的期望。
 * <p>
 * 提示：离散的非负随机变量的期望计算公式为 1。在本题中，由于 X 的取值为 0 到 n 之间，期望计算公式可以是 2。
 * <p>
 * 示例 1：
 * 输入：scores = [1,2,3]
 * 输出：3
 * 解释：由于面试者能力值互不相同，小 A 和小 B 的浏览顺序一定是相同的。X的期望是 3 。
 * <p>
 * 示例 2：
 * 输入：scores = [1,1]
 * 输出：1
 * 解释：设两位面试者的编号为 0, 1。由于他们的能力值都是 1，小 A 和小 B 的浏览顺序都为从全排列 [[0,1],[1,0]] 中等可能地取一个。如果小 A 和小 B 的浏览顺序都是 [0,1] 或者 [1,0] ，那么出现在同一位置的简历数为 2 ，否则是 0 。所以 X 的期望是 (2+0+2+0) * 1/4 = 1
 * <p>
 * 示例 3：
 * 输入：scores = [1,1,2]
 * 输出：2
 * <p>
 * 限制：
 * 1 <= scores.length <= 10^5
 * 0 <= scores[i] <= 10^6
 * <p>
 * https://leetcode.cn/problems/qi-wang-ge-shu-tong-ji/
 */
public class LCP11_expectNumber {

    // Math time: O(n) space: O(n)
    //将数组随机打乱两次，求打乱后两个数组中a[i]==b[i]的元素个数数学期望X
    //对于确定的数组b，设a[i]==b[i]的元素个数数学期望为Y
    //则Y=X*P(b出现的概率)=X*(1/n!)=X/n!  即X=Y*n!
    //由于打乱后的每个排列出现概率是一样的，不妨取数组b为特殊排列b[i]=i
    //问题转化为"对所有i，满足b[i]=i"的情况下求a[i]=i的元素个数的数学期望Y，再求X=Y*n!
    //由于"对所有i，b[i]=i"的概率为1/n!
    //问题进一步简化为求a[i]=i的元素个数数学期望Z,再求X=Z*1/n!*n!=Z
    //即问题简化为求将数组任意打乱后整个数组中a[i]=i的元素个数的数学期望
    //对任意元素j，a[j]==j的概率为1/n。总计共n个元素
    //即：Z=1/n*n=1 为确定值，与数组长度n无关
    //对于简历数组，每一段分数相同的元素可以视为一个可随机打断的数组
    //求原数组可分段数=求不同分数的个数
    public static int expectNumber(int[] scores) {
        Set<Integer> set = new HashSet<>();
        for (int x : scores) {
            set.add(x);
        }

        return set.size();
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + expectNumber(new int[]{1, 2, 3}));
        System.out.println("1 ?= " + expectNumber(new int[]{1, 1}));
    }
}
