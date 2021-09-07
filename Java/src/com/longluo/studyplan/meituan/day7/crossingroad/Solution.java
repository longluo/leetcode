package com.longluo.studyplan.meituan.day7.crossingroad;

import java.util.*;

/**
 * meituan-015. 十字路口
 * <p>
 * 在小美和小团生活的城市中，有 n 行 m 列共计 n * m 个十字路口，第 i 行 j 列的十字路口有两个属性 a[i][j]，b[i][j] 。
 * 当行人处在 i 行 j 列的路口，对于任意非负整数 k :
 * 当时间处在 [k * a[i][j] + k * b[i][j], (k+1) * a[i][j] + k * b[i][j])时，行人可以选择走到 i±1 行 j 列的路口。
 * 当时间处在 [(k+1) * a[i][j] + k * b[i][j], (k+1) * a[i][j] + (k+1) * b[i][j])时，行人可以选择走到 i 行 j±1 列的路口。
 * 每次移动花费的时间为 1 ，且要保证将要去的十字路口存在，即属于 n * m 个路口当中。可以选择原地静止不动。
 * 在第 0 时刻，小美处在 xs 行 ys 列的十字路口处，要去 xt 行 yt 列的十字路口找小团。
 * 小团原地不动等小美，请问小美所花费的时间最少是多少?
 * <p>
 * 格式：
 * 输入：
 * - 第一行六个正整数 n,m,xs,ys,xt,yt ，含义如上文所示。以样例第一行【5、5、2、4、4、3】 共计 6 个数字为例：
 * - 前两位数字代表有 5*5 的二维数组
 * - 三、四位数字代表小美处在 2 行 4 列的十字路口处
 * - 五、六位数字代表要去 4 行 3 列的十字路口找小团。
 * - 接下来 n 行每行 m 个正整数，在样例中为第一个 5*5 的二维数组，第 i 行第 j 个数代表 i 行 j 列十字路口的属性 a[i][j] 。
 * - 接下来 n 行每行 m 个正整数，在样例中为第二个 5*5 的二维数组，第 i 行第 j 个数代表 i 行 j 列十字路口的属性 b[i][j]。
 * 输出：
 * - 输出 1 行 1 个整数代表答案。
 * <p>
 * 示例：
 * 输入：
 * 5 5 2 4 4 3
 * 2 1 1 3 1
 * 1 4 2 3 1
 * 4 4 4 2 1
 * 3 1 1 2 4
 * 5 1 5 5 1
 * 5 3 4 1 3
 * 1 1 2 2 2
 * 2 1 4 4 5
 * 1 1 5 3 3
 * 3 2 1 3 3
 * 输出：3
 * <p>
 * 提示：
 * 对于100%的数据，1 ≤ n, m, xs, ys, xt, yt, a[i][j], b[i][j] ≤ 100
 * <p>
 * https://leetcode-cn.com/problems/KLwc3e/
 */
public class Solution {

    static int row, col;
    static int xs, ys, xt, yt;
    static int[][] a;
    static int[][] b;             // 十字路口的属性
    static boolean[][] visited;      // 节点是否已经被走过
    static int[] direction = new int[]{0, -1, 1};   // 移动方向

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        row = sc.nextInt();
        col = sc.nextInt();
        xs = sc.nextInt();
        ys = sc.nextInt();
        xt = sc.nextInt();
        yt = sc.nextInt();
        a = new int[row + 1][col + 1];
        b = new int[row + 1][col + 1];
        visited = new boolean[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                b[i][j] = sc.nextInt();
            }
        }

        int cost = 0;   // 初始化花费的时间
        visited[xs][ys] = true;
        System.out.println(bfs(cost));
    }

    private static int bfs(int cost) {
        // 用于存储同一时间点可能到达的节点
        Queue<int[]> queue = new LinkedList<>();
        // 先把起点加入队列
        queue.offer(new int[]{xs, ys});
        while (!queue.isEmpty()) {
            int len = queue.size();   // 当前时刻有len个可能的位置
            while (len-- > 0) {
                int[] curPos = queue.poll();
                // 找到了小团，直接返回耗时
                if (curPos[0] == xt && curPos[1] == yt) {
                    return cost;
                }
                // 在当前位置尝试移动
                for (int j = 0; j < direction.length; j++) {
                    int remainder = cost % (a[curPos[0]][curPos[1]] + b[curPos[0]][curPos[1]]);
                    int x = curPos[0];
                    int y = curPos[1];
                    if (remainder < a[x][y]) {
                        // 时间处于[k*aij+k*bij), (k+1)*aij+k*bij)
                        x += direction[j];
                    } else {
                        // 时间处于[(k+1)*aij+k*bij), (k+1)*aij+(k+1)*bij)
                        y += direction[j];
                    }
                    // 移动位置不合法
                    if (x < 1 || x > row || y < 1 || y > col) continue;
                    // 如果下一个位置还没有走过或者当前时刻不进行移动，就往队列中添加节点
                    if (!visited[x][y] || j == 0) {
                        queue.offer(new int[]{x, y});
                        visited[x][y] = true;
                    }
                }
            }
            cost++;
        }
        return cost;
    }

    public static int bfs(int[][] matrix, int[] src, int[] dest, int[][] attrA, int[][] attrB) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] visited = new boolean[row][col];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(src);
        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            time++;
            for (int i = 0; i < size; i++) {
                int[] loc = queue.poll();
                if (loc[0] == dest[0] && loc[1] == dest[1]) {
                    return time;
                }


            }
        }

        return time;
    }

    public static List<int[]> checkDirection(int[] current, int[][] attrA, int[][] attrB, int time) {
        int x = current[0];
        int y = current[1];
        List<int[]> next = new ArrayList<>();
        if (time < attrA[x][y]) {
            next.add(new int[]{x + 1, y});
            next.add(new int[]{x - 1, y});
        } else if (time >= attrA[x][y]) {
            next.add(new int[]{x, y + 1});
            next.add(new int[]{x, y - 1});
        }

        return next;
    }
}
