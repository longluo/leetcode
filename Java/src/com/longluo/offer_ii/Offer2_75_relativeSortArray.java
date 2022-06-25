package com.longluo.offer_ii;

import java.util.*;

/**
 * 剑指 Offer II 075. 数组相对排序
 * <p>
 * 给定两个数组，arr1 和 arr2，
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。
 * 未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 * <p>
 * 示例：
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 * <p>
 * 提示：
 * 1 <= arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 * <p>
 * 注意：
 * 本题与主站1122题相同：https://leetcode.cn/problems/relative-sort-array/
 * <p>
 * https://leetcode.cn/problems/0H97ZC/
 */
public class Offer2_75_relativeSortArray {

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        int[] res = new int[len1];
        Set<Integer> numSet = new TreeSet<>();
        for (int i = 0; i < len2; i++) {
            numSet.add(arr2[i]);
        }

        Map<Integer, Integer> hasMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len1; i++) {
            if (numSet.contains(arr1[i])) {
                hasMap.put(arr1[i], hasMap.getOrDefault(arr1[i], 0) + 1);
            } else {
                list.add(arr1[i]);
            }
        }

        int idx = 0;
        for (int i = 0; i < len2; i++) {
            res[idx++] = arr2[i];
            int num = hasMap.get(arr2[i]);
            for (int j = 0; j < num - 1; j++) {
                res[idx++] = arr2[i];
            }
        }

        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            res[idx + i] = list.get(i);
        }

        return res;
    }

    public static int[] relativeSortArray_1(int[] arr1, int[] arr2) {
        List<Integer> list = new ArrayList<>(arr1.length);
        for (int num : arr1) {
            list.add(num);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                if (map.containsKey(x) || map.containsKey(y)) {
                    return map.getOrDefault(x, 1001) - map.getOrDefault(y, 1001);
                }

                return x - y;
            }
        });

        int[] ans = new int[arr1.length];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }

    public static int[] relativeSortArray_2(int[] arr1, int[] arr2) {
        int maxNum = 0;
        for (int num : arr1) {
            maxNum = Math.max(maxNum, num);
        }

        int[] freq = new int[maxNum + 1];
        for (int num : arr1) {
            freq[num]++;
        }

        int[] ans = new int[arr1.length];
        int idx = 0;
        for (int num : arr2) {
            for (int i = 0; i < freq[num]; i++) {
                ans[idx++] = num;
            }

            freq[num] = 0;
        }

        for (int i = 0; i <= maxNum; i++) {
            for (int j = 0; j < freq[i]; j++) {
                ans[idx++] = i;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[2,2,2,1,4,3,3,9,6,7,19] ?= " + Arrays.toString(relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6})));
        System.out.println("[2,2,2,1,4,3,3,9,6,7,19] ?= " + Arrays.toString(relativeSortArray_1(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6})));
        System.out.println("[2,2,2,1,4,3,3,9,6,7,19] ?= " + Arrays.toString(relativeSortArray_2(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6})));
    }
}
