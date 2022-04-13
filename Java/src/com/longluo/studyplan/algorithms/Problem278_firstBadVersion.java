package com.longluo.studyplan.algorithms;

/**
 * 278. 第一个错误的版本
 * <p>
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。
 * 由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 * <p>
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。
 * 实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 * <p>
 * 示例 1：
 * 输入：n = 5, bad = 4
 * 输出：4
 * 解释：
 * 调用 isBadVersion(3) -> false
 * 调用 isBadVersion(5) -> true
 * 调用 isBadVersion(4) -> true
 * 所以，4 是第一个错误的版本。
 * <p>
 * 示例 2：
 * 输入：n = 1, bad = 1
 * 输出：1
 * <p>
 * 提示：
 * 1 <= bad <= n <= 2^31 - 1
 * <p>
 * https://leetcode-cn.com/problems/first-bad-version/
 */
public class Problem278_firstBadVersion {

    public boolean isBadVersion(int version) {
        return false;
    }

    public int firstBadVersion(int n) {
        int begin = 1;
        int end = n;

        while (begin <= end) {
            int mid = begin + (end - begin) / 2;
            if (isBadVersion(mid)) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }

        return begin;
    }

    public static void main(String[] args) {

    }
}
