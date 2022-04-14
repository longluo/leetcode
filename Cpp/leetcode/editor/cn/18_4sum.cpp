//给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[
//b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）： 
//
// 
// 0 <= a, b, c, d < n 
// a、b、c 和 d 互不相同 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// 你可以按 任意顺序 返回答案 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,2,2,2], target = 8
//输出：[[2,2,2,2]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 
// Related Topics 数组 双指针 排序 👍 1200 👎 0


// 2022-04-14 09:14:19
// By Long Luo

#include <bits/stdc++.h>

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    // Two Pointers time: O(n^3) space: O(1)
    // fix C++ 数组越界访问的bug，因为first 和 second指针需要保证不要越界
    vector<vector<int>> fourSum(vector<int> &nums, int target) {
        if (nums.size() < 4) {
            return {};
        }

        vector<vector<int>> ans;
        int len = nums.size();
        sort(nums.begin(), nums.end());
        for (int first = 0; first < len - 3; first++) {
            if (first >= 1 && nums[first] == nums[first - 1]) {
                continue;
            }

            if ((long) nums[first] + nums[first + 1] + nums[first + 2] + nums[first + 3] > target) {
                break;
            }

            if ((long) nums[first] + nums[len - 3] + nums[len - 2] + nums[len - 1] < target) {
                continue;
            }

            for (int second = first + 1; second < len - 2; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }

                int left = second + 1;
                int right = len - 1;
                while (left < right) {
                    if (nums[first] + nums[second] < target - nums[left] - nums[right]) {
                        left++;
                    } else if (nums[first] + nums[second] > target - nums[left] - nums[right]) {
                        right--;
                    } else {
                        ans.push_back({nums[first], nums[second], nums[left], nums[right]});
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
};
//leetcode submit region end(Prohibit modification and deletion)


int main() {
    Solution s;

    vector<int> data{1, 0, -1, 0, -2, 2};
    s.fourSum(data, 0);

    vector<int> data1{2, 1, 0, -1};
    s.fourSum(data1, 2);

    vector<int> data2{2, 2, 2, 2, 2};
    s.fourSum(data2, 8);

    vector<int> data3{1, -2, -5, -4, -3, 3, 3, 5};
    s.fourSum(data3, -11);
}