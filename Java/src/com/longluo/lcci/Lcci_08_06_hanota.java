package com.longluo.lcci;

import java.util.List;

/**
 * 面试题 08.06. 汉诺塔问题
 * <p>
 * 在经典汉诺塔问题中，有 3 根柱子及 N 个不同大小的穿孔圆盘，盘子可以滑入任意一根柱子。
 * 一开始，所有盘子自上而下按升序依次套在第一根柱子上(即每一个盘子只能放在更大的盘子上面)。移动圆盘时受到以下限制:
 * (1) 每次只能移动一个盘子;
 * (2) 盘子只能从柱子顶端滑出移到下一根柱子;
 * (3) 盘子只能叠在比它大的盘子上。
 * <p>
 * 请编写程序，用栈将所有盘子从第一根柱子移到最后一根柱子。
 * <p>
 * 你需要原地修改栈。
 * <p>
 * 示例1:
 * 输入：A = [2, 1, 0], B = [], C = []
 * 输出：C = [2, 1, 0]
 * <p>
 * 示例2:
 * 输入：A = [1, 0], B = [], C = []
 * 输出：C = [1, 0]
 * <p>
 * 提示:
 * A中盘子的数目不大于14个。
 * <p>
 * https://leetcode-cn.com/problems/hanota-lcci/
 */
public class Lcci_08_06_hanota {

    public static void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        move(A.size(), A, B, C);
    }

    public static void move(int size, List<Integer> start, List<Integer> auxiliary, List<Integer> target) {
        if (size == 1) {
            target.add(start.remove(start.size() - 1));
            return;
        }

        move(size - 1, start, target, auxiliary);
        target.add(start.remove(start.size() - 1));
        move(size - 1, auxiliary, start, target);
    }

    public static void main(String[] args) {

    }
}
