package com.longluo.leetcode.TwoPointers;

import com.longluo.datastructure.ArrayUtils;

import java.util.*;

/**
 * 18. 四数之和
 * <p>
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] ：
 * <p>
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 * <p>
 * 示例 1：
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * <p>
 * 示例 2：
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 * <p>
 * 提示：
 * 1 <= nums.length <= 200
 * -10^9 <= nums[i] <= 10^9
 * -10^9 <= target <= 10^9
 * <p>
 * https://leetcode.cn/problems/4sum/
 */
public class Problem18_4Sum {

    // Sort + BF + Set time: O(n^4) space: O(logn)
    public static List<List<Integer>> fourSum_bf_set(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        int n = nums.length;
        Set<List<Integer>> ans = new HashSet<>();
        for (int first = 0; first < n - 3; first++) {
            for (int second = first + 1; second < n - 2; second++) {
                for (int third = second + 1; third < n - 1; third++) {
                    for (int fourth = third + 1; fourth < n; fourth++) {
                        if (nums[first] + nums[second] + nums[third] + nums[fourth] == target) {
                            ans.add(Arrays.asList(nums[first], nums[second], nums[third], nums[fourth]));
                        }
                    }
                }
            }
        }

        return new ArrayList<>(ans);
    }

    // Sort + BF + List time: O(n^4) space: O(logn)
    public static List<List<Integer>> fourSum_bf_list(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }

            if ((long) nums[i] + nums[len - 3] + nums[len - 2] + nums[len - 1] < target) {
                continue;
            }

            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }

                if ((long) nums[i] + nums[j] + nums[len - 2] + nums[len - 1] < target) {
                    continue;
                }

                for (int k = j + 1; k < len - 1; k++) {
                    if (k > j + 1 && nums[k] == nums[k - 1]) {
                        continue;
                    }

                    if ((long) nums[i] + nums[j] + nums[k] + nums[k + 1] > target) {
                        break;
                    }

                    if ((long) nums[i] + nums[j] + nums[k] + nums[len - 1] < target) {
                        continue;
                    }

                    for (int l = k + 1; l < len; l++) {
                        if (l > k + 1 && nums[l] == nums[l - 1]) {
                            continue;
                        }

                        if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
                            ans.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        }
                    }
                }
            }
        }

        return ans;
    }

    // Sort + Hash time: O(n^2) space: O(n)
    public static List<List<Integer>> fourSum_hash(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int j = len - 1; j > 2; j--) {
            if (j < len - 1 && nums[j] == nums[j + 1]) {
                continue;
            }

            if (nums[j] < target / 4) {
                break;
            }

            if ((long) nums[j] + 3L * nums[0] > target) {
                continue;
            }

            for (int i = j - 1; i > 1; i--) {
                if (i < j - 1 && nums[i] == nums[i + 1]) {
                    continue;
                }

                if ((long) nums[j] + 3L * nums[i] < target) {
                    break;
                }

                if (nums[j] + nums[i] > target - 2 * nums[0]) {
                    continue;
                }

                int sum = nums[i] + nums[j];
                List<int[]> list = map.getOrDefault(sum, new ArrayList<>());
                list.add(new int[]{i, j});
                map.put(sum, list);
            }
        }

        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            if (nums[i] > target / 4) {
                break;
            }

            if ((long) nums[i] + 3L * nums[len - 1] < target) {
                continue;
            }

            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                if ((long) nums[i] + 3L * nums[j] > target) {
                    break;
                }

                if (2 * nums[len - 1] < target - nums[i] - nums[j]) {
                    continue;
                }

                int newTarget = target - nums[i] - nums[j];
                if (map.containsKey(newTarget)) {
                    List<int[]> list = map.get(newTarget);
                    for (int[] index : list) {
                        if (j < index[0]) {
                            ans.add(Arrays.asList(nums[i], nums[j], nums[index[0]], nums[index[1]]));
                        }
                    }
                }
            }
        }

        return ans;
    }

    // Two Pointers time: O(n^3) space: O(logn)
    public static List<List<Integer>> fourSum_tp(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int first = 0; first < n - 3; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            // 部分用例溢出
            if (nums[first] + nums[first + 1] > target - nums[first + 3] - nums[first + 2]) {
                break;
            }

            if (nums[first] + nums[n - 3] < target - nums[n - 1] - nums[n - 2]) {
                continue;
            }

            for (int second = first + 1; second < n - 2; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }

                if (nums[first] + nums[second] > target - nums[second + 2] - nums[second + 1]) {
                    break;
                }

                if (nums[first] + nums[second] < target - nums[n - 1] - nums[n - 2]) {
                    continue;
                }

                int left = second + 1;
                int right = n - 1;
                while (left < right) {
                    long sum = (long) nums[first] + nums[second] + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else if (sum == target) {
                        ans.add(Arrays.asList(nums[first], nums[second], nums[left], nums[right]));
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    }
                }
            }
        }

        return ans;
    }

    // DFS time: O(n^3) space: O(logn)
    public static List<List<Integer>> fourSum_dfs(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        dfs(nums, ans, new ArrayList<>(), 0, target);
        return ans;
    }

    public static void dfs(int[] nums, List<List<Integer>> res, List<Integer> list, int start, int target) {
        if (list.size() == 4 && target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        if (list.size() >= 4) {
            return;
        }

        int len = nums.length;

        for (int i = start; i < len; i++) {
            if (len - i < 4 - list.size()) {
                return;
            }

            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            if (i < len - 1 && nums[i] + (long) (3 - list.size()) * nums[i + 1] > target) {
                return;
            }

            if (i < len - 1 && nums[i] + (long) (3 - list.size()) * nums[len - 1] < target) {
                continue;
            }

            list.add(nums[i]);
            dfs(nums, res, list, i + 1, target - nums[i]);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE / Math.pow(10, 9));

        System.out.println("[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]] ?= " + ArrayUtils.print2DList(fourSum_bf_set(new int[]{1, 0, -1, 0, -2, 2}, 0)));
        System.out.println("[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]] ?= " + ArrayUtils.print2DList(fourSum_tp(new int[]{1, 0, -1, 0, -2, 2}, 0)));
        System.out.println("[[2,2,2,2]] ?= " + ArrayUtils.print2DList(fourSum_bf_set(new int[]{2, 2, 2, 2, 2}, 8)));
        System.out.println("[[2,2,2,2]] ?= " + ArrayUtils.print2DList(fourSum_bf_list(new int[]{2, 2, 2, 2, 2}, 8)));
        System.out.println("[[2,2,2,2]] ?= " + ArrayUtils.print2DList(fourSum_tp(new int[]{2, 2, 2, 2, 2}, 8)));
        System.out.println("[[-5,-4,4,5],[-5,-3,3,5],[-5,-2,2,5],[-5,-2,3,4],[-5,-1,1,5],[-5,-1,2,4],[-5,0,0,5],[-5,0,1,4],[-5,0,2,3],[-4,-3,2,5],[-4,-3,3,4],[-4,-2,1,5],[-4,-2,2,4],[-4,-1,0,5],[-4,-1,1,4],[-4,-1,2,3],[-4,0,0,4],[-4,0,1,3],[-3,-2,0,5],[-3,-2,1,4],[-3,-2,2,3],[-3,-1,0,4],[-3,-1,1,3],[-3,0,0,3],[-3,0,1,2],[-2,-1,0,3],[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]] ?= " + ArrayUtils.print2DList(fourSum_tp(new int[]{-5, -4, -3, -2, -1, 0, 0, 1, 2, 3, 4, 5}, 0)));
        System.out.println("[[-5,-4,-3,1]] ?= " + ArrayUtils.print2DList(fourSum_tp(new int[]{1, -2, -5, -4, -3, 3, 3, 5}, -11)));
        System.out.println("[[-2,-1,1,2],[-1,-1,1,1]] ?= " + ArrayUtils.print2DList(fourSum_tp(new int[]{-2, -1, -1, 1, 1, 2, 2}, 0)));
        System.out.println("[[0,0,0,1000000000]] ?= " + ArrayUtils.print2DList(fourSum_tp(new int[]{0, 0, 0, 1000000000, 1000000000, 1000000000, 1000000000}, 1000000000)));

        System.out.println("[[0,0,0,1000000000]] ?= " + ArrayUtils.print2DList(fourSum_hash(new int[]{0, 0, 0, 1000000000, 1000000000, 1000000000, 1000000000}, 1000000000)));

        System.out.println("[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]] ?= " + ArrayUtils.print2DList(fourSum_dfs(new int[]{1, 0, -1, 0, -2, 2}, 0)));
        System.out.println("[[2,2,2,2]] ?= " + ArrayUtils.print2DList(fourSum_dfs(new int[]{2, 2, 2, 2, 2}, 8)));
        System.out.println("[[0,0,0,1000000000]] ?= " + ArrayUtils.print2DList(fourSum_dfs(new int[]{0, 0, 0, 1000000000, 1000000000, 1000000000, 1000000000}, 1000000000)));
    }
}
