//给你两个 非递增 的整数数组 nums1 和 nums2 ，数组下标均 从 0 开始 计数。 
//
// 下标对 (i, j) 中 0 <= i < nums1.length 且 0 <= j < nums2.length 。如果该下标对同时满足 i <= 
//j 且 nums1[i] <= nums2[j] ，则称之为 有效 下标对，该下标对的 距离 为 j - i 。 
//
// 返回所有 有效 下标对 (i, j) 中的 最大距离 。如果不存在有效下标对，返回 0 。 
//
// 一个数组 arr ，如果每个 1 <= i < arr.length 均有 arr[i-1] >= arr[i] 成立，那么该数组是一个 非递增 数组。 
//
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [55,30,5,4,2], nums2 = [100,20,10,10,5]
//输出：2
//解释：有效下标对是 (0,0), (2,2), (2,3), (2,4), (3,3), (3,4) 和 (4,4) 。
//最大距离是 2 ，对应下标对 (2,4) 。
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [2,2,2], nums2 = [10,10,1]
//输出：1
//解释：有效下标对是 (0,0), (0,1) 和 (1,1) 。
//最大距离是 1 ，对应下标对 (0,1) 。 
//
// 示例 3： 
//
// 
//输入：nums1 = [30,29,19,5], nums2 = [25,25,25,25,25]
//输出：2
//解释：有效下标对是 (2,2), (2,3), (2,4), (3,3) 和 (3,4) 。
//最大距离是 2 ，对应下标对 (2,4) 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length <= 10⁵ 
// 1 <= nums2.length <= 10⁵ 
// 1 <= nums1[i], nums2[j] <= 10⁵ 
// nums1 和 nums2 都是 非递增 数组 
// 
// Related Topics 贪心 数组 双指针 二分查找 👍 25 👎 0


// 2022-04-11 11:58:54
// By Long Luo

#include <bits/stdc++.h>
#include <iostream>

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    // BF time: O(m * n) space: O(1)
    // TimeOut
    int maxDistance_bf(vector<int> &nums1, vector<int> &nums2) {
        int len1 = nums1.size();
        int len2 = nums2.size();
        int max = 0;
        for (int i = 0; i < len1; i++) {
            for (int j = i; j < len2; j++) {
                if (nums1[i] <= nums2[j]) {
                    max = std::max(max, j - i);
                }
            }
        }

        return max;
    }

    // Two Pointers time: O(m + n) space: O(1)
    // AC
    int maxDistance(vector<int> &nums1, vector<int> &nums2) {
        int len1 = nums1.size();
        int len2 = nums2.size();
        int max = 0;
        int p = 0;
        int q = 0;
        while (p < len1 && q < len2) {
            if (nums1[p] > nums2[q]) {
                p++;
            }

            if (p < len1 && q < len2 && nums1[p] <= nums2[q]) {
                max = std::max(max, q - p);
            }
            q++;
        }

        return max;
    }
};
//leetcode submit region end(Prohibit modification and deletion)


int main() {
    Solution s;
    vector<int> data1{55, 30, 5, 4, 2};
    vector<int> data2{100, 20, 10, 10, 5};
    cout << "2 ?= " << s.maxDistance(data1, data2) << endl;
}