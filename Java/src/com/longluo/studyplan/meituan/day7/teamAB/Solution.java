package com.longluo.studyplan.meituan.day7.teamAB;

import java.util.*;

/**
 * meituan-014. 小团的AB队
 * <p>
 * 小团要组织一只队伍参加 MT 杯竞赛，某媒体赛前要对各参赛队伍实力进行评估，已知这个比赛要求每一个参赛方组织一支由 x 个人组成的 A 队，
 * 和 y 个人组成的 B 队，这个媒体在评估时会把 A 队的人员的平均实力值和 B 队人员的平均实力值相加，从而得到一个参赛方的综合实力评估。
 * 小团可选的人手有限，只有 x+y 个人可以供他选择，但是显然不同的人员安排会有不同的综合实力评估，他希望他的综合实力评估尽可能高，
 * 请你帮助他完成分队。
 * <p>
 * 格式：
 * 输入：
 * - 输入第一行包含两个正整数x，y，分别表示 AB 队的人数。
 * - 输入第二行包含 x+y 个正整数，中间用空格隔开，第i个数字表示第i个人的实力值，每个人的实力值不会超过20000，
 * 保证任意两个人都不会有相同的实力值。
 * 输出：
 * - 输出包含一个长度为 x+y 的字符串，每个字符是 'A'或 'B'，表示某人应该被分在 A 或 B 队。如果存在多种答案，
 * 则输出字典序最小的字符串。
 * <p>
 * 示例：
 * 输入：
 * 4 4
 * 5 6 4 2 3 8 1 7
 * 输出：AAAABBBB
 * <p>
 * 提示：
 * 1 <= x, y <= 20000
 * <p>
 * https://leetcode-cn.com/problems/LMkFuT/
 */
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int teamANum = sc.nextInt();
        int teamBNum = sc.nextInt();
        int total = teamANum + teamBNum;
        PriorityQueue<AbstractMap.SimpleEntry<Integer, Integer>> priorityQueue = new PriorityQueue<>(new Comparator<AbstractMap.SimpleEntry<Integer, Integer>>() {
            @Override
            public int compare(AbstractMap.SimpleEntry<Integer, Integer> o1, AbstractMap.SimpleEntry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        for (int i = 0; i < total; i++) {
            int value = sc.nextInt();
            priorityQueue.add(new AbstractMap.SimpleEntry<Integer, Integer>(i, value));
        }
        StringBuilder sb = new StringBuilder(total);
        if (teamANum == teamBNum) {
            for (int i = 0; i < teamANum; i++) {
                sb.append('A');
            }
            for (int i = 0; i < teamBNum; i++) {
                sb.append('B');
            }

            System.out.println(sb.toString());
            return;
        }

        String ans;
        if (teamANum < teamBNum) {
            ans = makeResult(priorityQueue, total, teamANum, true);
        } else {
            ans = makeResult(priorityQueue, total, teamBNum, false);
        }
        System.out.println(ans);
    }

    public static String makeResult(PriorityQueue<AbstractMap.SimpleEntry<Integer, Integer>> priorityQueue, int total, int lessNumTeam, boolean isTeamA) {
        char[] mark = new char[total];
        Arrays.fill(mark, 'x');
        while (lessNumTeam > 0 && !priorityQueue.isEmpty()) {
            Map.Entry<Integer, Integer> head = priorityQueue.poll();
            int key = head.getKey();
            if (isTeamA) {
                mark[key] = 'A';
            } else {
                mark[key] = 'B';
            }
            lessNumTeam--;
        }
        for (int i = 0; i < total; i++) {
            if (mark[i] == 'x') {
                if (isTeamA) {
                    mark[i] = 'B';
                } else {
                    mark[i] = 'A';
                }
            }
        }
        String result = new String(mark);
        return result;
    }
}
