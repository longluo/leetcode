//给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,6,3,4,5,6], val = 6
//输出：[1,2,3,4,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [], val = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [7,7,7,7], val = 7
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 列表中的节点数目在范围 [0, 10⁴] 内 
// 1 <= Node.val <= 50 
// 0 <= val <= 50 
// 
// Related Topics 递归 链表 👍 862 👎 0


// 2022-04-11 21:56:58
// By Long Luo

#include<bits/stdc++.h>
#include <ListNode.h>

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    // Recursion time: O(n) space: O(1)
    ListNode *removeElements(ListNode *head, int val) {
        if (head == NULL) {
            return head;
        }

        head->next = removeElements(head->next, val);
        if (head->val == val) {
            return head->next;
        } else {
            return head;
        }
    }
};
//leetcode submit region end(Prohibit modification and deletion)

int main() {
    Solution s;

}