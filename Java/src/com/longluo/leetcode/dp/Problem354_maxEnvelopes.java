package com.longluo.leetcode.dp;

import java.util.*;

/**
 * 354. 俄罗斯套娃信封问题
 * <p>
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，
 * 这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 * <p>
 * 说明:
 * 不允许旋转信封。
 * <p>
 * 示例:
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 * <p>
 * 示例 2：
 * 输入：envelopes = [[1,1],[1,1],[1,1]]
 * 输出：1
 * <p>
 * 提示：
 * 1 <= envelopes.length <= 10^5
 * envelopes[i].length == 2
 * 1 <= wi, hi <= 10^5
 * <p>
 * https://leetcode.cn/problems/russian-doll-envelopes/
 */
public class Problem354_maxEnvelopes {

    // BF time: O(n^2 + nlogn) space: O(logn)
    public static int maxEnvelopes_bf(int[][] envelopes) {
        int len = envelopes.length;
        if (len <= 1) {
            return len;
        }

        Arrays.sort(envelopes, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);

        int ans = 1;
        for (int i = 0; i < len; i++) {
            int w = envelopes[i][0];
            int h = envelopes[i][1];
            int cnt = 1;
            for (int j = i + 1; j < len; j++) {
                if (envelopes[j][0] > w && envelopes[j][1] > h) {
                    w = envelopes[j][0];
                    h = envelopes[j][1];
                    cnt++;
                }
            }

            ans = Math.max(ans, cnt);
        }

        return ans;
    }

    public static int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0 || envelopes[0].length == 0) {
            return 0;
        }

        int res = 1;
        res = Math.max(getEnvelopesNumber(envelopes, true), getEnvelopesNumber(envelopes, false));
        return res;
    }

    public static int getEnvelopesNumber(int[][] envelopes, boolean compareWidth) {
        if (compareWidth) {
            Arrays.sort(envelopes, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] == o2[0]) {
                        return o1[1] - o2[1];
                    }

                    return o1[0] - o2[0];
                }
            });
        } else {
            Arrays.sort(envelopes, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[1] == o2[1]) {
                        return o1[0] - o2[0];
                    }

                    return o1[1] - o2[1];
                }
            });
        }

        int[] last = new int[2];
        int ans = 0;
        int max = 0;
        for (int i = 0; i < envelopes.length; i++) {
            last[0] = envelopes[i][0];
            last[1] = envelopes[i][1];
            max = 1;
            for (int j = 1; j < envelopes.length; j++) {
                if (envelopes[j][0] > last[0] && envelopes[j][1] > last[1]) {
                    max++;
                    last[0] = envelopes[j][0];
                    last[1] = envelopes[j][1];
                    continue;
                }
            }
            ans = Math.max(ans, max);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + maxEnvelopes_bf(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}}));
        System.out.println("5 ?= " + maxEnvelopes_bf(new int[][]{{2, 100}, {3, 200}, {4, 300}, {5, 500}, {5, 400}, {5, 250}, {6, 370}, {6, 360}, {7, 380}}));

        System.out.println("3 ?= " + maxEnvelopes(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}}));
        System.out.println("5 ?= " + maxEnvelopes(new int[][]{{2, 100}, {3, 200}, {4, 300}, {5, 500}, {5, 400}, {5, 250}, {6, 370}, {6, 360}, {7, 380}}));
        System.out.println("3 ?= " + maxEnvelopes(new int[][]{{46, 89}, {50, 53}, {52, 68}, {72, 45}, {77, 81}}));
        System.out.println("5 ?= " + maxEnvelopes(new int[][]{{15, 8}, {2, 20}, {2, 14}, {4, 17}, {8, 19}, {8, 9}, {5, 7}, {11, 19}, {8, 11}, {13, 11}, {2, 13}, {11, 19}, {8, 11}, {13, 11}, {2, 13}, {11, 19}, {16, 1}, {18, 13}, {14, 17}, {18, 19}}));
    }
}
