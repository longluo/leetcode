package com.longluo.leetcode.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 1138. 字母板上的路径
 * <p>
 * 我们从一块字母板上的位置 (0, 0) 出发，该坐标对应的字符为 board[0][0]。
 * <p>
 * 在本题里，字母板为board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"]，如下所示。
 * <p>
 * 我们可以按下面的指令规则行动：
 * <p>
 * 如果方格存在，'U' 意味着将我们的位置上移一行；
 * 如果方格存在，'D' 意味着将我们的位置下移一行；
 * 如果方格存在，'L' 意味着将我们的位置左移一列；
 * 如果方格存在，'R' 意味着将我们的位置右移一列；
 * '!' 会把在我们当前位置 (r, c) 的字符 board[r][c] 添加到答案中。
 * （注意，字母板上只存在有字母的位置。）
 * <p>
 * 返回指令序列，用最小的行动次数让答案和目标 target 相同。你可以返回任何达成目标的路径。
 * <p>
 * 示例 1：
 * 输入：target = "leet"
 * 输出："DDR!UURRR!!DDD!"
 * <p>
 * 示例 2：
 * 输入：target = "code"
 * 输出："RR!DDRR!UUL!R!"
 * <p>
 * 提示：
 * 1 <= target.length <= 100
 * target 仅含有小写英文字母。
 * <p>
 * https://leetcode.cn/problems/alphabet-board-path/
 */
public class Problem1138_alphabetBoardPath {

    // HashMap time: O(n) space: O(C)
    public static String alphabetBoardPath(String target) {
        Map<Character, int[]> map = new HashMap<>();

        int cols = 5;

        for (char ch = 'a'; ch <= 'z'; ch++) {
            int idx = ch - 'a';

            int rowIdx = idx / cols;
            int colIdx = idx % cols;

            map.put(ch, new int[]{rowIdx, colIdx});
        }

        int[] cur = {0, 0};
        char curCh = 'a';

        StringBuilder sb = new StringBuilder();
        for (char ch : target.toCharArray()) {
            if (curCh == ch) {
                sb.append('!');
                continue;
            }

            char flexCh = ch;
            if (ch == 'z') {
                flexCh = 'u';
            } else {
                if (curCh == 'z') {
                    sb.append('U');
                    curCh = 'u';
                    cur[0]--;
                }
            }

            int[] pos = map.get(flexCh);

            for (int j = 1; j <= Math.abs(pos[0] - cur[0]); j++) {
                int gap = j * cols;

                if (cur[0] < pos[0]) {
                    curCh += gap;
                    sb.append('D');
                } else {
                    curCh -= gap;
                    sb.append('U');
                }
            }

            for (int i = 1; i <= Math.abs(pos[1] - cur[1]); i++) {
                if (cur[1] < pos[1]) {
                    curCh++;
                    sb.append('R');
                } else {
                    curCh--;
                    sb.append('L');
                }
            }

            if (ch == 'z') {
                sb.append('D').append('!');
            } else {
                sb.append('!');
            }

            curCh = ch;

            int[] temp = map.get(ch);
            cur[0] = temp[0];
            cur[1] = temp[1];
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("DDDDD!UURRR!DLLLD!UUUR! ?= " + alphabetBoardPath("zszl"));
        System.out.println("DDR!UURRR!!DDD! ?= " + alphabetBoardPath("leet"));
        System.out.println("RR!DDRR!UUL!R! ?= " + alphabetBoardPath("code"));
        System.out.println("DDDDD!UUUUURRR!DDDDLLLD! ?= " + alphabetBoardPath("zdz"));
    }
}
