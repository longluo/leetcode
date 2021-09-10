package com.longluo.studyplan.meituan.day6.bookshelf;

import java.util.Arrays;
import java.util.Scanner;

/**
 * meituan-012. 小美的书架
 * <p>
 * 小美的书架上有很多书。小美是个爱读书的新时代好青年。
 * 小团虽然也喜欢看书，但小团大多数时候都更喜欢来小美家蹭书读。
 * 这就导致小美的书架上很多书都会被小团借走。
 * 小美很烦这一点，就想出了一个招数，小美的书架是一行一行的，他会对一些行加锁，这样小团就借不走了。
 * 现在小团想要借书，请你帮忙看看小团能不能借到书，如果可以借到的话在哪一行书架上有这本书。
 * 为了简单起见，每本书将用一个正整数进行编号，小美的书架一共有 N 行。
 * <p>
 * 格式：
 * 输入：
 * - 第一行三个正整数 M，N，Q，表示小美书架有 N 行编号 1 到 N ，书本编号从 1 到 M ，接下来有 Q 个操作
 * - 接下来 Q 行，每行是下列操作中的一种：
 * 1. x y : x 是书本的编号，y 是书架的行编号，代表小美将编号为 x 的书本放置到 y 行上。若该书本在小团手上则放置无效，
 * 若原来该书在书架上且原行上锁则放置无效，若该书被放置到一个锁了的行上则放置无效。
 * 2. y : y 是书架的行编号，代表小美将行编号为 y 的书架加锁，对已经上锁的书架行该操作无效。
 * 3. y : y 是书架的行编号，代表小美将行编号为 y 的书架锁去掉，对无锁的书架行该操作无效。
 * 4. x : x 是书本的编号，代表小团想借编号为 x 的书本，对该操作若可以借到输出一行正整数在哪一行，借不到输出一行 -1
 * 5. x : x 是书本的编号，代表小团还回来编号为 x 的书本。若该书本不在小团手上该操作无效。
 * 输出：
 * - 对于每个操作 4 ，若可以借到输出一行正整数在哪一行，借不到输出一行 -1 。
 * 示例：
 * <p>
 * 输入：
 * 5 5 10
 * 1 1 4
 * 1 2 3
 * 1 3 1
 * 2 1
 * 4 1
 * 5 2
 * 4 3
 * 4 5
 * 3 1
 * 4 2
 * 输出：
 * 4
 * -1
 * -1
 * 3
 * <p>
 * 提示：
 * 对于 30% 的数据有 N<=10, M<=10, Q<=20
 * 对于 80% 的数据有 N<=1000, M<=1000, Q<=100000
 * 对于 100% 的数据有 N<=10000, M<=10000, Q<=100000
 * <p>
 * https://leetcode-cn.com/problems/FvoBGh/
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int M = scan.nextInt();
        int Q = scan.nextInt();
        int[] bookshelf = new int[N + 1];//编号为i的书在书架第bookshelf[i]行
        boolean[] isLock = new boolean[M + 1];//记录哪些行有上锁
        int[] hasBooks = new int[N + 1];//记录小团借了哪些书
        Arrays.fill(bookshelf, -1);

        for (int i = 0; i < Q; i++) {
            //1:放书  2:对行上锁  3:对行去锁  4:借书  5:还书
            int oper = scan.nextInt(), x, y;
            switch (oper) {
                case 1:
                    x = scan.nextInt();
                    y = scan.nextInt();
                    //没有放置到一个锁了的行上 并且 该书本不在小团手上  并且 (原来该书不在书架上 或 原来该书在书架上且原行没上锁)
                    if (!isLock[y] && hasBooks[x] != 1 && (bookshelf[x] == -1 || !isLock[bookshelf[x]]))
                        bookshelf[x] = y;//把编号为x的书放到y行书架
                    break;
                case 2:
                    y = scan.nextInt();
                    isLock[y] = true;//对y行上锁
                    break;
                case 3:
                    y = scan.nextInt();
                    isLock[y] = false;//对y行去锁
                    break;
                case 4:
                    x = scan.nextInt();
                    y = bookshelf[x];
                    //如果可以借到书(书本在书架上,且该行没上锁,且不在小团手上)
                    if (y != -1 && !isLock[y] && hasBooks[x] != 1) {
                        System.out.println(y);
                        hasBooks[x] = 1;//更新小团借的书
                        bookshelf[x] = -1;//将书架上对应位置置空
                    } else {
                        System.out.println(-1);
                    }
                    break;
                case 5:
                    x = scan.nextInt();
                    //还书
                    if (hasBooks[x] != 0) {
                        hasBooks[x] = 0;
                    }
                    break;
            }
        }

        scan.close();
    }
}
