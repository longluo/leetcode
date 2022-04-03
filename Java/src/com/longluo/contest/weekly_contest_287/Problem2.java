package com.longluo.contest.weekly_contest_287;

import java.util.*;

public class Problem2 {

    public static List<List<Integer>> findWinners(int[][] matches) {
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

    public static void main(String[] args) {
        findWinners(new int[][]{{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {10, 4}, {10, 9}});
    }
}
