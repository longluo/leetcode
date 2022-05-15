package com.longluo.contest.biweekly_contest_78;

import java.util.Arrays;

/**
 * 6068. 毯子覆盖的最多白色砖块数
 * <p>
 * 给你一个二维整数数组 tiles ，其中 tiles[i] = [li, ri] ，表示所有在 li <= j <= ri 之间的每个瓷砖位置 j 都被涂成了白色。
 * <p>
 * 同时给你一个整数 carpetLen ，表示可以放在 任何位置 的一块毯子。
 * <p>
 * 请你返回使用这块毯子，最多 可以盖住多少块瓷砖。
 * <p>
 * 示例 1：
 * 输入：tiles = [[1,5],[10,11],[12,18],[20,25],[30,32]], carpetLen = 10
 * 输出：9
 * 解释：将毯子从瓷砖 10 开始放置。
 * 总共覆盖 9 块瓷砖，所以返回 9 。
 * 注意可能有其他方案也可以覆盖 9 块瓷砖。
 * 可以看出，瓷砖无法覆盖超过 9 块瓷砖。
 * <p>
 * 示例 2：
 * 输入：tiles = [[10,11],[1,1]], carpetLen = 2
 * 输出：2
 * 解释：将毯子从瓷砖 10 开始放置。
 * 总共覆盖 2 块瓷砖，所以我们返回 2 。
 * <p>
 * 提示：
 * 1 <= tiles.length <= 5 * 104
 * tiles[i].length == 2
 * 1 <= li <= ri <= 109
 * 1 <= carpetLen <= 109
 * tiles 互相 不会重叠 。
 * <p>
 * https://leetcode.cn/problems/maximum-white-tiles-covered-by-a-carpet/
 */
public class Problem6068_maximumWhiteTilesCoveredByACarpet {

    // Sliding Window
    // TODO: 2022/5/15
    public static int maximumWhiteTiles(int[][] tiles, int carpetLen) {

        Arrays.sort(tiles, (o1, o2) -> o1[0] - o2[0]);

        int len = tiles.length;

        int max = 0;

        for (int i = 0; i < len; i++) {
            int left = tiles[i][0];
            int right = left + carpetLen - 1;

            for (int j = left; j <= right; j++) {
                int cover = 0;
                int temp = carpetLen;

                int diff = tiles[i][1] - j + 1;

                if (diff >= carpetLen) {
                    return carpetLen;
                }

                temp -= diff;
                cover += diff;
                int k = i + 1;

                while (temp > 0 && k < len) {
                    temp -= tiles[k][0] - tiles[k - 1][1] - 1;

                    int segLen = tiles[k][1] - tiles[k][0] + 1;

                    if (temp > segLen) {
                        temp -= segLen;
                        cover += segLen;
                    } else {
                        cover += temp;
                        break;
                    }

                    k++;
                }

                max = Math.max(max, cover);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(maximumWhiteTiles(new int[][]{{1, 1}}, 2));
        System.out.println(maximumWhiteTiles(new int[][]{{1, 3}}, 2));
        System.out.println(maximumWhiteTiles(new int[][]{{1, 5}}, 2));
        System.out.println(maximumWhiteTiles(new int[][]{{1, 5}}, 8));
        System.out.println(maximumWhiteTiles(new int[][]{{10, 11}, {1, 1}}, 2));
    }
}
