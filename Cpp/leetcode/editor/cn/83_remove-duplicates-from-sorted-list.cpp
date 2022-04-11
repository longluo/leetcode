//给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,1,2]
//输出：[1,2]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,1,2,3,3]
//输出：[1,2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序 排列 
// 
// Related Topics 链表 👍 770 👎 0


// 2022-04-11 22:32:49
// By Long Luo

#include <bits/stdc++.h>
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
    // Recursion
    ListNode *deleteDuplicates(ListNode *head) {
        if (head == NULL || head->next == NULL) {
            return head;
        }

        ListNode* currNode = head;
        while (currNode->next != NULL) {
            if (currNode->val == currNode->next->val) {
                currNode->next = currNode->next->next;
            } else {
                currNode = currNode->next;
            }
        }

        return head;
    }
};
//leetcode submit region end(Prohibit modification and deletion)


int main() {
    Solution s;

}