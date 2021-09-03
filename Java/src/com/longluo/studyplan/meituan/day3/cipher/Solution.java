package com.longluo.studyplan.meituan.day3.cipher;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * meituan-006. 小团的神秘暗号
 * <p>
 * 小团深谙保密工作的重要性，因此在某些明文的传输中会使用一种加密策略，小团如果需要传输一个字符串 S ，
 * 则他会为这个字符串添加一个头部字符串和一个尾部字符串。头部字符串满足至少包含一个 “MT” 子序列，且以 T 结尾。
 * 尾部字符串需要满足至少包含一个 “MT” 子序列，且以 M 开头。例如 AAAMT 和 MAAAT 都是一个合法的头部字符串，
 * 而 MTAAA 就不是合法的头部字符串。很显然这样的头尾字符串并不一定是唯一的，因此我们还有一个约束，
 * 就是 S 是满足头尾字符串合法的情况下的最长的字符串。
 * 很显然这样的加密策略是支持解码的，给出一个加密后的字符串，请你找出中间被加密的字符串 S 。
 * <p>
 * 格式：
 * 输入：
 * - 输入第一行是一个正整数 n ，表示加密后的字符串总长度。
 * - 输入第二行是一个长度为 n 的仅由大写字母组成的字符串 T 。
 * 输出：
 * - 输出仅包含一个字符串 S 。
 * <p>
 * 示例：
 * 输入：
 * 10
 * MMATSATMMT
 * 输出：SATM
 * <p>
 * 提示：
 * 1 <= n <= 100000
 * <p>
 * https://leetcode-cn.com/problems/z3XKBp/
 */
public class Solution {

    /*
10
MMATSATMMT
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = Integer.parseInt(sc.nextLine());
        String encryptStr = sc.nextLine();
        if (len <= 4) {
            System.out.println("");
            return;
        }

        List<Integer> mIdxList = new ArrayList<>();
        List<Integer> tIdxList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (encryptStr.charAt(i) == 'M') {
                mIdxList.add(i);
            } else if (encryptStr.charAt(i) == 'T') {
                tIdxList.add(i);
            }
        }

        if (mIdxList.size() <= 1 || tIdxList.size() <= 1) {
            System.out.println("");
            return;
        }

        int start = 0;
        int end = len - 1;

        int left = 0;
        int right = tIdxList.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (tIdxList.get(mid) >= mIdxList.get(0)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        start = left;

        left = 0;
        right = mIdxList.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mIdxList.get(mid) > tIdxList.get(tIdxList.size() - 1)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        end = right;

        int ansStart = tIdxList.get(start) + 1;
        int ansEnd = mIdxList.get(end);
        System.out.println(encryptStr.substring(ansStart, ansEnd));
    }

    private static int binarySearch(List<Integer> list, int begin, int end, int target) {
        if (begin > end) {
            return -1;
        }

        while (begin <= end) {
            int mid = begin + (end - begin) / 2;
            if ((mid == begin || mid == end) && list.get(mid) > target) {
                return mid;
            }
            if (list.get(mid) > target) {
                return binarySearch(list, begin, mid - 1, target);
            } else {
                return binarySearch(list, mid + 1, end, target);
            }
        }

        return -1;
    }

    /*
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = Integer.parseInt(sc.nextLine());
        String encryptStr = sc.nextLine();

        int idx = 0;
        int begin = 0;
        int end = 0;

        while (idx < len) {
            if (encryptStr.charAt(idx) == 'M') {
                while (idx < len && encryptStr.charAt(idx) != 'T') {
                    idx++;
                }

                begin = idx + 1;
                break;
            }

            idx++;
        }

        idx = len - 1;
        while (idx >= 0) {
            if (encryptStr.charAt(idx) == 'T') {
                while (idx >= 0 && encryptStr.charAt(idx) != 'M') {
                    idx--;
                }

                end = idx;
                break;
            }

            idx--;
        }

        String srcStr = encryptStr.substring(begin, end);
        System.out.println(srcStr);
    }
    */
}
