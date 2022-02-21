package com.longluo.leetcode.twopointers;

/**
 * 838. 推多米诺
 * <p>
 * n张多米诺骨牌排成一行，将每张多米诺骨牌垂直竖立。在开始时，同时把一些多米诺骨牌向左或向右推。
 * 每过一秒，倒向左边的多米诺骨牌会推动其左侧相邻的多米诺骨牌。同样地，倒向右边的多米诺骨牌也会推动竖立在其右侧的相邻多米诺骨牌。
 * 如果一张垂直竖立的多米诺骨牌的两侧同时有多米诺骨牌倒下时，由于受力平衡， 该骨牌仍然保持不变。
 * 就这个问题而言，我们会认为一张正在倒下的多米诺骨牌不会对其它正在倒下或已经倒下的多米诺骨牌施加额外的力。
 * <p>
 * 给你一个字符串 dominoes 表示这一行多米诺骨牌的初始状态，其中：
 * <p>
 * dominoes[i] = 'L'，表示第 i 张多米诺骨牌被推向左侧，
 * dominoes[i] = 'R'，表示第 i 张多米诺骨牌被推向右侧，
 * dominoes[i] = '.'，表示没有推动第 i 张多米诺骨牌。
 * 返回表示最终状态的字符串。
 * <p>
 * 示例 1：
 * 输入：dominoes = "RR.L"
 * 输出："RR.L"
 * 解释：第一张多米诺骨牌没有给第二张施加额外的力。
 * <p>
 * 示例 2：
 * 输入：dominoes = ".L.R...LR..L.."
 * 输出："LL.RR.LLRRLL.."
 * <p>
 * 提示：
 * n == dominoes.length
 * 1 <= n <= 10^5
 * dominoes[i] 为 'L'、'R' 或 '.'
 * <p>
 * https://leetcode-cn.com/problems/push-dominoes/
 */
public class Problem838_pushDominoes {

    public static String pushDominoes(String dominoes) {
        if (dominoes == null || dominoes.length() <= 1) {
            return dominoes;
        }

        int len = dominoes.length();
        StringBuilder sb = new StringBuilder(len);
        int idx = 0;
        char lastCh = dominoes.charAt(idx);
        if (lastCh == '.' && idx + 1 < len && dominoes.charAt(idx + 1) == 'L') {
            lastCh = 'L';
        }
        sb.append(lastCh);
        idx++;
        while (idx < len - 1) {
            char currentCh = dominoes.charAt(idx);
            char nextCh = dominoes.charAt(idx + 1);

            if (currentCh == 'L' || currentCh == 'R') {
                sb.append(currentCh);
            } else if (currentCh == '.') {
                if ((lastCh == 'L' && nextCh == 'R') || (lastCh == 'R' && nextCh == 'L')) {
                    sb.append(currentCh);
                } else if (lastCh == 'L' && (nextCh == '.' || nextCh == 'L')) {
                    currentCh = 'L';
                    sb.append(currentCh);
                } else if (lastCh == 'R') {
                    currentCh = 'R';
                    sb.append(currentCh);
                }
            }

            lastCh = currentCh;
            idx++;
        }

        if (lastCh == 'R' && dominoes.charAt(idx) == '.') {
            sb.append('R');
        } else {
            sb.append(dominoes.charAt(idx));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("RR.L ?= " + pushDominoes("RR.L"));
        System.out.println("LL.RR.LLRRLL.. ?= " + pushDominoes(".L.R...LR..L.."));
    }
}
