package com.longluo.leetcode.graph;

import java.util.*;

/**
 * 5235. 找出输掉零场或一场比赛的玩家
 * <p>
 * 给你一个整数数组 matches 其中 matches[i] = [winneri, loseri] 表示在一场比赛中 winneri 击败了 loseri 。
 * <p>
 * 返回一个长度为 2 的列表 answer ：
 * <p>
 * answer[0] 是所有 没有 输掉任何比赛的玩家列表。
 * answer[1] 是所有恰好输掉 一场 比赛的玩家列表。
 * 两个列表中的值都应该按 递增 顺序返回。
 * <p>
 * 注意：
 * 只考虑那些参与 至少一场 比赛的玩家。
 * 生成的测试用例保证 不存在 两场比赛结果 相同 。
 * <p>
 * 示例 1：
 * 输入：matches = [[1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9]]
 * 输出：[[1,2,10},{4,5,7,8]]
 * 解释：
 * 玩家 1、2 和 10 都没有输掉任何比赛。
 * 玩家 4、5、7 和 8 每个都输掉一场比赛。
 * 玩家 3、6 和 9 每个都输掉两场比赛。
 * 因此，answer[0] = [1,2,10] 和 answer[1] = [4,5,7,8] 。
 * <p>
 * 示例 2：
 * 输入：matches = [[2,3},{1,3},{5,4},{6,4]]
 * 输出：[[1,2,5,6},{]]
 * 解释：
 * 玩家 1、2、5 和 6 都没有输掉任何比赛。
 * 玩家 3 和 4 每个都输掉两场比赛。
 * 因此，answer[0] = [1,2,5,6] 和 answer[1] = [] 。
 * <p>
 * <p>
 * 提示：
 * 1 <= matches.length <= 10^5
 * matches[i].length == 2
 * 1 <= winneri, loseri <= 10^5
 * winneri != loseri
 * 所有 matches[i] 互不相同
 * <p>
 * https://leetcode-cn.com/problems/find-players-with-zero-or-one-losses/
 */
public class Problem5235_findPlayersWithZeroOrOneLosses {

    // BF + Hash time: O(n*2) space: O(3*n)
    public List<List<Integer>> findWinners_bf(int[][] matches) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = matches.length;
        if (len <= 1) {
            ans.add(Arrays.asList(matches[0][0]));
            ans.add(Arrays.asList(matches[0][1]));
            return ans;
        }

        Set<Integer> winnerSet = new HashSet<>();
        Set<Integer> matchSet = new HashSet<>();
        Set<Integer> loserSet = new HashSet<>();
        Map<Integer, Integer> loserMap = new HashMap<>();
        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];

            matchSet.add(winner);
            matchSet.add(loser);
            winnerSet.add(winner);
            loserSet.add(loser);
            loserMap.put(loser, loserMap.getOrDefault(loser, 0) + 1);
        }

        List<Integer> winList = new ArrayList<>();
        for (Integer no : winnerSet) {
            if (matchSet.contains(no) && !loserSet.contains(no)) {
                winList.add(no);
            }
        }

        List<Integer> loseList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : loserMap.entrySet()) {
            if (entry.getValue() == 1 && matchSet.contains(entry.getKey())) {
                loseList.add(entry.getKey());
            }
        }

        Collections.sort(winList);
        Collections.sort(loseList);
        ans.add(winList);
        ans.add(loseList);

        return ans;
    }

    // BF + Hash time: O(n*2) space: O(n)
    public static List<List<Integer>> findWinners_hash(int[][] matches) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = matches.length;
        if (len <= 1) {
            ans.add(Arrays.asList(matches[0][0]));
            ans.add(Arrays.asList(matches[0][1]));
            return ans;
        }

        Map<Integer, Integer> playerMap = new HashMap<>();
        for (int[] match : matches) {
            int winnerTimes = playerMap.getOrDefault(match[0], 0);
            if (winnerTimes >= 0) {
                playerMap.put(match[0], winnerTimes + 1);
            } else {
                playerMap.put(match[0], -2);
            }
            int loserTimes = playerMap.getOrDefault(match[1], 0);
            if (loserTimes > 0) {
                playerMap.put(match[1], -2);
            } else {
                playerMap.put(match[1], loserTimes - 1);
            }
        }

        List<Integer> winnerList = new ArrayList<>();
        List<Integer> loseList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : playerMap.entrySet()) {
            int player = entry.getKey();
            int times = entry.getValue();
            if (times > 0) {
                winnerList.add(player);
            } else if (times == -1) {
                loseList.add(player);
            }
        }

        Collections.sort(winnerList);
        Collections.sort(loseList);
        ans.add(winnerList);
        ans.add(loseList);

        return ans;
    }

    public static void main(String[] args) {
        findWinners_hash(new int[][]{{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {10, 4}, {10, 9}});
    }
}
