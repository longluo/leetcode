//给定一个含有 n 个正整数的数组和一个正整数 target 。 
//
// 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长
//度。如果不存在符合条件的子数组，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
// 
//
// 示例 2： 
//
// 
//输入：target = 4, nums = [1,4,4]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target <= 10⁹ 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 
//
// 
//
// 进阶： 
//
// 
// 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。 
// 
// Related Topics 数组 二分查找 前缀和 滑动窗口 👍 1064 👎 0


// 2022-04-09 19:20:39
// By Long Luo

#include<bits/stdc++.h>

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    // BF time: O(n^2) space: O(1)
    // TimeOut
    int minSubArrayLen(int target, vector<int>& nums) {
        int len = nums.size();
        int min = INT32_MAX;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j < len; j++) {
                sum += nums[j];
                if (sum >= target) {
                    min = std::min(min, j - i + 1);
                    break;
                }
            }
        }

        return min == INT32_MAX ? 0 : min;
    }

    // BF time: O(n^2) space: O(1)
    int minSubArrayLen_bs(int target, vector<int>& nums) {
        int len = nums.size();
        int min = INT32_MAX;
        int *prefixSums = new int[len]();
        for (int i = 0; i < len; i++) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
        }

        return min == INT32_MAX ? 0 : min;
    }

    int binarySearch(int *arr ) {

        return -1;
    }

};
//leetcode submit region end(Prohibit modification and deletion)


int main()
{
    Solution s;
    vector<int> data{7, 1, 5, 3, 6, 4};
    //vector<int> ans = s.twoSum(data,11);
    //cout << ans[0]<<ans[1]<<endl;
    cout<<"Hello LeetCode"<<endl;
}