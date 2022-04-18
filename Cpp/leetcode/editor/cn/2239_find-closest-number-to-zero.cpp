//给你一个长度为 n 的整数数组 nums ，请你返回 nums 中最 接近 0 的数字。如果有多个答案，请你返回它们中的 最大值 。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [-4,-2,1,4,8]
//输出：1
//解释：
//-4 到 0 的距离为 |-4| = 4 。
//-2 到 0 的距离为 |-2| = 2 。
//1 到 0 的距离为 |1| = 1 。
//4 到 0 的距离为 |4| = 4 。
//8 到 0 的距离为 |8| = 8 。
//所以，数组中距离 0 最近的数字为 1 。
// 
//
// 示例 2： 
//
// 输入：nums = [2,-1,1]
//输出：1
//解释：1 和 -1 都是距离 0 最近的数字，所以返回较大值 1 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
// 👍 1 👎 0


// 2022-04-18 20:21:29
// By Long Luo

#include <bits/stdc++.h>

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    // time: O(n) space: O(1)
    int findClosestNumber(vector<int> &nums) {
        int len = nums.size();
        if (len == 1) {
            return nums[0];
        }

        int ans = 0;
        int delta = INT32_MAX;
        for (int x : nums) {
            if (x == 0) {
                return x;
            } else if (abs(x) < delta) {
                delta = abs(x);
                ans = x;
            } else if (abs(x) == delta) {
                ans = x > ans ? x : ans;
            }
        }

        return ans;
    }
};
//leetcode submit region end(Prohibit modification and deletion)


int main() {
    Solution s;
    vector<int> data{-4, -2, 1, 4, 8};
    cout << s.findClosestNumber(data) << endl;
}