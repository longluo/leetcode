//给你一个整数数组 arr ，请你将数组中的每个元素替换为它们排序后的序号。 
//
// 序号代表了一个元素有多大。序号编号的规则如下： 
//
// 
// 序号从 1 开始编号。 
// 一个元素越大，那么序号越大。如果两个元素相等，那么它们的序号相同。 
// 每个数字的序号都应该尽可能地小。 
// 
//
// 
//
// 示例 1： 
//
// 输入：arr = [40,10,20,30]
//输出：[4,1,2,3]
//解释：40 是最大的元素。 10 是最小的元素。 20 是第二小的数字。 30 是第三小的数字。 
//
// 示例 2： 
//
// 输入：arr = [100,100,100]
//输出：[1,1,1]
//解释：所有元素有相同的序号。
// 
//
// 示例 3： 
//
// 输入：arr = [37,12,28,9,100,56,80,5,12]
//输出：[5,3,4,2,8,6,7,1,3]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= arr.length <= 10⁵ 
// -10⁹ <= arr[i] <= 10⁹ 
// 
// Related Topics 数组 哈希表 排序 👍 76 👎 0


// 2022-07-28 09:31:13
// By Long Luo

#include <bits/stdc++.h>

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    vector<int> arrayRankTransform(vector<int>& arr) {
        vector<int> sorted = arr;
        sort(sorted.begin(), sorted.end());

        unordered_map<int, int> ranksMap;
        for (auto x : sorted) {
            if (!ranksMap.count(x)) {
                ranksMap.emplace(x, ranksMap.size() + 1);
            }
        }

        vector<int> ans(arr.size());
        for (int i = 0; i < arr.size(); i++) {
            ans[i] = ranksMap[arr[i]];
        }

        return ans;
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