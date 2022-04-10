////如果数组是单调递增或单调递减的，那么它是 单调 的。 
////
//// 如果对于所有 i <= j，nums[i] <= nums[j]，那么数组 nums 是单调递增的。 如果对于所有 i <= j，nums[i]> =
// 
////nums[j]，那么数组 nums 是单调递减的。 
////
//// 当给定的数组 nums 是单调数组时返回 true，否则返回 false。 
////
//// 
////
//// 
//// 
////
//// 示例 1： 
////
//// 
////输入：nums = [1,2,2,3]
////输出：true
//// 
////
//// 示例 2： 
////
//// 
////输入：nums = [6,5,4,4]
////输出：true
//// 
////
//// 示例 3： 
////
//// 
////输入：nums = [1,3,2]
////输出：false
//// 
////
//// 
////
//// 提示： 
////
//// 
//// 1 <= nums.length <= 10⁵ 
//// -10⁵ <= nums[i] <= 10⁵ 
//// 
//// Related Topics 数组 👍 159 👎 0
//

// 2022-04-09 18:30:38
// By Long Luo

#include<bits/stdc++.h>

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    bool isMonotonic(vector<int> &nums) {
        return isMonotonic(nums, true) || isMonotonic(nums, false);
    }

    bool isMonotonic(vector<int> &nums, bool isAscending) {
        int len = nums.size();
        for (int i = 1; i < len; i++) {
            if (isAscending) {
                if (nums[i] < nums[i - 1]) {
                    return false;
                }
            } else {
                if (nums[i] > nums[i - 1]) {
                    return false;
                }
            }
        }

        return true;
    }

    bool isMonotonic_single(vector<int> &nums) {
        bool inc = true;
        bool dec = true;
        int len = nums.size();
        for (int i = 1; i < len; i++) {
            if (nums[i] < nums[i - 1]) {
                inc = false;
            }

            if (nums[i] > nums[i - 1]) {
                dec = false;
            }
        }

        return inc || dec;
    }
};
//leetcode submit region end(Prohibit modification and deletion)


int main() {
    Solution s;
    vector<int> data{1, 2, 2, 3};
    cout << s.isMonotonic(data) << endl;
//    cout << "Hello LeetCode" << endl;
}