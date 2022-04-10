//You are keeping score for a baseball game with strange rules. The game 
//consists of several rounds, where the scores of past rounds may affect future rounds' 
//scores. 
//
// At the beginning of the game, you start with an empty record. You are given 
//a list of strings ops, where ops[i] is the iᵗʰ operation you must apply to the 
//record and is one of the following: 
//
// 
// An integer x - Record a new score of x. 
// "+" - Record a new score that is the sum of the previous two scores. It is 
//guaranteed there will always be two previous scores. 
// "D" - Record a new score that is double the previous score. It is guaranteed 
//there will always be a previous score. 
// "C" - Invalidate the previous score, removing it from the record. It is 
//guaranteed there will always be a previous score. 
// 
//
// Return the sum of all the scores on the record. 
//
// 
// Example 1: 
//
// 
//Input: ops = ["5","2","C","D","+"]
//Output: 30
//Explanation:
//"5" - Add 5 to the record, record is now [5].
//"2" - Add 2 to the record, record is now [5, 2].
//"C" - Invalidate and remove the previous score, record is now [5].
//"D" - Add 2 * 5 = 10 to the record, record is now [5, 10].
//"+" - Add 5 + 10 = 15 to the record, record is now [5, 10, 15].
//The total sum is 5 + 10 + 15 = 30.
// 
//
// Example 2: 
//
// 
//Input: ops = ["5","-2","4","C","D","9","+","+"]
//Output: 27
//Explanation:
//"5" - Add 5 to the record, record is now [5].
//"-2" - Add -2 to the record, record is now [5, -2].
//"4" - Add 4 to the record, record is now [5, -2, 4].
//"C" - Invalidate and remove the previous score, record is now [5, -2].
//"D" - Add 2 * -2 = -4 to the record, record is now [5, -2, -4].
//"9" - Add 9 to the record, record is now [5, -2, -4, 9].
//"+" - Add -4 + 9 = 5 to the record, record is now [5, -2, -4, 9, 5].
//"+" - Add 9 + 5 = 14 to the record, record is now [5, -2, -4, 9, 5, 14].
//The total sum is 5 + -2 + -4 + 9 + 5 + 14 = 27.
// 
//
// Example 3: 
//
// 
//Input: ops = ["1"]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= ops.length <= 1000 
// ops[i] is "C", "D", "+", or a string representing an integer in the range [-3
// * 10⁴, 3 * 10⁴]. 
// For operation "+", there will always be at least two previous scores on the 
//record. 
// For operations "C" and "D", there will always be at least one previous score 
//on the record. 
// 
// Related Topics Array Stack Simulation 👍 1006 👎 1364


// 2022-04-10 08:16:04
// By Long Luo

#include<bits/stdc++.h>

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    int calPoints(vector<string>& ops) {
        int ans = 0;
        stack<int> stk;
        for (int i = 0; i < ops.size(); i++) {
            string op = ops[i];
            if (op == "D") {
                int num = stk.top();
                stk.push(2 * num);
                ans += 2 * num;
            } else if (op == "C") {
                ans -= stk.top();
                stk.pop();
            } else if (op == "+") {
                int num1 = stk.top();
                stk.pop();
                int num2 = stk.top();
                stk.push(num1);
                stk.push(num1 + num2);
                ans += num1 + num2;
            } else {
                int num = atoi(op.c_str());
                stk.push(num);
                ans += num;
            }
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